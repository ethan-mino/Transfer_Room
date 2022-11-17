function requestAllInterestingArea(){
    return new Promise(((resolve, reject) => {
        $.ajax({
            type : "GET",
            url : "/user/interesting-area",
            success : (response) => {
                return resolve(response);
            },
            error : (error) => {
                return reject(error);
            }
        })
    }))
}

function displayInterestingArea($displayElem, dataList){
    $displayElem.empty();

    if(dataList.length > 0){
        $displayElem.css("display", "block");
        dataList.forEach((data) => {
            const createDate = new Date(data.createDate).format("yyyy년 MM월 dd일 a/p hh시 mm분");
            const $content = $(`
            <div class = "interesting-area">
                <div class = "interesting-content">
                    <input class = "dongCode" type="hidden" value="${data.dongCode}"/>
                    <input class = "id" type="hidden" value="${data.id}"/>
                    <span class = "region">관심지역 : ${data.sidoName} ${data.gugunName} ${data.dongName}</span> </br>
                    <span class = "interesting-create-date">생성일 : ${createDate}</span>   
                </div>
                <div class ="close"></div>
            </div>`)

            $displayElem.append($content)
        })
    }else{
        $displayElem.css("display", "none");
    }
}

async function getInterestingArea(){
    const interestingAreaList = await requestAllInterestingArea();
    const $interestingAreaList = $("#interesting-area-list");
    displayInterestingArea($interestingAreaList, interestingAreaList)
}

function createInterestingArea(dongCode){
    const data = {"dongCode" : dongCode}

    return new Promise(((resolve, reject) => {
        $.ajax({
            type : "POST",
            url : `/user/interesting-area?dongCode=${dongCode}`,
            contentType : "application/json",
            data : JSON.stringify(data),
            success : (response) => {
                return resolve(response);
            },
            error : (error) => {
                return reject(error);
            }
        })
    }))
}

function deleteInterestingArea(interestingAreaId){
    return new Promise(((resolve, reject) => {
        $.ajax({
            type : "DELETE",
            url : `/user/interesting-area/${interestingAreaId}`,
            success : (response) => {
                return resolve(response);
            },
            error : (error) => {
                return reject(error);
            }
        })
    }))
}