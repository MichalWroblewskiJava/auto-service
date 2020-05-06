<%--
  Created by IntelliJ IDEA.
  User: mWroblewski
  Date: 27.04.2020
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Order form</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/https://fonts.googleapis.com/css?family=Lato&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
<h1>Formularz zamówienia: <c:out value="${requestScope.customer_identifier}"/></h1>
<jsp:include page="/menu.jsp"/>
<br/>
<form action="${pageContext.request.contextPath}${(requestScope.orderToEdit==null ? "/order/add" :'/order/edit')}" method="post">
    <input type="hidden" name="customerOrderID" value="<c:out value="${requestScope.customer_identifier}"/>">
    <input type="hidden" name="editedOrder" value="<c:out value="${requestScope.orderToEdit.id}"/>">
    <br/>
    Order:
    <select name="fault">
        <c:forEach var="fau" items="${requestScope.faults}">
            <option value="${fau}" ${fau == requestScope.orderToEdit.fault ? 'selected': ''} >${fau.description}</option>
        </c:forEach>
    </select>
    <br/>
    Car plate: <input type="text" name="car_plate" value="${requestScope.orderToEdit.car_plate}"/>
    <br/>
    Paid: <input type="checkbox" name="paid" ${(requestScope.orderToEdit.paid)? "checked": ""} value="true"/>
    <br/>
    <input type="submit">
</form>


</body>
</html>