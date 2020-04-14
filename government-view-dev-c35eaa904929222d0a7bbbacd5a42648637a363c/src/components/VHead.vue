<template>
  <header class="VHead">{{ content }}</header>
</template>

<script>
export default {
  name: 'VHead',
  props: ['content']
}
</script>

<style lang="scss" scoped>
.VHead {
  height: 57px;
  line-height: 57px;
  font-size: 16px;
  color: #5E6977;
  text-indent: 20px;
  background: #fff;
}
</style>
