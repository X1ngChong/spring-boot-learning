import {createRouter,createWebHistory} from 'vue-router'
import  LayoutView  from '../views/LayoutView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes:[
    {
      path:'/',
      name:'layout',
      component: LayoutView,
      redirect: '/home',
      children:[
        {
          path:'/home',
          name:'home',
          component:() => import('../views/HomeView.vue')
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component:() => import('../views/LoginView.vue')
    }
  ]
})

export default router