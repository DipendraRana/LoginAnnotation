<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
<link rel="stylesheet" type="text/css" href="/Login/CSS/RegistrationForm.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/Login/JS/RegistrationFormValidator.js"></script>
</head>
<body>
<div class="container">

<div class="row">
<div class="col-xs-12">
<div class="form">
<form action="/Login/Registration" method="post" name="registrationform">
<div class="row">
<div class="col-xs-12">
<div class="registration"><h1>Registration Form</h1></div>
</div>
</div>
<div class="row">
<div class="col-xs-9">
<div class="name"><label for="name">Name</label></div>
<input type="text" name="name" class="name">
<span id="name-ID" style="color:red"></span>
<div class="message" >
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
<div class="col-xs-9">
<div class="emailId"><label for="emailId">Email-id</label></div>
<input type="text" name="emailId" class="emailId">
<span id="emailId-ID" style="color:red"></span>
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
<div class="col-xs-9">
<div class="password"><label for="password">Password</label></div>
<input type="password" name="password" class="password">
<span id="password-ID" style="color:red"></span>
<div class="message">
<% if(session.getAttribute("error-flag")!=null){
		if(session.getAttribute("error-flag").equals("3")){
			out.print("<p style=\"color:red;\"><b>"+session.getAttribute("error")+"</b></p>");
			session.removeAttribute("error-flag");
		}
	}
%>
</div>
</div>
</div>
<div class="row">
<div class="col-xs-9">
<div class="mobileNumber"><label for="mobileNumber">Mobile Number</label></div>
<input type="text" name="mobileNumber" class="mobileNumber">
<span id="mobileNumber-ID" style="color:red"></span>
<div class="message">
<% if(session.getAttribute("error-flag")!=null){
		if(session.getAttribute("error-flag").equals("4")){
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
<input type="submit" value="Register">
</div>
</div>
</form>
</div>
</div>
</div>
</div>
</body>
</html>