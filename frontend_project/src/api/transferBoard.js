import { apiInstance, transferBoardInstance } from "./index.js";

const api = apiInstance();
const tbApi = transferBoardInstance();

//동코드를 받아서 게시판 리스트 리턴할 요청 - 승인 된 게시판만 보이도록 함.
async function getTransferBoardList(dongCode, success, fail) {
  api.defaults.headers["Authorization"] =
    sessionStorage.getItem("access_token");
  console.log("token : " + sessionStorage.getItem("access_token"));
  await api
    .get(`/transfer-board/approved?dongCode=${dongCode}`)
    .then(success)
    .catch(fail);
}

//파일 업로드
async function setTransferBoard(multipartData, success, fail) { 
  tbApi.defaults.headers["Authorization"] =
    sessionStorage.getItem("access_token");
  
  await tbApi.post(`/transfer-board`,multipartData).then(success).catch(fail);
}

export { getTransferBoardList, setTransferBoard};
