$(document).ready(async () => {
    init();

    async function init(){
        // 브라우저가 열리면 시도정보 얻기.
        const sidoData = await requestRegion("/region/sido");
        addSidoOption(sidoData);
    }

    $("#sido").on("change", async function () {
        const $gugunSelect = $("gugun");
        if (this[this.selectedIndex].value) {
            const sidoCode = this[this.selectedIndex].value;
            const gugunData = await requestRegion(`/region/gugun?sidoCode=${sidoCode}`);
            addGugunOption(gugunData);
        } else {
            $gugunSelect.empty();
        }
    });

    $("#gugun").on("change", async function(){
        const $dongSelect = $("dong");
        if (this[this.selectedIndex].value) {
            const gugunCode = this[this.selectedIndex].value;
            const dongData = await requestRegion(`/region/dong?gugunCode=${gugunCode}`);
            addDongOption(dongData);
        } else {
            $dongSelect.empty();
        }
    })
}) ;

function getSearchInput(){
    const $sidoSel = document.querySelector("#sido option:checked");
    const $gugunSel = document.querySelector("#gugun option:checked");
    const $dongSel = document.querySelector("#dong option:checked");
    return {
        sido : {
            text : $sidoSel.text,
            code : $sidoSel.value
        },
        gugun : {
            text : $gugunSel.text,
            code : $gugunSel.value
        },
        dong : {
            text : $dongSel.text,
            code : $dongSel.value
        }
    }
}

function addSidoOption(data){
    const $sidoSelect = $("#sido");
    $sidoSelect.empty();
    $sidoSelect.append(`<option value="">시도선택</option>`)

    data.forEach((regionData) => {
        const $sidoOption = $(`<option value="${regionData.dongCode}">${regionData.sidoName}</option>`)
        $sidoSelect.append($sidoOption)
    })
}

function addGugunOption(data){
    const $gugunSelect = $("#gugun");
    $gugunSelect.empty();
    $gugunSelect.append(`<option value="">구군선택</option>`)

    data.forEach((regionData) => {
        const $gugunOption = $(`<option value="${regionData.dongCode}">${regionData.gugunName}</option>`)
        $gugunSelect.append($gugunOption)
    })
}

function addDongOption(data){
    const $dongSelect = $("#dong");
    $dongSelect.empty();
    $dongSelect.append(`<option value="">동선택</option>`)

    data.forEach((regionData) => {
        const $dongOption = $(`<option value="${regionData.dongCode}">${regionData.dongName}</option>`)
        $dongSelect.append($dongOption)
    })
}

function requestRegion(url){
    return new Promise((resolve, reject) => {
        $.ajax({
            type : "GET",
            url : url,
            success : (response) => {
                return resolve(response)
            },
            error : () => {
                return reject();
            }
        })
    })
}