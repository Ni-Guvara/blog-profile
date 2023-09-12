import Vue from "vue"
import VueRouter from "vue-router"
import blogShow from "../views/blogShow.vue"
import blogDetail from "../views/blogDetail.vue"  
import blogEdit from "../views/blogEdit.vue"
import blogUpdate from "../views/blogUpdate.vue"
import proFile from "../views/proFile.vue"


Vue.use(VueRouter)

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this,location).catch(err=>err)
}

const router = new VueRouter({
  routes:[
    { path: '/', component: blogShow },
    { path: '/blogDetail', component: blogDetail },
    { path: '/blogEdit', component: blogEdit },
    { path: '/blogUpdate' , component:blogUpdate},
    { path: '/profile', component: proFile }
  ]   
})

export default router