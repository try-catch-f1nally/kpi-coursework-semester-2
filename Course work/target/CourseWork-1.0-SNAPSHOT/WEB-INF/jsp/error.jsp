<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Бюро знахідок | Житомир</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<%@include file="header.jspf" %>
<section>
    <div class="notification"><p>${message}</p></div>
    <a href="." class="toMainPage">На головну</a>
</section>
<br>
<%@include file="footer.jspf" %>
</body>
</html>
