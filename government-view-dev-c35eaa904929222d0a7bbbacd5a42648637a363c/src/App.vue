<template>
  <div id="app">
    <div class="nav">
      <div class="nav-left">
        <div class="logo"></div>
        <div class="title">
          <p>治理类街乡镇清单管理系统</p>
          <p>STREET INVENTORY MANAGEMENT SYSTEM</p>
        </div>
        <ul class="nav-menu" @click="routerChange">
          <li :class="{'active': active}"><a href="#">事项管理</a></li>
          <li :class="{'active': !active}"><a href="#">项目管理</a></li>
        </ul>
      </div>
      <el-dropdown>
        <div class="avatar">
          <i class="el-icon-s-custom"></i>
          <p class="user-name">szxbP</p>
        </div>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
      active: true
    }
  },
  methods: {
    routerChange (e) {
      const target = e.target
      const tagName = e.target.tagName.toUpperCase()
      if (tagName === 'UL') return
      if (tagName === 'LI') {
        !target.className && this.toggleActive()
      } else {
        !target.parentNode.className && this.toggleActive()
      }
    },
    toggleActive () {
      this.active = !this.active
    }
  },
  watch: {
    active: function (newVal) {
      if (newVal) {
        this.$router.push({
          path: '/'
        })
      } else {
        this.$router.push({
          path: 'projectManage'
        })
      }
    }
  },
  created () {
    // const token = window.location.search.split('=')[1]
    history.pushState(null, null, '/')
  }
}
</script>

<style lang="scss">
html, body {
  height: 100%;
  background-color: rgba(245,245,245,1);
}
#app {
  min-width: 1200px;
  background-color: rgba(245,245,245,1);
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  .nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 30px;
    height: 70px;
    color: #fff;
    background-color: #023996;
    background-image: linear-gradient(#002D82, #0044A7);
    .nav-left {
      display: flex;
      align-items: center;
      height: 100%;
      .logo {
        width: 40px;
        height: 40px;
        border: 1px solid #fff;
        border-radius: 50%;
      }
      .title {
        margin-left: 10px;
        p {
          margin: 0;
          &:first-child {
            font-size: 20px;
            line-height: 30px;
          }
          &:last-child {
            font-size: 12px;
          }
        }
      }
      .nav-menu {
        display: flex;
        align-items: center;
        height: 100%;
        margin: 0;
        margin-left: 100px;
        transform: skew(-36deg);
        list-style: none;
        li {
          height: 70px;
          line-height: 70px;
          padding: 0 29px;
          font-size: 14px;
          cursor: pointer;
          a {
            display: block;
            font-size: 14px;
            color: #fff;
            text-decoration: none;
            transform: skew(36deg);
          }
          &.active {
            background: radial-gradient(#4AB2E6, #0063BF);
          }
        }
      }
    }
    .el-icon-s-custom {
      display: block;
      height: 35px;
      line-height: 35px;
      border: 1px solid #fff;
      font-size: 28px;
      border-radius: 50%;
      text-align: center;
      color: #fff;
    }
    .user-name {
      margin: 0;
      color: #fff;
    }
  }
}
</style>
