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
                  class="search btn btn-primary"
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
                >
                  관심지역 등록하기
                </button>
              </div>

              <div class="form-group col-md-2">
                <button
                  type="button"
                  id="add-interesting-btn"
                  class="search btn btn-info"
                  style="color: #ffffff"
                >
                  등록
                </button>
              </div>
              <!-- </c:if> -->
            </div>
          </div>

          <div id="map" style="width: 100%; height: 100%"></div>
          <div id="interesting-area-list" style="display: none"></div>
          <div class="overlay_buttons">
            <button
              type="button"
              class="overlay_button btn btn-secondary"
              value="roadview"
            >
              로드뷰 도로정보 보기
            </button>
            <button
              type="button"
              class="overlay_button btn btn-secondary"
              value="traffic"
            >
              교통정보 보기
            </button>
            <button
              type="button"
              class="overlay_button btn btn-secondary"
              value="terrain"
            >
              지형정보 보기
            </button>
            <button
              type="button"
              class="overlay_button btn btn-secondary"
              value="use_district"
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
export default {
  name: "TransferVue",
  mounted: function () {
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
  },
};
</script>

<style>
@import "@/assets/css/tradingSearch.css";
@import "@/assets/css/map.css";
@import "@/assets/css/interesting_area.css";
</style>
