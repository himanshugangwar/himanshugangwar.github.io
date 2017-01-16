"use strict";


//Responsive Navegation

$(document).ready(function(){
    
    "use strict";
    
    if($(window).outerWidth() <= 768 ){
        $('.cl-main-nav').slideUp('slow');
    }
    
    $('#mobile-holder').click(function(){
        $('.cl-main-nav').slideToggle('slow');
    });
    
    if($(window).outerWidth() < 768 ){
        $('.main-nav li a').click(function(){
            $('.cl-main-nav').slideToggle('slow');
        });
    }
    
    $('.cl-main-nav ul li').hover(function(){
        $(this).children.slideToggle('slow');
    });
});

$(window).resize(function(){
    
    "use strict";
    
    if($(window).outerWidth() < 768 ){
        $('.cl-main-nav').slideUp('slow');        
    } else if ($(window).outerWidth() > 768){
        $('.cl-main-nav').slideDown('slow');
    }
});



//Carousels
$(document).ready(function() {
   
  $('.cl-client-carousel').owlCarousel({
      pagination:true,
      slideSpeed : 300,
      paginationSpeed : 400,
      singleItem:true,
  }); 
  
  $('.cl-logo-carousel').owlCarousel({
	  items : 6,
      itemsDesktop : [1199,5],
      itemsDesktopSmall : [979,3],
      stopOnHover:true
  });

});


// Sticky Header
$(document).ready(function(){
    
    $(".cl-main-head").sticky({topSpacing:0});
    
    // Eliminates sticky inline style
    $('.sticky-wrapper').removeAttr('style');
    
    //Scroll reveal
    window.scrollReveal = new scrollReveal();
    
    //Smooth Scroll
    $(function(){
      $.scrollIt({
          upKey: 38,             // key code to navigate to the next section
          downKey: 40,           // key code to navigate to the previous section
          easing: 'linear',      // the easing function for animation
          scrollTime: 1000,       // how long (in ms) the animation takes
          activeClass: 'active', // class given to the active nav element
          onPageChange: null,    // function(pageIndex) that is called when page is changed
          topOffset: -30           // offste (in px) for fixed top navigation
        });
    });
    
});


/* Filtering Elements */
$(document).ready(function() {
    
    $('.filters li').click(function() {
        $('.filters li.active').removeClass('active');
        $(this).addClass('active');
         
        var filterVal = $(this).data('filter');
             
        if(filterVal == 'all') {
            $('.portfolio-items .hidden').fadeIn('slow').removeClass('hidden');
        } else {
            $('.portfolio-items .col-sm-4').each(function() {
                if($(this).data('filter') !== filterVal) {
                    $(this).fadeOut('slow',function(){
                        $(this).addClass('hidden');
                    });
                    
                } else {
                    $(this).fadeIn('slow').removeClass('hidden');
                }
            });
        }
         
        return false;
    });
    
    
});
