$(document).ready(() => {
    $(".authOn").on("mouseover", () =>{
        $(".css-1ieyvgb").css("visibility", "visible")
        $(".css-1ieyvgb").addClass("css-18412tx")
    })

    $(".authOn").on("mouseleave", () =>{
        $(".css-1ieyvgb").css("visibility", "hidden")
        $(".css-1ieyvgb").removeClass("css-18412tx")
    })

    $(".withdrawal_btn").on("click", (event) =>{
        event.preventDefault();

        Swal.fire({
            title: '회원 탈퇴',
            text: "정말 탈퇴하시겠습니까?",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '네',
            cancelButtonText : "아니오"
        }).then((result) => {
            if (result.isConfirmed) {

                fetch(`/user`, {
                    method: "delete",
                })
                .then((response) => {
                    location.reload();
                }).catch((error)=>{
                    console.log(error);
                })

            }
        })
    })

    $(".update_user_btn").on("click", async () =>{
        const loginUser = await fetch(`/user`)
            .then(async (response) => {
                return response.json();
            })

        const { value: updatedUserInfo } = await Swal.fire({
            title: '회원정보 수정',
            html:
                `<div class = "input-wrap">
                <label for = "swal-input1">비밀번호</label>
                <input id = "swal-input1" name = "password" type = "password" class="swal2-input" value = "${loginUser.password}" style="font-family : sans-serif; margin-left : 14px; width : 280px">
            </div>`,
            focusConfirm: false,
            preConfirm: () => {
                return {
                    password : $("input[name = 'password']").val(),
                }
            }
        })

        if (updatedUserInfo) {
            let password = updatedUserInfo["password"];
            fetch(`/user?password=${password}`, {
                method: "put",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
            })
                .then((response) => {
                    //location.href = "/"
                }).catch((error)=>{
                console.log(error);
            })
        }
    })

    $(".logout_btn").on("click", (e) =>{
        fetch(`/user/logout`)
            .then((response) => {
                location.reload();
            })
    })
})