<template>
  <div>
    <header class="p-3" :class="[($route.path==='/')? 'color' : 'white']">
      <div class="container">
        <div
          class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start"
        >
          <router-link to="/" class="nav-link px-6 text-secondary">
            <img
              :src="($route.path==='/')? white_logo_url : color_logo_url"
              class="logo"
            />
          </router-link>
          <ul
            class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 li-margin"
          >
            <li></li>
            <li>
                <router-link :to="{ name: 'transferPage' }" class="test">양도</router-link>
            </li>
            <li>
              <router-link :to="{ name: 'transferAdd' }">방 내놓기</router-link>
            </li>
            <li>
              <a href="#">커뮤니티</a>
            </li>
            <li><a href="#">공지사항</a></li>
            <!-- <li><a href="#">마이페이지</a></li> -->
          </ul>
          <div class="text-end">
            <div class="authOff" v-if="userInfo">
              <ul class="nav">
                <li><a href="#">마이페이지</a></li>
                <li><a @click="onClickLogout">로그아웃</a></li>
              </ul>
            </div>
            <div class="authOff" v-else>
              <router-link :to="{ name: 'loginPage' }">
                Login / SignUp
              </router-link>
            </div>
            <!-- </template> -->
          </div>
        </div>
      </div>
    </header>
  </div>
</template>

<script>
import { mapState, mapGetters, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "HeaderVue",
  data() {
    return {
      white_logo_url : require("../../assets/img/white_logo.png"),
      color_logo_url : require("../../assets/img/color_logo.png")
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userLogout"]),

    onClickLogout() {
      console.log("user info : " + this.userInfo);

      this.userLogout(); //로그아웃 action 호출
      this.$router.push({ name: "loginPage" });// 로그아웃되면 로그인 페이지로 이동.
      
    }
  },
};
</script>

<style>


.p-3 {

  /*
  background-image: linear-gradient(
    134deg,
    rgb(238 124 255) -5%,
    rgb(255 145 150) 56%,
    rgb(255 148 150) 56%
  );
  */
  background-color: transparent;
}


</style>
