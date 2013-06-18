<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
<html>
<head>
<meta charset="utf-8">
<title>Sign in</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

	<!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/login/login.css">
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/login/login.js"></script>
</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container"></div>
		</div>
	</div>
	<div class="container control-group" style="margin-top: 10px;">
		<form id="frmLogin" action="login" method="POST" class="form-signin">
			<h3 class="form-signin-heading"><fmt:message key="loginForm.signInLabel"/></h3>
			<div id="divFormHolder" class="control-group">
				<input type="text" ${f:text("accountName")} class="input-block-level ${f:errorClass('accountName', 'error')}"
					placeholder="Account Name" id="txtAccountName" >${f:h(errors.accountName)}
				<input type="password" ${f:text("password")} class="input-block-level ${f:errorClass('password', 'error')}"
					placeholder="Password" id="txtPass">${f:h(errors.password)}
			</div>
			
			<button id="btnNormSubmit" class="btn btn-large btn-primary" ><fmt:message key="loginForm.signIn" /></button>
			<div id="divLoading" style="display:none;">
				<img src="/img/loading.gif" />
			</div>
			<div id="divErrors" class="control-group error" style="display:block;">
			</div>
			<div align="right">
				<%
				    String identifier = "https://www.google.com/accounts/o8/id";
		        	String redirectURL = "/login/loginRedirect.jsp";
		        	UserService userService = UserServiceFactory.getUserService();
		        	@SuppressWarnings({ "rawtypes", "unchecked" })
		        	Set<String> attributes = new HashSet();
				%>
				<a href="<%=userService.createLoginURL(redirectURL, null, identifier, attributes)%>" onclick="return popitup('<%=userService.createLoginURL(redirectURL, null, identifier, attributes)%>')"><fmt:message key="loginForm.signInAdmin" /></a>
			</div>
		</form>
	</div>
</body>
</html>
