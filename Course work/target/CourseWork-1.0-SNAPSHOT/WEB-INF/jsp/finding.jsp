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
    <table class="findings-table">
        <tr>
            <th>Знахідка</th>
            <td><c:out value="${finding.title}"/></td>
        </tr>
        <tr>
            <th>Ключові слова:</th>
            <td>
                <c:forEach items="${finding.keywords}" var="keyword">
                    <c:out value="${keyword}"/>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <th>Опис знахідки:</th>
            <td><c:out value="${finding.description}"/></td>
        </tr>
        <tr>
            <th>Контактна інформація</th>
            <td><c:out value="${finding.contactInformation}"/></td>
        </tr>
        <c:if test="${viewByOwner}">
            <tfoot>
            <tr>
                <td colspan="2">
                    <form action="deleteFinding" method="POST">
                        <input type="hidden" name="findingId" value="${finding.findingId}" />
                        <input class="deleteButton" type="submit" value="Видалити" />
                    </form>
                </td>
            </tr>
            </tfoot>
        </c:if>
    </table>
</section>
<a href="." class="toMainPage">На головну</a>
<%@include file="footer.jspf" %>
</body>
</html>
