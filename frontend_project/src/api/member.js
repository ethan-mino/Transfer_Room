import { apiInstance } from "./index.js";

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

export { login, signup, getUser};

// async function signup(signupInfo, success, fail) {}
