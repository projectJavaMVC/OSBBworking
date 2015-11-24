<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>OSBB</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/signup/addUser2" method="post">
    <div class="form-group"><h3>Укажите персональные данные</h3></div>
    <div class="form-group"><input type="text" class="form-control" name="name" placeholder="Имя"></div>
    <div class="form-group"><input type="text" class="form-control" name="lastName" placeholder="Фамилия"></div>
    <div class="form-group"><input type="text" class="form-control" name="secondName" placeholder="Отчество"></div>
    <div class="form-group"><input type="text" class="form-control" name="phone" placeholder="Номер телефона"></div>
    <div class="form-group"><input type="text" class="form-control" name="flatNum" placeholder="Номер квартиры"></div>
    <select class="selectpicker form-control form-group" name="group">
      <option value="-1">Default</option>
      <c:forEach items="${groups}" var="group">
        <option value="${group.id}">${group.name}</option>
      </c:forEach>
    </select>
    <div class="form-group"><input type="submit" class="btn btn-primary" value="Готово!"></div>
  </form>
</div>
<script>
  $('.selectpicker').selectpicker();
</script>
</body>
</html>
