// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

// cookies  注意 不是 cookie
import VueCookies from 'vue-cookies'

// 引入 md5 加密
import md5 from 'js-md5'

// iView
import iView from 'iview'
import 'iview/dist/styles/iview.css'    // 使用 CSS


Vue.use(iView)
Vue.use(VueCookies)

Vue.config.productionTip = false;
Vue.prototype.$md5 = md5;

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
