function validateSignInForm() {

    var x = document.forms["signinForm"]["emailaddr"].value;
    if (x == null || x == "") {
        alert("Enter Username");
        return false;
    }

    var x = document.forms["signinForm"]["password"].value;
    if (x == null || x == "") {
        alert("Enter Password");
        return false;
    }
}