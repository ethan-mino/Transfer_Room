import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// import 'expose-loader?$!expose-loader?jQuery!jquery'
import VueLazyload from 'vue-lazyload';

Vue.use(VueLazyload)


Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
