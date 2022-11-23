import { getTransferBoardList } from "@/api/transferBoard";

const transferBoardStore = {
  namespaced: true,
  state: {
    transferBoardSearchValue: null,
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
  },
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
    }

  },
};

export default transferBoardStore;
