import Vue from "vue";
import VueRouter from "vue-router";
import MainView from "@/views/MainView";
import LoginView from "@/views/user/LoginView";
import SignupView from "@/views/user/SignupView";
import TransferView from "@/views/transfer/TransferView";
import TransferAddView from "@/views/transfer/TransferAddView";

import store from "@/store";

Vue.use(VueRouter);

const onlyAuthUser = async (to, from, next) => {
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  let token = sessionStorage.getItem("access-token"); //토큰 가져오기

  console.log("로그인 처리 전 확인");

  if (checkUserInfo == null || token == null) {
    alert("로그인이 필요한 페이지 입니다..");

    router.push({ name: "loginPage" });
  } else {
    console.log("로그인 성공");
    next();
  }
};

const routes = [
  {
    path: "/",
    name: "Main",
    component: MainView,
  },
  {
    path: "/loginPage",
    name: "loginPage",
    component: LoginView,
  },
  {
    path: "/sigupPage",
    name: "signupPage",
    component: SignupView,
  },
  {
    path: "/transferPage",
    name: "transferPage",
    beforeEnter: onlyAuthUser,
    component: TransferView,
  },
  {
    path: "/transferAdd",
    name: "transferAdd",
    beforeEnter: onlyAuthUser,
    component: TransferAddView,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
