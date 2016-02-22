var myApp = angular.module('myApp',['ngCookies']);

myApp.controller('timelineController',['$scope','$cookieStore',function($scope,$cookieStore){
	
	$scope.userName = '';
	$scope.userStatus = '';
	$scope.userEmailAddress = '';
	
	$scope.aid = $cookieStore.get("aid");
	
	
	$http.get('http://localhost:8080/ctwitter/webapi/accountdetails/'+$scope.aid)
    .success(function(result){
    
    	console.log('success '+result);
    })
    .error(function(data,status){
    
        console.log('failure '+data+' '+status);
    });
}]);