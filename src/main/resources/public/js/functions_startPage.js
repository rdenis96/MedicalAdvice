window.onload = function(ev){
    if("myUsername" in sessionStorage === true)
        window.location = "home/index";
    console.log(sessionStorage.getItem("myUsername"));
};

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

    var username=document.getElementById("username_signup").value;
    var password=document.getElementById("password_signup").value;
    var email= document.getElementById("email_signup").value;

    $.ajax({
        type: "POST",
        url: "registerValidation",
        data: {
            username: username,
            password: password,
            email: email
        },
        dataType: "json"
        }).done(function(result) {
            if(result == 1) {
                alert("Account  was successfuly created!");
                sessionStorage.setItem("myUsername", document.getElementById("username_login").value);
                window.location = "home/index";
            }
            else
                alert("Account already exists!");
        }).fail(function () {
            alert("Error!")
        });




}

function logIn(){

    var username=document.getElementById("username_login").value;
    var password=document.getElementById("password_login").value;

        $.ajax({
            type : "POST",
            url : "loginValidation",
            data: {
                username: username,
                password: password
            },
            dataType: "json"
            }).done(function(result) {
            if (result == 1) {
                alert("Logged was successful!");
                sessionStorage.setItem("myUsername", document.getElementById("username_login").value);
                window.location = "home/index";
            }
            else
                alert("Account does not exists or credentials are wrong!");
        }).fail(function () {
            alert("Error!")
        });

}
