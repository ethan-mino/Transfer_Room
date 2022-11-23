<template>
  <div class="content-container">
    <div class="contain">
      <div class="trading_info_area">
        <div class="aside">
          <span class="trading-legend">양도 정보</span>
          <div class="trading-data-list">
            <TransferListVue></TransferListVue>
          </div>
        </div>

        <div class="map">
          <div id="deal-input">
            <div class="row col-md-12 justify-content-center mb-2">
              <div class="form-group col-md-2">
                <select
                  class="form-select"
                  id="sido"
                  v-model="sidoCode"
                  @change="gugunList"
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
                  @change="dongList"
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
                <select class="form-select" id="dong" v-model="dongCode">
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
                  class="search btn btn-primary"
                  @click="searchBtn"
                >
                  검색
                </button>
              </div>

              <!-- <c:if test="${!empty userInfo}"> -->
              <div class="form-group col-md-2">
                <button
                  type="button"
                  id="add-interesting-btn"
                  class="search btn btn-info"
                  style="color: #ffffff"
                  @click="interestingBtn"
                >
                  관심지역 등록하기
                </button>
              </div>

              <!-- </c:if> -->
            </div>
          </div>

          <div
            id="map"
            style="width: 100%; height: 100%; position: absolute"
          ></div>
          <!-- <div>
            <InterestVue></InterestVue>
          </div> -->
          <div id="interesting-area-list" style="display: ">
            <InterestVue></InterestVue>
          </div>

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
import InterestVue from "@/components/transfer/interest/InterestVue";
import TransferListVue from "@/components/transfer/TransferListVue";

import { mapActions, mapState, mapMutations } from "vuex";

const regionStore = "regionStore";
const transferStore = "transferBoardStore";
const interestingStore = "interestingStore";

