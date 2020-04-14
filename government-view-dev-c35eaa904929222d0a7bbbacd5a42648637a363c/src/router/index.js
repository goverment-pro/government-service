import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'EventManage',
    component: () => import('@/views/EventManage/EventManage.vue')
  },
  {
    path: '/eventList',
    name: 'EventList',
    component: () => import('@/views/EventList/EventList.vue')
  },
  {
    path: '/projectList',
    name: 'ProjectList',
    component: () => import('@/views/ProjectList/ProjectList.vue')
  },
  {
    path: '/projectManage',
    name: 'ProjectManage',
    component: () => import('@/views/ProjectManage/ProjectManage.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
