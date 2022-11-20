<template>
  <div>
    <div class="limiter">
      <div class="login-container">
        <div class="login-wrap p-l-60 p-r-60 p-t-55 p-b-40">
          <form
            class="login-form validate-form flex-sb flex-w"
            v-on:submit.prevent
          >
            <span class="login-form__title p-b-32">회원가입</span>

            <div
              class="input-wrap validate-input m-b-15"
              data-validate="이메일을 입력해주세요"
            >
              <input
                class="input-wrap__input"
                type="email"
                v-model="userSignupInfo.userEmail"
                placeholder="이메일"
              />
              <span class="input-wrap__input-focus"></span>
            </div>

            <div
              class="input-wrap validate-input m-b-15"
              data-validate="이름을 입력해주세요"
            >
              <input
                class="input-wrap__input"
                type="text"
                v-model="userSignupInfo.userName"
                placeholder="이름"
              />
              <span class="input-wrap__input-focus"></span>
            </div>

            <div
              class="input-wrap validate-input m-b-15"
              data-validate="비밀번호를 입력해주세요"
            >
              <span class="btn-show-pass">
                <i class="fa fa-eye"></i>
              </span>
              <input
                class="input-wrap__input"
                type="password"
                v-model="userSignupInfo.userPassword"
                placeholder="비밀번호"
              />
              <span class="input-wrap__input-focus"></span>
            </div>
            <div
              class="input-wrap validate-input m-b-15"
              data-validate="주소를 입력해주세요"
            >
              <input
                class="input-wrap__input"
                type="text"
                v-model="userSignupInfo.userAddress"
                placeholder="주소"
              />
              <span class="input-wrap__input-focus"></span>
            </div>
            <span v-if="emailDuplicated" class="login-form__fail-msg p-b-15"
              >이미 가입된 이메일입니다.</span
            >
            <button class="login-form__login-btn m-t-30" @click="signupBtn">
              Sign up
            </button>
          </form>
        </div>
      </div>
    </div>
    <div id="dropDownSelect1"></div>
  </div>
</template>

<script>
import { signup } from "@/api/member";

export default {
  name: "SignupVue",
  data() {
    return {
      userSignupInfo: {
        userName: null,
        userEmail: null,
        userPassword: null,
        userAddress: null,
      },
      signFailCheck: false,
    };
  },
  computed: {
    emailDuplicated: function () {
      return this.signFailCheck;
    },
  },
  methods: {
    signupBtn: async function () {
      await signup(
        this.userSignupInfo,

        //성공시
        ({ data }) => {
          console.log(data);
          this.signFailCheck = false;
          //로그인 창으로 이동
          this.$router.push({ name: "loginPage" });
        },
        (error) => {
          console.log(error);
          this.signFailCheck = true;
        }
      );
    },
  },
};
</script>

<style>
@import "@/assets/css/login/util.css";
@import "@/assets/css/login/main.css";
</style>