export default {
  name: "TransferVue",
  components: {
    InterestVue,
    TransferListVue,
  },
  data() {
    return {
      currentTypeId: null,

      sidoCode: null,
      gugunCode: null,
      dongCode: null,

      // 지도 마커 정보 담고 있기.
      markerInfos: [],

      //지도 초기 위치
      initLat: 37.40202682159887,
      initLng: 127.1086368474788,
    };
  },
  //생성시점에 동코드로 게시글 조회 해오기
  async created() {


    /*관심지역 조회*/
    await this.selctInterestingInfo(); // 뷰엑스에 저장되어있음.

    /*이전에 검색된 값 삭제*/
    this.clearSearchInfo();

    console.log("before clear test :"+this.selectDongCode);
    //선택된 동코드가 null이 아니라면(메인페이지에서 선택하고 온 경우.)
    if (this.selectDongCode != null) {
      await this.getBoardInfo();
      
    }

    //시도구군 초기화 및 시도 값 받아오기.
    else {
      this.CLEAR_SIDO_LIST();
      this.CLEAR_GUGUN_LIST();
      this.CLEAR_DONG_LIST();
      this.getSido();
    }

    
  },
  beforeDestroy() { 
    this.selectCodeClear(); //선택했던 정보 초기화.
    // this.removeAllMaker();//지도 초기화
    // this.map.marker.clear();

    console.log("after mark : " +  this.markerInfos);
    console.log("after clear test :"+this.selectDongCode);
  },
  computed: {
    ...mapState(regionStore, ["sidos", "guguns", "dongs", "selectDongCode"]),
    ...mapState(transferStore, ["transferBoardSearchValue"]),
    ...mapState(interestingStore, ["interestingInfos", "insertFail"]),
  },

  mounted: function () {

    console.log(this.selectDongCode);
    // TODO - 현재 컴포넌트가 생성될때 지도를 생성하도록 바꿨는데, 지도 재생성하지 않고, 마커만 지우는 방법 생각해볼 필요가 있음.
    // if (!window.kakao || !window.kakao.maps) {
      const script = document.createElement("script");
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?appkey=60929dd5ec29490e1dec592ba22a0dff&autoload=false";
      script.addEventListener("load", () => {
        kakao.maps.load(this.initMap);
      });
      document.head.appendChild(script);
      // this.initMap();
    // } else {
    //   this.initMap();
    // }
  },
  methods: {
    ...mapActions(regionStore, [
      "getSido",
      "getGugun",
      "getDong",
      "setSelectDongCode",
      "selectCodeClear",
    ]),
    ...mapMutations(regionStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    ...mapActions(transferStore, ["getTransferBoardResult","clearSearchInfo"]),
    ...mapActions(interestingStore, ["selectInteresting", "insertInteresting"]),
    getBoardInfo: async function () {
      await this.getTransferBoardResult(this.selectDongCode);
      console.log("test2 : " + this.transferBoardSearchValue);
    },
    gugunList: function () {
      //구군 정보 가져오기.
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList: function () {
      //동정보 가져오기.
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    searchBtn: async function () {
      //시도 구군 동까지 전부 입력이 되어있어야 됨.
      if (this.sidoCode === null) {
        alert("시도를 선택해주세요");
      } else if (this.gugunCode === null) {
        alert("구군을 선택해주세요");
      } else if (this.dongCode === null) {
        alert("동을 선택해주세요");
      } else {
        //동코드로 게시글 조회해서 지도 찍는 코드 실행.
        this.setSelectDongCode(this.dongCode); //해당 동코드 저장.
        await this.getBoardInfo(); //게시글 다시 조회.

        console.log("check data : " + this.transferBoardSearchValue);

        //게시글 조회 후 획인결과 게시글이 없다면 이전에 검색한 결과를 계속 지도에 찍음.
        if (this.transferBoardSearchValue.length == 0) {
          alert("검색결과가 없습니다.");
          this.map.panTo(new kakao.maps.LatLng(this.initLat, this.initLng));
        }
        this.setMarker(); // 마커 다시 찍기.
      }

      console.log("value check : " + this.transferBoardSearchValue);
    },

    /*관심지역 처리 파트*/
    interestingBtn: async function () {
      //시도 구군 동까지 전부 입력이 되어있어야 됨
      if (this.sidoCode === null) {
        alert("시도를 선택해주세요");
      } else if (this.gugunCode === null) {
        alert("구군을 선택해주세요");
      } else if (this.dongCode === null) {
        alert("동을 선택해주세요");
      } else {
        //관심페이지 등록하는 코드와, 관심지역 뷰엑스에 다시 호출하는 코드 실행.
        await this.insertInterestingInfo(); //추가하고

        //중복에러가 났다면 true 가 됨.
        if (this.insertFail) {
          alert("이미 등록된 지역입니다.");
        } else {
          await this.selctInterestingInfo(); //새로 조회.
        }

        console.log(this.interestingInfos[0]);
      }
    },
    selctInterestingInfo: async function () {
      await this.selectInteresting();
    },
    insertInterestingInfo: async function () {
      let data = { dongCode: this.dongCode };
      await this.insertInteresting(data);
    },

    /*지도 처리 파트*/
    initMap() {
      const container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
      const options = {
        //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(this.initLat, this.initLng), //지도의 중심좌표.
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

      if (this.transferBoardSearchValue != null) {
        this.setMarker();
      }
    },
    setOverlayMapTypeId(maptype) {
      var changeMaptype;

      // maptype에 따라 지도에 추가할 지도타입을 결정합니다
      if (maptype === "traffic") {
        // 교통정보 지도타입
        changeMaptype = kakao.maps.MapTypeId.TRAFFIC;
      } else if (maptype === "roadview") {
        // 로드뷰 도로정보 지도타입
        changeMaptype = kakao.maps.MapTypeId.ROADVIEW;
      } else if (maptype === "terrain") {
        // 지형정보 지도타입
        changeMaptype = kakao.maps.MapTypeId.TERRAIN;
      } else if (maptype === "use_district") {
        // 지적편집도 지도타입
        changeMaptype = kakao.maps.MapTypeId.USE_DISTRICT;
      }

      // 이미 등록된 지도 타입이 있으면 제거합니다
      if (this.currentTypeId) {
        this.map.removeOverlayMapTypeId(this.currentTypeId);
      }

      if (maptype !== "normal") {
        // maptype에 해당하는 지도타입을 지도에 추가합니다
        this.map.addOverlayMapTypeId(changeMaptype);
      }

      // 지도에 추가된 타입정보를 갱신합니다
      this.currentTypeId = changeMaptype;
    },
    //
    createMaker(latitude, longitude) {
      const coords = new kakao.maps.LatLng(latitude, longitude);

      // 마커를 생성합니다
      // const marker =
      const marker = new kakao.maps.Marker({
        map: this.map,
        position: coords,
        clickable: true,
      });
      // 마커에 마우스오버 이벤트를 등록합니다
      // var overlay = new kakao.maps.CustomOverlay({
      //   content: overlayContent,
      //   map: this.map,
      //   position: marker.getPosition(),
      // });
      // // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
      // kakao.maps.event.addListener(marker, "click", function () {
      //   overlay.setMap(this.map);
      // });

      const markerInfo = { marker: marker, overlay: null };
      this.markerInfos.push(markerInfo);
    },
    removeAllMaker() {
      for (let i = 0; i < this.markerInfos.length; i++) {
        this.markerInfos[i].marker.setMap(null);
        this.markerInfos[i].overlay = null;
        
        // console.log("remove Marker etst : " + this.markerInfos[i].marker.);
      }
      this.markerInfos = [];
    },
    setMarker() {
      this.removeAllMaker();
      this.transferBoardSearchValue.forEach((searchInfo) => {
        this.createMaker(searchInfo.roomLatitude, searchInfo.roomLongitude);
      });
      this.moveToFirstMarker();
    },
    //마커중 첫번째 위치로 이동.
    moveToFirstMarker() {
      if (this.markerInfos.length > 0) {
        this.map.panTo(this.markerInfos[0].marker.getPosition());
        console.log("test1231231");
      }
    },
  },
};
</script>

<style>
@import "@/assets/css/tradingSearch.css";
@import "@/assets/css/map.css";
@import "@/assets/css/interesting_area.css";
</style>
