<%--
  Created by IntelliJ IDEA.
  User: anyak
  Date: 2024-01-16
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <form action="${pageContext.request.contextPath}/ListOfAnimals/animalDelete" method="POST">
            <span>ID-number on the animal to be deleted</span>
            <input type="number" name="id">
            <button>
               Confirm
            </button>
        </form>
    </body>
</html>
