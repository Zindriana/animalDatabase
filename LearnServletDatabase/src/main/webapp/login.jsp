<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Massa djur!" %>
</h1>
<br/>

<form action="${pageContext.request.contextPath}/Login" method="POST">
    <h2>
        <span>Användare</span>
        <input type="text" name="name">
    </h2>
    <h2>
        <span>Lösenord</span>
        <input type="password" name="password">
    </h2>
    <button> Submit </button>
</form>

</body>
</html>