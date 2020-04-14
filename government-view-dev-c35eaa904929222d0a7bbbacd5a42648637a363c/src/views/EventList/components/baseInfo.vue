<template>
  <el-form label-width="95px" :model="form" :rules="rules" ref="baseInfo">
    <el-form-item label="区域：" prop="area">
      <el-select v-model="form.area" :disabled="isDisable" @change="regionChange">
        <el-option v-for="item in regionList" :key="item.id"
          :label="item.placeName"
          :value="item.placeCode"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="街乡镇：" prop="streetTown">
      <el-select v-model="form.streetTown" :disabled="isDisable">
        <el-option v-for="item in streetList" :key="item.id"
          :label="item.placeName"
          :value="item.placeCode"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="事项类型：">
      <el-select v-model="form.eventType" :disabled="isDisable">
        <el-option v-for="item in selectList.EVENT_TYPE" :key="item.id"
          :label="item.codeName" :value="item.codeValue"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="所属类别：" prop="belongType">
      <el-select class="el-select__tip"
        v-model="form.belongType"
        @change="(val) => selectChange('type', val)"
        :disabled="isDisable">
        <el-option v-for="item in selectList.BELONG_TYPE" :key="item.id"
          :label="item.codeName" :value="item.codeValue"></el-option>
      </el-select>
      <p class="tip" v-show="showTypeTip"><i class="el-icon-warning"></i> {{ typeDes }}</p>
    </el-form-item>
    <el-form-item label="支持级别：" prop="supportLevel">
      <el-select class="el-select__tip"
        v-model="form.supportLevel"
        @change="(val) => selectChange('level', val)"
        :disabled="isDisable">
        <el-option v-for="item in selectList.SUPPORT_LEVEL" :key="item.id"
          :label="item.codeName" :value="item.codeValue"></el-option>
      </el-select>
      <p class="tip" v-show="showLevelTip"><i class="el-icon-warning"></i> {{ levelDes }}</p>
    </el-form-item>
    <el-form-item label="事项描述：" prop="eventDesc">
      <el-input v-model="form.eventDesc" type="textarea" rows="9" placeholder="请输入......" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item label="事项来源：" prop="eventSource">
      <el-select class="el-select__tip"
        v-model="form.eventSource"
        @change="(val) => selectChange('origin', val)"
        :disabled="isDisable">
        <el-option v-for="item in selectList.EVENT_SOURCE" :key="item.id"
          :label="item.codeName" :value="item.codeValue"></el-option>
      </el-select>
      <p class="tip" v-show="showOriginTip"><i class="el-icon-warning"></i> {{ originDes }}</p>
    </el-form-item>
    <el-form-item label="工单编号：" v-show="showNumField">
      <el-input placeholder="请输入工单编号" v-model="form.workOrderNo" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" style="margin-left: 100px;" @click="submitForm(true)">下一步</el-button>
      <el-button @click="$router.back()">返回</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
/* eslint-disable no-unused-vars */
import { fetchRegionList } from 'api/eventList.js'

export default {
  name: 'baseInfo',
  props: ['origin', 'form', 'selectList'],
  data () {
    return {
      showTypeTip: false,
      showLevelTip: false,
      showOriginTip: false,
      showNumField: false,
      typeDes: '',
      levelDes: '',
      originDes: '',
      rules: {
        area: [
          { required: true, message: '请选择区域', trigger: 'change' }
        ],
        streetTown: [
          { required: true, message: '请选择街乡镇', trigger: 'change' }
        ],
        belongType: [
          { required: true, message: '请选择所属类别', trigger: 'change' }
        ],
        supportLevel: [
          { required: true, message: '请选择支持级别', trigger: 'change' }
        ],
        eventDesc: [
          { required: true, message: '请填写事项描述', trigger: 'blur' }
        ],
        eventSource: [
          { required: true, message: '请选择事项来源', trigger: 'change' }
        ]
      },
      regionList: [],
      streetList: []
    }
  },
  computed: {
    isDisable () {
      return this.origin === 'view'
    }
  },
  methods: {
    selectChange (type, val) {
      const typeMap = {
        type: ['showTypeTip', 'typeDes', 'BELONG_TYPE'],
        level: ['showLevelTip', 'levelDes', 'SUPPORT_LEVEL'],
        origin: ['showOriginTip', 'originDes', 'EVENT_SOURCE']
      }

      this[typeMap[type][0]] = true
      this[typeMap[type][1]] = this.selectList[typeMap[type][2]][val - 1].codeDesc

      // 事项来源选中 12345 -> 显式工单编号
      if (type === 'origin' && val === '2') {
        this.showNumField = true
      } else {
        this.showNumField = false
        this.form.workOrderNo = ''
      }
    },
    // 区域改变- 获取街乡镇下拉列表
    regionChange (regionCode) {
      return fetchRegionList({
        upplaceCode: regionCode
      }).then(res => {
        this.streetList = res.data.data
      })
    },
    // flag - 标志不会跳转只做校验
    submitForm (flag) {
      return this.$refs.baseInfo.validate()
        .then(res => {
          !flag || this.$emit('change-tab', 'problemDes')
          return true
        })
        .catch(err => {
          console.warn(err)
          return false
        })
    }
  },
  created () {
    fetchRegionList({
      placeType: '01'
    }).then(res => {
      this.regionList = res.data.data
    })
  }
}
</script>

<style lang="scss" scoped>
.el-form {
  margin: 25px auto 0;
  width: 1005px;
  /deep/ .el-form-item__content {
    .el-select__tip {
      float: left;
    }
    .tip {
      float: left;
      margin: 0 0 0 10px;
      padding: 0 10px;
      border: 1px solid #FFF2C2;
      border-radius: 9px;
      background: #FFFBE6;
      i {
        color: #FFAA00;
      }
    }
    .el-input {
      width: 590px;
      input {
        background: transparent;
      }
    }
    .el-textarea {
      width: 590px;
    }
  }
}
</style>
