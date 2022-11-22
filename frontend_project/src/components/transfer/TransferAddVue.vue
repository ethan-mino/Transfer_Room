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
                        <ul class="radio-list">
                            <li>
                                <label class="input-radio">
                                    <input type="radio" name="roomType">
                                    <p>투룸</p>
                                </label>
                            </li>

                            <li>
                                <label class="input-radio">
                                    <input type="radio" name="roomType">
                                    <p>쓰리룸</p>
                                </label>
                            </li>

                            <li>
                                <label class="input-radio">
                                    <input type="radio" name="roomType">
                                    <p>쓰리룸</p>
                                </label>
                            </li>

                            <li>
                                <label class="input-radio">
                                    <input type="radio" name="roomType">
                                    <p>아파트</p>
                                </label>
                            </li>

                            <li>
                                <label class="input-radio">
                                    <input type="radio" name="roomType">
                                    <p>오피스텔</p>
                                </label>
                            </li>
                        </ul>
                    </td>
                </tr>

                <tr>
                    <th>계약 종류</th>
                    <td>
                        <ul class="radio-list">
                            <li>
                                <label class="input-radio">
                                    <input type="radio" name="roomType">
                                    <p>월세</p>
                                </label>
                            </li>

                            <li>
                                <label class="input-radio">
                                    <input type="radio" name="roomType">
                                    <p>전세</p>
                                </label>
                            </li>
                        </ul>
                    </td>
                </tr>

                <tr>
                    <th>주소</th>
                    <td>
                        <div class="input-wrap">
                            <input type="text" class="detail-input" >
                        </div>
                    </td>
                </tr>

                <tr>
                    <th>층</th>
                    <td>
                        <div class="input-wrap">
                            <input type="number" class="detail-input" >
                        </div>
                    </td>
                </tr>

                <tr>
                    <th>계약 종료일</th>
                    <td>
                        <div class="input-wrap">
                            <input type="date" class="detail-input" >
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
                            <input class="detail-input" name="tbTitle" type="text" placeholder="예)충남대 도보 10분거리, 혼자 살기 좋은 방 양도합니다.">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th>상세 설명</th>
                    <td>
                        <div class="input-wrap">
                            <textarea class="detail-text-area styled__Memo-sc-17hggnx-2 SAaJi" name="tbContent" placeholder="양도 상세설명 작성"></textarea>
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
            <button class="cancel">취소</button>
            <button class="add">매물등록</button>
        </div>
    </div>
</div>
</template>

<script>
export default {
  name: "TransferAddVue",
};
</script>

<style>

.add-transfer header{
  margin: 80px 0px 64px;
  font-size: 46px;
  line-height: 70px;
  letter-spacing: -1px;
  font-weight: 700;
  height: 100%;
}

.add-transfer .content-container2{
  margin: -70px auto -80px auto !important;
}

.add-transfer .header-content{
  color: magenta !important;
  text-align: center;
}

.content-container2{
  width : 1000px;
  text-align: center;
  margin: auto;
}

.add-transfer .detail-contents > h1 {
  height: 60px;
  color: rgb(34, 34, 34);
  font-size: 18px;
  line-height: 60px;
  text-align: center;
  border-bottom: 1px solid rgb(204, 204, 204);
  position: relative;
  margin-bottom: 0px;
}

.add-transfer .detail-contents{
  width: 100%;
  margin-bottom: 50px;
  border-radius: 4px;
  box-shadow: rgb(0 0 0 / 5%) 0px 1px 5px 0px;
  border: 1px solid rgb(226, 226, 226);
  background-color: rgb(255, 255, 255);
}

.add-transfer .detail-contents > table th {
  min-width: 150px;
  color: rgb(34, 34, 34);
  font-size: 15px;
  font-weight: 500;
  background-color: rgb(249, 249, 249);
  vertical-align: middle;
}

.add-transfer .detail-contents > table{
  width: 100%;;
}

.add-transfer .detail-contents > table td{
  vertical-align: middle;
}

.add-transfer .detail-contents .detail-text-area{
  padding: 12px 16px;
  color: rgb(76, 76, 76);
  font-size: 14px;
  border: 1px solid rgb(223, 223, 223);
  border-radius: 2px;
  background-color: rgb(255, 255, 255);
  resize: none;
  width: 100%;
  height: 230px;
}

.add-transfer .detail-contents .detail-input{
  padding: 0px 16px;
  color: rgb(76, 76, 76);
  font-size: 14px;
  border: 1px solid rgb(223, 223, 223);
  border-radius: 2px;
  background-color: rgb(255, 255, 255);
  width: 100%;
  height: 46px;
}

.add-transfer .input-wrap{
  display: flex;
  -webkit-box-align: center;
  align-items: center;
  padding: 12px 20px;
  position: relative;
}

.add-transfer .input-radio {
  display: block;
  position: relative;
  cursor: pointer;
}

.add-transfer .input-radio input[type="radio"] {
  width: 0px;
  height: 0px;
  opacity: 0;
  position: absolute;
  top: 0px;
  left: 0px;
}

.add-transfer .radio-list{
  display: flex;
  -webkit-box-align: center;
  align-items: center;
  padding: 0px 20px;
}

.add-transfer .input-radio input[type="radio"]:checked + p {
  color: rgb(255, 255, 255);
  border-color: rgb(50, 108, 249);
  background-color: rgb(50, 108, 249);
}

.add-transfer .input-radio p{
  display: flex;
  -webkit-box-align: center;
  align-items: center;
  -webkit-box-pack: center;
  justify-content: center;
  min-width: 82px;
  height: 46px;
  padding: 0px 15px;
  color: rgb(102, 102, 102);
  font-size: 14px;
  border: 1px solid rgb(217, 217, 217);
  border-radius: 3px;
  background-color: rgb(255, 255, 255);
  user-select: none;
}

.add-transfer .radio-list > li + li {
  margin-left: 10px;
}

.add-transfer .agree-wrap{
  display: flex;
  flex-direction: column;
  -webkit-box-pack: center;
  justify-content: center;
  width: 100%;
  margin: 30px 0px 150px;
}

.add-transfer .check-label {
  display: flex;
  -webkit-box-align: center;
  align-items: center;
  -webkit-box-pack: center;
  justify-content: center;
  margin-left: 10px;
  cursor: pointer;
  user-select: none;
}

.add-transfer .check-label > input[type="checkbox"] {
  margin: 0px;
  border: 0px;
  border-radius: 0px;
  background: url("@/assets/img/check_off.svg") center center / cover no-repeat rgb(255, 255, 255);
  appearance: none;
  cursor: pointer;
  width: 22px;
  height: 22px;
}

.add-transfer .check-label > input[type="checkbox"]:checked {
  background-image: url("@/assets/img/check_on.svg") !important;
}

.add-transfer .check-label > p {
  margin-left: 8px;
  color: rgb(34, 34, 34);
  font-size: 16px;
}

.add-transfer .btn-wrap {
  margin-top: 30px;
  text-align: center;
}
.add-transfer .btn-wrap button.cancel {
  color: rgb(34, 34, 34);
  font-size: 15px;
  border: 1px solid rgb(204, 204, 204);
  background-color: rgb(255, 255, 255);
}

.add-transfer .btn-wrap button.add {
  color: rgb(255, 255, 255);
  font-size: 15px;
  border: 0px;
  background-color: rgb(26, 90, 232);
}

.add-transfer .btn-wrap button {
  width: 160px;
  height: 50px;
}
</style>
