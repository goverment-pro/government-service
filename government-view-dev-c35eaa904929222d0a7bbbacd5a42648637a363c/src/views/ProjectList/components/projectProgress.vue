<template>
    <div>
        <div class="delate-step" v-if="activities.length !==0">
            <div style="width: 100%; height: 300px; padding: 20px 0 50px 40px; display: table; margin-top: 10px;">
                <div class="delate-step-lt">
                    <div
                            class="delate-time"
                            :style="{'top': `${index*142}px`}"
                            v-for="(item, index) in activities"
                            :key="index"
                    >{{item.progressWirteDate}}</div>
                </div>
                <div class="delate-step-rt">
                    <el-timeline :reverse="reverse">
                        <el-timeline-item
                                v-for="(activity, index) in activities"
                                :key="index">
                            {{activity.progressDesc}}
                            <el-button type="primary" class="btn-common" style="margin-left: 10px;" @click="editProgress(activity.id, index)">编辑</el-button>
                            <el-button type="danger" class="btn-common" @click="delProgress(activity.id, index)">删除</el-button>
                            <div class="imgBox">
                                <ul>
                                    <li>
                                        <img src="@/assets/logo.png" alt="">
                                    </li>
                                    <li>
                                        <img src="@/assets/logo.png" alt="">
                                    </li>
                                    <li>
                                        <img src="@/assets/logo.png" alt="">
                                    </li>
                                    <li>
                                        <img src="@/assets/logo.png" alt="">
                                    </li>
                                </ul>
                            </div>
                        </el-timeline-item>
                    </el-timeline>
                </div>
            </div>
        </div>
        <el-row>
            <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
            <el-col :span="8"><div class="grid-content bg-purple-light">
                <el-button type="primary" @click="isDialog = true">填写进度</el-button>
                <el-button type="primary" @click="dialogWorkProgress = true">进度修改记录</el-button>
                <el-button>返回</el-button>
            </div></el-col>
        </el-row>
        <!--新建工作进展弹框-->
        <el-dialog title="工作进展" :visible.sync="isDialog">
            <el-form :model="formProgress" :rules="rules" ref="progress">
                <el-form-item label="进展状态" :label-width="formLabelWidth" prop="progressState">
                    <el-select v-model="formProgress.progressState" placeholder="请选择">
                        <el-option
                                v-for="item in progressState"
                                :key="item.codeValue"
                                :label="item.codeName"
                                :value="item.codeValue"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="进展说明" :label-width="formLabelWidth" prop="explain">
                    <el-input v-model="formProgress.explain" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="附件上传" :label-width="formLabelWidth">
                    <input type="file" name="file" id="fileExport" @change="handleFileChange" ref="inputer" multiple>
                    <!--                    <el-upload-->
                    <!--                            class="upload-demo"-->
                    <!--                            action="http://49.233.83.167:8080/lm-progress/upload"-->
                    <!--                            :on-success="handlePreview"-->
                    <!--                            :on-remove="handleRemove"-->
                    <!--                            :before-remove="beforeRemove"-->
                    <!--                            multiple-->
                    <!--                            :limit="3"-->
                    <!--                            :on-exceed="handleExceed"-->
                    <!--                            :file-list="fileList">-->
                    <!--                        <el-button size="small" type="primary">点击上传</el-button>-->
                    <!--                        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>-->
                    <!--                    </el-upload>-->
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="isDialog = false">取 消</el-button>
                <el-button type="primary" @click="submitProgress">提交</el-button>
            </div>
        </el-dialog>
        <!--编辑工作进展弹框-->
        <el-dialog title="工作进展" :visible.sync="isEditDialog">
            <el-form :model="editProObj" :rules="rules" ref="progress">
                <el-form-item label="进展状态" :label-width="formLabelWidth" prop="progressState">
                    <el-select v-model="editProObj.progressState" placeholder="请选择">
                        <el-option
                                v-for="item in progressState"
                                :key="item.codeValue"
                                :label="item.codeName"
                                :value="item.codeValue"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="进展说明" :label-width="formLabelWidth" prop="explain">
                    <el-input v-model="editProObj.explain" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="附件上传" :label-width="formLabelWidth">
                    <input type="file" name="file" id="fileExport" @change="handleFileChange" ref="inputer">
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="isEditDialog = false">取 消</el-button>
                <el-button type="primary" @click="submitEditProgress">提交</el-button>
            </div>
        </el-dialog>
        <!--进展记录弹框-->
        <el-dialog title="进展修改记录" :visible.sync="dialogWorkProgress">
            <el-table
                    :data="progressData"
                    :header-cell-style="headClass"
                    border
            >
                <el-table-column property="date" label="操作员" width="150"></el-table-column>
                <el-table-column property="name" label="操作类型" width="150"></el-table-column>
                <el-table-column property="progressDesc" label="操作内容"></el-table-column>
                <el-table-column property="progressWirteDate" label="操作时间" width="150"></el-table-column>
            </el-table>
        </el-dialog>
    </div>
