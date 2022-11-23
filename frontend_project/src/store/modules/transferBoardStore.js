import { getTransferBoardList } from "@/api/transferBoard";

const transferBoardStore = {
  namespaced: true,
  state: {
    transferBoardSearchValue: null,

    //선택된 보드 아이디 저장
    selectTransferBoardId: null,
  },

  getters: {
    getSearchValue: function (state) {
      return state.transferBoardSearchValue;
    },
  },
  mutations: {
    SET_SEARCH_VALUE(state, boardInfo) {
      state.transferBoardSearchValue = boardInfo.data;
    },
    CLEAR_SEARCH_VALUE(state) {
      state.transferBoardSearchValue = [];
    },

    //이동할 게시글 id 셋팅
    SET_BOARD_ID(state, boardId) {
      state.selectTransferBoardId = boardId;
    },
    CLEAR_BOARD_ID(state) {
      state.selectTransferBoardId = null;
    },
  },
  /* eslint-disable */
  actions: {
    //동코드로 보드 정보 가져오기
    async getTransferBoardResult({ commit }, dongCode) {
      await getTransferBoardList(
        dongCode,
        ({ data }) => {
          console.log("info : " + data);
          console.log("dong code : " + dongCode);
          commit("SET_SEARCH_VALUE", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },

    clearSearchInfo: function ({ commit }) {
      commit("CLEAR_SEARCH_VALUE");
    },

    //이동할 게시글 아이디 저장
    setSelectBoardId: function ({ commit }, boardId) {
      commit("SET_BOARD_ID", boardId);
    },
    clearSelectBoardId: function ({ commit }) {
      commit("CLEAR_BOARD_ID");
    },
  },
};

export default transferBoardStore;
