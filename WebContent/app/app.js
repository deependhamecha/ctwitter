var myApp = angular.module('myApp',['ngRoute']);

myApp.config(function($routeProvider){
	
	$routeProvider
	.when('/signup',{
		templateUrl : 'app/signup/signupView.html', 
		controller : 'mainController'
	})
	.when('/signin',{
		templateUrl : 'app/signin/signinView.html',
		controller : 'mainController'
	})
});

myApp.controller('mainController',['$scope','$timeout','$http','$log',function ($scope,$timeout,$http,$log){
	
	/*$scope.name = "";
	$scope.imageupload = "";
	$scope.emailaddr = "";
	$scope.username = "";
	$scope.password = "";
	$scope.cpassword = "";
	$scope.status = "";*/
	
	$scope.onSubmit = function(){
		
		$scope.dataurl = 'http://localhost:8080/ctwitter/webapi/accountdetails/create';

		$scope.data = {
				"emailAddress" : $scope.emailaddr,
				"name" : $scope.name,
				"password" : $scope.password,
				"profilePic" : "myProfilePic",
				"status" : $scope.status,
				"tweet" : null,
				"username" : $scope.username
		};
		
		console.log($scope.data);
	    
		$http.post($scope.dataurl, $scope.data, $scope.config).then(function(){
			console.log("success");
		}, function(){
			console.log("error");
		});
		
	    /*$scope.results = $http.post($scope.dataurl,$scope.data);
	    $scope.result = $scope.results.success(function(data,status,headers,config){
	    		console.log(data);
	    		console.log(status);
	    		console.log(headers);
	    		console.log(config);
	    });*/
	};
	
}]);