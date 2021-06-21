<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.servlet.*" %>
<%
String nonce = request.getAttribute("nonceForCSP") != null ? (String) request.getAttribute("nonceForCSP") : "";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
<script nonce='<%=nonce%>'>
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("msg").innerHTML = "CSP with nonce";
});
</script>
</head>
<body>
<h3>Hello</h3><br>
<div id="msg">CSP enabled</div>

</body>
</html>