function validateSignUpForm() {
    var x = document.forms["signupForm"]["firstname"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }

    var x = document.forms["signupForm"]["lastname"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }

    var x = document.forms["signupForm"]["designation"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }

    var x = document.forms["signupForm"]["emailaddr"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }

    var x = document.forms["signupForm"]["password"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }

    var x = document.forms["signupForm"]["cpassword"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }

    var x = document.forms["signupForm"]["password"].value;
    var y = document.forms["signupForm"]["cpassword"].value;
    if (x != y) {
        alert("Password do not match");
        return false;
    }
}