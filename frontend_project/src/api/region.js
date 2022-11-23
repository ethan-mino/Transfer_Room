import { regionInstance } from "./index.js";

const regionApi = regionInstance();

//시도
async function sidoList(success, fail) {
  regionApi.defaults.headers["Authorization"] =
    sessionStorage.getItem("access_token");
  await regionApi.get(`/sido`).then(success).catch(fail);
}

//구군
async function gugunList(sidoCode, success, fail) {
  regionApi.defaults.headers["Authorization"] =
    sessionStorage.getItem("access-token");
  await regionApi.get(`/gugun?sidoCode=${sidoCode}`).then(success).catch(fail);
}

//동
async function dongList(gugunCode, success, fail) {
  regionApi.defaults.headers["Authorization"] =
    sessionStorage.getItem("access-token");
  await regionApi.get(`/dong?gugunCode=${gugunCode}`).then(success).catch(fail);
}

//해당 하는 동코드로 전체 정보 뽑기
async function getDong(dongCode, success, fail) {
  regionApi.defaults.headers["Authorization"] =
    sessionStorage.getItem("access-token");
  await regionApi.get(`/dong/${dongCode}`).then(success).catch(fail);
}

export { sidoList, gugunList, dongList, getDong };
