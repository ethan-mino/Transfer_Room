<template>
  <div class="content-container2 add-transfer">
    <header>
        <div class="header-content">
            방 내놓기
        </div>
    </header>  
    
    <div class="detail-contents">
        <h1>기본 정보</h1>
        <table>
            <colgroup>
                <col width="150px"><col>
            </colgroup>
            <tbody>
                <tr>
                    <th>매물 종류</th>
                    <td>
                        <div class="input-wrap">
                            <ul class="radio-list">
                                <li>
                                    <label class="input-radio">
                                        <input type="radio" name="roomType" value="투룸" v-model="this.roomType" >
                                        <p>투룸</p>
                                    </label>
                                </li>
    
                                <li>
                                    <label class="input-radio">
                                        <input type="radio" name="roomType" value="쓰리룸" v-model="this.roomType">
                                        <p>쓰리룸</p>
                                    </label>
                                </li>
    
    
                                <li>
                                    <label class="input-radio">
                                        <input type="radio" name="roomType" value="아파트" v-model="this.roomType">
                                        <p>아파트</p>
                                    </label>
                                </li>
    
                                <li>
                                    <label class="input-radio">
                                        <input type="radio" name="roomType" value="오피스텔" v-model="this.roomType">
                                        <p>오피스텔</p>
                                    </label>
                                </li>
                            </ul>
                        </div>
                    </td>
                </tr>

                <tr>
                    <th>계약 종류</th>
                    <td>
                        <div class="input-wrap">
                            <ul class="radio-list">
                                <li>
                                    <label class="input-radio">
                                        <input type="radio" name="contractType" value="월세" v-model="this.contractType">
                                        <p>월세</p>
                                    </label>
                                </li>
    
                                <li>
                                    <label class="input-radio">
                                        <input type="radio" name="contractType" value="전세" v-model="this.contractType">
                                        <p>전세</p>
                                    </label>
                                </li>
                            </ul>
                        </div>
                        
                    </td>
                </tr>

                <tr>
                    <th rowspan="2">주소</th>
                    <td>
                        <div class="input-wrap">
                          <div id="deal-input">
                            <!-- <div class="row col-md-12 justify-content-center mb-2"> -->
                              
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
                                <select class="form-select" id="dong" v-model="dongCode" @click="test">
                                  <option
                                    v-for="(item, index) in dongs"
                                    :value="item.value"
                                    :key="index"
                                  >
                                    {{ item.text }}
                                  </option>
                                </select>
                              </div>
                            <!-- </div> -->
                          </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                      <div class="input-wrap">
                        <input type="text" name="roomAddress" class="detail-input" v-model="this.roomAddress" placeholder="예) 대전광역시 유성구 온천1동 124 삼성화재 유성연수원 ">
                      </div>
                    </td>
                </tr>

                <tr>
                    <th>층</th>
                    <td>
                        <div class="input-wrap">
                            <input type="number" name="roomFloor" class="detail-input" v-model="this.roomFloor" placeholder="예) 4">
                        </div>
                    </td>
                </tr>

                <tr>
                    <th>계약 종료일</th>
                    <td>
                        <div class="input-wrap">
                            <input type="date" name="contractEndTime" class="detail-input" v-model="this.contractEndDay">
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="detail-contents">
        <h1>상세 설명</h1>
        <table>
            <colgroup>
                <col width="150px"><col>
            </colgroup>
            <tbody>
                <tr>
                    <th>제목</th>
                    <td>
                        <div class="input-wrap">
                            <input class="detail-input" name="tbTitle" type="text" placeholder="예) 충남대 도보 10분거리, 혼자 살기 좋은 방 양도합니다." v-model="this.title">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th>상세 설명</th>
                    <td>
                        <div class="input-wrap">
                            <textarea class="detail-text-area" name="tbContent" placeholder="양도 상세설명 작성" v-model="content"></textarea>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="agree-wrap">
        <label class="check-label">
            <input type="checkbox">
            <p>입력한 정보는 실제 매물과 다름이 없습니다.</p>
        </label>

        <div class="btn-wrap">
            <button class="cancel" @click="cancelBtn">취소</button>
            <button class="add" @click="registBtn">매물등록</button>
        </div>
    </div>
</div>
</template>

<script>
import { mapState, mapActions } from "vuex";

const regionStore = "regionStore";

export default {
  name: "TransferAddVue",

  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,

      //매물 종류
      roomType: null,
      contractType: null,
      roomAddress: null,
      roomFloor: null,
      contractEndDay: null,
      title: null,
      content: null,

    }
  },
  created: function(){

    //시도구군 정보 초기화
    this.clearInfo();

    //시도 정보 불러오기
    this.getSido();
  },
  computed: {
    ...mapState(regionStore,["sidos", "guguns", "dongs"])
  },
  methods: {
    ...mapActions(regionStore, ["getSido", "getGugun", "getDong", "clearInfo","clearGugun","clearDong"]),
    gugunList: async function (e) {
      console.log(e);
        this.clearGugun(); //기존에 있던 동 정보 삭제.
        this.gugunCode = null;
        if (this.sidoCode) await this.getGugun(this.sidoCode);
      },
    dongList: async function (e) {
      console.log(e);
        this.clearDong();
        this.dongCode = null;
        if (this.gugunCode) await this.getDong(this.gugunCode);

    },
    test: function () { 
      console.log("sidoCode check : " + this.sidoCode);
      console.log("gugunCode check : " + this.gugunCode);
      console.log("dongCode check : " + this.dongCode);
    },
    //취소버튼 - 취소시 메인으로 돌아감. 
    //TODO - 버튼 누를시 메인 또는 게시판(지도부분)부분으로 돌아가야됨.(아직 결정안됨.)
    cancelBtn: function () { 
      
    },
    registBtn: function () { 

    }


  }
};
</script>