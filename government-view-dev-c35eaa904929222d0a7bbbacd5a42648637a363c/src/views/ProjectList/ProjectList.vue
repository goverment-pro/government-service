<template>
  <el-tabs tab-position="left" v-model="activeName">
    <el-tab-pane label="项目信息" name="projectInfo">
      <v-head content="项目信息"></v-head>
      <project-info :origin="origin" :form="form.projectInfo" :selectList="selectList"></project-info>
    </el-tab-pane>
    <el-tab-pane label="建设地址" name="buildAddress">
      <v-head content="建设地址"></v-head>
      <build-address></build-address>
    </el-tab-pane>
    <el-tab-pane label="其他信息" name="otherInfo">
      <v-head content="其他信息"></v-head>
      <other-info :origin="origin" :form="form.otherInfo"></other-info>
    </el-tab-pane>
    <el-tab-pane label="工作进展" name="projectProgress">
      <v-head content="工作进展"></v-head>
      <project-progress :origin="origin" :form="form.projectProgress"></project-progress>
    </el-tab-pane>
    <el-tab-pane label="修改记录" name="projectRecord">
      <v-head content="修改记录"></v-head>
      <project-Record :origin="origin" :form="form.projectProgress"></project-Record>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import { fetchSelectList } from 'api/common.js'

import VHead from '@/components/VHead.vue'
import projectInfo from './components/projectInfo.vue'
import buildAddress from './components/buildAddress.vue'
import otherInfo from './components/otherInfo.vue'
import projectProgress from './components/projectProgress.vue'
import projectRecord from './components/projectRecord.vue'

export default {
  name: 'ProjectList',
  components: {
    VHead,
    projectInfo,
    buildAddress,
    otherInfo,
    projectProgress,
    projectRecord
  },
  data () {
    return {
      activeName: 'projectProgress',
      origin: '',
      form: {
        projectInfo: {},
        otherInfo: {},
        projectProgress: {}
      },
      selectList: [],
      queryData: this.$route.query
    }
  },
  created () {
    this.origin = 'increase'
    this.form.projectProgress = this.queryData
    // 初始化时获取所有 tab - 下拉项的数据
    fetchSelectList(['EVENT_TYPE', 'BELONG_TYPE', 'SUPPORT_LEVEL', 'EVENT_SOURCE'])
      .then(res => {
        this.selectList = res.data.data
      })
  }
}
</script>

<style lang="scss" scoped>
.el-tabs {
  margin: 24px 23px 0;
  /deep/ .el-tabs__header {
    margin-right: 20px;
    .el-tabs__nav {
      .el-tabs__item {
        text-align: left;
      }
    }
  }
}
</style>
