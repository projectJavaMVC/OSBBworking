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
    <td></td>
    <td><b>Name</b></td>
    <td><b>Surname</b></td>
    <td><b>Phone</b></td>
    <td><b>E-mail</b></td>
    <td><b>Group</b></td>
  </tr>
  </thead>
  <c:forEach items="${users}" var="users">
    <tr>
      <td><input type="checkbox" name="toDelete[]" value="${users.id}" id="checkbox_${users.id}"/></td>
      <td>${users.name}</td>
      <td>${users.surname}</td>
      <td>${users.phone}</td>
      <td>${users.email}</td>
      <c:choose>
        <c:when test="${users.group ne null}">
          <td>${users.group.name}</td>
        </c:when>
        <c:otherwise>
          <td>Default</td>
        </c:otherwise>
      </c:choose>
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>
