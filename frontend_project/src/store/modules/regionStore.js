import { sidoList, gugunList, dongList } from "@/api/region";

const regionStore = {
  namespaced: true,
  //시도 구군 동 select 박스에 들어갈 내용 저장.
  state: {
    sidos: [{ value: null, text: "시도선택" }],
    guguns: [{ value: null, text: "구군선택" }],
    dongs: [{ value: null, text: "동선택" }],
    //사용자가 선택한 동코드
    selectsidoCode: null,
    selectgugunCode: null,
    selectDongCode: null,


    //사용자가 선택한 이름
    selectsidoName: null,
    selectgugunName: null,
    selectdongName: null,
  },
  getters: {
    sidoValueList: function (state) {
      return state.sidos;
    },
    gugunValueList: function (state) {
      return state.guguns;
    },
    dongValueList: function (state) {
      return state.dongs;
    },
  },
  mutations: {
    //초기화
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "시도선택" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "구군선택" }];
    },
    CLEAR_DONG_LIST(state) {
      state.dongs = [{ value: null, text: "동선택" }];
    },
    //생성
    SET_SIDO_LIST(state, sidoValues) {
      sidoValues.forEach((sidoValue) => {
        state.sidos.push({
          value: sidoValue.dongCode,
          text: sidoValue.sidoName,
        });
      });
    },
    SET_GUGUN_LIST(state, gugunValues) {
      gugunValues.forEach((gugunValue) => {
        state.guguns.push({
          value: gugunValue.dongCode,
          text: gugunValue.gugunName,
        });
      });
    },
    SET_DONG_LIST(state, dongValues) {
      dongValues.forEach((dongValue) => {
        state.dongs.push({
          value: dongValue.dongCode,
          text: dongValue.dongName,
        });
      });
    },
    SET_DONG_CODE(state,dongCode) { 
      state.selectDongCode = dongCode;
    },
    CLEAR_SIDO_CODE(state) { 
      state.selectsidoCode = null;
    },
    CLEAR_GUGUN_CODE(state) { 
      state.selectgugunCode = null;
    },
    CLEAR_DONG_CODE(state) { 
      state.selectDongCode = null;
    },
    
  },
  actions: {
    async getSido({ commit }) {
      await sidoList(
        ({ data }) => {
          console.log(data);
          commit("SET_SIDO_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    async getGugun({ commit }, sidoCode) {
      await gugunList(
        sidoCode,
        ({ data }) => {
          commit("SET_GUGUN_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    async getDong({ commit }, gugunCode) {
      await dongList(
        gugunCode,
        ({ data }) => {
          commit("SET_DONG_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    setSelectDongCode({ commit }, dongcode) { 
      commit("SET_DONG_CODE", dongcode);
    },
    //모든 정보 초기화
    clearInfo({ commit }) { 
      commit("CLEAR_SIDO_LIST");
      commit("CLEAR_GUGUN_LIST");
      commit("CLEAR_DONG_LIST");
    },
    clearGugun({ commit }) { 
      commit("CLEAR_GUGUN_LIST");
    },
    clearDong({ commit }) {
      commit("CLEAR_DONG_LIST");
    },
    selectCodeClear: function ({ commit }) { 
      commit("CLEAR_SIDO_CODE");
      commit("CLEAR_GUGUN_CODE");
      commit("CLEAR_DONG_CODE");
    }
  },
};

export default regionStore;
