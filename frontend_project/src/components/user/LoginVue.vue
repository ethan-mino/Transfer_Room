<template>
  <div>
    <div class="limiter">
      <div class="login-container">
        <div class="login-wrap p-l-60 p-r-60 p-t-55 p-b-40">
          <form
            class="login-form validate-form flex-sb flex-w"
            v-on:submit.prevent
          >
            <span class="login-form__title p-b-32">로그인</span>

            <div
              class="input-wrap validate-input m-b-36"
              data-validate="이메일을 입력해주세요"
            >
              <input
                class="input-wrap__input"
                type="email"
                v-model="userLoginInfo.userEmail"
                placeholder="이메일"
              />
              <span class="input-wrap__input-focus"></span>
            </div>

            <div
              class="input-wrap validate-input m-b-12"
              data-validate="비밀번호를 입력해주세요"
            >
              <span class="btn-show-pass">
                <i class="fa fa-eye"></i>
              </span>
              <input
                class="input-wrap__input"
                type="password"
                v-model="userLoginInfo.userPassword"
                placeholder="비밀번호"
              />
              <span class="input-wrap__input-focus"></span>
            </div>

            <div class="flex-sb-m w-full p-b-25">
              <div>
                <router-link :to="{ name: 'signupPage' }"
                  ><a class="txt3" @click="moveSignup">Sign Up</a>
                </router-link>
              </div>
              <div>
                <a href="#" class="txt3">Forgot Password?</a>
              </div>
            </div>
            <span
              v-if="isLoginError"
              style=""
              class="login-form__fail-msg p-b-15"
              >아이디 또는 비밀번호를 확인해 주세요.</span
            >
            <button class="login-form__login-btn" @click="loginLogic">
              Login
            </button>
          </form>
        </div>
      </div>
    </div>
    <div id="dropDownSelect1"></div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "LoginVue",

  data() {
    return {
      userLoginInfo: {
        userEmail: null,
        userPassword: null,
      },
      
    };
  },
  created: function() {
    this.clearError();
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm","clearError"]),
    loginLogic: async function () {
      await this.userConfirm(this.userLoginInfo); // 유저 정보를 넘겨서 로그인 시도

      //로그인성공하면 메인 페이지로 이동
      if (this.isLogin) {
        this.$router.push({ name: "Main" });
      }
    },

    //회원가입 페이지로 이동.
    moveSignup: function () {
      this.$router.push({ name: "signupPage" });
    },
  },
};
</script>

<style>
@import "@/assets/css/login/util.css";
@import "@/assets/css/login/main.css";
</style>
