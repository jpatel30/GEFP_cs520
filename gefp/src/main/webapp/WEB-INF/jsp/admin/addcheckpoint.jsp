<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../import.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#section {
	width: 500px;
	padding: 10px;
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Golden Eagle Flight Plan</title>
<!-- Core CSS - Include with every page -->
<script src="//cdn.ckeditor.com/4.4.7/standard/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/config.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/adapters/jquery.js"></script>
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
			 <li>   <strong> ${user1.username}</strong></li> 
			| <li><a href="${pageContext.request.contextPath}/j_spring_security_logout" style="font-color: black;">Logout</a></li>
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
				<li class="selected"><a href="admin.html"><i
						class="fa fa-dashboard fa-fw"></i><font size="3" color="black"><strong>Admin
								Detail</strong></font></a></li>
				<li><a href="studentlist.html"><i class="fa fa-flask fa-fw"></i><font
						size="3" color="black"><strong>Student List</strong></font></a></li>
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
				<!-- Page Header -->
				<div class="col-lg-12">
					<h1 class="page-header">Admin</h1>
				</div>
				<!--End Page Header -->
			</div>

			<div class="row">
				<!-- Welcome -->
				<div class="col-lg-12">
					<div class="alert alert-info" style="background-color: #D8D1D4;">
						<th><a
							href="plandetail.html?id=${planid}&dname=${departmentname}">Back</a></th>
					</div>
					<form:form modelAttribute="checkpoint" method="POST"
						action="addcheckpoint.html">
						<div class="row">
							<div class="col-lg-12">
								<!--    Striped Rows Table  -->
								<div class="panel panel-default">
									<div class="panel-heading"style=" background-color: #D8D1D4;"><font size="3" color="black" ><strong>Add Checkpoint</strong></font></div>
											<div class="panel-body" id="section" style="width:100%">
										<div class="table-responsive">
											<table class="table table-striped" border="1">

												<tr>
													<td>Select Stage:</td>
													<td><select name="stage" class="form-control">
															<c:forEach var="stage" items="${plan.stages}">
																<option value="${stage.name}">${stage.name}</option>
															</c:forEach>
													</select></td>
												</tr>
												<tr>
													<td>Select Runway:</td>
													<td><select name="runway" class="form-control">
															<c:forEach var="runway" items="${plan.runways}">
																<c:out value="${runway.name}"></c:out>
																<option value="${runway.name}">${runway.name}</option>

															</c:forEach>
													</select></td>
												</tr>
												<tr>
													<td>Checkpoint Name:</td>
													<td><textarea name="description" class="form-control"  id="ck" ></textarea>
													
													<script>
													$(function() {
													    $('#ck').ckeditor({
													        toolbar: 'Full',
													        enterMode : CKEDITOR.ENTER_BR,
													        shiftEnterMode: CKEDITOR.ENTER_P
													    });
													});
														
													</script></td>
												</tr>
												<tr>
													<td><input type="hidden" name="dname" value="${departmentname}">
													<input type="hidden" name="planid" value="${plan.id}"></td>
													<td align="right"><input type="submit" name="save"
														value="Add Checkpoint " class="btn btn-primary" /></td>
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
	</div>

	
</body>
</html>