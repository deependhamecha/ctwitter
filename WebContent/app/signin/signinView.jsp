<div class="container">
		<div class="clearfix"></div>

		<!-- Sign Up -->
		<div class="" style="margin-top: 30px">
			<div class="col-md-6">
			<form name="signinForm" class="form-horizontal" method="post" action="checklogin.do" onsubmit="return validateSignInForm();">

				<div class="form-group">
					<label class="col-sm-4 control-label">Enter Username</label>
					<div class="col-sm-8">
						<input name="loginusername" ng-model="loginusername" type="text" class="form-control" placeholder="Enter Username"/>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label">Password</label>
					<div class="col-sm-8">
						<input name="loginpassword" ng-model="loginpassword" type="password" class="form-control" placeholder=" Enter Password"/>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<input type="submit" class="btn btn-success submit" value="Submit"/>
					</div>
				</div>
			</form>
			</div>
		</div>
		
		
			
	</div>