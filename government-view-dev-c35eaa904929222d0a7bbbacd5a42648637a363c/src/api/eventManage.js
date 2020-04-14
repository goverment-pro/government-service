// EventManage 页面请求方法
import request from '@/utils/request'

export function fetchSelectList (data) {
  return request({
    url: '/lm-code/getCodesByCodeTypes',
    method: 'post',
    data: ['BELONG_TYPE', 'SUPPORT_LEVEL', 'EVENT_SOURCE', 'EVENT_PROGRESS_STATE', 'EVENT_TYPE', 'ADDRESS_TYPE', 'COMMIT_STATE', 'FINISH_STATE', 'EVENT_CONTENT_TYPE', 'OPERATE_TYPE']
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
    url: '/lm-event/queryEventClassCount',
    method: 'post',
    data
  })
}
// 查询列表
export function queryList (data) {
  return request({
    url: '/lm-event/queryEventList',
    method: 'post',
    data
  })
}
// 批量提交事项列表
export function submitEvent (data) {
  return request({
    url: '/lm-event/updateEventCommited',
    method: 'post',
    data
  })
}
// 事项列表完成更新状态
export function commitEvent (data) {
  return request({
    url: '/lm-event/updateEventFinished',
    method: 'post',
    data
  })
}
// 批量删除事项列表
export function deleteEvent (data) {
  return request({
    url: '/lm-event/deleteEvent',
    method: 'post',
    data
  })
}
// 删除进展
export function deleteProgress (data) {
  return request({
    url: '/lm-progress/saveEventProgressInfo',
    method: 'post',
    data
  })
}
// 查询进展
export function queryWorkProgress (data) {
  return request({
    url: '/lm-progress/queryEventProgressHistoryRecord',
    method: 'post',
    data
  })
}
// 新建进展
export function addWorkProgress (data) {
  return request({
    url: '/lm-progress/saveEventProgressInfo',
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
// 事项进展修改记录查询
export function queryEventProgressModifyRecord (data) {
  return request({
    url: '/lm-modify-record/queryEventProgressModifyRecord',
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
// 事项修改记录
export function queryEventModifyRecord (data) {
  return request({
    url: '/lm-modify-record/queryEventModifyRecord',
    method: 'post',
    data
  })
}
