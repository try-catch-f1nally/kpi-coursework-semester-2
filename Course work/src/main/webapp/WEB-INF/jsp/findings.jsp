<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Бюро знахідок | Житомир</title>
    <link rel="stylesheet" type="text/css" href="../css/reset.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<%@include file="header.jspf" %>
<section>
    <c:if test="${keywords != null}">
        <div class="notification"><p> Результати пошуку по ключаовим словам:
            <c:forEach items="${keywords}" var="keyword">
                <c:out value="${keyword}"/>
            </c:forEach></p></div>
    </c:if>
    <c:if test="${findings.size() != 0}">
        <table class="findings-table">
            <thead>
            <tr>
                <th>Знахідка</th>
                <th>
                    Ключові слова
                </th>
                <th>
                    Час публікації
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="finding" items="${findings}">
                <tr>
                    <td title="${finding.description}">
                        <a href="finding?findingId=${finding.findingId}">${finding.title}</a>
                    </td>
                    <td>
                        <c:forEach items="${finding.keywords}" var="keyword">
                            <c:out value="${keyword}"/>
                        </c:forEach>
                    </td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${finding.date}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${findings.size() == 0 && keywords == null}">
        <div class="notification"><p> На сайті ще немає оголошень про знахідки. Будьте першим, хто опублікує
            оголошення.</p></div>
    </c:if>
    <c:if test="${search}">
        <a href="." class="toMainPage">Усі оголошення</a>
    </c:if>
</section>
<br>
<%@include file="footer.jspf" %>
</body>
</html>
