import Vue from 'vue'
import ElementUI from 'element-ui';
import App from './App.vue'
import axios from "axios"
import router from "./router"
import mavonEditor from "mavon-editor"

import 'element-ui/lib/theme-chalk/index.css';
import "mavon-editor/dist/css/index.css"

axios.defaults.baseURL = "http://localhost:8000"
axios.prototype.$http = axios 

Vue.config.productionTip = false

// 注册ElementUI
Vue.use(ElementUI)
Vue.use(mavonEditor)


new Vue({
  render: h => h(App),
  router: router
}).$mount('#app')
