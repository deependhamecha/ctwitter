function validateSignInForm() {

    var x = document.forms["signinForm"]["loginusername"].value;
    if (x == null || x == "") {
        alert("Enter Username");
        return false;
    }

    var x = document.forms["signinForm"]["loginpassword"].value;
    if (x == null || x == "") {
        alert("Enter Password");
        return false;
    }
}