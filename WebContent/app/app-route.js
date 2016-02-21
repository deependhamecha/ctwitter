var myApp = angular.module('myApp',['ngRoute']);

myApp.config(function($routeProvider){
	
	$routeProvider
	.when('/signup',{
		templateUrl : 'app/signup/signup.html', //
		controller : 'app/signup/signup.js.'
	})
	.when('/signin',{
		templateUrl : 'app/signin/signin.html',
		controller : 'app/signin/signin.js.'
	})
});