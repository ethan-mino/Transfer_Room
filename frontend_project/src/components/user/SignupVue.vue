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
                placeholder="이메일"
              />
              <span class="input-wrap__input-focus"></span>
            </div>

            <div
              class="input-wrap validate-input m-b-15"
              data-validate="이름을 입력해주세요"
            >
              <input class="input-wrap__input" type="text" placeholder="이름" />
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
                placeholder="비밀번호"
              />
              <span class="input-wrap__input-focus"></span>
            </div>
            <div
              class="input-wrap validate-input m-b-15"
              data-validate="주소를 입력해주세요"
            >
              <input class="input-wrap__input" type="text" placeholder="주소" />
              <span class="input-wrap__input-focus"></span>
            </div>
            <!-- <span v-show="signup_fail_msg" class="login-form__fail-msg p-b-15"
              >이미 가입된 이메일입니다.</span
            > -->
            <button class="login-form__login-btn m-t-30">Sign up</button>
          </form>
        </div>
      </div>
    </div>
    <div id="dropDownSelect1"></div>
  </div>
</template>

<script>
export default {
  name: "SignupVue",
};
</script>

<style>
@import "@/assets/css/login/util.css";
@import "@/assets/css/login/main.css";
</style>
