import Vue from "vue";
import VueRouter from "vue-router";
import MainView from "@/views/MainView";
import LoginView from "@/views/LoginView";
import SignupView from "@/views/SignupView";
import TransferView from "@/views/TransferView";

Vue.use(VueRouter);

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
    component: TransferView,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
