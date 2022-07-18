<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Бюро знахідок | Житомир</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <meta charset="UTF-8">
</head>
<body>
<%@include file="header.jspf"%>
<section>
    <div class="notification"><p>Після створення облікового запису Ви зможете публікувати власні оголошення про знахідки</p></div><br>
    <form class="creatingForm" action="createAccount" method="post">
        Введіть ім'я: <input type="text" name="name"><br>
        Введіть логін: <input type="text" name="login"><br>
        Введіть пароль: <input type="password" name="password"><br>
        <input class="button" type="submit" value="Створити обліковий запис"><br>
    </form>
</section>
<a href="." class="toMainPage">На головну</a>
<%@include file="footer.jspf"%>
</body>
</html>
