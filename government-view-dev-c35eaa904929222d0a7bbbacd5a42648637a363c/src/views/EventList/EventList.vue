<template>
  <el-tabs tab-position="left" v-model="activeName">
    <el-tab-pane label="基本信息" name="baseInfo">
      <v-head content="基本信息"></v-head>
      <base-info :origin="origin" :form="form.baseInfo" :selectList="selectList" @change-tab="changeTab" ref="baseInfo"></base-info>
    </el-tab-pane>
    <el-tab-pane label="涉及点位" name="relatePoint">
      <v-head content="涉及点位"></v-head>
    </el-tab-pane>
    <el-tab-pane label="存在问题及解决意见" name="problemDes">
      <v-head content="存在问题及解决意见"></v-head>
      <problem-des :origin="origin" :form="form.problemInfo" @change-tab="changeTab" ref="problemDes"></problem-des>
    </el-tab-pane>
    <el-tab-pane label="其他信息" name="otherInfo">
      <v-head content="其他信息"></v-head>
      <other-info :origin="origin" :form="form.otherInfo" @change-tab="changeTab" @submit="submitForm"></other-info>
    </el-tab-pane>
    <el-tab-pane label="工作进展" name="workProgress" v-if="isProgress">
      <v-head content="工作进展"></v-head>
      <work-progress :origin="origin" :form="form.workProgress"></work-progress>
    </el-tab-pane>
    <el-tab-pane label="修改记录" name="recordInfo" v-if="isProgress">
      <v-head content="修改记录"></v-head>
      <record :origin="origin" :form="form.recordInfo"></record>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
import { fetchSelectList } from 'api/common.js'
import { saveEvent, queryInfo } from 'api/eventList.js'
import VHead from '@/components/VHead.vue'
import baseInfo from './components/baseInfo.vue'
import problemDes from './components/problemDes.vue'
import otherInfo from './components/otherInfo.vue'
import workProgress from './components/workProgress.vue'
import record from './components/record.vue'

export default {
  name: 'EventList',
  components: {
    VHead,
    baseInfo,
    problemDes,
    otherInfo,
    workProgress,
    record
  },
  data () {
    return {
      origin: '',
      activeName: 'baseInfo',
      form: {
        baseInfo: {
          id: null,
          area: '',
          streetTown: '',
          eventType: null,
          belongType: '',
          supportLevel: '',
          eventDesc: '',
          eventSource: '',
          workOrderNo: ''
        },
        problemInfo: {
          existProblem: '',
          thingsToCoordinate: '',
          researchSolution: ''
        },
        otherInfo: {
          departmentTakeLead: '',
          departmentCooperate: '',
          companyInvolved: '',
          realtyManagementAgency: '',
          propertyRightOwner: '',
          householdNumbers: '',
          areaSize: '',
          planFinishDate: ''
        },
        workProgress: {
          relatedId: ''
        },
        recordInfo: {

        }
      },
      paramsData: this.$route.query,
      selectList: {},
      isProgress: false
    }
  },
  created () {
    // 初始化时获取所有 tab - 下拉项的数据
    fetchSelectList(['EVENT_TYPE', 'BELONG_TYPE', 'SUPPORT_LEVEL', 'EVENT_SOURCE'])
      .then(res => {
        this.selectList = res.data.data
      })
    this.isProgress = this.$route.query.isProgress
    if (this.isProgress) {
      this.form.workProgress = this.paramsData
      this.form.recordInfo = this.paramsData
      this.activeName = 'workProgress'
    }

    const isIncrease = !this.$route.query.origin
    // 如果 origin 没有值代表新增
    if (isIncrease) return

    this.origin = this.$route.query.origin
    const eventId = this.$route.query.eventId
    // 查询
    this.queryEventInfo(eventId)
  },
  methods: {
    queryEventInfo (eventId) {
      queryInfo({ eventId })
        .then(res => {
          const {
            id,
            area,
            streetTown,
            eventType,
            belongType,
            supportLevel,
            eventDesc,
            eventSource,
            workOrderNo,
            existProblem,
            thingsToCoordinate,
            researchSolution,
            departmentTakeLead,
            departmentCooperate,
            companyInvolved,
            realtyManagementAgency,
            propertyRightOwner,
            householdNumbers,
            areaSize,
            planFinishDate
          } = res.data.data.event
          this.$refs.baseInfo.regionChange(area)
            .then(() => {
              this.form.baseInfo = Object.assign({}, this.form.baseInfo, {
                id,
                area,
                streetTown,
                eventType,
                belongType,
                supportLevel,
                eventDesc,
                eventSource,
                workOrderNo
              })
            })
          this.form.problemInfo = Object.assign({}, this.form.problemInfo, {
            existProblem,
            thingsToCoordinate,
            researchSolution
          })
          this.form.otherInfo = Object.assign({}, this.form.otherInfo, {
            departmentTakeLead,
            departmentCooperate,
            companyInvolved,
            realtyManagementAgency,
            propertyRightOwner,
            householdNumbers,
            areaSize,
            planFinishDate
          })
          this.oldObj = res.data.data.event
        })
    },
    changeTab (tabName) {
      this.activeName = tabName
    },
    submitForm () {
      this.$refs.baseInfo.submitForm(false)
        .then(res => {
          if (res) return false
          this.activeName = 'baseInfo'
          return true
        })
        .then(res => {
          // 验证问题及意见
          if (res) return
          this.$refs.problemDes.submitForm(false)
            .then(res => {
              if (!res) {
                this.activeName = 'problemDes'
              } else {
                if (!this.origin) {
                  // 新增
                  saveEvent({
                    newObj: { ...this.form.baseInfo, ...this.form.problemInfo, ...this.form.otherInfo }
                  }).then(res => {
                    if (res.data.code === 20000) {
                      this.$router.back()
                    }
                  })
                } else {
                  // 修改
                  saveEvent({
                    newObj: Object.assign({}, this.oldObj, { ...this.form.baseInfo, ...this.form.problemInfo, ...this.form.otherInfo }),
                    oldObj: this.oldObj
                  }).then(res => {
                    if (res.data.code === 20000) {
                      this.$router.back()
                    }
                  })
                }
              }
            })
        })
    }
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
