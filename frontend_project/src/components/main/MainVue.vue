<template>
  <div>
    <div style="height: 70px"></div>
    <div class="content-container">
      <div class="contain">
        <div
          class="p-0 mb-5 bg-light justify-content-center rounded-3"
          style="display: flex; margin-top: 30px">
          <img
            src="https://cdn.pixabay.com/photo/2022/07/01/04/42/beach-house-7294928_960_720.png"
            alt=""
          />
        </div>

        <div class="row align-items-md-stretch">
          <div class="col-md-6" style="margin-bottom: 20px">
            <div class="h-100 p-5 bg-light border rounded-3">
              <h2>공지사항</h2>
              <ul>
                <li class="nav-item">
                  <a class="nav-link" href="news.do?arti_id=6"
                    ><i class="fa fa-won"></i> 가용자금 확인 및 대출 계획</a
                  >
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="news.do?arti_id=7"
                    ><i class="fa fa-home"></i> 집 종류 및 지역 선택</a
                  >
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="news.do?arti_id=8"
                    ><i class="fa fa-line-chart"></i>정보수집 & 시세파악</a
                  >
                </li>
              </ul>
            </div>
          </div>
          <div class="col-md-6 m-b-20" style="margin-bottom: 20px">
            <div class="h-100 p-5 bg-light border rounded-3">
              <h2>오늘의 뉴스</h2>
              <ul>
                <li class="nav-item">
                  <a
                    href="news.do?arti_id=5"
                    class="NPI=a:title,i:0004615690"
                    title="서울 아파트, 매매·전세 다른 양상…상승둔화vs상승확대"
                    >서울 아파트, 매매·전세 다른 양상…상승..</a
                  >
                </li>
              </ul>
            </div>
          </div>

          <div class="col-md-6 m-b-20" style="margin-bottom: 20px">
            <div class="h-100 p-5 bg-light border rounded-3">
              <h2>게시판</h2>
              <ul></ul>
            </div>
          </div>

          <div class="col-md-6 m-b-20" style="margin-bottom: 20px">
            <div class="h-100 p-5 bg-light border rounded-3">
              <h2>최근 아파트 매매 내역</h2>
              <ul></ul>
            </div>
          </div>

          <div class="col-md-6 m-b-20" style="margin-bottom: 20px">
            <div class="h-100 p-5 bg-light border rounded-3">
              <h2>관심지역 상가</h2>
              <ul></ul>
            </div>
          </div>
          <div class="col-md-6 m-b-20" style="margin-bottom: 20px">
            <div class="h-100 p-5 bg-light border rounded-3">
              <h2>관심지역 대기 오염</h2>
              <ul></ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "MainVue",
};
</script>

<style></style>
