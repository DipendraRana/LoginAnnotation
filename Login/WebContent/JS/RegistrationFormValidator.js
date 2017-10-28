$(document).ready(function(){
	$(".name").blur(function(){
		var userName=document.registrationform.name.value;
		var userName=userName.replace(/ /g,'');
		document.getElementById("name-ID").innerHTML="";
		var regularExpressionForUserName=/[^A-Za-z]{1,}/;
		if(userName==""||regularExpressionForUserName.test(userName))
			document.getElementById("name-ID").innerHTML="Invalid User Name";
	});
	$(".emailId").blur(function(){
		var emailId=document.registrationform.emailId.value;
		document.getElementById("emailId-ID").innerHTML="";
		var regularExpressionForEmailId=/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
		if(!regularExpressionForEmailId.test(emailId)||emailId=="")
			document.getElementById("emailId-ID").innerHTML="Invalid Email ID";
	});
	$(".password").blur(function(){
		var password=document.registrationform.password.value;
		document.getElementById("password-ID").innerHTML="";
		if(password.length<5||password=="")
			document.getElementById("password-ID").innerHTML="Invalid Password";
	});
	$(".mobileNumber").blur(function(){
		var mobileNumber=document.registrationform.mobileNumber.value;
		document.getElementById("mobileNumber-ID").innerHTML="";
		if(mobileNumber.length !=10 || isNaN(mobileNumber) || mobileNumber=="")
			document.getElementById("mobileNumber-ID").innerHTML="Invalid Mobile Number";
	});
});