<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--Esto es un comentario desde JSP --%>
<!-- Esto es un comentario html -->
<%="Hola mundo"+ new Date().toString()%>
<%
//out.println("Hola mundo"+ new Date().toString());
String[] valores= new String[3];
valores[0]="test";
valores[1]="test1";
valores[2]="test2";

for(String valor:valores){
 %>
 <div><%=valor%></div>
 <%
 	}
  %>
 <%@include file="Copyright.jspf" %>
</body>
</html>