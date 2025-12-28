<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Form Page</title>
</head>
<body>
<h2>Uesr Form</h2>
<form action="result.jsp"method="Post">

Full Name:
<input type="text"  name="FullName"/>
<br><br>

Password:
<input type="text"  name="Password"/>
<br><br>

Age:
<input type ="text"  name="Age"/>
<br><br>

Address (Radio):
    <input type="radio" name="addressRadio" value="Cairo" /> Cairo
    <input type="radio" name="addressRadio" value="Alex" /> Alex
    <input type="radio" name="addressRadio" value="Menofia" /> Menofia
    <br><br>
    
Address (Select):
    <select name="addressSelect">
        <option value="Cairo">Cairo</option>
        <option value="Alex">Alex</option>
        <option value="Menofia">Menofia</option>
    </select>
    <br><br>

    <input type="submit" value="Submit" />







</form>
</body>
</html>