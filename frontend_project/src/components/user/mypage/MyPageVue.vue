<template>
    <div class="myPageContainer">
        <div class="container">
            <h1 class="container-title">커뮤니티 게시글 내역</h1> <!-- TODO : 모든 글씨가 bold 채라서 게시글 정보가 잘 안보임-->
            <div style="display: flex; flex-direction: row; justify-content: center;">
                <div class="category-list" id="accordian">
                    <ul class="show-dropdown main-navbar">
                        <div class="selector-active">
                            <div class="top"></div>
                            <div class="bottom"></div>
                        </div>
                        <li><a >내 정보</a></li>
                        <li><a>1:1 문의</a></li>
                        <li><a>양도 내역</a></li>
                        <li><a>커뮤니티 게시글 내역</a></li>
                    </ul>
                </div>
    
                <div class="contents">
                    <table class="list-table">
                        <colgroup> 
                            <col width="15%" /> 
                            <col width="70%" /> 
                            <col width="15%" />
                        </colgroup>

                        <thead>
                            <tr align="center" bgcolor="white">
                                <th>번호</th>
                                <th>제목</th>
                                <th>등록일</th>
                            </tr>
                        </thead>
            
                        <tbody>
                            <tr align="center" bgcolor="white">
                                <td>200</td>
                                <td><a href="#">충남대 근처 10분거리, 혼자 살기 좋은 집 양도합니다.</a></td>
                                <td>2022.11.24</td>
                            </tr>
                            <tr align="center" bgcolor="white">
                                <td>201</td>
                                <td><a href="#">유성온천역 근처 5분 거리, 쾌적한 집 양도합니다!!</a></td>
                                <td>2022.11.24</td>
                            </tr>
                        </tbody>
                    </table> 
                </div>
            </div>
        </div>
    </div>

</template>

<script>
export default {
    name: "MyPageVue",

    methods: {
        // activeTab: function (liElem) { 
        //     $('#accordian ul li').removeClass("active");
        //     liElem.addClass('active');

        //     var activeWidthVerticalHeight = liElem.innerHeight();
        //     var activeWidthVerticalWidth = liElem.innerWidth();
        //     var itemPosVerticalTop = liElem.position();
        //     var itemPosVerticalLeft = liElem.position();

        //     $(".selector-active").css({
        //         "top":itemPosVerticalTop.top + "px",
        //         "left":itemPosVerticalLeft.left + "px",
        //         "height": activeWidthVerticalHeight + "px",
        //         "width": activeWidthVerticalWidth + "px"
        //     });
        // },
        // test: {
        //     selectBtn
        // } 
    }
}

// $(document).on("click", "#accordian ul li", (event) =>{ // 카테고리를 클릭한 경우
//     console.log("asd");
//     const target = event.target;
//     const closestLiElem = $(target).closest("li");
    

//     if(target === closestLiElem[0] || target === closestLiElem.children("a")[0]){  // ! li 태그 또는 자식인 a 태그가 클릭 되었을 때만 동작하도록 해서, 이벤트 위임으로 인해 더보기 버튼(.more-container)을 클릭해도 카테고리가 변경되는 현상을 해결
//         activeTab(closestLiElem);   // * a 태그와 가장 가까운 li 태그를 활성화시킴

//         const categoryName = closestLiElem.data("label");
//     }
// })
</script>

<style scoped>
@import "@/assets/css/accordianVerticalTap.css";
/*@import "https://code.jquery.com/jquery-3.6.1.min.js";*/

    .myPageContainer .container{
        display: flex;
        flex-direction: column;
    }

    .myPageContainer .contents{
        width : 700px;
        height: 700px;
        background-color: #ffffff;
        border-radius: 5px;
        box-shadow: 0 0 5px rgba(0,0,0,.2);
        margin-left : 20px;
    }
    
    .myPageContainer h1.container-title{
        text-align: center;
        height: 60px;
        padding-left: 200px;
        padding-top: 10px;
    }

    .myPageContainer .list-table{
        border-collapse: collapse;
        width : 100%;
    }

    .myPageContainer .list-table a{
        text-decoration: none;
        color : #000000;
    }

    .myPageContainer .list-table th, .list-table td{
        border-bottom: 1px solid #444444;
        padding: 20px 5px;
    }
</style>