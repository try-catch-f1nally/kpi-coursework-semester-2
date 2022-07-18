<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<section>
    <c:if test="${usersFindings.size() != 0}">
        <h2 class="textWithLines"><span>Ваші оголошення про знахідки</span></h2>
        <table class="findings-table">
            <thead>
            <tr>
                <th>Знахідка</th>
                <th>
                    Ключові слова
                </th>
                <th colspan="2">
                    Час публікації
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="finding" items="${usersFindings}">
                <tr>
                    <td title="${finding.description}">
                        <a href="finding?findingId=${finding.findingId}">${finding.title}</a>
                    </td>
                    <td>
                        <c:forEach items="${finding.keywords}" var="keyword">
                            <c:out value="${keyword}"/>
                        </c:forEach>
                    </td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${finding.date}"/></td>
                    <td>
                        <form action="deleteFinding" method="POST">
                            <input type="hidden" name="findingId" value="${finding.findingId}"/>
                            <input class="deleteButton" type="submit" value="Видалити"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${usersFindings.size() == 0}">
        <h2 class="textWithLines"><span>У вас не має оголошень.</span></h2>
    </c:if>
</section>
<a href="." class="toMainPage">На головну</a>
<%@include file="footer.jspf" %>
</body>
</html>
