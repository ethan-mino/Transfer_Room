import Vue from "vue";
import VueRouter from "vue-router";
import MainView from "@/views/MainView";
import LoginView from "@/views/user/LoginView";
import SignupView from "@/views/user/SignupView";
import TransferView from "@/views/transfer/TransferView";
import TransferAddView from "@/views/transfer/TransferAddView";

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
  {
    path: "/transferAdd",
    name: "transferAdd",
    component: TransferAddView,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
