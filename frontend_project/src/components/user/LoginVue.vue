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
                placeholder="비밀번호"
              />
              <span class="input-wrap__input-focus"></span>
            </div>

            <div class="flex-sb-m w-full p-b-25">
              <div>
                <router-link :to="{ name: 'signupPage' }"
                  ><a class="txt3">Sign Up</a></router-link
                >
              </div>
              <div>
                <a href="#" class="txt3">Forgot Password?</a>
              </div>
            </div>
            <!-- <span
              v-show="login_fail_msg"
              style=""
              class="login-form__fail-msg p-b-15"
              >아이디 또는 비밀번호를 확인해 주세요.</span
            > -->
            <button class="login-form__login-btn">Login</button>
          </form>
        </div>
      </div>
    </div>
    <div id="dropDownSelect1"></div>
  </div>
</template>

<script>
export default {
  name: "LoginVue",
};
</script>

<style>
@import "@/assets/css/login/util.css";
@import "@/assets/css/login/main.css";
</style>
