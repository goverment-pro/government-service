// EventManage 页面请求方法
import request from '@/utils/request'

export function fetchSelectList (data) {
  return request({
    url: '/lm-code/getCodesByCodeTypes',
    method: 'post',
    data: ['BELONG_TYPE', 'SUPPORT_LEVEL', 'EVENT_SOURCE', 'EVENT_PROGRESS_STATE', 'EVENT_TYPE', 'ADDRESS_TYPE', 'COMMIT_STATE', 'FINISH_STATE', 'FUNDS_SOURCE', 'PROJECT_SUPPORT_LEVEL', 'PROJECT_BELONG_TYPE', 'PROJECT_TYPE', 'PROJECT_PROGRESS_STATE', 'OPERATE_TYPE', 'PROJECT_CONTENT_TYPE']
  })
}
// 获取街乡镇列表
export function fetchRegionList (data) {
  return request({
    url: '/lm-address/queryLmAddress',
    method: 'post',
    data
  })
}
// 查询分类列表
export function queryClassList (data) {
  return request({
    url: '/lm-project/queryProjectClassCount',
    method: 'post',
    data
  })
}
// 查询列表
export function queryList (data) {
  return request({
    url: 'lm-project/queryProjectList',
    method: 'post',
    data
  })
}
// 批量提交事项列表
export function submitEvent (data) {
  return request({
    url: '/lm-project/updateProjectCommited',
    method: 'post',
    data
  })
}
// 事项列表完成更新状态
export function commitEvent (data) {
  return request({
    url: '/lm-project/updateProjectFinished',
    method: 'post',
    data
  })
}
// 批量删除事项列表
export function deleteEvent (data) {
  return request({
    url: '/lm-project/deleteProject',
    method: 'post',
    data
  })
}
// 删除进展
export function deleteProgress (data) {
  return request({
    url: '/lm-progress/saveProjectProgressInfo',
    method: 'post',
    data
  })
}
// 查询进展
export function queryWorkProgress (data) {
  return request({
    url: '/lm-progress/queryProjectProgressHistoryRecord',
    method: 'post',
    data
  })
}
// 新建进展
export function addWorkProgress (data) {
  return request({
    url: '/lm-progress/saveProjectProgressInfo',
    method: 'post',
    data
  })
}
// 进展查询
export function queryProgressRecord (data) {
  return request({
    url: '/lm-progress/queryEventProgressHistoryRecord',
    method: 'post',
    data
  })
}
// 项目进展修改记录查询
export function queryProjectProgressModifyRecord (data) {
  return request({
    url: '/lm-modify-record/queryProjectProgressModifyRecord',
    method: 'post',
    data
  })
}
// 文件上传
export function uploadFile (data) {
  return request({
    url: '/lm-progress/upload',
    method: 'post',
    headers: {
      'Content-Type': 'multipart/form-data' // 值得注意的是，这个地方一定要把请求头更改一下
    },
    data
  })
}
// 项目修改记录
export function queryEventModifyRecord (data) {
  return request({
    url: '/lm-modify-record/queryProjectModifyRecord',
    method: 'post',
    data
  })
}
