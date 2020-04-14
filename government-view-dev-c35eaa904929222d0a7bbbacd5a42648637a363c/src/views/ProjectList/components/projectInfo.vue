<template>
  <el-form label-width="95px" :model="form" :rules="rules" ref="projectInfo">
    <el-form-item label="所属区域：" required>
      <el-select v-model="form.area" :disabled="isDisable"></el-select>
    </el-form-item>
    <el-form-item label="街乡镇：" required>
      <el-select v-model="form.streetTown" :disabled="isDisable"></el-select>
    </el-form-item>
    <el-form-item label="项目分类：" required>
      <el-select v-model="form.streetTown" :disabled="isDisable">
        <el-option v-for="item in PROJECT_TYPE" :key="item.id"
          :label="item.codeName"
          :value="item.codeValue"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="支持级别：" required>
      <el-select class="el-select__tip"
        v-model="form.supportLevel"
        :disabled="isDisable"
        @change="(val) => selectChange('level', val)">
        <el-option
          v-for="item in SUPPORT_LEVEL"
          :key="item.id"
          :label="item.codeName"
          :value="item.codeValue"></el-option>
      </el-select>
      <p class="tip" v-show="showLevelTip"><i class="el-icon-warning"></i> {{ levelDes }}</p>
    </el-form-item>
    <el-form-item label="项目类别：" required>
      <el-select v-model="form.streetTown" :disabled="isDisable"></el-select>
    </el-form-item>
    <el-form-item label="项目名称：" required>
      <el-input v-model="form.streetTown" :disabled="isDisable" placeholder="请输入......"></el-input>
    </el-form-item>
    <!-- 根据支持级别（市级、区级、街乡镇），呈现相应的主管单位 -->
    <el-form-item label="主管单位：" required>
      <el-select v-model="form.streetTown" :disabled="isDisable"></el-select>
    </el-form-item>
    <el-form-item label="建设单位：">
      <el-input v-model="form.streetTown" :disabled="isDisable" placeholder="请输入......"></el-input>
    </el-form-item>
    <el-form-item label="是否立项：">
      <el-select v-model="form.streetTown" :disabled="isDisable"></el-select>
    </el-form-item>
    <el-form-item label="基本情况：" required>
      <el-input v-model="form.eventDesc" type="textarea" rows="9" placeholder="请输入......" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" style="margin-left: 100px;">下一步</el-button>
      <el-button>返回</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: 'projectInfo',
  props: ['form', 'origin', 'selectList'],
  computed: {
    isDisable () {
      return this.origin === 'view'
    }
  },
  data () {
    return {
      showLevelTip: false,
      levelDes: '',
      rules: {},
      PROJECT_TYPE: [
        {
          id: 1,
          codeName: '治理类',
          codeValue: '1'
        },
        {
          id: 2,
          codeName: '微提升类',
          codeValue: '2'
        },
        {
          id: 3,
          codeName: '腾退空间再利用类',
          codeValue: '3'
        }
      ],
      SUPPORT_LEVEL: [
        {
          id: 1,
          codeName: '市级',
          codeValue: '1',
          codeDesc: '需要市级主管部门解决'
        },
        {
          id: 2,
          codeName: '区级',
          codeValue: '2',
          codeDesc: '需要区级主管解决'
        },
        {
          id: 3,
          codeName: '街乡镇级',
          codeValue: '3',
          codeDesc: '街乡镇解决'
        }
      ]
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
      this[typeMap[type][1]] = this[typeMap[type][2]][val - 1].codeDesc
    }
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
    }
    .el-select {
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
