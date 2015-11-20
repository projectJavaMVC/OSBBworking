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
  <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/signup" method="post">
    <div class="form-group"><h3>Регистрация</h3></div>
    <div class="form-group"><input type="text" class="form-control" name="j_username" placeholder="Login"></div>
    <div class="form-group"><input type="text" class="form-control" name="j_password" placeholder="Password"></div>
    <div class="form-group"><input type="text" class="form-control" name="email" placeholder="@Email"></div>
    <div class="form-group">
          <label for="sel1">Тип учетной записи:</label>
          <select class="form-control" id="sel1">
              <option>Житель Дома</option>
              <option>УправДом</option>
          </select>
    </div>

    <div class="form-group"><input type="submit" class="btn btn-primary" value="Готово!"></div>
  </form>
</div>
</div>
</body>
</html>
