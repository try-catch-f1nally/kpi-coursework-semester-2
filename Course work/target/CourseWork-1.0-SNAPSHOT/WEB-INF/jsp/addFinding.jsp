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
<%@include file="header.jspf" %>
<c:if test="${!empty user}">
    <div class="notification"><p><c:out value="${user.name}"/>, опишіть свою знахідку як найкраще, додайте ключові слова
        (район знаходження, бренд/марка/ колір речі і т.п.). Це дозволить власнику швидше відшукати свою втрату.</p><br>
    </div>
    <form id="creatingFinding" class="creatingForm" action="createFinding" method="post">
        Назва(заголовок оголошення): <input type="text" name="title"><br>
        Ключові слова: <input type="text" name="keywords"><br>
        Опис знахідки:<br><textarea name="description" rows="10" cols="65" form="creatingFinding"></textarea><br>
        Контактна інформація: <input type="text" name="contactInformation"><br>
        <input class="button" type="submit" value="Опублікувати"><br>
    </form>
</c:if>
<c:if test="${empty user}">
    <div class="notification"><p>Щоб створити оголошення про знахідку, потрібно увійти у свій обліковий запис!</p></div>
</c:if>
<a href="." class="toMainPage">На головну</a>
<%@include file="footer.jspf" %>
</body>
</html>
