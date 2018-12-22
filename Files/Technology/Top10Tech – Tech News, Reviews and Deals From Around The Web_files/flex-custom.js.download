jQuery(window).load(function() {
    jQuery('.flexslider').flexslider({
        animation: "fade",
        direction: "horizontal",
        slideshowSpeed: 6000,
        animationSpeed: 600
    });
});

(function($) {
	$('div.arouse-slider-container').on( 'click', function(e) {
		if ( $(e.target).is('span.cat-links') ) { 
			return false;
		} else {
			window.location = $(this).data('loc');
		}
	});
})(jQuery);