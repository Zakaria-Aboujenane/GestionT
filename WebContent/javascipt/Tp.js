/**
 * 
 */
// fonctions pour recuperer le tp par AJAX:
$(document).ready(recall(), search(),afficherTous());


function recall() {
	window.setInterval(afficherTous, 300000);
}
function afficherTous() {

	var CNE = $('#CNE').text();

	$.ajax({
		type : 'POST',
		url : '/GestionTp/gettpEt',
		data : {
			cne : CNE
		},
		success : function(data) {
			$('.divTp').html(data)
		}
	});
}
function search() {

	$('#search').keyup(function() {
		var searchString = $('#search').val();
		$.ajax({
			type : 'POST',
			url : '/GestionTp/search',
			data : {
				searchString : searchString
			},
			success : function(data) {
				$('.divTp').html(data)
			}
		});
	});
}
