
window.onload = function(ev){
    if("myUsername" in sessionStorage === false)
        window.location.href = "/";
    console.log(sessionStorage.getItem("myUsername"));
};

var xMLHttpRequest = new XMLHttpRequest();

xMLHttpRequest.open("GET","getHistoryList",true);
xMLHttpRequest.onreadystatechange = loadHistory;
xMLHttpRequest.send();

function loadHistory(){

    //implicand faptul ca am o sursa de date

    if(xMLHttpRequest.readyState==4 && xMLHttpRequest.status==200){

        var row = table.insertRow(0);

        var JSONList=eval('('+xMLHttpRequest.responseText+')');
        var table = document.getElementById("tabel");

        for (var i=0;i<JSONList.length;i++){


            var data_i = row.insertCell(0);
            var simptome_i = row.insertCell(1);
            var boli_i = row.insertCell(2);

            data_i.setAttribute('class','data');
            data_i.innerHTML=JSONList[i].date;

            simptome_i.setAttribute('class','simptome');
            simptome_i.innerHTML=JSONList[i].symptoms;

            boli_i.setAttribute('class','boli');
            boli_i.innerHTML=JSONList[i].diseases;

        }

    }

}


function logOut(){

    alert("Logged out!");
    sessionStorage.removeItem("myUsername");
    window.location.href = "/";
}

function goHome(){
    window.location = "../home/index";
}
