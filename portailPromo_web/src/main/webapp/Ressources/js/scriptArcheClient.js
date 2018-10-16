function comboInit(thelist) {
    theinput = document.getElementById(theinput);
    var idx = thelist.selectedIndex;
    var content = thelist.options[idx].innerHTML;
    if (theinput.value == "")
        theinput.value = content;
}

function combo(thelist, theinput) {
    theinput = document.getElementById(theinput);
    var idx = thelist.selectedIndex;
    var content = thelist.options[idx].innerHTML;
    theinput.value = content;
}

function myFunction() {
    var x = document.getElementById("myBottomnav");
    if (x.className === "bottomnav") {
        x.className += " responsive";
    } else {
        x.className = "bottomnav";
    }
}