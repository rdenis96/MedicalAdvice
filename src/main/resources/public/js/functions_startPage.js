
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


//APELUL METODELOR ASTORA SUPRASCRIU ATRIBUTELE "REQUIERD" DE LA INPUT SI NU MAI AU LOC VALIDARILE
function signUp(){

    $.ajax({
        type: "POST",
        url: "registerValidation",
        data: {
            "username": document.getElementById("username_signup").value,
            "password": document.getElementById("password_signup").value,
            "email": document.getElementById("email_signup").value
        },
        contentType: "application/json; charset=utf-8",
        dataType : "json",
        async: true,
        success : function(result) {
            alert("Logged was successful!");
            localStorage.setItem("myUsername",document.getElementById("username_login").value)
            alert(localStorage.getItem("myUsername"));

        }
    });

    window.location = "home/index";

}

function logIn(){

    var t=document.getElementById("username_login").value;
    alert(t);

    if (t.value === '' || t.value === t.defaultValue) {

        $.ajax({
            type : "POST",
            url : "loginValidation",
            data: {
                "username": document.getElementById("username_login").value,
                "password": document.getElementById("password_login").value
            },
            contentType: "application/json; charset=utf-8",
            dataType : "json",
            async: true,
            success : function(result) {
                alert("Logged was successful!");
                localStorage.setItem("myUsername",document.getElementById("username_login").value)
                alert(localStorage.getItem("myUsername"));
                window.location = "home/index";
            },
            error : function (result) {
                alert("Account does not exist or credentials are wrong!")
            }
        });
    }
    //window.location = "home/index";

}
