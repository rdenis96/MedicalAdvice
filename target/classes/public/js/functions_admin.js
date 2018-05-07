
var xMLHttpRequest_boli = new XMLHttpRequest(), xMLHttpRequest_simptome = new XMLHttpRequest();

xMLHttpRequest_boli.open("GET","getBoliList",true);
xMLHttpRequest_boli.onreadystatechange = loadBoli;
xMLHttpRequest_boli.send();

xMLHttpRequest_simptome.open("GET","getSimptomeList",true);
xMLHttpRequest_simptome.onreadystatechange = loadSimptome;
xMLHttpRequest_simptome.send();
//incarca toate bolile din baza de date
function loadBoli(){

    if(xMLHttpRequest_boli.readyState==4 && xMLHttpRequest_boli.status==200){
        var JSONList=eval('('+xMLHttpRequest_boli.responseText+')');
        var DDList = document.getElementById('lista_boli');
        DDList.innerHTML='';

        for (var i=0;i<JSONList.length;i++){

            var divBoala = document.createElement('div');
            var labBoala = document.createElement('label');

            labBoala.innerHTML = JSONList[i];

            divBoala.onclick = function(){ completeaza_boala(JSONList[i]) };
            divBoala.appendChild(labBoala);

            DDList.appendChild(divBoala);

        }
    }
}
//incarca toate simptomele din baza de date
function loadSimptome(){
    if(xMLHttpRequest_simptome.readyState==4 && xMLHttpRequest_simptome.status==200){
        var JSONList=eval('('+xMLHttpRequest_simptome.responseText+')');
        var DDList = document.getElementById('lista_simptome');
        DDList.innerHTML='';

        for (var i=0;i<JSONList.length;i++){

            var divSimptoma = document.createElement('div');
            var labSimptoma = document.createElement('label');

            labSimptoma.innerHTML = JSONList[i];

            divSimptoma.onclick = function(){ completeaza_simptoma(JSONList[i]) };
            divSimptoma.appendChild(labSimptoma);

            DDList.appendChild(divSimptoma);

        }
    }
}
//daca se da click pe o boala sugerata se completeaza automat cu numele ei
function completeaza_boala(text){

    document.getElementById("boala").value=text;

}
//daca se da click pe o simptoma sugerata se completeaza automat cu numele ei
function completeaza_simptoma(text){

    document.getElementById("simptoma").value=text;

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

//AM PUTEA IMPLEMENTA SI O FUNCTIE CARE ASCUNDE LISTELE CAND SE DA CLICK ORICUNDE ALTUNDEVA


function modificare(){
    //TRIMITE VARIABILELE IN JAVA UNDE SE VERIFICA DACA COMBINATIA EXISTA.
        //DACA DA, ATUNCI SE STERGE DIN BAZA DE DATE
        //DACA NU, ATUNCI SE ADAUGA
    var boala=document.getElementById("boala").value;
    var simptoma=document.getElementById("simptoma").value;

}


function logOut(){
    alert("logout");
}

function goHome(){
    window.location = "home/index";
}
