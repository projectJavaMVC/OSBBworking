<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/signup/addAdmin2" method="post">

    <div class="form-group"><h3>Регистрация</h3></div>
    <hidden > dfsfsd</hidden>>
    <div class="form-group"><input type="text" class="form-control" name="flatCnt" placeholder="Количество квартир"></div>
    <div class="form-group"><input type="text" class="form-control" name="city" placeholder="Город"></div>
    <div class="form-group"><input type="text" class="form-control" name="street" placeholder="Улица"></div>
    <div class="form-group"><input type="text" class="form-control" name="buildNum" placeholder="Номер Дома"></div>
     <div class="form-group"><input type="submit" class="btn btn-primary" value="Готово!"></div>
  </form>
</div>
</body>
</html>
