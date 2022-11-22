<template>
  <div>
    <div
      class="trading_data"
      v-for="item in transferBoardSearchValue"
      :key="item.transferBoardId"
    >
      <!-- <input type="hidden" id="dealNo" value="${tradingData.aptCode}">
            <input type="hidden" id="aptCode" value="${tradingData.aptCode}"> -->
      <span class="transfer-title">{{ item.transferTitle }}<br /></span>
      <span class="floor">{{ item.roomFloor }} 층<br /></span>
      <span class="contract-type"
        >계약 구분 : {{ item.contractType }}<br
      /></span>
      <span class="room-type">방 형태 : {{ item.roomType }}<br /></span>
      <span class="contract-end-time"
        >계약만료일 : {{ item.contractEndTime }}<br
      /></span>
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
  },
};
</script>

<style></style>
