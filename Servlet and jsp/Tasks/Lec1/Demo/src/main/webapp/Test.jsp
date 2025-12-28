<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.*" %>
<%!
public String  concatIdName(int id , String name){
	return id + " - " + name ;
}


%>

<%
   
 int  id = 101;
String name = "Mohamed";

  
    String result =concatIdName (id , name);
%>

<html>
<head>
    <title>JSP Example</title>
</head>
<body>
    <h2>Result:</h2>
    <p><%= result %></p>
</body>
</html>
