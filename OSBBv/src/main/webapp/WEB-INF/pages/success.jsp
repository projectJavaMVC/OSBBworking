<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 24.11.2015
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
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
<form role="form" enctype="multipart/form-data" class="form-horizontal" action="/signup/addFlat" method="post">
  <h3>Поздравляем! Регистрация прошла успешно! Нажмите кнопку чтобы заполнить информацию о квартире.</h3>
  <div class="form-group"><input type="submit" class="btn btn-primary" value="Регистрация квартиры"></div>
</form>
</div>
</body>
</html>
