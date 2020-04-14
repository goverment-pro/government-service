// EventList 页面请求方法
import request from '@/utils/request'

/**
 * 获取区域 placeType and 街乡镇 upplaceCode
 * @param {Object} data
 * @returns {Promise}
 */
export function fetchRegionList (data) {
  return request({
    url: '/lm-address/queryLmAddress',
    method: 'post',
    data
  })
}

/**
 * 保存
 * @param {Object} data
 * @returns {Promise}
 */
export function saveEvent (data) {
  return request({
    url: '/lm-event/saveEvent',
    method: 'post',
    data
  })
}

/**
 * 查询
 * @param {Object} data
 * @returns {Promise}
 */
export function queryInfo (data) {
  return request({
    url: '/lm-event/queryEventDetail',
    method: 'post',
    data
  })
}
