<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>OSBB Главная страница. Ведение учета вашего ОСББ</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <style>
    body {
      position: relative;
    }
    #section1 {padding-top:50px;height:100%;color: #fff; background-color: #1E88E5;}
  </style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">ОСББ</a>
    </div>
  </div>
</nav>

<div id="section1" class="container-fluid">



<div class="container">
  <div class="container">
  <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/signup/addUser2" method="post">
    <div class="form-group"><h3>Укажите персональные данные</h3></div>
    <div class="form-group"><input type="text" class="form-control" name="name" placeholder="Имя"></div>
    <div class="form-group"><input type="text" class="form-control" name="lastName" placeholder="Фамилия"></div>
    <div class="form-group"><input type="text" class="form-control" name="secondName" placeholder="Отчество"></div>
    <div class="form-group"><input type="text" class="form-control" name="phone" placeholder="Номер телефона"></div>

    <select class="selectpicker form-control form-group" data-live-search="true" name="flatNum">
      <c:forEach items="${listFlat}" var="flat">
        <option value="${flat.id}">${flat.flatNumber}</option>
      </c:forEach>
    </select>
    <div class="form-group"><input type="submit" class="btn btn-primary" value="Готово!"></div>
  </form>
</div>
  </div>
</div>

<script>
  $('.selectpicker').selectpicker();
  $('#basic2').selectpicker({
    liveSearch: true,
    maxOptions: 1
  });
</script>
</body>
</html>
