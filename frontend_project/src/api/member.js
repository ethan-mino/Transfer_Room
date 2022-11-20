import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(userInfo, success, fail) {
  await api.post(`/login`, JSON.stringify(userInfo)).then(success).catch(fail);
}

export { login };

// async function signup(signupInfo, success, fail) {}
