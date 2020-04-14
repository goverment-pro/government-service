<template>
    <div>
        <el-table
                :data="recordData"
                :header-cell-style="headClass"
                border
        >
            <el-table-column property="operator" label="操作员" ></el-table-column>
            <el-table-column property="version" label="版本" ></el-table-column>
            <el-table-column property="contentTypeName" label="内容类型"></el-table-column>
            <el-table-column property="operateTypeName" label="操作类型"></el-table-column>
            <el-table-column property="operateContent" label="操作内容" width="250">
                <template slot-scope="scope">
                    <div v-for="(item, index) in scope.row.operateContent" :key="index">
                        <span>{{item}}</span>
                        <span></span>
                    </div>
                </template>
            </el-table-column>
            <el-table-column property="operateTime" label="操作时间" ></el-table-column>
            <el-table-column property="progressWirteDate" label="操作" >
                <template slot-scope="scope">
                    <el-button
                            type="primary"
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)">历史查看</el-button>
                    <el-button
                            size="mini"
                            type="primary"
                            @click="handleDelete(scope.$index, scope.row)">还原</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import { queryEventModifyRecord, fetchSelectList } from '@/api/projectManage.js'

export default {
  name: 'projectRecord',
  props: ['origin', 'form'],
  data () {
    return {
      recordData: [],
      contentType: [],
      operateType: []
    }
  },
  created () {
    fetchSelectList({})
      .then(({ data }) => {
        this.contentType = data.data.PROJECT_CONTENT_TYPE
        this.operateType = data.data.OPERATE_TYPE
      })
    this.queryEventRecord()
  },
  methods: {
    // 事项修改记录
    queryEventRecord () {
      console.log(1111, this.contentType)
      queryEventModifyRecord({ projectId: this.$route.query.projectId })
        .then(data => {
          this.recordData = data.data.data
          this.recordData.forEach((item, index) => {
            this.contentType.forEach((eva, i) => {
              if (Number(item.contentType) === Number(eva.codeValue)) {
                item.contentTypeName = eva.codeName
              }
            })
            this.operateType.forEach((eva, i) => {
              if (Number(item.operateType) === Number(eva.codeValue)) {
                item.operateTypeName = eva.codeName
              }
            })
            if (item.operateContent === null) {
              var jsont = '[{字段名称:修改,修改前:基础设施短板,修改后内容:危改棚改拆迁},' +
                '{字段名称:所属类别,修改前内容:政策类,修改后内容:协调类},' +
                '{字段名称:支持级别,修改前内容:区级,修改后内容:市级},' +
                '{字段名称:事项描述,修改前内容:string,修改后内容:sdfsdfasdfasdsd},' +
                '{字段名称:事项来源,修改前内容:12345诉求,修改后内容:主动治理}]'
              item.operateContent = jsont
              console.log(item.operateContent)
            }
          })
          console.log(data)
        })
    },
    // 表头样式设置
    headClass () {
      return 'background: #F8F8F8;'
    },
    handleEdit (index, row) {
      console.log(index, row)
    },
    handleDelete (index, row) {
      console.log(index, row)
    }
  }
}
</script>

<style scoped>

</style>
