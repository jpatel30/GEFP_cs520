<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../import.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/plugins/dragtable.css" />
<script src="${pageContext.request.contextPath}/assets/plugins/jquery.dragtable.js"></script>
<style>
#section {
	list-style-type: none;
}
</style>
<script type="text/javascript">
function call(){
	alert("hello");
	return true;
}

$(function() {
   var runwaycount = $("#runwaysize").val();
   var stagecount = $("#stagesize").val();
   var cellcount=runwaycount*stagecount;
 
  for(i=0;i<=cellcount;i++){
    var cell= "#sort_col" + i  
    $( cell ).sortable({
    	update: function(event, ui) {
    		 var planid=$('#planid').val();
    		 var cellid=$('#cellid').val();
    		 var ckids=[];
 			$(this).find('li').each(function(i,k){
 				ckids.push($(k).attr('id'));
 				})
    		$.ajax({
                type: "POST",
                url:  "/gefp/admin/saveck.html",
                data: {
            		"planid": planid,
            		"cellid": cellid,
            		"ckid" : ckids
                }
            }); 
    	}
    });
   }
   $('tbody').sortable( {
	   update: function(event, ui) {
		   var planid=$('#planid').val();
		   //alert(ui.item.index())
		   var stages = [];
		   
		   $(this).find('tr').each(function(i,k){
			   stages.push($(k).attr('id'));
		   })
		   console.log(stages)
		   $.ajax({
               type: "POST",
               url:  "/gefp/admin/saverow.html",
               data: {
                   "stages": stages,
                   "planid": planid
               }
           });
       
       }
   });
   $('table').dragtable({
	   dragaccept:'.accept',
	   persistState: function(table) {
		   var runways = [];
	        table.el.find('th').each(function(i,k) {
	          runways.push($(k).attr('id'));
	        })
	        console.log(runways)
	       var planid=$('#planid').val();
	        $.ajax({
               type: "POST",
               url:  "/gefp/admin/savecolumn.html",
               data: {
            	    "runways": runways,
            	  	"planid": planid
               }
           });
       } 
   });
  
 });
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
			<img src="${pageContext.request.contextPath}/assets/img/csulalogo.gif" alt=" " width="90" height="90" align="left">
			<a class="navbar-brand" href="login.html" ><font size="15" color="black" > <strong>G</strong>olden <strong>E</strong>agle <strong>F</strong>light <strong>P</strong>lan</font>
			</a>
					</div>
		  <ul class="nav navbar-top-links navbar-right">
               <li>   <strong> ${user1.username}</strong></li> 
			| <li><a href="${pageContext.request.contextPath}/j_spring_security_logout" style="font-color: black;">Logout</a></li>
            </ul>
            <!-- end navbar-top-links -->

        </nav>
		<!-- end navbar-top-links --> </nav>
		<!-- end navbar top -->

		<!-- navbar side -->
		<nav class="navbar-default navbar-static-side" role="navigation">
		<!-- sidebar-collapse -->
		<div class="sidebar-collapse">
			<!-- side-menu -->
			<ul class="nav" id="side-menu">
				<li></li><li></li><li></li><li></li>
				<li>
					
					<div class="user-section">
						
					</div>
				</li>
				<li></li>
				<li class="selected" >
				<a href="admin.html"><i class="fa fa-dashboard fa-fw"></i><font size="3" color="black" ><strong>Admin Detail</strong></font></a></li>
				<li><a href="studentlist.html"><i class="fa fa-flask fa-fw"></i><font size="3" color="black" ><strong>Student List</strong></font></a></li>
				<li><a href="notes.html"><i class="fa fa-table fa-fw"></i><font size="3" color="black" ><strong>Notes</strong></font></a></li>
				<li><a href="http://csns.calstatela.edu/"><font size="3" color="black" ><strong>CSNS</strong></font></a></li>	
				<li><a href="https://get.calstatela.edu/"><font size="3" color="black" ><strong>GET</strong></font></a></li>
				
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
					<div class="row">
						<!-- Welcome -->
						<div class="col-lg-12">
							<div class="alert alert-info" style=" background-color: #D8D1D4;">

								<form:form method="POST" action="add.html">
									<input type="hidden" id="planid" name="id" value="${plan.id}">
									<th><a
										href="addstage.html?id=${plan.id}&dname=${departmentname}">AddStage</a></th> |
							<th><a
										href="addrunway.html?id=${plan.id}&dname=${departmentname}">AddRunway</a></th> |
							<th><a
										href="addcheckpoint.html?id=${plan.id}&dname=${departmentname}">AddCheckpoint</a></th> |
							<th><a
										href="editrun.html?id=${plan.id}&dname=${departmentname}">EditRunway</a></th> |			
										
										<th><a href="view.html?id=${plan.id}&dname=${departmentname}">Back</a></th>
								</form:form>
							</div>
							<form:form>
								<div class="row">
									<div class="col-lg-12">
										<!--    Striped Rows Table  -->
										<div class="panel panel-default">
											<div class="panel-heading"style=" background-color: #D8D1D4;"><font size="3" color="black" ><strong>Plan View</strong></font></div>
											<div class="panel-body">
												<div class="table-responsive">
													<table class="table table-striped" border="1" width="100%" cellspacing="10" >
														<thead >
															<tr>
																<th ><input type="hidden" value="${runwaysize}" id="runwaysize">
																<input type="hidden" value="${stagesize}" id="stagesize">
																<input type="hidden" value="${cellsize}" id="cellsize">
																</th>
																
																<c:forEach items="${plan.runways}" var="runway">
																	<th class="accept" id="${runway.id}"> ${runway.name}
																	<%-- <a href="editRunway.html?rid=${runway.id}&pid=${planid}&dname=${departmentname}">[Edit]</a></th> --%>
																
																</c:forEach>
																
															</tr>
															<tr>
															<td></td>
															<c:forEach items="${plan.runways}" var="runway">
																	<td id="${runway.id}"> 
																	<a href="editRunway.html?rid=${runway.id}&pid=${planid}&dname=${departmentname}">[Click To Edit]</a></th>
																
																</c:forEach>
															</tr>
															
														</thead>
														<c:set var="total" value="${stagesize*runwaysize}"></c:set>
														
														<c:forEach items="${plan.stages}" var="stage">
															<tr id="${stage.id}">
																<td>${stage.name}<a href="editStage.html?sid=${stage.id}&pid=${planid}&dname=${departmentname}">[Edit]</a></td>
																		<c:forEach items="${plan.runways}" var="runway">
																		
																		<c:set var="total" value="${total-1}" ></c:set>	
																		<td id="sort_col${total}">
																		<%-- <c:out value="sort_col${total}"></c:out> --%>
																		<c:forEach items="${plan.cells}" var="cell">
																			<input type="hidden" id="cellid" value="${cell.id}">	
																			
																			<c:if test="${cell.stage.id == stage.id and runway.id == cell.runway.id}">
								 													<c:forEach items="${cell.checkpoints}" var="c">
																					
																					<li id="${c.id}"><input type="checkbox" name="checkbox" /> <label  >${c.description}</label>  
																						<a href="edit.html?cid=${c.id}&sid=${stage.id}&rid=${runway.id}&pid=${planid}&cellid=${cell.id}&dname=${departmentname}">[Edit]</a>
																						<a href="delete.html?cid=${c.id}&pid=${planid}&cellid=${cell.id}&dname=${departmentname}">[Remove]</a>
																					</li>	<br>
																					
																					</c:forEach>
																				
																				</c:if>
																				
																		</c:forEach>
																		
																		</td>
																		
																		
																	</c:forEach>
																	
															</tr>
																
														</c:forEach>
														
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