// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'


import VueCookie from 'vue-cookie';     //注意 是 cookie
import iView from 'iview'               // iView
import 'iview/dist/styles/iview.css'    // 使用 CSS

Vue.use(iView)
Vue.use(VueCookie)


// 非对称加密 RSA
import JsEncrypt from 'jsencrypt'
Vue.prototype.$jsEncrypt = JsEncrypt

Vue.config.productionTip = false;


new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
