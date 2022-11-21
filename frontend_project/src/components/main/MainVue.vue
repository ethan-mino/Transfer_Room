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
                <select class="form-select" id="dong" v-model="dongCode" @change="dongChange($event)">
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
            <div class="card">
              <img
                class="card-img-top"
                src="@/assets/img/temp.jpg"
                alt="Card image cap"
              />
              <div class="card-body">
                <p class="card-text">서율툭별시 종로구 청운동</p>

                <h5 class="card-title">세종하우스 105호</h5>
                <p class="card-text">6층, 원룸, 월세 10만원, 관리비 5만원</p>
                <p class="card-text">2022.06.10까지 계약</p>
              </div>
            </div>

            <div class="card">
              <img
                class="card-img-top"
                src="@/assets/img/temp.jpg"
                alt="Card image cap"
              />
              <div class="card-body">
                <p class="card-text">서율툭별시 종로구 청운동</p>

                <h5 class="card-title">세종하우스 105호</h5>
                <p class="card-text">6층, 원룸, 월세 10만원, 관리비 5만원</p>
                <p class="card-text">2022.06.10까지 계약</p>
              </div>
            </div>
          </div>
        </section>

        <section class="board-section">
          <h5 class="title">최근 올라온 양도 게시물</h5>
          <div class="cards">
            <div class="card">
              <img
                class="card-img-top"
                src="@/assets/img/temp.jpg"
                alt="Card image cap"
              />
              <div class="card-body">
                <p class="card-text">서율툭별시 종로구 청운동</p>

                <h5 class="card-title">세종하우스 105호</h5>
                <p class="card-text">6층, 원룸, 월세 10만원, 관리비 5만원</p>
                <p class="card-text">2022.06.10까지 계약</p>
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

const regionStore = "regionStore";

export default {
  name: "MainVue",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
    };
  },
  computed: {
    ...mapState(regionStore, ["sidos", "guguns", "dongs","selectsidoName","selectgugunName","selectdongName"]),
    // ...mapGetters(regionStore, [
    //   "sidoValueList",
    //   "gugunValueList",
    //   "dongValueList",
    // ]),
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.getSido();
    console.log(this.sidos);
  },
  methods: {
    ...mapActions(regionStore, ["getSido", "getGugun", "getDong","setSelectDongCode"]),
    ...mapMutations(regionStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    gugunList: function (e) {
      console.log(e.target)
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
      }
      else if (this.gugunCode === null) {
        alert("구군을 선택해주세요");
      }
      else if (this.dongCode === null) {
        alert("동을 선택해주세요");
      }
      else { 
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
