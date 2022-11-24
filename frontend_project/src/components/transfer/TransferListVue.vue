<template>
  <div>
    <div
      class="trading_data"
      v-for="item in transferBoardSearchValue"
      :key="item.transferBoardId"
    >
      <!-- <input type="hidden" id="dealNo" value="${tradingData.aptCode}">
            <input type="hidden" id="aptCode" value="${tradingData.aptCode}"> -->
      <div @click="transferBoardSelect(item.transferBoardId)" style = "display: flex;">
        <span class="img__span">
          <img :src="'http://localhost:8080/transfer-board/file/' + item.imgFileList[0].fileId" />
        </span>
        <br />
        <span >
          <div class="transfer-title">{{ item.transferTitle }}<br /></div>
          <div class="address" style="font-size : 14px; margin-top : 10px">{{item.roomAddress.replace(/ {2,}/gi, " ").split(" ").splice(0, 4).join(" ")}}, {{ item.roomFloor }} 층</div> 
          <div class="room-type">{{ item.roomType }}, {{item.contractType}}<br /></div>
          <div class="transfer-content">{{item.transferContent}}</div>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

const transferBoardStore = "transferBoardStore";

/*해당 지역의 양도 게시글 보여주기.*/
export default {
  name: "TransferListVue",

  computed: {
    ...mapState(transferBoardStore, ["transferBoardSearchValue"]),
  },
  methods: {
    //해당지역을 선택하면 상세 페이지로 이동.
    transferBoardSelect: function (transferBoardId) {
      console.log("emit chlid check");
      this.$emit("boardSelect", transferBoardId);
    },
  },
};
</script>

<style>
@import "@/assets/css/transfer/transferList.css";
</style>
