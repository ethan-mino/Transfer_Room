import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(userInfo, success, fail) {
  await api.post(`/login`, JSON.stringify(userInfo)).then(success).catch(fail);
}

async function signup(userInfo, success, fail) {
  await api.post(`/signup`, JSON.stringify(userInfo)).then(success).catch(fail);
}

export { login, signup };

// async function signup(signupInfo, success, fail) {}
