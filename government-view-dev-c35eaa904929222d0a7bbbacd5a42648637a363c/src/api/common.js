// 公共请求方法
import request from '@/utils/request'

export function fetchSelectList (data) {
  return request({
    url: '/lm-code/getCodesByCodeTypes',
    method: 'post',
    data
  })
}
