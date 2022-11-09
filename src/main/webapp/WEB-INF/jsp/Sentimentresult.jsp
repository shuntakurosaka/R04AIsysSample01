<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
    Object o = request.getAttribute("message");
    Object q = request.getAttribute("message1");
    Object b = request.getAttribute("message2");
    
    double a =(double)o;
    double v =(double)q;
    double c =(double)b;
%>



<body>
<h2>Sentiment</h2>
<p>Positive<%=a %>
<p>Neutral<%=v %>
<p>Negative<%=c %>
</body>
</html>