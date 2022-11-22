import { insertInterest, getInterest } from "@/api/interesting";


const interestingStore = {
    namespaced: true,

    state: {
        interestingInfos: [],
        insertFail: false,

    },
    getters: {
        getInterest: function (state) {
            return state.interestingInfos;
        }
    },
    mutations: {
        SET_INTERESTING_LIST(state, interestingValues) {
            state.interestingInfos = interestingValues.data;
        },
        CLEAR_INTERESTING_LIST(state) {
            state.interestingInfos = [];
        },
        SET_INSERT_FAIL(state) { 
            state.insertFail = true;
        },
        CLEAR_INSERT_FAIL(state) { 
            state.insertFail = false;
        }
    },
    actions: {
        selectInteresting: async function ({ commit }) {
            await getInterest(
                ({ data }) => {
                    commit("SET_INTERESTING_LIST", data);
                },
                (error) => {
                    console.log(error);
                }
            );
      
        },
        /* eslint-disable */
        insertInteresting: async function ({ commit },insertInfo) {
            await insertInterest(
                insertInfo,
                ({ data }) => {
                    console.log(data);
                    commit("CLEAR_INSERT_FAIL");
                },
                (error) => {
                    console.log(error);
                    commit("SET_INSERT_FAIL");  
                }
            );
        },
    }
};

export default interestingStore;