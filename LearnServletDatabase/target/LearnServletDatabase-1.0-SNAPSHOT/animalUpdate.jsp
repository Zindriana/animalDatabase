<%--
  Created by IntelliJ IDEA.
  User: anyak
  Date: 2024-01-16
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/ListOfAnimals/animalUpdate" method="POST">
        <span>ID-number on the animal that you want to update</span>
        <input type="number" name="id">
        <span>New name</span>
        <input type="text" name="name">
        <span>New age</span>
        <input type="number" name="age">
        <span>New specie</span>
        <input type="text" name="specie">
        <button>
            Confirm update
        </button>
    </form>
</body>
</html>
