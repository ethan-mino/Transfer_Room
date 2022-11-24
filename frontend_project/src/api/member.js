import { apiInstance } from "./index.js";
import jwtDecode from "jwt-decode";

const api = apiInstance();

async function login(userInfo, success, fail) {
  await api.post(`/login`, JSON.stringify(userInfo)).then(success).catch(fail);
}

async function signup(userInfo, success, fail) {
  await api.post(`/signup`, JSON.stringify(userInfo)).then(success).catch(fail);
}

//유저 정보 조회 - 이름 필요함.
async function getUser(userId, success, fail) { 
  await api.get(`/user/${userId}`).then(success).catch(fail);
}

//현재 유저 정보 받아오기.
async function getCurrnetUser(success, fail) {
  api.defaults.headers["Authorization"] =
    sessionStorage.getItem("access-token");
  await api.get('/user').then(success).catch(fail);
}

//유저 양도 내역 조회
async function getMemberTransferInfo(success, fail) { 
  let decodeToken = jwtDecode(sessionStorage.getItem("access-token"))
  let userEmail = decodeToken.sub;
  await api.get(`/transfer-board/${userEmail}`).then(success).catch(fail);
}

export { login, signup, getUser, getMemberTransferInfo, getCurrnetUser};

// async function signup(signupInfo, success, fail) {}
