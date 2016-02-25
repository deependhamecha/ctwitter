<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<html lang="en-US">
	<head>
		 <meta charset="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
		<script src="https://dl.dropboxusercontent.com/u/40036711/jquery.hovercard.min.js"></script>
		
		<title>My Timeline</title>

		<style>
		#userStatus{
			font-style: italic;
		}
		
		.name{
			font-weight:bold;
		}

		#newTweettLbl{
			text-align:left;
			padding:5px 5px 5px 5px;
		}

		#newTweetTextArea{
			text-align:left;
			margin:5px 0;
		}
		
		#newTweetBtn{
			margin:5px 0;
		}
		
		.top-align{
			margin: auto;
		}
		
		</style>
		
		<script>
			window.no = '';
			window.username = '${sessionScope.myAccountDetails.username}';

			$(document).ready(function(){
				$("#otheruserprofile").hide();
			});
			
			function editTweet(no){
				
				var tweetusername = "tweetUsername"+no;
				var tweetmessage = "tweetMessageNumber"+no;
				window.no = no;
				
				var tweetUsernameText = document.getElementById(tweetusername).innerHTML;
				var tweetMessageText = document.getElementById(tweetmessage).innerHTML;
				
				/* document.getElementById('editModalBody').innerHTML = ''; */
				document.getElementById('editModalHeader').innerHTML = tweetUsernameText.trim();
				/* document.getElementById('editModalBody').innerHTML = tweetMessageText.trim(); */
				document.getElementById('editModalBody').value = tweetMessageText.trim();
			}
			
			$('#editTweetModal').on('shown', function () {
			    $('#editModalBody').focus();
			});
			
			$('#deleteTweetModal').on('shown', function () {
			    $('#deleteModalButton').focus();
			});
			
			function deleteTweetOnYes(){
				$.ajax({
				    url: "http://localhost:8080/ctwitter/webapi/tweet/delete/"+window.no,
				    type: "DELETE",
				    async: false,
				    data: {},
				    /* dataType: "json", */
				    contentType: "application/json",
				    success: function(data){
				    	
				    	$("#newTweetTextArea").val('');
				    	$("#anyAlertMessage").show();
						$("#anyAlertMessage").attr('class','alert alert-success');
						$("#anyAlertMessage").text('Tweet Deleted');
						
						window.setTimeout(function() {
							  $("#anyAlertMessage").fadeTo(500, 0).slideUp(500, function(){
							    $(this).hide(); 
							    $("#anyAlertMessage").attr('class','');
							    $("#anyAlertMessage").text('');
							    $("#anyAlertMessage").removeAttr('style');
							  });
							}, 3000);
						
				    	
						$("#tweetBlock"+window.no).remove();
						$("#tweetMessageNumber"+window.no).remove();
				    }
				});
			}
			
			$(document).ready(function(){
			$("#editModalButton").click(function(){
				var jsonObj = {"username":window.username,"tweetMessage":$("#editModalBody").val()};
				
				$.ajax({
				    url: "http://localhost:8080/ctwitter/webapi/tweet/update/"+window.no,
				    type: "PUT",
				    async: false,
				    data: JSON.stringify(jsonObj),
				    dataType: "json",
				    contentType: "application/json",
				    success: function(data){
				    	$("#newTweetTextArea").val('');
				    	$("#anyAlertMessage").show();
						$("#anyAlertMessage").attr('class','alert alert-success');
						$("#anyAlertMessage").text('Tweet Updated');
						
						window.setTimeout(function() {
							  $("#anyAlertMessage").fadeTo(500, 0).slideUp(500, function(){
							    $(this).hide(); 
							    $("#anyAlertMessage").attr('class','');
							    $("#anyAlertMessage").text('');
							    $("#anyAlertMessage").removeAttr('style');
							  });
							}, 3000);
						
				    	
				    	$("#tweetBlock"+window.no).val('');
						$("#tweetMessageNumber"+window.no).val('');
				    	
				    	$("#tweetUsername"+window.no).text('@' + data.username);
						$("#tweetMessageNumber"+window.no).text(data.tweetMessage);
				    }
				});
			});
			});
			
			function deleteTweet(no){
				window.no = no;
			}
			
			$(document).ready(function(){
				$(document).on('keyup', '#editModalBody', function() {
					$("#editModalButton").attr("disabled",false);
				});
			});
			
			$(document).ready(function(){
				$("#newTweetBtn").click(function(){
					
					if($("#newTweetTextArea").val().trim() == ""){
						alert('Please Enter Tweet Message');
					}else{
						var jsonObj = {"username":window.username,"tweetMessage":$("#newTweetTextArea").val()};
						
						$.ajax({
						    url: "http://localhost:8080/ctwitter/webapi/tweet/create",
						    type: "POST",
						    async: false,
						    data: JSON.stringify(jsonObj),
						    dataType: "json",
						    contentType: "application/json",
						    success: function(data){
						    	$("#newTweetTextArea").val('');
						    	$("#anyAlertMessage").show();
								$("#anyAlertMessage").attr('class','alert alert-success');
								$("#anyAlertMessage").text('Tweet Added');
								
								window.setTimeout(function() {
									  $("#anyAlertMessage").fadeTo(500, 0).slideUp(500, function(){
									    $(this).hide(); 
									    $("#anyAlertMessage").attr('class','');
									    $("#anyAlertMessage").text('');
									    $("#anyAlertMessage").removeAttr('style');
									  });
									}, 3000);
								
								var date = new Date(data.tweetDate).getFullYear() + '-'+ (new Date(data.tweetDate).getMonth()+1) + '-'+ new Date(data.tweetDate).getDate()+' '+new Date(data.tweetDate).getHours()+':'+new Date(data.tweetDate).getMinutes()+':'+new Date(data.tweetDate).getMinutes();
								
								var createTweetElement = '<div class="panel-heading" style="min-height: 45px; " id="tweetBlock'+data.tweetId+'"><kbd id="tweetUsername'+data.tweetId+'">@'+data.username+'</kbd><p class="pull-right"><span style="margin: 0 50px;"><var>'+date+'</var></span><button class="btn btn-sm btn-danger pull-right" onclick="deleteTweet('+data.tweetId+');" data-toggle="tooltip" title="Delete Tweet" style="margin:0 5px;" data-toggle="modal" data-target="#deleteTweetModal"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span></button><button class="btn btn-sm btn-success pull-right" data-toggle="tooltip" title="Edit Tweet" onclick="editTweet('+data.tweetId+');" data-toggle="modal" data-target="#editTweetModal"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button></p></div><div class="panel-body" id="tweetMessageNumber'+data.tweetId+'">'+data.tweetMessage+'</div>';
								
								$("#tweetsBlock").prepend(createTweetElement);
						    }
						});
					}
					
				});
			});
			
			$(document).ready(function(){
				$(".viewAccountDetails").hover(function(){
					
					var usrname = ''+$(this).text().slice(1,$(this).text().length);
					 $.ajax({
					    url: "http://localhost:8080/ctwitter/webapi/accountdetails/getaccountdetails/"+usrname,
					    type: "GET",
					    async: false,
					    contentType: "application/json;charset=utf-8",
					    success: function(data){
					    	
					    	$("#othername").text('');
							$("#otherstatus").text('');
							$("#otheremailaddress").text('');
														
							$("#othername").text(data.name);
							$("#otherstatus").text('\"'+data.status+'\"');
							$("#otheremailaddress").text(data.emailAddress);

							$("#otheruserprofile").show();
					    },
					    error : function(data){
					    	console.log("error in Fetching data");
					    }
					});
				},function(){
					$("#otheruserprofile").hide();
					
				})
			});
		</script>
	
	</head>
	<body>
		<div class="container">
		
		<div class="page-header" align="center">
  			<h1>A Twitter Clone Application <small>By Deepen Dhamecha</small></h1>
		</div>
		<div class="clearfix"></div>
		
			<div class="row">
  				<div class="col-sm-6 col-md-4">
    				<div class="thumbnail">
      					<!-- <img src="..." alt="profilePic" id="userProfilePic"> -->
      					<div class="caption bg-info">
        					<h1 align="center" id="userName">${sessionScope.myAccountDetails.name}</h1>
        					<br/>
        					<p align="center" id="userstatus"><b>Status<br/>"${sessionScope.myAccountDetails.status}"</b></p>
        					<br/>
        					<p id="emailAddress" align="center" ><b>Email Address</b><br/><i>${sessionScope.myAccountDetails.emailAddress}</i></p>        					        					        
      					</div>
    				</div>
    				
    				<form action="logout.do" action="get">
    					<div align="center"><button type="submit" class="btn btn-success">Logout</button></div>
  					</form>
  					
  					<br/>
  					<br/>
  					<br/>
  					<div id="anyAlertMessage" class="" ></div>
  					
  					<div>
  					<div class="thumbnail" id="otheruserprofile">
      					<!-- <img src="..." alt="profilePic" id="userProfilePic"> -->
      					<div class="caption bg-info">
        					<h1 align="center" id="othername"></h1>
        					<br/>
        					<p align="center"><b>Status</b><br/><b id="otherstatus"></b></p>
        					<br/>
        					<p align="center" ><b>Email Address</b><br/><i id="otheremailaddress"></i></p>
        					        					        					        
      					</div>
    				</div>
  					</div>
  				</div>

				<div class="col-sm-6 col-md-8">
  				<!-- 		<div class="row" align="center">
  						<div class="btn-group" role="group" aria-label="...">
  							<input type="submit" class="btn btn-primary" value="All Tweets" />
  							<input type="submit" class="btn btn-default" value="My Tweets" />
						</div>
						</div> -->
						
						
    					<div class="container-fluid">

    						<div id="newTweetBlock">
    							<p align="left" id="newTweettLbl"><b>New Tweet</b></p>
    							<textarea class="form-control" id="newTweetTextArea" rows="3" style="resize:none;" name="newtweet"></textarea>
    							
    							<input type="submit" class="btn btn-primary add-tweet pull-right" value="Add Tweet" id="newTweetBtn" / >
    						</div>
						
							<br/>
    					
    					
    						<!-- <button type="button" class="btn btn-default" aria-label="Left Align" id="refreshBtn">
  								<span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
							</button> -->
    					
    						
    						<!-- <div class="clearfix"></div>
    						
    						<div class="modal fade" id="editAccountDetailsModal" role="dialog">
    							<div class="modal-dialog modal-md">
      								<div class="modal-content">
      									<div class="modal-header">
          									<button type="button" class="close" data-dismiss="modal">&times;</button>
          									<h4 class="modal-title" id="editAccountDetailsModalHeader"></h4>
        								</div>
        							<div class="modal-body">
          								<input type="text" class="form-control" style="min-width:100%;overflow:hidden" id="editAccountDetailsModalBody" />
        							</div>
        							<div class="modal-footer">
          								<button type="button" class="btn btn-success" data-dismiss="modal" id="editAccountDetailsModalButton" disabled=true>Update</button>
        							</div>
      							</div>
    						</div>
  						</div>
  						 -->
    						<div class="clearfix"></div>
    						
    						<div class="modal fade" id="editTweetModal" role="dialog">
    							<div class="modal-dialog modal-md">
      								<div class="modal-content">
      									<div class="modal-header">
          									<button type="button" class="close" data-dismiss="modal">&times;</button>
          									<h4 class="modal-title" id="editModalHeader"></h4>
        								</div>
        							<div class="modal-body">
          								<input type="text" class="form-control" style="min-width:100%;overflow:hidden" id="editModalBody" />
        							</div>
        							<div class="modal-footer">
          								<button type="button" class="btn btn-success" data-dismiss="modal" id="editModalButton" disabled=true>Update</button>
        							</div>
      							</div>
    						</div>
  						</div>
  						
  						<div class="modal fade" id="deleteTweetModal" role="dialog">
    							<div class="modal-dialog modal-sm">
      								<div class="modal-content">
      									<div class="modal-header">
          									<button type="button" class="close" data-dismiss="modal">&times;</button>
          									<h4 class="modal-title">Delete this tweet?</h4>
        								</div>
        							
        							<div class="modal-footer">
          								<button type="button" class="btn btn-warning" data-dismiss="modal" id="deleteModalButton" onclick="deleteTweetOnYes();">Yes</button>
          								<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
        							</div>
      							</div>
    						</div>
  						</div>
   
    							<div class="panel panel-info" id="tweetsBlock">
    								<c:forEach items="${sessionScope.allTweets}" var="tweet">
									<div class="panel-heading" style="min-height: 45px; " id="tweetBlock${tweet.tweetId}">
										<a href="" class="viewAccountDetails"><kbd id="tweetUsername${tweet.tweetId}">@${tweet.username}</kbd></a>
										<p class="pull-right">
											<span style="margin: 0 50px;"><var>${tweet.tweetDate}</var></span>
											
											<c:if test="${sessionScope.myAccountDetails.username eq tweet.username}">
											<button class="btn btn-sm btn-danger pull-right" onclick="deleteTweet(${tweet.tweetId});" style="margin:0 5px;" data-toggle="modal" data-target="#deleteTweetModal" data-toggle="tooltip" title="Delete Tweet"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span></button>
											<button class="btn btn-sm btn-success pull-right" onclick="editTweet(${tweet.tweetId});" data-toggle="modal" data-target="#editTweetModal" data-toggle="tooltip" title="Edit Tweet"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button>
											</c:if>
											
										</p>
									</div>
									<div class="panel-body" id="tweetMessageNumber${tweet.tweetId}">
										${tweet.tweetMessage}
									</div>
									</c:forEach>
								</div>
    					</div>
					</div>
  				</div>
		</div>
	</body>
</html>