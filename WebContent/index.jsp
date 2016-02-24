<%@ page session="true" %>
<!-- <!DOCTYPE html> -->
<html lang="en">
<head>
	<title>Twitter App</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta charset="utf-8"/>
	
	<link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous" ></link>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
	
	<script>
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
	$(document).ready(function(){
		$("#signupbtn").click(
		function(){
			$("#view").load('app/signup/signupView.jsp');
		});
	});
	
	$(document).ready(function(){
		$("#signinbtn").click(
		function(){
			$("#view").load('app/signin/signinView.jsp');
		});
	});
	


	</script>
</head>
<body class="container">
	<!-- Page Header -->
	
	<div class="page-header" align="center">
  		<h1>A Twitter Clone Application <small>By Deepen Dhamecha</small></h1>
	</div>

	<!-- Nav Bar -->
	<div class="btn-group btn-group-justified" role="group">
		<div class="btn-group" role="group">
			<button class="btn btn-primary btn-lg" id="signupbtn">Sign Up</button>
		</div>
		<div class="btn-group" role="group">
			<button class="btn btn-primary btn-lg" id="signinbtn">Sign In</button>
		</div>
	</div>
	
	<div id="view" class="container"></div>    
	<div id="successMessage">${requestScope.message}</div>
</body>
</html>