import axios from "axios";

function apiInstance() {
  const instance = axios.create({
    baseURL: process.env.VUE_APP_API_BASE_URL,
    headers: {
      "Content-Type": "application/json; charset=uft-8",
    },
  });

  return instance;
}

function regionInstance() {
  const instance = axios.create({
    baseURL: process.env.VUE_APP_API_REGION_URL,
    headers: {
      "Content-Type": "application/json; charset=uft-8",
    },
  });

  return instance;
}

//양도 게시판 - 이미지 업로드를 위해서 multipart/form-data로 처리
function transferBoardInstance() {
  const instance = axios.create({
    baseURL: process.env.VUE_APP_API_TRANSFER_BOARD_URL,
    headers: {
      "Content-Type": "multipart/form-data",
    },
  });

  return instance;
}

export { apiInstance, regionInstance, transferBoardInstance };
