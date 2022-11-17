
$(document).ready(async () =>{
    init();

    async function init(){
        createMap();

        // url에서 파라미터를 꺼내옴
        const params = new Proxy(new URLSearchParams(window.location.search), {
            get: (searchParams, prop) => searchParams.get(prop),
        });

        // query 파라미터에서 dongCode를 가져옴
        const dongCode = params["dongCode"]

        // dongCode가 query 파라미터에 존재한다면
        if(dongCode){
            await getHouseInfoByDongCode(dongCode);
        }

        await getInterestingArea();
    }

    async function getHouseInfoByDongCode(dongCode){
        const houseList = await requestHouseInfoByDongCode(dongCode);
        displayHomeList(houseList);
    }

    // dongCode로 집 정보를 가져오는 함수
    function requestHouseInfoByDongCode(dongCode){
        return new Promise((resolve, reject) => {
            $.ajax({
                type : "GET",
                url : `/house?dongCode=${dongCode}`,
                success : function (res){
                    resolve(res)
                },
                error : function (){
                    reject()
                }
            })
        })
    }

    // aptCode로 아파트 매매 정보를 가져오는 함수
    function requestHouseDealByAptCode(aptCode){
        return new Promise((resolve, reject) => {
            $.ajax({
                type : "GET",
                url : `/house/deal?aptCode=${aptCode}`,
                success : function (response){
                    resolve(response)
                },
                error : function (){
                    reject()
                }
            })
        })
    }

    $("#add-interesting-btn").on("click", async (event) => {
        const searchInput = getSearchInput();
        const dongCode = searchInput.dong.code;

        await createInterestingArea(dongCode);
        await getInterestingArea();
    });

    document.querySelector("#list-btn").addEventListener("click", async function () {
        const searchInput = getSearchInput()
        const dongCode = searchInput.dong.code
        const houseList = await requestHouseInfoByDongCode(dongCode);
        displayHomeList(houseList);
    });

    $(document).on("click", ".interesting-area", (event) => {
        const target = event.target;
        if(!$(target).hasClass("close")){
            const $interestingArea = $(target).closest(".interesting-area")
            const dongCode = $interestingArea.find(".interesting-content .dongCode").val();

            getHouseInfoByDongCode(dongCode);
        }
    })

    $(document).on("click", ".interesting-area", async (event) => {
        const target = event.target;
        if($(target).hasClass("close")){
            const $interestingArea = $(target).closest(".interesting-area")
            const interestingAreaId = $interestingArea.find(".id").val();

            await deleteInterestingArea(interestingAreaId)
            await getInterestingArea();
        }
    })

    // 주소를 좌표로 변환하여 반환하는 함수
    function addressToCoordinate(address){
        const restApiKey = "KakaoAK c87e4cd89b45fefccbcad126e1cf38a5";
        const apiUrl = `https://dapi.kakao.com/v2/local/search/address.json?size=1&query=${address}`
        return new Promise((resolve, reject) =>{
            $.ajax({
                type : "GET",
                url : apiUrl,
                headers : {
                    "Content-type" : "application/json",
                    "Authorization" : restApiKey
                },
                success: (response) =>{
                    resolve(JSON.parse(response))
                },
                error : (a, b, c) =>{
                    reject()
                }
            })
        })
    }

    function displayHomeList(homeList){
        initList()
        removeAllMaker()

        homeList.forEach((homeData) => {
            const $content = $(`<div class = "trading_info_window">
            <div class = "wrap">
                <div class = "info">
                    <div class = "title">
                        ${homeData.apartmentName}
                        <div class="close" title="닫기"></div>
                    </div>
                    <div class = "body">
                    <div class="img">
                        <img src="resources/img/apartment.jpg" width="73" height="70">
                    </div>
                    <div class="desc">
                        <input type="hidden" class = "aptCode" value = ${homeData.aptCode}>
                        <input type="hidden" class = "dongCode" value = ${homeData.dongCode}>
                        <input type="hidden" class = "lng" value = ${homeData.lng}>
                        <input type="hidden" class = "lat" value = ${homeData.lat}>
                        <span class = "dong">동 : ${homeData.dong}</br></span>   
                        <span class = "roadName">도로명 : ${homeData.roadName}</br></span>
                        <span class = "jibun">지번 : ${homeData.jibun}</br></span>
                        <span class = "buildYear">건설년도 : ${homeData.buildYear}</br></span>
                    </div>
                </div>
                </div>
            </div>`)[0]
            const coordinate = {x : homeData.lat, y : homeData.lng};
            const markerInfo = createMarker(coordinate, $content)

            kakao.maps.event.addListener(markerInfo.marker, 'click', async function() {
                // 마커 위에 인포윈도우를 표시합니다
                const dealDataList = await requestHouseDealByAptCode(homeData.aptCode)
                displayTradingData(dealDataList)
            });
        })

        moveToFirstMarker()
    }

    //* 매매 data를 화면에 뿌려주는 함수
    async function displayTradingData(data){
        initList()
        const $tradingDataList = $(".trading-data-list");

        data.forEach((tradingData) => {
            const $tradingData = $(`<div class = "trading_data">
            <input type="hidden" id = "dealNo" value = "${tradingData.aptCode}">
            <input type="hidden" id = "aptCode" value = "${tradingData.aptCode}">
            <span class = "floor">${tradingData.floor}층</br></span>
            <span class = "area">전용 면적 : ${tradingData.area}</br></span>
            <span class = "trading_price">거래 금액 : ${tradingData.dealAmount} 만원</br></span>
            <span class = "trading_date">${tradingData.dealYear}.${tradingData.dealMonth}.${tradingData.dealDay}</br></span>
        </div>`)

            $tradingDataList.append($tradingData);
        });
    }

//* 매매 data를 초기화하는 함수
    function initList(){
        const $tradingList = $(".trading-data-list");
        $tradingList.empty();
    }
})