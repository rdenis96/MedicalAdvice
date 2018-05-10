
window.onload = function(ev){
    if("myUsername" in sessionStorage === false)
        window.location.href = "/";
    console.log(sessionStorage.getItem("myUsername"));
};

var xMLHttpRequest_boala = new XMLHttpRequest(), xMLHttpRequest_simptoma = new XMLHttpRequest();

xMLHttpRequest_boala.open("GET","getDiseasesList",true);
xMLHttpRequest_boala.onreadystatechange = loadBoli;
xMLHttpRequest_boala.send();

xMLHttpRequest_simptoma.open("GET","getSimptomsList",true);
xMLHttpRequest_simptoma.onreadystatechange = loadSimptome;
xMLHttpRequest_simptoma.send();

//incarca toate bolile din baza de date
function loadBoli(){
    if(xMLHttpRequest_boala.readyState==4 && xMLHttpRequest_boala.status==200){

        var JSONList=eval('('+xMLHttpRequest_boala.responseText+')');
        var DDList = document.getElementById('lista_boli');
        DDList.innerHTML='';

        for (var i=0;i<JSONList.length;i++){

            var boala=JSONList[i];

            var divBoala = document.createElement('div');
            var labBoala = document.createElement('label');

            labBoala.innerHTML = boala;

            divBoala.setAttribute('onclick','completeaza_boala("'+boala+'")');
            divBoala.appendChild(labBoala);

            DDList.appendChild(divBoala);

        }

    }
}

//incarca toate simptomele din baza de date
function loadSimptome(){
    if(xMLHttpRequest_simptoma.readyState==4 && xMLHttpRequest_simptoma.status==200){
        var JSONList=eval('('+xMLHttpRequest_simptoma.responseText+')');
        var DDList = document.getElementById('lista_simptome');
        DDList.innerHTML='';

        for (var i=0;i<JSONList.length;i++){

            var simptoma=JSONList[i];

            var divSimptoma = document.createElement('div');
            var labSimptoma = document.createElement('label');

            labSimptoma.innerHTML = simptoma;

            divSimptoma.setAttribute('onclick','completeaza_simptoma("'+simptoma+'")');
            divSimptoma.appendChild(labSimptoma);

            DDList.appendChild(divSimptoma);

        }
    }
}

//daca se da click pe o boala sugerata se completeaza automat cu numele ei
function completeaza_boala(text){

    document.getElementById("boala").value=text;
    document.getElementById("lista_boli").setAttribute('style', 'display: none');

}

//daca se da click pe o simptoma sugerata se completeaza automat cu numele ei
function completeaza_simptoma(text){

    document.getElementById("simptoma").value=text;
    document.getElementById("lista_simptome").setAttribute('style', 'display: none');

}

//cauta boala in lista
function cauta_boala(){

    var cuvant_cautat=document.getElementById('boala').value.toLowerCase();
    var vector_elem_lista=document.getElementById('lista_boli').children;

    if(cuvant_cautat===null || cuvant_cautat==="")
        for(var i=0;i<vector_elem_lista.length;i++)
            vector_elem_lista[i].style.display="block";
    else
        for(var i=0;i<vector_elem_lista.length;i++) {
            if (vector_elem_lista[i].children[0].textContent.toLowerCase().indexOf(cuvant_cautat) === -1)
                vector_elem_lista[i].style.display = "none";
        }

}

//cauta simptoma in lista
function cauta_simptoma(){

    var cuvant_cautat=document.getElementById('simptoma').value.toLowerCase();
    var vector_elem_lista=document.getElementById('lista_simptome').children;

    if(cuvant_cautat===null || cuvant_cautat==="")
        for(var i=0;i<vector_elem_lista.length;i++)
            vector_elem_lista[i].style.display="block";
    else
        for(var i=0;i<vector_elem_lista.length;i++) {
            if (vector_elem_lista[i].children[0].textContent.toLowerCase().indexOf(cuvant_cautat) === -1)
                vector_elem_lista[i].style.display = "none";
        }

}

//afiseaza lista de boli cand se da click pe input
function afiseaza_ddlb(){

    document.getElementById("lista_boli").setAttribute('style', 'display: inline-block');
    document.getElementById("lista_simptome").setAttribute('style', 'display: none');

}

//afiseaza lista de simptome cand se da click pe input
function afiseaza_ddls(){

    document.getElementById("lista_simptome").setAttribute('style', 'display: inline-block');
    document.getElementById("lista_boli").setAttribute('style', 'display: none');

}


function modificare(){
    //TRIMITE VARIABILELE IN JAVA UNDE SE VERIFICA DACA COMBINATIA EXISTA.
    //DACA DA, ATUNCI SE STERGE DIN BAZA DE DATE
    //DACA NU, ATUNCI SE ADAUGA
    var boala=document.getElementById("boala").value;
    var simptoma=document.getElementById("simptoma").value;

}


function logOut(){
    sessionStorage.removeItem("myUsername");
    window.location.href = "/";
}

function goHome(){
    window.location = "../home/index";
}
