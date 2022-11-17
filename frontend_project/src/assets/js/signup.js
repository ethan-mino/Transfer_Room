$(document).ready(() => {
    const inputs = $(".validate-input .input-wrap__input")

    $(".login-form__login-btn").on("click", (event) =>{
        event.preventDefault()

        const username = $("input[name = 'username']").val();
        const password = $("input[name = 'password']").val();
        const signUpInfo = {username, password}

        let check = true;
        for(var i = 0; i < inputs.length; i++) {
            if(validate(inputs[i]) === false){
                showValidate(inputs[i]);
                check=false;
            }
        }

        if(!check) return;

        fetch(`/user/signup?username=${username}&password=${password}`, {
            method: "post",
        })
            .then((response) => {
                if(response.ok){
                    window.location.replace("/loginPage");
                }else {
                    $(".login-form__fail-msg").text("이미 가입된 아이디입니다.");
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

    let showPass = 0;
    $('.btn-show-pass').on('click', function(){
        if(showPass == 0) {
            $(this).next('input').attr('type','text');
            $(this).find('i').removeClass('fa-eye');
            $(this).find('i').addClass('fa-eye-slash');
            showPass = 1;
        }
        else {
            $(this).next('input').attr('type','password');
            $(this).find('i').removeClass('fa-eye-slash');
            $(this).find('i').addClass('fa-eye');
            showPass = 0;
        }
    });
})