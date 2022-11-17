$(document).ready(() => {
    const inputs = $(".validate-input .input-wrap__input")

    $(".login-form__login-btn").on("click", (event) =>{
        event.preventDefault();

        const username = $("input[name = 'username']").val();
        const password = $("input[name = 'password']").val();

        let check = true;
        for(var i = 0; i < inputs.length; i++) {
            if(validate(inputs[i]) === false){
                showValidate(inputs[i]);
                check=false;
            }
        }

        fetch(`/user/login?username=${username}&password=${password}`)
            .then((response) => {
                if(response.ok){
                    location.href = "/";
                }else{  //로그인 실패시
                    $(".login-form__fail-msg").text("아이디 또는 비밀번호를 확인해 주세요.");
                }
            })
    })

    function validate(input){
        if(!$(input).val().trim()){
            return false;
        }else{
            return true;
        }
    }

    $('.validate-form .input-wrap__input').each(function(){
        $(this).focus(function(){
            hideValidate(this);
        });
    });

    function showValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).removeClass('alert-validate');
    }
})