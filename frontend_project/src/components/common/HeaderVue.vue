<template>
  <div>
    <header class="p-3">
      <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
          <router-link to="/" class="nav-link px-6 text-secondary">
            <img
                src="@/assets/img/white_logo.png"
                alt="rlfalsgh95"
                class = "logo"
              />
          </router-link>
          <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 li-margin">
            <li></li>
            <li>
              <router-link
                :to="{ name: 'transferPage' }"
               >양도</router-link>
            </li>
            <li>
              <a href="#">커뮤니티</a>
            </li>
            <li><a href="#">공지사항</a></li>
            <li><a href="#">마이페이지</a></li>
          </ul>
          <div class="text-end">
            <!-- <template v-if="this.$session.get('userInfo') != null"> -->
            <!-- <div class="authOn">
              <a class="user_info" href="#">
                <img
                  src="@/assets/img/user.jpg"
                  alt="rlfalsgh95"
                  class="user_info__img"
                />
              </a>
              <div
                style="position: absolute; top: 70px"
                tabindex="-1"
                class="css-1ieyvgb"
              ></div>
            </div> -->
            <!-- </template> -->

            <!-- <template v-else> -->
            <div class="authOff">
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
export default {
  name: "HeaderVue",
};
</script>

<style></style>
