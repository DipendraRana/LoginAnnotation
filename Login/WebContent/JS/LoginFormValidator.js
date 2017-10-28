$(document).ready(function(){
	$("#emailId").blur(function(){
		var emailId=document.loginform.emailId.value;
		var regularExpressionForEmailId=/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
		document.getElementById("emailId-ID").innerHTML="";
		if(!regularExpressionForEmailId.test(emailId)||emailId=="")
			document.getElementById("emailId-ID").innerHTML="Please enter proper Email ID";
	});
	$("#password").blur(function(){
		var password=document.loginform.password.value;
		document.getElementById("password-ID").innerHTML="";
		if(password.length<5||password=="")
			document.getElementById("password-ID").innerHTML="Password Should be greater than 4";
	});
});
