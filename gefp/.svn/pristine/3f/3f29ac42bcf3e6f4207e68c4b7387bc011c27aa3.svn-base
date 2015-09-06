<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../import.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script type="text/javascript">
	function doAjax(me) {
		var userid = $('#userid').val();
		//	alert(userid);
		var checkid = me.value;
		//alert(checkid);
		var checkvalue = "";
		if (me.checked) {
			checkvalue = document.getElementById("checkbox").innerHTML = "yes";
		} else {
			checkvalue = document.getElementById("checkbox").innerHTML = "no";
		}
		//alert(checkvalue);
		if (checkvalue == "yes") {
			$.ajax({
				type : "POST",
				url : "/gefp/advisor/savecheckbox.html",
				data : "userid=" + userid + "&checkid=" + checkid,
				success : function(response) {
					$('#info').html(response);
				},
				error : function(e) {
					$('#info').e;
				}
			});
		}
		if (checkvalue == "no") {
			$.ajax({
				type : "POST",
				url : "/gefp/advisor/deletecheckbox.html",
				data : "userid=" + userid + "&checkid=" + checkid,
				success : function(response) {
					$('#info').html(response);
				},
				error : function(e) {
					$('#info').e;
				}
			});

		}
	}
</script>
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
			 <li><a href="profile.html?userid=${userid}" style="font-color: black;"><strong> ${user1.username}</strong> profile</a></li>
			|<li><a href="${pageContext.request.contextPath}/j_spring_security_logout" style="font-color: black;">Logout</a></li>
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
				<!-- Page Header -->
				<div class="col-lg-12">
					<h1 class="page-header">Student</h1>
				</div>
				<!--End Page Header -->
			</div>


			<form:form>
				<div class="row">
					<div class="col-lg-12">
						<!--    Striped Rows Table  -->
						<div class="panel panel-default">
							<div class="panel-heading" style="background-color: #D8D1D4;">
								<font size="3" color="black"><strong>Plan View</strong></font>
								|<a href="search.html?term=${term}">Back</a></th>
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped" border="1" width="100%"
										cellspacing="10">
										<thead>
											<tr>
												<th></th>
												<c:forEach items="${plan.runways}" var="runway">
													<th>${runway.name}</th>
												</c:forEach>
											</tr>
										</thead>
										<c:forEach items="${plan.stages}" var="stage">

											<tr>
												<td>${stage.name}</td>
												<c:forEach items="${plan.runways}" var="runway">
													<td><c:forEach items="${plan.cells}" var="cell">
															<c:if
																test="${cell.stage.id == stage.id and runway.id == cell.runway.id}">
																<c:forEach items="${cell.checkpoints}" var="c">
																	<input type="hidden" id="userid" value="${userid}">

																	<input type="checkbox" name="checkbox" id="checkbox"
																		value="${c.id}" onclick="doAjax(this)"
																		<c:forEach items="${userdetail.checkpoints}" var="check">
																
																<c:choose>
																<c:when test="${check.id eq c.id}">
																	 checked="checked"
																</c:when>
																</c:choose>
																</c:forEach>>${c.description}<br>
																</c:forEach>
															</c:if>
														</c:forEach></td>
												</c:forEach>

											</tr>

										</c:forEach>
										<tr>
										<td  colspan="4"><label id="info" style="color: green;"></label></td>
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

	
</body>
</html>