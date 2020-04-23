


// autre:
//ajax:

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
function zigzag() {
	if ($('input[name=choix]:checked').val() == 'etudiant') {
		$('.etud').show();
		$('.prof').hide();
		$('#cin').val("empty");
		$('#cne').val("");
	}
	if ($('input[name=choix]:checked').val() == 'professeur') {
		$('.etud').hide();
		$('.prof').show();
		$('#cne').val("emty");
		$('#cin').val("");
	}
}
function ajaxLogin() {
	console.log("good yes");
	$('.prof').hide();
	$('input[name=choix]').filter('[value=etudiant]').prop(
			'checked', true);
	$('#cin').val("empty");	
	
	$('#login').on(
			'submit',
			function(e) {
				e.preventDefault();
				e.stopPropagation();
				console.log("good yes");
				var cin = $('#cin').val();
				var mdp = $('#password').val();
				var cne = $('#cne').val();
				var choix = $('input[name=choix]:checked')
						.val();
				$.ajax({
							type : 'POST',
							url : '/GestionTp/login',
							data : "CIN=" + cin
									+ "&MotDePasse=" + mdp
									+ "&CNE=" + cne + "&choix="
									+ choix,
							success : function(data) {
								var x= 'etud0';
								var y='prof0';
								 	if( data.trim() == x.trim() ){
								 		var err = $('#erreur').text();
								 		err += "<br/>"+"etudiant non valid";
								 		$('#erreur').html("");
								 		$('#erreur').html(err);
								 	}else if(data == 'prof0'){
								 		var err = $('#erreur').val();
								 		err += "</br>"+"professeur non valid";
								 		$('#erreur').html("");
								 		$('#erreur').html(err);
								 	}
								 	else if(data){
								 		location.replace(data);
								 	}
							},
							error : function(e) {
								alert("error");
								return false;
							}
						});
			});
}
$(document).ready(
		ajaxLogin(),
		inStart()
		
);

function inStart() {
	console.log("good yes");
	$('.prof').hide();
	$('input[name=choix]').filter('[value=etudiant]').prop(
			'checked', true);
	$('#cin').val("empty");	
}

inputs.forEach(input =>{
    input.addEventListener('focus',focusFunc);
    input.addEventListener('blur',blurFunc);
});

document.getElementById("login").addEventListener("submit",function(e){
    var erreur;
    var inputs=document.getElementById("login").getElementsByTagName("input");
    for(var i=0;i<inputs.length ;i++){
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
//AJAX:


