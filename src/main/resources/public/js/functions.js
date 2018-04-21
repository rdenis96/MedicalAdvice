
function afiseaza_lista(){

    var buton=document.getElementById('buton_dd');
    if(buton.style.getPropertyValue('border-bottom')==='medium none white')
        buton.setAttribute('style', 'border-bottom: solid black');
    else
        buton.setAttribute('style', 'border-bottom: white');

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

}


var xMLHttpRequest = new XMLHttpRequest();

function LoadDD(){

    document.getElementById('activare_search').setAttribute('style', 'display: none');

    xMLHttpRequest.open("GET","getSymptomsList",true);
    xMLHttpRequest.onreadystatechange = loadData;
    xMLHttpRequest.send();

}

function loadData() {

    if(xMLHttpRequest.readyState==4 && xMLHttpRequest.status==200){
        var JSONList=eval('('+xMLHttpRequest.responseText+')');
        //alert(JSONList);
        var DDList = document.getElementById('elemente_lista');
        DDList.innerHTML='';

        for (var i=0;i<JSONList.length;i++){

            var divSimpt = document.createElement('div');
            var inpSimpt = document.createElement('input');
            var labSimpt = document.createElement('label');

            inpSimpt.setAttribute('type','checkbox');
            inpSimpt.setAttribute('onchange','aduna()');
            inpSimpt.setAttribute('id',JSONList[i].name);

            labSimpt.innerHTML = JSONList[i].name;

            divSimpt.appendChild(inpSimpt);
            divSimpt.appendChild(labSimpt);

            DDList.appendChild(divSimpt);

        }

    }

}

