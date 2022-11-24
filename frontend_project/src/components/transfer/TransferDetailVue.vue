<template>
    <div class="detail_page">
        <div class="content-container">
            <div class="content">
                <div id="img-carousel" class="img-list carousel slide" style="margin-bottom : 15px;" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div v-for="(item, idx) in boardInfo.imgFileList" :key="idx">
                            <div class="carousel-item" :class="{active : (idx == 0)}">
                                <img :src="'http://localhost:8080/transfer-board/file/' + item.fileId" class="d-block w-100" alt="">
                            </div>
                        </div>
                    </div>
                    
                    <button class="carousel-control-prev" type="button" data-bs-target="#img-carousel" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#img-carousel" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                    </button>
                </div>

                <div class="transfer_board" style = "width : 100%; padding : 20px">
                    <div class="board_infos">
                    <div class="tb_title" style = "font-size: 20px; margin-bottom : 10px; font-weight: bold;">
                        {{boardInfo.transferTitle}}
                    </div>
                    <span class = "address" style = "font-size: 15px; margin-bottom : 5px">{{boardInfo.roomAddress}}</span>,
                    <span class = "room_floor">{{boardInfo.roomFloor}}층</span>

                    <div>
                        <span class = "room_type">{{boardInfo.roomType}}</span> / <span class = "contract_type">{{boardInfo.contractType}}</span>
                    </div>
                    
                    <div style = "border-bottom: 1px solid lightgray; padding-bottom : 10px">
                        <!-- todo 작성자 id만 있어서 user 테이블 조인 필요. 또는 유저 테이블에 요청 필요 -->
                        <span class = "transferer">{{userName}}</span>,
                        <span class = "create_time">{{boardInfo.contractEndTime}}</span>
                    </div>
                    
                    
                    <div class="tb_content" style="font-size : 14px; padding : 20px 0px; border-bottom: 1px solid lightgray;" v-html="boardInfo.transferContent.replace(/\n/gi, '</br>')">
                        <!-- {{boardInfo.transferContent.replace(/\n/gi, '</br>')}} -->
                    </div>
                    </div>
                    <div style="margin-top : 15px">
                        <a v-for="(file, idx) in boardInfo.attachedFileList" :key="idx">
                            <a :href = "'http://localhost:8080/transfer-board/file/' + file.fileId">{{file.filePath.split("/")[2]}}</a>
                        </a>                
                    </div>
                </div>
            
                <div class="btn-wrap" style="margin-bottom : 20px">
                    <button class="add" @click="registBtn">양도 요청</button>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
import { mapState } from "vuex";
import { getTransferBoardById } from "@/api/transferBoard";
import { getUser } from "@/api/member";

const transferBoardStore = "transferBoardStore";

export default {
    name: "TransferDetailVue",
    data() { 
        return {
            boardInfo: {},
            contractEndTime: null,
            userName: "Anonymous",
        };
    },
    created: async function() {
        // 게시글 정보 받아오기.
        await getTransferBoardById(
            this.selectTransferBoardId,
            ({ data }) => { 
                console.log(data);
                this.boardInfo = data.data[0];
            },
            (error) => { 
                console.log(error);
            }
        )
        // if (this.boardInfo != null) { 

        //     let splitTime = this.boardInfo.contractEndTime.split("-");

        //     this.contractEndTime = splitTime[0] + "." + splitTime[1] + "." + splitTime[2];
        // }
        
        //유저정보 조회
        await getUser(
            this.boardInfo.transfererId,
            ({ data }) => { 
                console.log(data);
                if (data.data.userName != null) { 
                    this.userName = data.data.userName;
                }
                
            },
            (error) => { 
                console.log(error);
            }
        )
        
    },
    computed: {
        ...mapState(transferBoardStore, ["selectTransferBoardId"]),
    },
    methods: {
        registBtn: function () { 
            this.$router.push({ name: "transferPage" });
        }
    }

};
</script>

<style scoped>
@import "@/assets/css/transfer/transferBoard.css";

</style>
