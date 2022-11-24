<template>
  <div class="contents">
    <table class="list-table">
      <colgroup>
        <col width="10%" />
        <col width="60%" />
        <col width="15%" />
        <col width="15%" />
      </colgroup>

      <thead>
        <tr align="center" bgcolor="white">
          <th>번호</th>
          <th>제목</th>
          <th>등록일</th>
          <th>상태</th>
        </tr>
      </thead>

      <tbody>
        <tr
          align="center"
          bgcolor="white"
          v-for="(item, index) in userTransferBoard"
          :key="index"
        >
          <td>{{ index + 1 }}</td>
          <td>
            <a @click="boardBtn(item.transferBoardId)">{{
              item.transferTitle
            }}</a>
          </td>
          <td>{{ item.contractEndTime }}</td>
          <!-- transferStatus가 0(미완료)이면서 transfereeId가 0(신청자 없음) 일 경우 -->
          <td
            class="progress__text"
            v-if="item.transferStatus === 0 && item.transfereeId === 0"
          >
            진행중
          </td>
          <!-- "수락" 버튼의 경우, transferStatus가 0(미완료)이면서 transfereeId가 0이 아닌 경우. -->
          <td v-if="item.transferStatus === 0 && item.transfereeId !== 0">
            <button
              class="accept__btn"
              @click="acceptBtn(item.transferBoardId)"
            >
              수락
            </button>
          </td>
          <!-- "완료"의 경우, transferStatus가 1(완료)인 경우. -->
          <td class="completion__text" v-if="item.transferStatus === 1">
            완료
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { mapActions } from "vuex";

const transferStore = "transferBoardStore";

import { getMemberTransferInfo, acceptTransfer } from "@/api/member";
export default {
  name: "TransferInfo",
  data() {
    return {
      userTransferBoard: [],
    };
  },
  created: async function () {
    //해당 유저의 이메일로 데이터 조회해옴.
    await this.getMemberInfo();
  },
  methods: {
    ...mapActions(transferStore, ["selectTransferBoardId"]),
    boardBtn: function (e) {
      this.selectTransferBoardId(e);
      this.$router.push({ name: "transferDetail" });
    },
    getMemberInfo: async function () {
      await getMemberTransferInfo(
        ({ data }) => {
          console.log(data);
          this.userTransferBoard = data.data;
          if (this.userTransferBoard == null) {
            this.userTransferBoard = {};
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    //수락 요청
    acceptBtn: async function (id) {
      await acceptTransfer(
        id,
        ({ data }) => {
          console.log(data);
        },
        (error) => {
          console.log(error);
        }
      );

      //데이터 세로 받아오기
      await this.getMemberInfo();
    },

    //TODO 조건문 필요
    // transferStatus 상태에 따라서 거래 상태를 진행, 수락, 완료 3상태로 나눔
    // "진행중"의 경우, transferStatus가 0(미완료)이면서 transfereeId가 0(신청자 없음) 일 경우
    // "수락" 버튼의 경우, transferStatus가 0(미완료)이면서 transfereeId가 0이 아닌 경우.
    // "완료"의 경우, transferStatus가 1(완료)인 경우.
  },
};
</script>

<style scoped>
@import "@/assets/css/accordianVerticalTap.css";
.container {
  display: flex;
  flex-direction: column;
}
table {
  border-collapse: collapse;
  width: 100%;
}
th,
td {
  background: #fff;
  padding: 8px 16px;
}
.contents {
  width: 700px;
  height: 600px;
  background-color: #ffffff;
  border-radius: 5px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
  margin-left: 20px;
  overflow: auto;
}

.contents thead th {
  position: sticky;
  top: 0;
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

.progress__text {
  color: #e50c0c;
}
.completion__text {
  color: #969696;
}

.accept__btn {
  color: green;
  border: 1px, black;
}
</style>
