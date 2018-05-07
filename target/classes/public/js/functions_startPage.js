
function redirectLogin(){
    window.location = "home/index";
    var name = "MyName is";
    $.ajax({
        type: "POST",
        url: "loginValidation",
        data: {
            "myName": name
        }
    });
}


function activate_signUp(){
    document.getElementById("signup_input").setAttribute('style', 'display: inline-block');
    document.getElementById("login_input").setAttribute('style', 'display: none');
    document.getElementById("introducere").setAttribute('style', 'display: none');
}

function activate_logIn(){
    document.getElementById("signup_input").setAttribute('style', 'display: none');
    document.getElementById("login_input").setAttribute('style', 'display: inline-block');
    document.getElementById("introducere").setAttribute('style', 'display: none');
}


function signUp(){
    $.ajax({
        type: "POST",
        url: "validareSignup",
        data: {
            "username": document.getElementById("username_signup").value,
            "password": document.getElementById("password_signup").value,
            "email": document.getElementById("email_signup").value
        }
    });
}

function logIn(){

    //windows.location="home";

    $.ajax({
        type: "POST",
        url: "validateLogin",
        data: {
            "username": document.getElementById("username_signup").value,
            "password": document.getElementById("password_signup").value
        }
    });
}
