<template>
  <div>
      <div class="top">
          <el-form :model="form" ref="ruleForm" label-width="100px" class="demo-ruleForm">
              <el-row :gutter="20">
                  <el-col :span="8"><div class="grid-content bg-purple fillDate">
                      <el-form-item label="填报日期:" prop="date">
                          <el-date-picker
                                  v-model="submissionDate"
                                  type="daterange"
                                  range-separator="-"
                                  start-placeholder="请选择日期"
                                  end-placeholder="请选择日期">
                          </el-date-picker>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="6"><div class="grid-content bg-purple">
                      <el-form-item label="所属区域:" prop="area">
                          <el-select v-model="form.area" placeholder="请选择" @change="regionChange">
                              <el-option
                                      v-for="item in regionList"
                                      :key="item.placeCode"
                                      :label="item.placeName"
                                      :value="item.placeCode">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="5"><div class="grid-content bg-purple">
                      <el-form-item label="街乡镇:" prop="street">
                          <el-select v-model="form.streetTown" placeholder="全部">
                              <el-option
                                      v-for="item in streetList"
                                      :key="item.placeCode"
                                      :label="item.placeName"
                                      :value="item.placeCode">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="5"><div class="grid-content bg-purple">
                      <el-form-item label="支持级别:" prop="supportLevel">
                          <el-select v-model="form.supportLevel" placeholder="全部">
                              <el-option
                                      v-for="item in supportLevel"
                                      :key="item.codeValue"
                                      :label="item.codeName"
                                      :value="item.codeValue">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
              </el-row>
              <el-row :gutter="20">
                  <el-col :span="8"><div class="grid-content bg-purple belongCate">
                      <el-form-item label="所属类别:" prop="belongType">
                          <el-select v-model="form.belongType" placeholder="全部">
                              <el-option
                                      v-for="item in belongType"
                                      :key="item.codeValue"
                                      :label="item.codeName"
                                      :value="item.codeValue">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="6"><div class="grid-content bg-purple">
                      <el-form-item label="事项类型:" prop="eventCategory">
                          <el-select v-model="form.eventType" placeholder="请选择">
                              <el-option
                                      v-for="item in eventType"
                                      :key="item.codeValue"
                                      :label="item.codeName"
                                      :value="item.codeValue">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="5"><div class="grid-content bg-purple">
                      <el-form-item label="地址类型:" prop="addressCategory">
                          <el-select v-model="form.addressType" placeholder="全部">
                              <el-option
                                      v-for="item in addressType"
                                      :key="item.codeValue"
                                      :label="item.codeName"
                                      :value="item.codeValue">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="5"><div class="grid-content bg-purple">
                      <template>
                          <el-button v-if="!isOpen" type="primary" @click="queryEventList" class="btn-query">查询</el-button>
                          <el-button v-if="!isOpen" @click="resetList" class="btn-reset">重置</el-button>
                          <el-button v-if="!isOpen"  @click="zhankai" class="btn-open">{{isOpenText}}</el-button>
                      </template>
                      <template v-if="isOpen">
                          <el-form-item label="牵头部门:" prop="departmentTakeLead">
                              <el-select v-model="form.departmentTakeLead" placeholder="全部">
                                  <el-option
                                          v-for="item in regionList"
                                          :key="item.value"
                                          :label="item.label"
                                          :value="item.value">
                                  </el-option>
                              </el-select>
                          </el-form-item>
                      </template>
                  </div></el-col>
              </el-row>
              <el-row :gutter="20" v-if="isOpen">
                  <el-col :span="8"><div class="grid-content bg-purple">
                      <el-form-item label="事项来源:" prop="eventSource">
                          <el-select v-model="form.eventSource" placeholder="全部">
                              <el-option
                                      v-for="item in eventSource"
                                      :key="item.codeValue"
                                      :label="item.codeName"
                                      :value="item.codeValue">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="6"><div class="grid-content bg-purple">
                      <el-form-item label="填报状态:" prop="fillState">
                          <el-select v-model="form.commited" placeholder="全部">
                              <el-option
                                      v-for="item in commitState"
                                      :key="item.codeValue"
                                      :label="item.codeName"
                                      :value="item.codeValue">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="5"><div class="grid-content bg-purple">
                      <el-form-item label="进展状态:" prop="progressStateName">
                          <el-select v-model="form.currentProgressState" placeholder="全部">
                              <el-option
                                      v-for="item in progressState"
                                      :key="item.codeValue"
                                      :label="item.codeName"
                                      :value="item.codeValue">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="5"><div class="grid-content bg-purple">
                      <el-form-item label="完成状态:" prop="completeState">
                          <el-select v-model="form.finished" placeholder="全部">
                              <el-option
                                      v-for="item in finishState"
                                      :key="item.codeValue"
                                      :label="item.codeName"
                                      :value="item.codeValue">
                              </el-option>
                          </el-select>
                      </el-form-item>
                  </div></el-col>
              </el-row>
              <el-row :gutter="20" v-if="isOpen">
                  <el-col :span="8"><div class="grid-content bg-purple">
                      <el-form-item label="事项描述：" prop="eventDesc">
                          <el-input v-model="form.eventDesc" placeholder="请输入"></el-input>
                      </el-form-item>
                  </div></el-col>
                  <el-col :span="6"><div class="grid-content bg-purple">
                      <template>
                          <el-button v-if="isOpen" type="primary" @click="queryEventList" class="btn-query">查询</el-button>
                          <el-button v-if="isOpen" @click="resetList" class="btn-reset">重置</el-button>
                          <el-button v-if="isOpen"  @click="zhankai" class="btn-open">{{isOpenText}}</el-button>
                      </template>
                  </div></el-col>
              </el-row>
          </el-form>

          <el-row>
              <el-col :span="12"><div class="grid-content bg-purple">
                  <el-button type="primary" @click="addEvent">+新建</el-button>
                  <el-button type="primary" :disabled="isDisabled" @click="submitArr">提交</el-button>
                  <el-button type="danger" :disabled="isDelDisabled" @click="delArrEvent">删除</el-button>
                  <el-button type="primary">点位地图</el-button>
                  <el-button >全部导出</el-button>
              </div></el-col>
              <el-col :span="12"><div class="grid-content bg-purple-light rightNum">
                  <span class="">总数：{{classCount.totalCount}}</span>
                  <span class="btn-w policyNum">政策类：{{classCount.policyClassCount}}</span>
                  <span class="btn-w coordinateNum">协调类：{{classCount.coordinateClassCount}}</span>
                  <span class="btn-w projectNum">项目类：{{classCount.projectClassCount}}</span>
                  <span class="btn-w otherNum">其他类：{{classCount.otherClassCount}}</span>
                  <span class="cityNum"><i class="circle"></i> 市级：{{classCount.cityLevelCount}}</span>
                  <span class="aresNum"><i class="circle"></i> 区级：{{classCount.districtLevelCount}}</span>
                  <span class="townNum"><i class="circle"></i> 街乡镇级：{{classCount.streetTownLevelCount}}</span>
              </div></el-col>
          </el-row>
          <!--表格-->
          <el-table
                  :data="eventList"
                  style="width: 100%"
                  border
          >
              <el-table-column
                      type="index"
                      label="序号"
                      width="50">
              </el-table-column>
              <el-table-column
                      prop="area"
                      label="所属区域"
                      width="150">
                  <template slot-scope="scope">
                      <el-checkbox name="type" @change="checkState($event, scope.row.id, scope.row.commited, scope.row.finished)"></el-checkbox>
                      <span style="margin-left: 10px">{{ scope.row.area }}</span>
                  </template>
              </el-table-column>
              <el-table-column
                      prop="streetTown"
                      label="街乡镇"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="supportLevelName"
                      label="支持级别"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="belongTypeName"
                      label="所属类别"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="address"
                      label="事项类型"
                      width="180">
              </el-table-column>
              <el-table-column
                      prop="eventDesc"
                      label="事项描述"
                      width="180">
              </el-table-column>
              <el-table-column
                      prop="zip"
                      label="详细地址"
                      width="180">
              </el-table-column>
              <el-table-column
                      prop="progressStateName"
                      label="进展状态"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="zip"
                      label="牵头部门"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="zip"
                      label="地址类型"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="zip"
                      label="涉及点位数量"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="eventSourceName"
                      label="事项来源"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="zip"
                      label="填报状态"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="finishStateName"
                      label="完成状态"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="fillInTime"
                      label="填报日期"
                      width="120">
              </el-table-column>
              <el-table-column
                      prop="planFinishDate"
                      label="计划完成日期"
                      width="120">
              </el-table-column>
              <el-table-column
                      fixed="right"
                      label="操作"
                      width="420">
                  <template slot-scope="scope">
                      <el-button
                              size="mini"
                              @click="handleQuery(scope.row.id)">查看</el-button>
                      <el-button
                              v-if="(scope.row.finished === '1' && !scope.row.commited) || (scope.row.commited && scope.row.finished === '2')"
                              size="mini"
                              @click="handleEdit(scope.row)">编辑</el-button>
                      <el-button
                              v-if="scope.row.commited && scope.row.finished === '2'"
                              size="mini"
                              type="primary"
                              @click="toProgress(scope.$index, scope.row.id)">进展</el-button>
                      <el-button
                              v-if="scope.row.finished === '1' && !scope.row.commited"
                              size="mini"
                              type="primary"
                              @click="submitEvent(scope.row.id)">提交</el-button>
                      <el-button
                              v-if="scope.row.commited && scope.row.finished === '2'"
                              size="mini"
                              type="danger"
                              @click="handleCommit(scope.row.id)">完成</el-button>
                      <el-button
                              v-if="(scope.row.finished === '1' && !scope.row.commited) || (scope.row.commited && scope.row.finished === '2')"
                              size="mini"
                              type="danger"
                              @click="delEvent(scope.row.id)">删除</el-button>
                  </template>
              </el-table-column>
          </el-table>
          <!--分页-->
          <el-row>
              <el-col :span="12"><div class="grid-content bg-purple totalNum">
                  共{{classCount.totalCount}}条记录 第{{currentPage1}}页
              </div></el-col>
              <el-col :span="12"><div class="grid-content bg-purple-light rightPage">
                  <el-pagination
                          background
                          @size-change="handleSizeChange"
                          @current-change="handleCurrentChange"
                          :current-page.sync="currentPage1"
                          :page-size="form.pageSize"
                          :page-sizes="[10, 20, 30, 40]"
                          layout="prev, pager, next, jumper, sizes"
                          :total="+classCount.totalCount">
                  </el-pagination>
              </div></el-col>
          </el-row>
      </div>
  </div>
