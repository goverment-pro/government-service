const { resolve } = require('path')

module.exports = {
  chainWebpack: config => {
    config.resolve.alias
      .set('@', resolve(__dirname, 'src'))
      .set('utils', resolve(__dirname, 'src/utils'))
      .set('api', resolve(__dirname, 'src/api'))
      .set('components', resolve(__dirname,'src/components'))
  }
}