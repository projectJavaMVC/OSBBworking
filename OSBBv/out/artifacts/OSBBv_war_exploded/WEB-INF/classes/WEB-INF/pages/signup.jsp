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
  <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/signup/add" method="post">
    <div class="form-group"><h3>Регистрация</h3></div>
    <div class="form-group"><input type="text" class="form-control" name="login" placeholder="Login"></div>
    <div class="form-group"><input type="password" class="form-control" name="pass" placeholder="Password"></div>
    <div class="form-group"><input type="text" class="form-control" name="email" placeholder="@Email"></div>

    <div class="form-group"><h4>Тип учетной записи:</h4>
    <select class="selectpicker form-control form-group" name="group">
          <option value="0">Житель Дома</option>
          <option value="1">УправДом</option>
    </select>
    </div>
    <div class="form-group"><input type="text" class="form-control" name="key" placeholder="Secret Key"></div>
    <div class="form-group"><input type="submit" class="btn btn-primary" value="Готово!"></div>
  </form>
</div>
</body>
</html>
