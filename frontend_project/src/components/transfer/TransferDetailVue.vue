<template>
    <div class="detail_page">
        <div class="content-container">
            <div class="content">
            <div id="img-carousel" class="img-list carousel slide" style="margin-bottom : 15px;" data-bs-ride="carousel">
                <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="@/assets/img/img1.jpg" class="d-block w-100" alt="">
                </div>
                <div class="carousel-item active">
                    <img src="@/assets/img/img2.jpg" class="d-block w-100" alt="">
                </div>
                <div class="carousel-item">
                    <img src="@/assets/img/img3.jpg" class="d-block w-100" alt="">
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
                    유성온천역 근처 5분 거리, 혼자 살기 좋은 집 양도합니다.
                </div>
                <span class = "address" style = "font-size: 15px; margin-bottom : 5px">장대로 80번길 59 세종하우스 105호</span>,
                <span class = "room_floor">4층</span>

                <div>
                    <span class = "room_type">원룸</span> / <span class = "contract_type">월세</span>
                </div>
                
                <div style = "border-bottom: 1px solid lightgray; padding-bottom : 10px">
                    <span class = "transferer">rlfalsgh95</span>,
                    <span class = "create_time">2022.08.20</span>
                </div>
                
                
                <pre class = "tb_content" style="font-size : 14px; padding : 20px 0px; border-bottom: 1px solid lightgray;">
                    취뽀로 SSAFY를 퇴소하게 되어 집을 양도합니다! 
                    좋은 기운 받으셔서, 취뽀 하시길 바랄게요!!

                    🎈 구조와 특징 🎈

                    ㅇ 넓은 베란다 공간 !!
                    ㅇ 화이트톤 깔끔한 주방시설 !!


                    🎈 위치와 교통 🎈

                    ㅇ 선정릉역 선릉역 더블 역세권  
                    ㅇ 편리한교통으로  버스노선 다수


                    🎈 주차와 편의시설 🎈

                    ㅇ 병원, 커피숍, 편의점, 세탁소, 미용실 등 편의시설 인접
                    ㅇ 주차대수: 세대당 1대 선착순 협의 주차
                    ㅇ 방향 기준: 안방
                    ㅇ 수도, 전기, 가스 요금은 실사용량에 따라 별도 부과

                    * 3개월 기준 금액으로 1~2개월은 협의 후 가능하다고 하시네요!! *
                </pre>
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
export default {
    name: "TransferDetailVue",
    data() { 
        return {
        
        };
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
