import jwtDecode from "jwt-decode";
// import router from "@/router";
import { login } from "@/api/member";

const memberStore = {
  namespaced: true,
  state: {
    //로그인 유무 확인
    isLogin: false,
    isLoginError: false,
    userInfo: null,
  },
  getters: {
    //현재 저장된 유저 정보 가져오기.
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    //현재 로그인이 되었는지 확인하는 변수를 바꿈.
    SET_IS_LOGIN: (state, isLogin) => {
      console.log("mutations check : " + isLogin);
      state.isLogin = isLogin;
    },
    //로그인 실패 여부 확인 - 로그인 정보가 틀렸을때
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    //로그인 성공하면 유저 정보 저장.
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    CLEAR_LOGIN_ERROR: (state) => { 
      state.isLoginError = false;
    }
  },
  actions: {
    //로그인버튼 눌렀을때 동작.
    async userConfirm({ commit }, user) {
      await login(
        user,
        ({ data }) => {
          //성공시
          let accessToken = data["data"]; //토큰 꺼내오기.
          let decodeToken = jwtDecode(accessToken);

          //mutation에 commit 날려서 status 값 변경
          commit("SET_IS_LOGIN", true); //로그인 되어있는지 상태 확인
          commit("SET_IS_LOGIN_ERROR", false); // 로그인이 실패했는지 확인.
          commit("SET_USER_INFO", decodeToken.sub); //유저정보에 email 저장.
          sessionStorage.setItem("access-token", accessToken); //스토리지에도 저장.
        },
        (error) => {
          console.log(error);
          //성공 상태를 제외한 나머지 모든 경우에 대해서 실패처리
          commit("SET_IS_LOGIN", false); //로그인 되어있는지 상태 확인
          commit("SET_IS_LOGIN_ERROR", true); // 로그인이 실패했는지 확인.
        }
      );
    },

    userLogout({ commit }) {
      //로그아웃시, 세션스토리지에 토큰이 있다면 삭제.
      //   if (sessionStorage.getItem("access-token") !== null) {
      //로그아웃 가능하다면 모든 값 초기화 하고, 로그인 페이지로 던짐.
      commit("SET_IS_LOGIN", false);
      commit("SET_IS_LOGIN_ERROR", false);
      commit("SET_USER_INFO", null);
      console.log("hello ssafy");
      sessionStorage.removeItem("access-token"); //토큰 삭제.
      //   } else {
      //     console.log("유저 정보 없음");
      //   }
    },

    clearError({ commit }) { 
      commit("CLEAR_LOGIN_ERROR");
    }
  },
};

export default memberStore;
