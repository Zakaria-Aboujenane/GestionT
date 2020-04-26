const inputs=document.querySelectorAll('.input');

function focusFunc(){
    let parent =this.parentNode.parentNode;
    parent.classList.add('focus');
}

function blurFunc(){
    let parent =this.parentNode.parentNode;
    if(this.value == ""){
        parent.classList.remove('focus');
    }
    
}

inputs.forEach(input =>{
    input.addEventListener('focus',focusFunc);
    input.addEventListener('blur',blurFunc);
});

document.getElementById("passwordconfirmer").addEventListener("input",function(){
    if( this.value!=document.getElementById("password").value){
        document.getElementById("erreur").innerHTML="les deux mot de passe  ne correspondent pas";
    } else {
        document.getElementById("erreur").innerHTML="";
    }
});


document.getElementById("inscription").addEventListener("submit",function(e){
    var erreur;
    var inputs=document.getElementById("inscription").getElementsByTagName("input");
    for(var i=0;i<7;i++){
        if(!inputs[i].value){
            erreur="Vieullez renseigner tous les champ";
        }
    }
    if(erreur){
        e.preventDefault();
        document.getElementById("erreur").innerHTML=erreur;
        return false;
    } else {
        alert('formulaire envoyé!!');
    }
});
