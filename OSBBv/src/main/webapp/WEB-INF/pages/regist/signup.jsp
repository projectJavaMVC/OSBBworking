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
    #section1 {padding-top:50px;height:100%;color: #fff; background-color: #1E88E5;} <!--#1E88E5
  </style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50" style="background-color:#0a0b0b">
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
  <form role="form" enctype="multipart/form-data" class="form-group" action="/signup/add" method="post">
    <div class="row"style="margin-top:15px;"><h3>Регистрация</h3></div>

    <div class="row" style="margin-top:15px;">
    <div class="col-md-3"><input type="text" class="form-control" name="login" placeholder="Login"></div>
    </div>

    <div class="row" style="margin-top:15px;">
    <div class="col-md-3"><input type="password" class="form-control" name="pass" placeholder="Password"></div>
    </div>
    <div class="row"style="margin-top:15px;">
    <div class="col-md-3"><input type="email" class="form-control" name="email" placeholder="@Email"></div>
    </div>
    <div  class="row"style="margin-top:15px;"><h4>Тип учетной записи:</h4> </div>

    <div  class="row"style="margin-top:15px;">
    <div class="col-md-3">
      <select class="selectpicker form-control form-group" name="group">
          <option value="0">Житель Дома</option>
          <option value="1">УправДом</option>
      </select>
    </div>
    </div>
    <div  class="row" >
    <div class="col-md-3"><input type="text" class="form-control" name="key" placeholder="Secret Key"></div>
    </div>
    <div  class="row"style="margin-top:15px;">
    <div class="row"><input type="submit" class="btn btn-primary" value="Готово!"></div>
      </div>
  </form>

</div>
</div>

</body>
</html>
