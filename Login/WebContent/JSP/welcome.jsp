<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome <%= session.getAttribute("name") %></title>
<link rel="stylesheet" type="text/css" href="/Login/CSS/WelcomeFile.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">

<div class="col-xs-4" style="background-color:#99ddff">
<div class="toptext">Home Page</div>
</div>
<div class="col-xs-4" style="background-color:#66c2ff">
<div class="toptext">User:<%= session.getAttribute("name") %></div>
</div>
<% if(session!=null) {
	session.removeAttribute("name");
	session.invalidate();
} %>
<div class="col-xs-4" style="background-color:#33adff"><form action="/Login/JSP/index" method="post">
<input type="submit" value="Logout" align="right">
</form>
</div>
</div>
</body>
</html>