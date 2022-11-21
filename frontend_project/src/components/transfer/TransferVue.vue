<template>
  <div class="content-container">
    <div class="contain">
      <div class="trading_info_area">
        <div class="aside">
          <span class="trading-legend">거래 정보</span>
          <div class="trading-data-list"></div>
        </div>

        <div class="map">
          <div id="deal-input">
            <div class="row col-md-12 justify-content-center mb-2">
              <div class="form-group col-md-2">
                <!-- <select
                  class="form-select"
                  id="sido"
                  v-model="sidoCode"
                  @change="gugunList"
                >
                  <option
                    v-for="(item, index) in sidoOption"
                    :value="item.value"
                    :key="index"
                  >
                    {{ item.text }}
                  </option>
                </select> -->
                <select class="form-select" id="sido">
                  <option value="">시도선택</option>
                </select>
              </div>
              <div class="form-group col-md-2">
                <!-- <select
                  class="form-select"
                  id="gugun"
                  v-model="gugunCode"
                  @change="dongList"
                >
                  <option
                    v-for="(item, index) in gugunOption"
                    :value="item.value"
                    :key="index"
                  >
                    {{ item.text }}
                  </option>
                </select> -->
                <select class="form-select" id="gugun">
                  <option value="">구군선택</option>
                </select>
              </div>
              <!-- <div class="form-group col-md-2">
                <select class="form-select" id="dong" v-model="dongCode">
                  <option
                    v-for="(item, index) in dongOption"
                    :value="item.value"
                    :key="index"
                  >
                    {{ item.text }}
                  </option>
                </select>
              </div> -->
              <div class="form-group col-md-2">
                <select class="form-select" id="dong">
                  <option value="">동선택</option>
                </select>
              </div>
              <div class="form-group col-md-2" style="display: contents">
                <button
                  type="button"
                  id="list-btn"
                  class="search btn btn-primary">
                  검색
                </button>
              </div>

              <!-- <c:if test="${!empty userInfo}"> -->
              <div class="form-group col-md-2">
                <button
                  type="button"
                  id="add-interesting-btn"
                  class="search btn btn-info"
                  style="color: #ffffff">
                  관심지역 등록하기
                </button>
              </div>

              <!-- </c:if> -->
            </div>
          </div>

          <div id="map" style="width: 100%; height: 100%; position:absolute"></div>
          <div id="interesting-area-list" style="display: none"></div>
          
          <div class="overlay_buttons">
            <button
              type="button"
              class="overlay_button btn btn-secondary"
              value="roadview"
              @click="setOverlayMapTypeId('normal')"
            >
              기본뷰 보기
            </button>
            <button
              type="button"
              class="overlay_button btn btn-secondary"
              value="roadview"
              @click="setOverlayMapTypeId('roadview')"
            >
              로드뷰 도로정보 보기
            </button>
            <button
              type="button"
              class="overlay_button btn btn-secondary"
              value="traffic"
              @click="setOverlayMapTypeId('traffic')"
            >
              교통정보 보기
            </button>
            <button
              type="button"
              class="overlay_button btn btn-secondary"
              value="terrain"
              @click="setOverlayMapTypeId('terrain')"
            >
              지형정보 보기
            </button>
            <button
              type="button"
              class="overlay_button btn btn-secondary"
              value="use_district"
              @click="setOverlayMapTypeId('use_district')"
            >
              지적편집도 보기
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState, mapMutations } from "vuex";


const regionStore = "regionStore";
const transferStore = "transferBoardStore"

export default {
  name: "TransferVue",
  data() { 
    return {
      currentTypeId: null,

      // 지도 마커 정보 담고 있기.
    };
  },
  //생성시점에 동코드로 게시글 조회 해오기
  created() {


    //선택된 동코드가 null이 아니라면(메인페이지에서 선택하고 온 경우.)
    if (this.selectDongCode != null) { 
      this.getBoardInfo();
    }

    //시도구군 초기화 및 시도 값 받아오기.
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.getSido();

  },
  computed: {
    ...mapState(regionStore,["sidos", "guguns", "dongs","selectDongCode"]),
  },
  mounted: function () {

    console.log(this.selectDongCode);
    if (!window.kakao || !window.kakao.maps) {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=60929dd5ec29490e1dec592ba22a0dff&autoload=false";
      script.addEventListener("load", () => {
        kakao.maps.load(this.initMap);
      });
      document.head.appendChild(script);
      // this.initMap();
    } else {
      this.initMap();
    }
  },
  methods: {
    ...mapActions(regionStore, ["getSido", "getGugun", "getDong","setSelectDongCode"]),
    ...mapMutations(regionStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    ...mapActions(transferStore, ["getTransferBoardResult"]),
    getBoardInfo: async function () { 
      await this.getTransferBoardResult(this.selectDongCode)
    },
    gugunList: function () {
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList: function () {
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
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

    initMap() {
      const container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
      const options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(36.3552, 127.2985), //지도의 중심좌표.
        level: 5, //지도의 레벨(확대, 축소 정도)
      };

      this.map = new kakao.maps.Map(container, options); //지도
      // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
      this.mapTypeControl = new kakao.maps.MapTypeControl();

      // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
      // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
      this.map.addControl(
        this.mapTypeControl,
        kakao.maps.ControlPosition.TOPRIGHT
      );

      // 지도 확대 축소를 제어할 수 있는 줌 컨트롤을 생성합니다
      this.zoomControl = new kakao.maps.ZoomControl();
      this.map.addControl(this.zoomControl, kakao.maps.ControlPosition.RIGHT);
    },
    setOverlayMapTypeId(maptype) { 
      var changeMaptype;

      // maptype에 따라 지도에 추가할 지도타입을 결정합니다
      if (maptype === 'traffic') {    // 교통정보 지도타입
        changeMaptype = kakao.maps.MapTypeId.TRAFFIC;
      } else if (maptype === 'roadview') {    // 로드뷰 도로정보 지도타입
        changeMaptype = kakao.maps.MapTypeId.ROADVIEW;
      } else if (maptype === 'terrain') {// 지형정보 지도타입
        changeMaptype = kakao.maps.MapTypeId.TERRAIN;
      } else if (maptype === 'use_district') {    // 지적편집도 지도타입
        changeMaptype = kakao.maps.MapTypeId.USE_DISTRICT;
      }

      // 이미 등록된 지도 타입이 있으면 제거합니다
      if (this.currentTypeId) {
        this.map.removeOverlayMapTypeId(this.currentTypeId);
      }

      if (maptype !== 'normal') { 
        // maptype에 해당하는 지도타입을 지도에 추가합니다
        this.map.addOverlayMapTypeId(changeMaptype);
      }
      

      // 지도에 추가된 타입정보를 갱신합니다
      this.currentTypeId = changeMaptype;
    }
  },
};
</script>

<style>
@import "@/assets/css/tradingSearch.css";
@import "@/assets/css/map.css";
@import "@/assets/css/interesting_area.css";
</style>
