import { interestingInstance } from "./index.js";

const interApi = interestingInstance();

//관심지역 추가
async function insertInterest(interestingInfo, success, fail) {
    console.log("token1 : " + sessionStorage.getItem("access-token"));
    interApi.defaults.headers['Authorization'] = sessionStorage.getItem("access-token");
    await interApi.post(`/user/interesting-area`, JSON.stringify(interestingInfo)).then(success).catch(fail);
}

//관심지역 조회.
async function getInterest(success, fail) { 
    interApi.defaults.headers["Authorization"] =
    sessionStorage.getItem("access-token");
    await interApi.get(`/user/interesting-area`).then(success).catch(fail);
}

export { insertInterest, getInterest};