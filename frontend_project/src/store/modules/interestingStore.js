import { insertInterest, getInterest } from "@/api/interesting";


const interestingStore = {
    namespaced: true,

    state: {
        interestingInfos: [],

    },
    getters: {
        getInterest: function (state) {
            return state.interestingInfos;
        }
    },
    mutations: {
        SET_INTERESTING_LIST(state, interestingValues) {
            state.interestingInfos = interestingValues;
        },
        CLEAR_INTERESTING_LIST(state) {
            state.interestingInfos = [];
        }
    },
    actions: {
        selectInteresting: async function ({ commit }) {
            await getInterest(
                ({ data }) => {
                    console.log(data);
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
                },
                (error) => {
                    console.log(error);
                }
            );
        },
    }
};

export default interestingStore;