<template>
  <div>
    <header class="p-3 text-bg-dark">
      <div class="container">
        <div
          class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start"
        >
          <h2>
            <router-link to="/" class="nav-link px-6 text-secondary"
              >구해줘방</router-link
            >
          </h2>
          <ul
            class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 li-margin"
          >
            <li></li>
            <li><a href="#" class="nav-link px-1 text-white">양도</a></li>
            <li>
              <a href="#" class="nav-link px-1 text-white">커뮤니티</a>
            </li>
            <li><a href="#" class="nav-link px-1 text-white">공지사항</a></li>
            <li><a href="#" class="nav-link px-1 text-white">마이페이지</a></li>
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
              <button
                type="button"
                class="btn btn-outline-light me-2"
                onclick="location.href = '#'"
              >
                Login
              </button>
              <button
                type="button"
                class="btn btn-outline-light me-2"
                onclick="location.href = '#'"
              >
                SignUp
              </button>
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
