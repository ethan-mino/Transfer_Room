<template>
  <div class="content-container">
    <div class="container">
      <h1 class="container-title">양도 내역</h1>
      <!-- TODO : 모든 글씨가 bold 채라서 게시글 정보가 잘 안보임-->
      <div style="display: flex; flex-direction: row; justify-content: center">
        <div class="category-list" id="accordian">
          <ul class="show-dropdown main-navbar">
            <div class="selector-active">
              <div class="top"></div>
              <div class="bottom"></div>
            </div>
            <li><a @click="myInfo">내 정보</a></li>
            <li><a @click="questionInfo">1:1 문의</a></li>
            <li><a @click="transferInfo">양도 내역</a></li>
            <li><a @click="communtityInfo">커뮤니티 게시글 내역</a></li>
          </ul>
        </div>
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import $ from "jquery";
// import TransferInfo from "@/components/user/mypage/TransferInfo";
// import MyInfo from "@/components/user/mypage/MyInfo";

export default {
  name: "MyPageVue",
  // components: {
  //     TransferInfo,
  //     MyInfo,
  // },
  created: function () {},
  methods: {
    activeTab: function (liElem) {
      $("#accordian ul li").removeClass("active");
      liElem.addClass("active");

      var activeWidthVerticalHeight = liElem.innerHeight();
      var activeWidthVerticalWidth = liElem.innerWidth();
      var itemPosVerticalTop = liElem.position();
      var itemPosVerticalLeft = liElem.position();

      $(".selector-active").css({
        top: itemPosVerticalTop.top + "px",
        left: itemPosVerticalLeft.left + "px",
        height: activeWidthVerticalHeight + "px",
        width: activeWidthVerticalWidth + "px",
      });
    },
    myInfo: function () {
      this.$router.push({ name: "myInfo" });
    },
    questionInfo: function () {
      // this.$router.push({ name: "transferInfo" });
    },
    transferInfo: function () {
      this.$router.push({ name: "transferInfo" });
    },
    communtityInfo: function () {
      // this.$router.push({ name: "transferInfo" });
    },
  },
  mounted: function () {
    if (this.$route.path !== "/transferInfo") {
      this.$router.push({ name: "transferInfo" });
    }

    const firstLiElem = $("#accordian ul li:nth-child(4)");
    this.activeTab(firstLiElem);

    $(document).on("click", "#accordian ul li", (event) => {
      // 카테고리를 클릭한 경우
      console.log("asd");
      const target = event.target;
      const closestLiElem = $(target).closest("li");

      if (
        target === closestLiElem[0] ||
        target === closestLiElem.children("a")[0]
      ) {
        // ! li 태그 또는 자식인 a 태그가 클릭 되었을 때만 동작하도록 해서, 이벤트 위임으로 인해 더보기 버튼(.more-container)을 클릭해도 카테고리가 변경되는 현상을 해결
        this.activeTab(closestLiElem); // * a 태그와 가장 가까운 li 태그를 활성화시킴
      }
    });
  },
};
</script>

<style scoped>
@import "@/assets/css/accordianVerticalTap.css";
/*@import "https://code.jquery.com/jquery-3.6.1.min.js";*/

.container {
  display: flex;
  flex-direction: column;
}

.contents {
  width: 700px;
  height: 600px;
  background-color: #ffffff;
  border-radius: 5px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
  margin-left: 20px;
}

h1.container-title {
  text-align: center;
  height: 100px;
  padding-left: 200px;
  padding-top: 10px;
}

.list-table {
  border-collapse: collapse;
  width: 100%;
}

.list-table a {
  text-decoration: none;
  color: #000000;
}

.list-table th,
.list-table td {
  border-bottom: 1px solid #444444;
  padding: 20px 5px;
}
</style>
