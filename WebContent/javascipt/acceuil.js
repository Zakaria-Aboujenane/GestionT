//slider par slick :
$('.post-wraper').slick({
			centerMode : true,
			centerPadding : '20px',
			slidesToShow : 2,
			nextArrow : $('.prev'),
			prevArrow : $('.next'),
			responsive : [ {
				breakpoint : 768,
				settings : {
					arrows : false,
					centerMode : true,
					centerPadding : '40px',
					slidesToShow : 1
				}
			}, {
				breakpoint : 480,
				settings : {
					arrows : false,
					centerMode : true,
					centerPadding : '40px',
					slidesToShow : 1
				}
			} ]
		});