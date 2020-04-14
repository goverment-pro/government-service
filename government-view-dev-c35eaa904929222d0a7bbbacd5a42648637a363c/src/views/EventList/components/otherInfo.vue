<template>
  <el-form label-width="110px" :model="form" ref="otherInfo">
    <el-form-item label="牵头部门：" prop="departmentTakeLead" :rules="[{ required: true, message: '请选择牵头部门', trigger: 'change' }]">
      <el-select v-model="form.departmentTakeLead" :disabled="isDisable">
        <el-option v-for="opt in options" :key="opt.value" :label="opt.label" :value="opt.value"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="配合部门：">
      <el-input v-model="form.departmentCooperate" placeholder="请输入......" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item label="涉及企业：">
      <el-input v-model="form.companyInvolved" placeholder="请输入......" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item label="物业管理单位：">
      <el-input v-model="form.realtyManagementAgency" placeholder="请输入......" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item label="产权单位：">
      <el-input v-model="form.propertyRightOwner" placeholder="请输入......" :disabled="isDisable"></el-input>
    </el-form-item>
    <!-- 必须填入大于等于0的整数 -->
    <el-form-item label="户数：" prop="householdNumbers" :rules="[{ validator: validHouseNo }]">
      <el-input v-model="form.householdNumbers" placeholder="请输入......" :disabled="isDisable"></el-input>
    </el-form-item>
    <!-- 必须填入小数位不超过2且大于等于0的数字 -->
    <el-form-item label="面积：" prop="areaSize" :rules="[{ validator: validArea }]">
      <el-input placeholder="请输入......" v-model="form.areaSize" :disabled="isDisable">
        <template slot="append">平方米</template>
      </el-input>
    </el-form-item>
    <el-form-item label="计划完成日期：">
      <el-date-picker
        :picker-options="pickerOptions"
        v-model="form.planFinishDate"
        type="date"
        placeholder="请选择日期"
        value-format="yyyy-MM-dd"
        :disabled="isDisable">
      </el-date-picker>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" style="margin-left: 100px;" @click="$emit('change-tab', 'problemDes')">上一步</el-button>
      <el-button type="primary" @click="submitForm">保存</el-button>
      <el-button @click="$router.back()">返回</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { isInt, isDecimal } from 'utils/utils'
export default {
  name: 'otherInfo',
  props: ['origin', 'form'],
  computed: {
    isDisable () {
      return this.origin === 'view'
    }
  },
  data () {
    return {
      value: 1,
      options: [
        {
          label: '测试1',
          value: '1'
        },
        {
          label: '测试2',
          value: '2'
        }
      ],
      pickerOptions: {
        disabledDate (time) {
          return time.getTime() < Date.now() - 24 * 60 * 60 * 1000
        }
      }
    }
  },
  methods: {
    validHouseNo (rule, value, callback) {
      // 校验户数-必须填入大于等于0的整数
      if (!value) return
      !isInt(value) && callback(new Error('必须填入大于等于0的整数'))
    },
    validArea (rule, value, callback) {
      if (!value) return
      !isDecimal(value) && callback(new Error('必须填入小数位不超过2且大于等于0的数字'))
    },
    submitForm () {
      this.$refs.otherInfo.validateField('departmentTakeLead', (msg) => {
        if (msg) return
        // todo
        this.$emit('submit')
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.el-form {
  margin: 25px auto 0;
  width: 1005px;
  /deep/ .el-form-item__content {
    .el-select {
      .el-input {
        input {
          background: transparent;
        }
      }
    }
    .el-input {
      width: 590px;
    }
    .el-date-editor {
      width: 300px;
      input {
        background: transparent;
      }
    }
  }
}
</style>
