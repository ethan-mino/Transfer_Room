import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

import memberStore from "@/store/modules/memberStore";
import regionStore from "@/store/modules/regionStore";
import transferBoardStore from "@/store/modules/transferBoardStore";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    memberStore,
    regionStore,
    transferBoardStore,
  },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
  // state: {},
  // getters: {},
  // mutations: {},
  // actions: {},
  // modules: {},
});
