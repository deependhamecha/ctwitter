function validateSignUpForm() {
    var x = document.forms["signupForm"]["name"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }
    

    var x = document.forms["signupForm"]["status"].value;
    if (x == null || x == "") {
        alert("Status must be filled out");
        return false;
    }
    
    var x = document.forms["signupForm"]["username"].value;
    if (x == null || x == "") {
        alert("Username must be filled out");
        return false;
    }

    var x = document.forms["signupForm"]["emailaddr"].value;
    if (x == null || x == "") {
        alert("Email Address must be filled out");
        return false;
    }
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var re1 = re.test(x);
    if(!re1){
    	alert("Not a Valid Email Address");
        return false;
    }

    var x = document.forms["signupForm"]["password"].value;
    if (x == null || x == "") {
        alert("Password must be filled out");
        return false;
    }

    var x = document.forms["signupForm"]["cpassword"].value;
    if (x == null || x == "") {
        alert("Confirm Password must be filled out");
        return false;
    }

    var x = document.forms["signupForm"]["password"].value;
    var y = document.forms["signupForm"]["cpassword"].value;
    if (x != y) {
        alert("Password do not match");
        return false;
    }
}

/*function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#profilepic')
                .attr('src', e.target.result)
        };
        reader.readAsDataURL(input.files[0]);
    }
}*/



/*var createData = function(){
    $("#signupForm").submit(function(evt){
        evt.preventDefault();
        var url = 'http://localhost:8080/ctwitter/webapi/accountdetails/create';
        var postData = {
			"emailAddress" : $("#emailaddr").val(),
			"name" : $("#name").val(),
			"password" : $("#password").val(),
			"profilePic" : "myProfilePic",
			"status" : $("#status").val(),
			"tweet" : null,
			"username" : $("#username").val()
		};
        console.log(postData);

        $.ajax = function(url, postData) {
            return jQuery.ajax({
            headers: { 
                'Accept': 'application/json',
                'Content-Type': 'application/json' 
            },
            'type': 'POST',
            'url': url,
            'data': JSON.stringify(data),
            'dataType': 'json',
            'success':function{
                alert('success');
            }
            });
        };
    });
};*/
