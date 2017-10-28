<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="/Login/CSS/LoginForm.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/Login/JS/LoginFormValidator.js"></script>
</head>
<body>
<div class="row">
<div class="col-xs-12">
<div class="outer">
<form action="/Login/LoginServlet" method="post" name="loginform" id="loginform">
<div class="row">
<div class="col-xs-12">
<div class="inner"><h1>Welcome</h1></div>
</div>
</div>
<div class="row">
<div class="col-xs-12">
<div class="emailId"><label for="emailId">Email-ID</label></div>
<input type="text" name="emailId" id="emailId">
<span id="emailId-ID" style="color:red"></span>
<div class="message">
<% if(session.getAttribute("error-flag")!=null){
		if(session.getAttribute("error-flag").equals("1")){
			out.print("<p style=\"color:red;\"><b>"+session.getAttribute("error")+"</b></p>");
			session.removeAttribute("error-flag");
		}
	}
%>
</div>
</div>
</div>
<div class="row">
<div class="col-xs-12">
<div class="password"><label for="password">Password</label></div>
<input type="password" name="password" id="password">
<span id="password-ID" style="color:red"></span>
<div class="message">
<% if(session.getAttribute("error-flag")!=null){
		if(session.getAttribute("error-flag").equals("2")){
			out.print("<p style=\"color:red;\"><b>"+session.getAttribute("error")+"</b></p>");
			session.removeAttribute("error-flag");
		}
	}
%>
</div>
</div>
</div>
<div class="row">
<div class="col-xs-4">
<input type="submit" value="Login" name="action">
</div>
<div class="col-xs-6">
<h4><a href="/Login/JSP/Registration">Register</a></h4>
</div>
</div>
</form>
</div>
</div>
</div>
</body>
</html>