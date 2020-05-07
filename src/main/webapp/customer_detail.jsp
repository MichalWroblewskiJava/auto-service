<%--
  Created by IntelliJ IDEA.
  User: mWroblewski
  Date: 02.05.2020
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--dzięki poniższej linii możliwe jest wywoływanie funkcji/tagów html z jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--dzięki lini poniżej możliwe jest wykonywanie dyrektyw z użyciem zmiennych adresując je przez ${}--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Customer details</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>
<h1>Detailed information about a customer with id: <c:out value="${requestScope.customerDetails.id}"/></h1>
<jsp:include page="/menu.jsp"/>
<br/>


<a href="${pageContext.request.contextPath}/customer/edit?customerEditId=<c:out value="${requestScope.customerDetails.id}"/>">Edit customer data </a>

<br/>
<br/>
<table>
    <tr>
        <td class="td_item">Name:</td>
        <td class="td_item"><c:out value="${requestScope.customerDetails.name}"/></td>
    </tr>
    <tr>
        <td class="td_item">Surname:</td>
        <td class="td_item"><c:out value="${requestScope.customerDetails.surname}"/></td>
    </tr>
    <tr>
        <td class="td_item">Cars Qty:</td>
        <td class="td_item"><c:out value="${requestScope.customerDetails.cars_qty}"/></td>
    </tr>
    <tr>
        <td class="td_item">Tips:</td>
        <td class="td_item"><c:out value="${requestScope.customerDetails.tips}"/></td>
    </tr>
    <tr>
        <td class="td_item">Rate:</td>
        <td class="td_item"><c:out value="${requestScope.customerDetails.rate}"/></td>
    </tr>
</table>
<br/>

<a href="${pageContext.request.contextPath}/order/add?customerId=<c:out value="${requestScope.customerDetails.id}"/>">Add order to this customer </a>

<br/>
<br/>

<table style="border: 1px solid">
    <thead>
    <tr>
        <td class="td_item">Id</td>
        <td class="td_item">Fault</td>
        <td class="td_item">Car Plate</td>
        <td class="td_item">Paid</td>
        <td class="td_item">Date time</td>
        <td class="td_item">/order/remove</td>
        <td class="td_item">/order/edit</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="elementFromListOfOrder" items="${requestScope.customerDetails.customerOrderList}">
        <tr>
            <td class="td_item"><c:out value="${elementFromListOfOrder.id}"/></td>
            <td class="td_item"><c:out value="${elementFromListOfOrder.fault.description}"/></td>
            <td class="td_item"><c:out value="${elementFromListOfOrder.car_plate}"/></td>
            <td class="td_item"><c:out value="${elementFromListOfOrder.paid}"/></td>
            <td class="td_item"><c:out value="${elementFromListOfOrder.dateTime}"/></td>
            <td class="td_item">
                <a href="${pageContext.request.contextPath}/order/remove?orderId=<c:out value="${elementFromListOfOrder.id}"/>">Remove</a>
            </td>
            <td class="td_item">
                <a href="${pageContext.request.contextPath}/order/edit?orderId=<c:out value="${elementFromListOfOrder.id}"/>">Edit</a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
