
window.onload = function(ev){
    if("myUsername" in sessionStorage === false)
        window.location.href = "/";
    console.log(sessionStorage.getItem("myUsername"));

    var username=sessionStorage.getItem("myUsername");

    $.ajax({
        type: "POST",
        url: "checkAdmin",
        data: {
            username: username
        },
        dataType: "json"
    }).done(function(result) {
        if(result==2){

            var btn = document.createElement('button');

            btn.innerHTML="Admin panel";
            btn.setAttribute('onclick','to_admin()');
            btn.setAttribute('id', 'btnAdmin');

            document.getElementById('holder').appendChild(btn);

        }
    }).fail(function () {
        alert("Error!")
    });

};

function to_admin(){
    window.location = "../admin/panel";
}

var xMLHttpRequest = new XMLHttpRequest();

xMLHttpRequest.open("GET","getSymptomsList",true);
xMLHttpRequest.onreadystatechange = loadData;
xMLHttpRequest.send();

var count;
var timer;

var array_check=[];


function fct(){

    var butoane_bifate=document.querySelectorAll('input[type="checkbox"]:checked');

    for (var i=0;i<butoane_bifate.length;i++)
        array_check.push(butoane_bifate[i].value);

}

function timerupdate() {
    count = 6;
    timer = setInterval(function () {
        document.getElementById("countdown").innerText = count;
        count--;
        if (count < 0) {
            clearInterval(timer);

            fct(); //ia alea bifate

            //pornesc diplay-ul pt grafic si rezultat
            document.getElementById("instructiuni").setAttribute('style', 'display: none');
            document.getElementById("result").setAttribute('style', 'display: inline-block');

            //ml alg
            var testModel = id3(examples,'disease',array_check);

            //afis graf
            drawGraph(testModel,'canvas');

            //fct care ret checkboxes
            document.getElementById("countdown").innerText = "/";
            $.ajax({
                type: "POST",
                url: "/selectedCheckboxes",
                data: {
                    selCheck : array_check
                }
            });
        }
    }, 1000);
}


function afiseaza_lista(){

    var lista=document.getElementById('lista_dd');
    if(lista.style.getPropertyValue('display')==='none')
        lista.setAttribute('style', 'display: inline-block');
    else
        lista.setAttribute('style', 'display: none');

}

function cauta(){

    var cuvant_cautat=document.getElementById('cautare_simptoma').value.toLowerCase();
    var vector_elem_lista=document.getElementById('elemente_lista').children;

    if(cuvant_cautat===null || cuvant_cautat==="")
        for(var i=0;i<vector_elem_lista.length;i++)
            vector_elem_lista[i].style.display="block";
    else
        for(var i=0;i<vector_elem_lista.length;i++) {
            if (vector_elem_lista[i].children[1].textContent.toLowerCase().indexOf(cuvant_cautat) === -1)
                vector_elem_lista[i].style.display = "none";
        }
}

function aduna() {

    var butoane_bifate=document.querySelectorAll('input[type="checkbox"]:checked').length;
    document.getElementById('nr_simptome').innerHTML=butoane_bifate;

    clearInterval(timer);
    timerupdate();

}


function loadData() {

    if(xMLHttpRequest.readyState==4 && xMLHttpRequest.status==200){
        var JSONList=eval('('+xMLHttpRequest.responseText+')');
        var DDList = document.getElementById('elemente_lista');
        DDList.innerHTML='';

        for (var i=0;i<JSONList.length;i++){

            var symptom = JSONList[i];

            var divSimpt = document.createElement('div');
            var inpSimpt = document.createElement('input');
            var labSimpt = document.createElement('label');

            inpSimpt.setAttribute('type','checkbox');
            inpSimpt.setAttribute('onchange','aduna()');
            inpSimpt.setAttribute('value',symptom);
            inpSimpt.setAttribute('name',"chackbox_name");

            labSimpt.innerHTML = symptom;

            divSimpt.appendChild(inpSimpt);
            divSimpt.appendChild(labSimpt);

            DDList.appendChild(divSimpt);

        }

    }

}


function logOut(){
    sessionStorage.removeItem("myUsername");
    window.location.href = "/";
}

function to_account(){
    window.location = "../user/history";
}
