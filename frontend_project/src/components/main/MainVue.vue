<template>
  <div>
    <div class="content-container">
      <div class="contain">
        <div class="background-input">
          <h2 id="background-input__title">어떤 집으로 환승하시겠어요?</h2>

          <div id="deal-input">
            <div class="row col-md-12 justify-content-center mb-2">
              <div class="form-group col-md-2">
                <select
                  class="form-select"
                  id="sido"
                  v-model="sidoCode"
                  @change="gugunList($event)"
                >
                  <option
                    v-for="(item, index) in sidos"
                    :value="item.value"
                    :key="index"
                  >
                    {{ item.text }}
                  </option>
                </select>
              </div>
              <div class="form-group col-md-2">
                <select
                  class="form-select"
                  id="gugun"
                  v-model="gugunCode"
                  @change="dongList($event)"
                >
                  <option
                    v-for="(item, index) in guguns"
                    :value="item.value"
                    :key="index"
                  >
                    {{ item.text }}
                  </option>
                </select>
              </div>
              <div class="form-group col-md-2">
                <select
                  class="form-select"
                  id="dong"
                  v-model="dongCode"
                  @change="dongChange($event)"
                >
                  <option
                    v-for="(item, index) in dongs"
                    :value="item.value"
                    :key="index"
                  >
                    {{ item.text }}
                  </option>
                </select>
              </div>
              <div class="form-group col-md-2" style="display: contents">
                <button
                  type="button"
                  id="list-btn"
                  class="search btn btn-light"
                  @click="searchBtn"
                >
                  검색
                </button>
              </div>
            </div>
          </div>
        </div>

        <section class="board-section">
          <h5 class="title">좋아요 많이 받은 양도 게시물</h5>
          <div class="cards">
            <div class="card" v-for="(item, index) in likeSelect" :key="index">
              <img
                class="card-img-top"
                :src="
                  'http://localhost:8080/transfer-board/file/' +
                  item.imgFileList[0].fileId
                "
                alt="Card image cap"
              />
              <div class="card-body">
                <p class="card-text">{{ item.roomAddress }}</p>

                <h5 class="card-title">{{ item.transferTitle }}</h5>
                <p class="card-text">
                  {{ item.roomFloor }}층, {{ item.roomType }},
                  {{ item.contractType }}
                </p>
                <p class="card-text">{{ item.contractEndTime }}까지 계약</p>
              </div>
            </div>
          </div>
        </section>

        <section class="board-section">
          <h5 class="title">최근 올라온 양도 게시물</h5>
          <div class="cards">
            <div class="card" v-for="(item, index) in timeSelect" :key="index">
              <img
                class="card-img-top"
                :src="
                  'http://localhost:8080/transfer-board/file/' +
                  item.imgFileList[0].fileId
                "
                alt="Card image cap"
              />
              <div class="card-body">
                <p class="card-text">{{ item.roomAddress }}</p>

                <h5 class="card-title">{{ item.transferTitle }}</h5>
                <p class="card-text">
                  { item.roomFloor }}층, {{ item.roomType }},{{
                    item.contractType
                  }}
                </p>
                <p class="card-text">{{ item.contractEndTime }}까지 계약</p>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import { mostLikeBoard, lastTimeBoard } from "@/api/transferBoard";

const regionStore = "regionStore";

export default {
  name: "MainVue",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,

      //좋아요 순 데이터
      likeSelect: [],
      //시간 순 데이터.
      timeSelect: [],
    };
  },
  computed: {
    ...mapState(regionStore, [
      "sidos",
      "guguns",
      "dongs",
      "selectsidoName",
      "selectgugunName",
      "selectdongName",
    ]),
    // ...mapGetters(regionStore, [
    //   "sidoValueList",
    //   "gugunValueList",
    //   "dongValueList",
    // ]),
  },
  created: async function () {
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.getSido();
    console.log(this.sidos);

    //좋아요 순으로 5개 가져오기.
    await mostLikeBoard(
      ({ data }) => {
        console.log(data);
        this.likeSelect = data.data;
      },
      (error) => {
        console.log(error);
      }
    );

    //시간순으로 5개 가져오기.
    await lastTimeBoard(
      ({ data }) => {
        console.log(data);
        this.timeSelect = data.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    ...mapActions(regionStore, [
      "getSido",
      "getGugun",
      "getDong",
      "setSelectDongCode",
    ]),
    ...mapMutations(regionStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    gugunList: function (e) {
      console.log(e.target);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList: function (e) {
      console.log(e.target);
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    dongChange: function (e) {
      console.log(e.target);
    },
    searchBtn: function () {
      //시도 구군 동까지 전부 입력이 되어있어야 됨.
      if (this.sidoCode === null) {
        alert("시도를 선택해주세요");
      } else if (this.gugunCode === null) {
        alert("구군을 선택해주세요");
      } else if (this.dongCode === null) {
        alert("동을 선택해주세요");
      } else {
        this.setSelectDongCode(this.dongCode); //뷰엑스에 동코드 저장.
        this.$router.push({ name: "transferPage" });
      }
    },
  },
};
</script>

<style>
@import "@/assets/css/home/home.css";
</style>
