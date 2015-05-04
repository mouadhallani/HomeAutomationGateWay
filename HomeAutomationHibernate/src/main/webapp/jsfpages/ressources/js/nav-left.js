$(document).ready(function(){
  $("#opened").on("click", function(e){
    e.preventDefault();
    var hrefval = $(this).attr("href");
    
    if(hrefval == "#about") {
      var distance = $('#mainpage').css('left');
      
      if(distance == "auto" || distance == "0px") {
        $(this).addClass("open");
        openSidepage();
      } else {
        closeSidepage();
      }
    }
  }); // end click event handler
  
  
  $("#closebtn").on("click", function(e){
    e.preventDefault();
    closeSidepage();
  }); // end close button event handler

  function openSidepage() {
    $('#mainpage').animate({
      left: '350px'
    }, 400, 'easeOutBack'); 
  }
  
  function closeSidepage(){
    $("#navigation li a").removeClass("open");
    $('#mainpage').animate({
      left: '0px'
    }, 400, 'easeOutQuint');  
  }
}); 