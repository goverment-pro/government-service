/**
 * 判断是否是整数
 * @param {String} val
 * @returns {Boolean}
 */
export function isInt (val) {
  const regExp = /^\d+$/
  return regExp.test(val)
}

/**
 * 判断是否是小数（保留2位）
 * @param {String} val
 * @returns {Boolean}
 */
export function isDecimal (val) {
  const regExp = /^\d+\.?\d{0,2}$/
  return regExp.test(val)
}
