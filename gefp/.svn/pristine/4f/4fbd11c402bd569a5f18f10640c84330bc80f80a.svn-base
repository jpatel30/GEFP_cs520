<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="import.jsp" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GOLDEN EAGLE FLIGHT PLAN</title>
   

</head>

<body class="body-Login-back" >
    <div class="container" >
        <div class="row" >
            <div class="col-md-4 col-md-offset-4 text-center logo-margin ">
              <img src="assets/img/login.png" alt=""/>
                </div>
            <div class="col-md-4 col-md-offset-4" >
                <div class="login-panel panel panel-default" >                  
                    <div class="panel-heading" style=" background-color: #D8D1D4;">
                        <h3 class="panel-title" ><font size="3" color="black" ><strong>Please Sign In</strong></font></h3>
                    </div>
                    <div class="panel-body" style=" background-color: #e2e2e2;">
                       <form:form modelAttribute="user" action="j_spring_security_check" method="POST" role="form">
                          <c:if test ="${not empty sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}">
                        		<font color="red">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</font>
                        	</c:if>
                      	  <fieldset>
                                <div class="form-group" align="center">
                                        <input type="text" name="j_username" class="form-control" placeholder="Username"/>
								</div>
                                <div class="form-group" align="center">
                                     <input type="password" name="j_password" class="form-control" placeholder="Password" />
                                </div>
                                <div align="center">
                               <input type="submit" value="Login"  width="50%" />
                              </div>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

   

</body>

</html>
