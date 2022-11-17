let currentTypeId;
let markerInfos = [];

// 버튼이 클릭되면 호출되는 함수입니다
function setOverlayMapTypeId(maptype) {
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
    if (currentTypeId) {
        map.removeOverlayMapTypeId(currentTypeId);
    }

    // maptype에 해당하는 지도타입을 지도에 추가합니다
    map.addOverlayMapTypeId(changeMaptype);

    // 지도에 추가된 타입정보를 갱신합니다
    currentTypeId = changeMaptype;
}

$(".overlay_button").click((event) =>{
    const target = event.target;
    const overlayType = $(target).val()
    setOverlayMapTypeId(overlayType)
})


async function createMap(){
    const container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    const options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(36.3552, 127.2985), //지도의 중심좌표.
        level: 5 //지도의 레벨(확대, 축소 정도)
    };

    map = new kakao.maps.Map(container, options); //지도

    // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
    var mapTypeControl = new kakao.maps.MapTypeControl();

    // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
    // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
    map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

    // 지도 확대 축소를 제어할 수 있는 줌 컨트롤을 생성합니다
    var zoomControl = new kakao.maps.ZoomControl();
    map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
}

// * 맵에 마커를 찍어주는 함수
function createMarker(coordinate, overlayContent){
    const coords = new kakao.maps.LatLng(coordinate.x, coordinate.y);

    // 마커를 생성합니다
    const marker = new kakao.maps.Marker({
        map: map,
        position: coords,
        clickable : true
    });

    // 마커에 마우스오버 이벤트를 등록합니다
    var overlay = new kakao.maps.CustomOverlay({
        content: overlayContent,
        map: map,
        position: marker.getPosition()
    });

    // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        overlay.setMap(map);
    });

    // 커스텀 오버레이를 닫기 위해 호출되는 함수입니다
    $(overlayContent).on("click", ".info .close", (event) =>{
        overlay.setMap(null);
    })

    const markerInfo = {marker : marker, overlay : overlay};
    markerInfos.push(markerInfo);
    return markerInfo;
}

function removeAllMaker(){
    for(let i = 0; i < markerInfos.length; i++){
        markerInfos[i].marker.setMap(null)
        markerInfos[i].overlay.setMap(null)
    }
    markerInfos = [];
}

function moveToFirstMarker(){
    if(markerInfos.length > 0)
        map.panTo(markerInfos[0].marker.getPosition());
}