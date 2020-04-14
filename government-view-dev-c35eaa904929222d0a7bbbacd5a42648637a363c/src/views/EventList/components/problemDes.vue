<template>
  <el-form label-width="300px" ref="problemDes" :model="form">
    <el-form-item label="存在问题及原因：" prop="existProblem" :rules="[{ required: true, message: '请填写存在问题及原因', trigger: 'blur' }]">
      <el-input v-model="form.existProblem" type="textarea" placeholder="请输入... ..." rows="5" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item label="协调事项：">
      <el-input v-model="form.thingsToCoordinate" type="textarea" placeholder="请输入... ..." rows="5" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item label="研究解决意见：">
      <el-input v-model="form.researchSolution" type="textarea" placeholder="请输入... ..." rows="5" :disabled="isDisable"></el-input>
    </el-form-item>
    <el-form-item style="margin-left: 263px;">
      <el-button type="primary" @click="$emit('change-tab', 'baseInfo')">上一步</el-button>
      <el-button type="primary" @click="submitForm(true)">下一步</el-button>
      <el-button @click="$router.back()">返回</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: 'problemDes',
  props: ['origin', 'form'],
  computed: {
    isDisable () {
      return this.origin === 'view'
    }
  },
  methods: {
    submitForm (flag) {
      return this.$refs.problemDes.validate()
        .then(res => {
          !flag || this.$emit('change-tab', 'otherInfo')
          return true
        })
        .catch(err => {
          console.warn(err)
          return false
        })
    }
  }
}
</script>

<style lang="scss" scoped>
.el-form {
  margin: 25px auto 0;
}
</style>
