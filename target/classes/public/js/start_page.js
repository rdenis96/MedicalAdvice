function redirectLogin()
{
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