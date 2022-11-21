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
            state.transferBoardSearchValue = boardInfo;
        },
        CLEAR_SEARCH_VALUE(state) { 
            state.transferBoardSearchValue = [];
        },
    },
    actions: {
        //동코드로 보드 정보 가져오기
        async getTransferBoardResult({ commit },dongCode) { 
            await getTransferBoardList(
                dongCode,
                ({ data }) => { 
                    console.log(data);
                    commit("CLEAR_SEARCH_VALUE", dongCode);
                },
                (error) => { 
                    console.log(error);
                }
            )
        }
    }
}

export default transferBoardStore;