<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 25.11.2015
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
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

        #section1 {
            padding-top: 50px;
            height: 100%;
            color: #fff;
            background-color: #1E88E5;
        }
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
        <form role="form" enctype="multipart/form-data" class="form-horizontal" action="/edit/ServiceRates"
              method="post">
            <div class="form-group">
                <div class="row">
                    <div class="col-md-8">
                        <h3>Внесите изменения по тарифам</h3>
                    </div>
                </div>
            </div>
            <c:forEach items="${services}" var="service">
                <div class="entry input-group">
                    <div class="form-group">
                        <div class="row">
                            <div class="form-group">
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="${service.serviceId}" placeholder="Тариф" value="${service.rate}">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>


            <div class="form-group">
                <form class="col-md-4">
                    <input type="submit" class="btn btn-primary" value="Сохранить изменения">
                </form>
            </div>
        </form>
    </div>
</div>
</body>
</html>
