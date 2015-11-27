<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Prog.kiev.ua</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<table class="table table-striped">
  <thead>
  <tr>
    <td><b>Номер квартиры</b></td>
    <td><b>Имя</b></td>
    <td><b>Фамилия</b></td>
    <td><b>Тел.</b></td>
    <td><b>Емейл</b></td>
    <td><b>Площадь</b></td>
    <td><b>Проживает</b></td>
   </tr>
  </thead>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.flatNum}</td>
      <td>${user.name}</td>
      <td>${user.surename}</td>
      <td>${user.phone}</td>
      <td>${user.email}</td>
      <td>${user.area}</td>
      <td>${user.peopleCNT}</td>
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>
