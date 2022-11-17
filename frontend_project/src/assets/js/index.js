$(document).ready(() => {
    document.querySelector(".search").addEventListener("click", () => {
        const searchInput = getSearchInput();
        const sidoCode = searchInput.sido.code
        const gugunCode = searchInput.gugun.code
        const dongCode = searchInput.dong.code

        location.href = `/tradingPage?sidoCode=${sidoCode}&gugunCode=${gugunCode}&dongCode=${dongCode}`;
    })
})