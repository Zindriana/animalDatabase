<%--
  Created by IntelliJ IDEA.
  User: anyak
  Date: 2024-01-16
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fler djur</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/ListOfAnimals/animalAdd" method="POST">
        <span>Namn</span>
        <input type="text" name="name">
        <span>Ålder</span>
        <input type="number" name="age">
        <span>Art</span>
        <input type="text" name="specie">
        <button>
            Submit
        </button>
    </form>

</body>
</html>
