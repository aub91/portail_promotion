/*function rendreDisable(elem){
	elem.disabled = 'disabled';
	document.button.style.backgroundColor = "red";
	 $(this).css('background', '#aaa')
}*/



/*function chBackcolor(color) {
	   document.getElementsByClassName("btnRecup").style.background = red;
	} */

$(".btnRecup").on("click", function(element){
	console.log("rout");
	var element = $(this);
	element.css("background-color", "lightgrey");
});

