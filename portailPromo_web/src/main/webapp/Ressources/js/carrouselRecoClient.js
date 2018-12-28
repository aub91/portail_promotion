document.getElementById("carousselRecoClient").onmouseover = function() {mouseOver()};
document.getElementById("carousselRecoClient").onmouseout = function() {mouseOut()};

function mouseOver() {
  document.getElementById("carousselRecoClient").className = "slidesOff";
}

function mouseOut() {
  document.getElementById("carousselRecoClient").className = "slides";
}