</template>

<script>
import { fetchSelectList, queryList, deleteEvent, queryClassList, fetchRegionList, submitEvent, commitEvent } from '@/api/eventManage.js'
// import request from '@/utils/request'
export default {
  name: 'EventManage',
  data () {
    return {
      submissionDate: '', // 填报日期
      area: '', // 所属区域
      regionList: [],
      streetTown: '',
      streetList: [],
      belongType: [
        { label: '协调类', value: '1' },
        { label: '政策类', value: '2' },
        { label: '项目类', value: '3' },
        { label: '其它类', value: '4' }
      ],
      supportLevel: [
        { label: '市级', value: '1' },
        { label: '区级', value: '2' },
        { label: '街乡镇级', value: '3' }
      ],
      eventSource: [
        { label: '主动治理', value: '1' },
        { label: '12345诉求', value: '2' },
        { label: '其它', value: '3' }
      ],
      progressState: [],
      addressType: [],
      commitState: [],
      finishState: [],
      eventType: [],
      isOpen: false,
      isOpenText: '展开',
      eventList: [],
      currentPage1: 1,
      eventDesc: '',
      form: {
        area: '',
        streetTown: '',
        supportLevel: '',
        belongType: '',
        eventType: '',
        addressType: '',
        departmentTakeLead: '',
        commited: '',
        eventSource: '',
        currentProgressState: '',
        finished: '',
        eventDesc: '',
        startDate: '',
        endDate: '',
        pageNo: 1,
        pageSize: 10
      },
      delArr: [],
      subArr: [],
      isDelArr: false,
      queryData: {
        pageNo: 1,
        pageSize: 10,
        addressType: '',
        area: '',
        eventSource: ''
      },
      classCount: {
        totalCount: '',
        coordinateClassCount: '',
        policyClassCount: '',
        projectClassCount: '',
        otherClassCount: '',
        cityLevelCount: '',
        districtLevelCount: '',
        streetTownLevelCount: ''
      },
      isDisabled: true,
      isDelDisabled: true,
      isSubmit: false
    }
  },
  methods: {
    queryEventList () { // 查询
      queryList(this.form)
        .then((data) => {
          // console.log(this.form)
          this.eventList = data.data.data.records
          this.eventList.forEach((item, index) => {
            this.supportLevel.forEach((eva, i) => {
              if (Number(item.supportLevel) === Number(eva.codeValue)) {
                item.supportLevelName = eva.codeName
              }
            })
            this.belongType.forEach((eva1, i1) => {
              if (Number(item.belongType) === Number(eva1.codeValue)) {
                item.belongTypeName = eva1.codeName
              }
            })
            this.eventSource.forEach((eva2, i2) => {
              if (Number(item.eventSource) === Number(eva2.codeValue)) {
                item.eventSourceName = eva2.codeName
              }
            })
            this.addressType.forEach((eva2, i2) => {
              if (Number(item.eventSource) === Number(eva2.codeValue)) {
                item.eventSourceName = eva2.codeName
              }
            })
            this.finishState.forEach((eva2, i2) => {
              if (Number(item.currentProgressState) === Number(eva2.codeValue)) {
                item.finishStateName = eva2.codeName
              }
            })
            this.progressState.forEach((eva2, i2) => {
              if (Number(item.areaSize) === Number(eva2.codeValue)) {
                item.progressStateName = eva2.codeName
              }
            })
            this.regionList.forEach((eva2, i2) => {
              if (Number(item.area) === Number(eva2.placeCode)) {
                item.area = eva2.placeName
              }
            })
          })
        })
    }, // 查询列表
    // 查询分类列表
    queryClass () {
      queryClassList()
        .then((data) => {
          this.classCount = data.data.data
          // console.log(data)
        })
    },
    // 区域改变- 获取街乡镇下拉列表
    regionChange (regionCode) {
      fetchRegionList({
        upplaceCode: regionCode
      }).then(res => {
        this.streetList = res.data.data
      })
    },
    checkState (e, id, commited, finished) {
      console.log(e, commited)
      // 提交列表
      if (e && !commited) {
        this.isDisabled = false
        // this.delArr.push(Number(id))
        this.subArr.push(Number(id))
      } else if (!e) {
        this.subArr.forEach((item, index) => {
          if (Number(item) === Number(id)) {
            this.subArr.splice(index, 1)
          }
        })
        if (this.subArr.length > 0) {
          this.isDisabled = false
        } else {
          this.isDisabled = true
        }
      }
      // 删除列表
      if (e && finished !== '3') {
        this.isDelDisabled = false
        this.delArr.push(Number(id))
      } else if (!e) {
        this.delArr.forEach((item, index) => {
          if (Number(item) === Number(id)) {
            this.delArr.splice(index, 1)
          }
        })
        if (this.delArr.length > 0) {
          this.isDelDisabled = false
        } else {
          this.isDelDisabled = true
        }
      }
    },
    // 批量提交
    submitArr () {
      this.$confirm('确定要继续提交吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        submitEvent(this.subArr)
          .then((data) => {
            // console.log(data.data.code)
            if (data.data.code === 20000) {
              this.queryEventList()
              this.$message({
                type: 'success',
                message: '提交成功!'
              })
            }
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消提交'
        })
      })
    },
    // 提交
    submitEvent (id) {
      this.delArr.push(Number(id))
      this.$confirm('确定要继续提交吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        submitEvent(this.subArr)
          .then((data) => {
            if (data.data.code === 20000) {
              this.queryEventList()
              this.isSubmit = true
              this.$message({
                type: 'success',
                message: '提交成功!'
              })
            }
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消提交'
        })
      })
    },
    // 删除
    delEvent (id) {
      this.delArr.push(Number(id))
      this.$confirm('确定要继续删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteEvent(this.delArr)
          .then((data) => {
            // console.log(data.data.code)
            if (data.data.code === 20000) {
              this.queryEventList()
              this.delArr = []
              this.$message({
                type: 'success',
                message: '删除成功!'
              })
            }
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    // 批量删除
    delArrEvent () {
      this.$confirm('确定要继续删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteEvent(this.delArr)
          .then((data) => {
            // console.log(data.data.code)
            if (data.data.code === 20000) {
              this.queryEventList()
              this.$message({
                type: 'success',
                message: '删除成功!'
              })
            }
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    resetList () { // 重置

    },
    // 点击完成
    handleCommit (id) {
      this.delArr.push(Number(id))
      this.$confirm('确定要继续吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        commitEvent(this.delArr)
          .then((data) => {
            // console.log(data.data.code)
            if (data.data.code === 20000) {
              this.queryEventList()
              this.isSubmit = true
              this.$message({
                type: 'success',
                message: '提交成功!'
              })
            }
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消提交'
        })
      })
    },
    addEvent () {
      this.$router.push({
        path: '/eventList',
        name: 'EventList',
        params: {
          key: 'key',
          msgKey: this.msg
        }
      })
    }, // 新建
    zhankai () { // 展开
      this.isOpen = !this.isOpen
      if (this.isOpenText === '收起') {
        this.isOpenText = '展开'
      } else {
        this.isOpenText = '收起'
      }
      // this.isOpenText = '收起' ? '展开' : '收起'
    },
    handleSizeChange (val) {
      this.form.pageSize = val
      this.queryEventList()
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (val) {
      this.form.pageNo = val
      this.queryEventList()
      console.log(`当前页: ${val}`)
    },
    // 查看
    handleQuery (id) {
      this.$router.push({
        path: '/eventList',
        query: {
          origin: 'view',
          id
        }
      })
    },
    handleEdit (row) {
      this.$router.push({
        path: '/eventList',
        query: {
          origin: 'edit',
          eventId: row.id
        }
      })
      // var editData = this.eventList[index]
      // this.$router.push({
      //   path: '/eventList',
      //   name: 'EventList',
      //   params: {
      //     origin: 'edit',
      //     area: editData.area,
      //     streetTown: editData.streetTown,
      //     eventType: editData.eventType,
      //     belongType: editData.belongType,
      //     supportLevel: editData.supportLevel,
      //     eventDesc: editData.eventDesc,
      //     eventSource: editData.eventSource,
      //     workOrderNo: editData.workOrderNo
      //   }
      // })
    },
    // 新建进展
    toProgress (index, id) {
      // var editData = this.eventList[index]
      this.$router.push({
        path: '/eventList',
        name: 'EventList',
        query: {
          isProgress: true,
          origin: 'increase',
          eventId: id
          // isDialog: true,
          // currentProgressState: editData.currentProgressState
        }
      })
      // window.localStorage.setItem('eventId', id)
    },
    handleDelete (index, row) {
      console.log(index, row)
    }
  },
  created () {
    fetchSelectList({})
      .then(({ data }) => {
        this.belongType = data.data.BELONG_TYPE
        this.supportLevel = data.data.SUPPORT_LEVEL
        this.progressState = data.data.EVENT_PROGRESS_STATE
        this.eventType = data.data.EVENT_TYPE
        this.eventSource = data.data.EVENT_SOURCE
        this.addressType = data.data.ADDRESS_TYPE
        this.commitState = data.data.COMMIT_STATE
        this.finishState = data.data.FINISH_STATE
      })
    fetchRegionList({
      placeType: '01'
    }).then(res => {
      // console.log(1111111, res)
      this.regionList = res.data.data
    })
    this.queryEventList()
    this.queryClass()
  }
}
</script>

<style lang="scss" scoped>
    .top{
        padding: 18px 15px 30px 24px;
        .btn-open, .btn-reset, .btn-query{
            width: 72px;
            height: 38px;
        }
        .btn-query{
            margin-left: 28px;
        }
        .belongCate{
            /deep/.el-input__inner{
                width: 350px;
            }
        }
        .fillDate{
            /deep/.el-input__inner{
                width: 350px;
            }
        }
        .btn-open{
            border: none;
            background-color: transparent;
            color: #2C8CF0;
        }
        .rightNum{
            text-align: right;
            padding-right: 28px;
            padding-top: 14px;
            box-sizing: border-box;
            .btn-w{
                display: inline-block;
                width: 89px;
                height: 26px;
                line-height: 26px;
                text-align: center;
                color: #FFF;
                margin-left: 13px;
                &.policyNum{
                    background-color: #DB5A47;
                }
                &.coordinateNum{
                    background-color: #52B259;
                }
                &.projectNum{
                    background-color: #6E8FDC;
                }
                &.otherNum{
                    background-color: #3E5AA3;
                }
            }
            .circle{
                display: inline-block;
                width: 12px;
                height: 12px;
                border-radius: 12px;
                vertical-align: middle;
                margin-left: 12px;
            }
            .cityNum{
                .circle{
                    background-color: #72A7C6;
                }
            }
            .aresNum{
                .circle{
                    background-color: #C09C78;
                }
            }
            .townNum{
                .circle{
                    background-color: #0741A2;
                }
            }
        }
        .rightPage{
            text-align: right;
            margin-top: 23px;
            font-size: 17px;
            /deep/.el-pagination{
                .btn-prev, .btn-next{
                    width: 43px;
                    height: 37px;
                    text-align: center;
                    line-height: 37px;
                    border-radius: 3px;
                    border: 1px solid #DFDFDF;
                }
                .el-pager{
                    li{
                        width: 38px;
                        height: 37px;
                        text-align: center;
                        line-height: 37px;
                        border-radius: 3px;
                        border: 1px solid #DFDFDF;
                    }
                }
                .el-input--suffix{
                    width: 104px;
                    height: 37px;
                    background-color: #FFF;
                    .el-input__inner{
                        width: 104px;
                        height: 37px;
                        background-color: #FFF;
                    }
                }
                .el-pagination__jump{
                    line-height: 37px;
                    font-size: 17px;
                    color: #575A61;
                    vertical-align: middle;
                    .el-input__inner{
                        width: 46px;
                      background-color: #FFF;
                    }
                }
            }
        }
        .totalNum{
            margin-top: 23px;
            color: #575A61;
            font-size: 17px;
        }
    }
    .el-row {
        margin-bottom: 20px;
        &:last-child {
            margin-bottom: 0;
        }
    }
    .el-col {
        border-radius: 4px;
        /deep/.el-range-editor{
            background-color: transparent;
            .el-icon-date{
                display: none;
            }
            .el-range-input{
                background-color: transparent;
            }
        }
        /deep/.el-input__inner{
            width: 260px;
            background-color: transparent;
        }
    }
    .bg-purple-dark {
        /*background: #99a9bf;*/
    }
    .bg-purple {
        /*background: #d3dce6;*/
    }
    .bg-purple-light {
        /*background: #e5e9f2;*/
    }
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }
    .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }
</style>
