 	<div class="container" id="signupcontainer">
		
		<div class="clearfix"></div>

		<!-- Sign Up -->
		<div class="" style="margin-top: 30px">
			<div class="col-md-2"></div>
			<div class="col-md-6">
			<form name="signupForm" class="form-horizontal" method="post" action="signupcontroller.do" id="signupForm">
				<div class="form-group">
					<label class="col-sm-4 control-label">Name</label>
					<div class="col-sm-8">
						<input type="text" name="name" class="form-control" id="name" placeholder="Enter Name" />
					</div>
				</div>

<!-- 				<div class="form-group">
					<label class="col-sm-4 control-label">Upload Profile Picture</label>
					<div class="col-sm-8">
						<input name="imageupload" class="form-control"  id="imageupload" type="file" onchange="readURL(this)" />
					</div>
				</div> -->

				<div class="form-group">	
					<label class="col-sm-4 control-label">E-mail address</label>
					<div class="col-sm-8">
						<input name="emailaddr" type="email" class="form-control" id="emailaddr" placeholder="Enter Email Address" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-4 control-label">Username</label>
					<div class="col-sm-8">
						<input name="username" type="text" class="form-control" id="username" placeholder="Enter Username" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label">Password</label>
					<div class="col-sm-8">
						<input name="password" type="password" class="form-control" id="password" placeholder="Enter Password"/>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label">Confirm Password</label>
					<div class="col-sm-8">
						<input name="cpassword"  type="password" class="form-control" placeholder="Confirm Password"/>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label">Status</label>
					<div class="col-sm-8">
						<textarea name="status" type="text" class="form-control" id="status" placeholder="Enter Status" style="resize: none;" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<input type="submit" class="btn btn-success submit" value="Submit" id="submit" /> <!-- return validateSignUpForm(); -->
					</div>
				</div>
			</form>
			
			</div>
			<div class="col-md-2"></div>
			<%-- <div class="col-md-5 col-md-offset-1">
				<table class="table table-hover" border="0" cellspacing="0" cellpadding="0" width="100%">
					<thead>
						<tr>
							<th class="text-center">Profile Preview</th>
						</tr>
					</thead>
					<tbody>
						<tr style="height:150px;text-align:center;">
							<td>
								<img class="img-circle" alt="" id="profilepic" src="http://localhost:8080${pageContext.request.contextPath}/res/avatar.png" width="140" height="140" />
							</td>
						</tr>
						<tr style="height:100px;text-align:center;">
							<td>
								<label class="control-label">
									<h2 align="left" ng-cloak>{{ name }}</h2>
								</label>
							</td>
						</tr>
						
						<tr style="height:50px;text-align:center;font-weight:bold;font-size:20px;">
							<td>
								<label class="control-label">
									<h6 align="right" ng-cloak>{{ emailaddr }}</h6>
								</label>
							</td>
						</tr>
						
						<tr style="height:50px;text-align:center;">
							<td>
								<label class="control-label">
									<p align="left" ng-cloak><i>{{ username }}</i></p>
								</label>
							</td>
						</tr>
						
						

						<tr style="height:50px;text-align:center;">
							<td>
								<label class="control-label">
									<h5 ng-cloak>{{ status }}</h5>
								</label>
							</td>
						</tr>
					</tbody>
				</table>
			</div>   --%>
		</div>
	</div>
<hr/>