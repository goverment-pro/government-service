<template>
  <el-form label-width="110px" :model="form" ref="otherInfo">
    <el-form-item label="占地面积：">
      <el-input placeholder="请输入......" v-model="form.areaSize" :disabled="isDisable">
        <template slot="append">公顷</template>
      </el-input>
    </el-form-item>
    <el-form-item label="建筑面积：">
      <el-input placeholder="请输入......" v-model="form.areaSize" :disabled="isDisable">
        <template slot="append">万平方米</template>
      </el-input>
    </el-form-item>
    <el-form-item label="现状用地性质：">
      <el-input v-model="form.departmentCooperate" placeholder="请输入......" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item label="规划用地性质：">
      <el-input v-model="form.companyInvolved" placeholder="请输入......" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item label="资金来源：">
      <el-select v-model="form.fundOrigin" :disabled="isDisable">
        <el-option
          v-for="item in FUND_ORIGIN"
          :key="item.id"
          :label="item.codeName"
          :value="item.codeValue"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="所需资金：">
      <el-input placeholder="请输入......" v-model="form.areaSize" :disabled="isDisable">
        <template slot="append">万元</template>
      </el-input>
    </el-form-item>
    <el-form-item label="项目开始日期：">
      <el-date-picker
        :picker-options="pickerOptions"
        v-model="form.planFinishDate"
        type="date"
        placeholder="请选择日期"
        :disabled="isDisable">
      </el-date-picker>
    </el-form-item>
    <el-form-item label="项目结束日期：">
      <el-date-picker
        :picker-options="pickerOptions"
        v-model="form.planFinishDate"
        type="date"
        placeholder="请选择日期"
        :disabled="isDisable">
      </el-date-picker>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" style="margin-left: 100px;">上一步</el-button>
      <el-button type="primary">保存</el-button>
      <el-button>返回</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
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
      pickerOptions: {
        disabledDate (time) {
          return time.getTime() < Date.now() - 24 * 60 * 60 * 1000
        }
      },
      FUND_ORIGIN: [
        {
          id: 1,
          codeName: '市财政资金项目',
          codeValue: '1'
        },
        {
          id: 2,
          codeName: '市政府固定资产投资项目',
          codeValue: '2'
        },
        {
          id: 3,
          codeName: '专业公司建设实施',
          codeValue: '3'
        }
      ]
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
