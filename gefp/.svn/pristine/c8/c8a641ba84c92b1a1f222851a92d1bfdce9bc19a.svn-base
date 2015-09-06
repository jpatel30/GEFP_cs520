<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../import.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Golden Eagle Flight Plan</title>

</head>
<body>
	<!--  wrapper -->
	<div id="wrapper">
		<!-- navbar top -->
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
			id="navbar"> <!-- navbar-header -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<img src="${pageContext.request.contextPath}/assets/img/csulalogo.gif" alt=" " width="90" height="90"
				align="left"> <a class="navbar-brand" href="login.html"><font
				size="15" color="black"> <strong>G</strong>olden <strong>E</strong>agle
					<strong>F</strong>light <strong>P</strong>lan
			</font> </a>
		</div>
		<ul class="nav navbar-top-links navbar-right">
			<li><a href="studenthome.html?userid=${userid}" style="font-color: black;"><strong>${user1.username}</strong>Home</a></li> 
			|
			<li><a href="${pageContext.request.contextPath}/j_spring_security_logout" style="font-color: black;">Logout</a></li>
			<!-- end main dropdown -->
		</ul>
		<!-- end navbar-top-links --> </nav>
		<!-- end navbar-top-links -->
		</nav>
		<!-- end navbar top -->

		<!-- navbar side -->
		<nav class="navbar-default navbar-static-side" role="navigation">
		<!-- sidebar-collapse -->
		<div class="sidebar-collapse">
			<!-- side-menu -->
			<ul class="nav" id="side-menu">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li>

					<div class="user-section"></div>
				</li>
				<li></li>
				<li class="selected">
					<!-- <a href="admin.html"><i class="fa fa-dashboard fa-fw"></i><font size="3" color="black" ><strong>Admin Detail</strong></font></a></li>
				<li><a href="studentlist.html"><i class="fa fa-flask fa-fw"></i><font size="3" color="black" ><strong>Student List</strong></font></a></li>
				 -->
				<li><a href="notes.html"><i class="fa fa-table fa-fw"></i><font
						size="3" color="black"><strong>Notes</strong></font></a></li>
				<li><a href="http://csns.calstatela.edu/"><font size="3"
						color="black"><strong>CSNS</strong></font></a></li>
				<li><a href="https://get.calstatela.edu/"><font size="3"
						color="black"><strong>GET</strong></font></a></li>

			</ul>
			<!-- end side-menu -->
		</div>
		<!-- end sidebar-collapse --> </nav>
		<!-- end navbar side -->
		<!--  page-wrapper -->
		<div id="page-wrapper">

			<div class="row">
			
				<div class="col-lg-12">
					<h1 class="page-header">Student</h1>
				</div>
				
			</div>

			<div class="row">
				<!-- Welcome -->
				<div class="col-lg-12">
					<div class="row">
						<!-- Welcome -->
						<div class="col-lg-12">
							<div class="alert alert-info" style="background-color: #D8D1D4;">

								<form:form>
									<input type="hidden" name="userid" value="${userid}">
									<th><a href="resetpassword.html?userid=${userid}">Reset
											Password</a></th> |
									<th><a href="changedepartment.html?userid=${userid}">Change
											Major </a></th>
								</form:form>
							</div>
							<form:form>
								<div class="row">
									<div class="col-lg-12">
										<!--    Striped Rows Table  -->
										<div class="panel panel-default">
											<div class="panel-heading" style="background-color: #D8D1D4;">
												<font size="3" color="black"><strong>Student
														Detail</strong></font>
											</div>
											<div class="panel-body">
												<div class="table-responsive">
													<table class="table table-striped" border="1" width="100%"
														cellspacing="10">
														<tr>
															<td align="right">User Name :</td>
															<td ><input type="text"
																value="${username}" /></td>
														</tr>
														<tr>
															<td align="right">Password :</td>
															<td><input type="text" value="${userpassword}" /></td>

														</tr>
														<tr>
															<td align="right">Major :</td>
															<td><input type="text" value="${userdept}" /></td>
															
														</tr>
													</table>

												</div>
											</div>
										</div>
									</div>
								</div>

							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
</body>
</html>