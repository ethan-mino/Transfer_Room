<template>
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
        <tr
          align="center"
          bgcolor="white"
          v-for="(item, index) in userTransferBoard"
          :key="index"
          @click="boardBtn(item.transferBoardId)"
        >
          <td>{{ index + 1 }}</td>
          <td>
            <a href="#">{{ item.transferTitle }}</a>
          </td>
          <td>{{ item.contractEndTime }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { mapActions } from "vuex";

const transferStore = "transferBoardStore";

import { getMemberTransferInfo } from "@/api/member";
export default {
  name: "TransferInfo",
  data() {
    return {
      userTransferBoard: {},
    };
  },
  created: async function () {
    //해당 유저의 이메일로 데이터 조회해옴.
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
  methods: {
    ...mapActions(transferStore, ["selectTransferBoardId"]),
    boardBtn: function (e) {
      this.selectTransferBoardId(e);
      this.$router.push({ name: "transferDetail" });
    },
  },
};
</script>

<style scoped>
@import "@/assets/css/accordianVerticalTap.css";
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