</template>

<script>
import { deleteProgress, fetchSelectList, addWorkProgress, queryWorkProgress, uploadFile, queryProjectProgressModifyRecord } from '@/api/projectManage.js'
export default {
  name: 'projectProgress',
  props: ['origin', 'form'],
  data () {
    return {
      reverse: true,
      activities: [
        { content: '活动按期开始', timestamp: '2018-04-15' },
        { content: '通过审核', timestamp: '2018-04-13' },
        { content: '创建成功', timestamp: '2018-04-11' }
      ],
      progressData: [],
      dialogWorkProgress: false,
      isDialog: false,
      isEditDialog: false,
      formProgress: {
        explain: '',
        progressState: ''
      },
      editProObj: {
        id: '',
        index: '',
        explain: '',
        progressState: '',
        progressStateCode: ''
      },
      formLabelWidth: '120px',
      fileList: [],
      progressState: [],
      rules: {
        explain: [
          { required: true, message: '请输入进展说明', trigger: 'blur' }
        ],
        progressState: [
          { required: true, message: '请选择进展状态', trigger: 'change' }
        ]
      },
      file: '',
      fileUrl: [],
      projectOperateType: []
    }
  },
  methods: {
    viewWorkProgress () {
      // this.dialogWorkProgress = true
      console.log(this.form)
      // projectId: this.form.projectId
      queryWorkProgress({ projectId: this.form.projectId })
        .then((data) => {
          console.log(data)
          this.activities = data.data.data
        })
    },
    // 提交新建进展
    submitProgress () {
      console.log(this.fileList)
      this.$refs.progress.validate((valid) => {
        var date = new Date()
        if (valid) {
          addWorkProgress({
            projectId: this.form.projectId,
            operationFlag: 'insert',
            newLmProgress: [
              {
                deleted: false,
                enclosure: this.fileUrl.join(),
                progressDesc: this.formProgress.explain,
                progressState: this.formProgress.progressState,
                progressWirteDate: this.dateFormat(date),
                relatedId: this.form.projectId,
                relatedType: '4'
              }
            ],
            oldLmProgress: []
          })
            .then((data) => {
              this.isDialog = false
              this.viewWorkProgress()
              this.$message(data.data.msg)
              console.log(data)
            })
        }
      })
    },
    // 编辑进展
    editProgress (id, index) {
      this.isEditDialog = true
      this.editProObj.progressState = this.progressState[index].codeName
      this.editProObj.progressStateCode = this.progressState[index].codeValue
      this.editProObj.explain = this.activities[index].progressDesc
      this.editProObj.id = id
      this.editProObj.index = index
    },
    // 提交编辑进展
    submitEditProgress () {
      console.log(456)
      this.$refs.progress.validate((valid) => {
        var date = new Date()
        if (valid) {
          addWorkProgress({
            projectId: this.form.projectId,
            operationFlag: 'update',
            newLmProgress: [
              {
                id: this.editProObj.id,
                deleted: false,
                enclosure: this.fileUrl.join(),
                progressDesc: this.editProObj.explain,
                progressState: this.editProObj.progressStateCode,
                progressWirteDate: this.dateFormat(date),
                relatedId: this.form.projectId,
                relatedType: '4'
              }
            ],
            oldLmProgress: [
              {
                id: this.editProObj.id,
                deleted: false,
                progressDesc: this.activities[this.editProObj.index].progressDesc,
                progressState: this.progressState[this.editProObj.index].codeValue,
                progressWirteDate: this.dateFormat(date),
                relatedId: this.form.projectId,
                relatedType: '4'
              }
            ]
          })
            .then((data) => {
              this.isEditDialog = false
              this.viewWorkProgress()
              this.$message(data.data.msg)
            })
        }
      })
    },
    // 删除进展
    delProgress (id, index) {
      var date = new Date()
      this.$prompt('请填写删除原因', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /^[\u4e00-\u9fffa-zA-Z0-9]{1,15}$/,
        inputErrorMessage: '删除原因格式不正确！',
        type: 'warning'
      }).then((value) => {
        deleteProgress({
          projectId: this.form.projectId,
          operationFlag: 'delete',
          progressId: id,
          oldLmProgress: [
            {
              progressDesc: this.activities[index].progressDesc,
              progressState: this.progressState[index].codeValue,
              progressWirteDate: this.dateFormat(date),
              deleteReason: value.value,
              deleted: true,
              relatedId: this.form.projectId,
              relatedType: '4'
            }
          ]
        })
          .then((data) => {
            if (data.data.code === 20000) {
              this.viewWorkProgress()
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
    // 表头样式设置
    headClass () {
      return 'background: #F8F8F8;'
    },
    handlePreview (response, file, fileList) {
      console.log(file)
      console.log(fileList)
    },
    handleRemove (file, fileList) {
      console.log(file, fileList)
    },
    beforeRemove (file, fileList) {
      return this.$confirm(`确定移除${file.name}？`)
    },
    handleExceed (files, fileList) {
      this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
    },
    // 时间过滤
    dateFormat (time) {
      var date = new Date(time)
      var year = date.getFullYear()
      /* 在日期格式中，月份是从0开始的，因此要加0
        * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
        * */
      var month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1
      var day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
      var hours = date.getHours() < 10 ? '0' + date.getHours() : date.getHours()
      var minutes = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()
      var seconds = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds()
      // 拼接
      return year + '-' + month + '-' + day + ' ' + hours + ':' + minutes + ':' + seconds
    },
    // 上传文件
    handleFileChange (e) {
      var inputDOM = this.$refs.inputer
      this.file = inputDOM.files[0] // 通过DOM取文件数据
      // let size = Math.floor(this.file.size / 1024) // 计算文件的大小
      const formData = new FormData() // new一个formData事件
      formData.append('file', this.file) // 将file属性添加到formData里
      uploadFile(formData)
        .then((data) => {
          this.fileUrl.push(data.data.data)
          console.log(data)
        })
    },
    queryProjectRecord () {
      queryProjectProgressModifyRecord({ projectId: this.form.projectId })
        .then(data => {
          console.log(data)
          this.progressRecordData = data.data.data
          // this.progressRecordData.forEach((item, index) => {
          //   this.projectOperateType.forEach((eva, i) => {
          //     if (Number(item.operateType) === Number(eva.codeValue)) {
          //       item.operateTypeName = eva.codeName
          //     }
          //   })
          // })
        })
    }
  },
  created () {
    this.viewWorkProgress()
    this.isDialog = true
    fetchSelectList({})
      .then(({ data }) => {
        console.log(data.data)
        this.progressState = data.data.PROJECT_PROGRESS_STATE
      })
    this.queryProjectRecord()
  }
}
</script>

<style lang="scss" scoped>
    .delate-step-lt {
        width: 80px;
        color: #818181;
        font-size: 13px;
        display: table-cell;
        position: relative;
        .delate-time {
            position: absolute;
            width: 112px;
        }
    }
    .delate-step-rt {
        display: table-cell;
        /deep/
        .el-timeline-item__wrapper{
            top: -12px;
            .btn-common{
                width: 60px;
                height: 30px;
                line-height: 30px;
                text-align: center;
                border-radius: 4px;
                font-size: 14px;
                color: #fff;
                padding: 0;
            }
        }
        .imgBox{
            min-height: 84px;
            li{
                list-style: none;
                float: left;
                width: 118px;
                height: 84px;
                margin-top: 20px;
                margin-right: 19px;
                img{
                    width: 118px;
                    max-height: 84px;
                    display: inline-block;
                }
            }
        }
    }
    /deep/.el-dialog{
        width: 40%;
        .el-select{
            width: 100%;
        }
    }
    /deep/.el-dialog__wrapper{
        .el-table {
            .has-gutter{
                background-color: #F8F8FA;
            }
        }
    }
    .el-row {
        margin-bottom: 20px;
        &:last-child {
            margin-bottom: 0;
        }
    }
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }

</style>
