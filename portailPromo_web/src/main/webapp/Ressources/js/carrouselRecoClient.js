document.getElementById("carousselRecoClientSlides").onmouseover = function() {mouseOver()};
document.getElementById("carousselRecoClientSlides").onmouseout = function() {mouseOut()};
document.getElementById("leftArrow").onmouseover = function() {arrowLeft()};
document.getElementById("rightArrow").onmouseover = function() {arrowRight()};


function mouseOver() {
  document.getElementById("carousselRecoClientSlides").className = "slidesOff w3-col s10 l10";
}

function mouseOut() {
  document.getElementById("carousselRecoClientSlides").className = "slidesRight w3-col s10 l10";
}

function arrowRight(event) {
  event.stopPropagation();
  document.getElementById("carousselRecoClientSlides").className = "slidesRight w3-col s10 l10";
  document.getElementById("carousselRecoClientSlides").className = "FichePromotion slideRight w3-mobile w3-row w3-col s1 l1 ";
}

function arrowLeft(event) {
  event.stopPropagation();
  document.getElementById("carousselRecoClientSlides").className = "slidesLeft w3-col s10 l10";
  document.getElementById("carousselRecoClientSlides").className = "FichePromotion slideLeft w3-mobile w3-row w3-col s1 l1 ";
}

