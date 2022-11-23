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
                                    <input type="radio" name="contractType">
                                    <p>월세</p>
                                </label>
                            </li>

                            <li>
                                <label class="input-radio">
                                    <input type="radio" name="contractType">
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
                            <input type="text" name="roomAddress" class="detail-input" >
                        </div>
                    </td>
                </tr>

                <tr>
                    <th>층</th>
                    <td>
                        <div class="input-wrap">
                            <input type="number" name="roomFloor" class="detail-input" >
                        </div>
                    </td>
                </tr>

                <tr>
                    <th>계약 종료일</th>
                    <td>
                        <div class="input-wrap">
                            <input type="date" name="contractEndTime" class="detail-input" >
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
                            <textarea class="detail-text-area" name="tbContent" placeholder="양도 상세설명 작성"></textarea>
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