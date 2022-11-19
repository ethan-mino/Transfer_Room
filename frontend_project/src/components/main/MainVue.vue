<template>
  <div>
    <div class="content-container">
      <div class="contain">
        
        <div class = "background-input">
          <h2 id = "background-input__title">어떤 집으로 환승하시겠어요?</h2>

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
                  class="search btn btn-light">
                  검색
                </button>
              </div>
            </div>
          </div>
        </div>

        <section class = "board-section">
          <h5 class = "title">좋아요 많이 받은 양도 게시물</h5>  
          <div class = "cards">
            <div class="card">
              <img class="card-img-top" src="@/assets/img/temp.jpg" alt="Card image cap">
              <div class="card-body">
                <p class="card-text">서율툭별시 종로구 청운동</p>
                
                <h5 class="card-title">세종하우스 105호</h5>
                <p class="card-text">6층, 원룸, 월세 10만원, 관리비 5만원</p>
                <p class="card-text">2022.06.10까지 계약</p>
              </div>
            </div>
  
            <div class="card">
              <img class="card-img-top" src="@/assets/img/temp.jpg" alt="Card image cap">
              <div class="card-body">
                <p class="card-text">서율툭별시 종로구 청운동</p>
                
                <h5 class="card-title">세종하우스 105호</h5>
                <p class="card-text">6층, 원룸, 월세 10만원, 관리비 5만원</p>
                <p class="card-text">2022.06.10까지 계약</p>
              </div>
            </div>
          </div>
        </section> 

        <section class = "board-section">
          <h5 class = "title">최근 올라온 양도 게시물</h5>  
          <div class = "cards">
            <div class="card">
              <img class="card-img-top" src="@/assets/img/temp.jpg" alt="Card image cap">
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
export default {
  name: "MainVue",
};
</script>

<style>
@import "@/assets/css/home/home.css";
</style>
