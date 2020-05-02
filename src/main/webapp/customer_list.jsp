<%@ page import="pl.sda.javagdy2.database.EntityDao" %>
<%@ page import="pl.sda.javagdy2.database.model.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: mWroblewski
  Date: 21.04.2020
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>customer list</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/styles/main.css">
</head>
<body>

<header id="header">
    <div class="link_description">
        <h1>Customer list</h1>
    </div>
    <nav class="nav">

        <jsp:include page="/menu.jsp"/>

    </nav>
</header>

<main>
    <table>
        <thead>
        <td class="td_item">id</td>
        <td class="td_item">Name</td>
        <td class="td_item">Surname</td>
        <td class="td_item">Cars Quntity</td>
        <td class="td_item">Tips</td>
        <td class="td_item">Rate</td>
        <td class="td_item">/customer/delete</td>
        <td class="td_item">/customer/detail</td>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${requestScope.customers}">
            <tr>
                <td class="td_item"><c:out value="${customer.id}"/></td>
                <td class="td_item"><c:out value="${customer.name}"/></td>
                <td class="td_item"><c:out value="${customer.surname}"/></td>
                <td class="td_item"><c:out value="${customer.cars_qty}"/></td>
                <td class="td_item"><c:out value="${customer.tips}"/></td>
                <td class="td_item"><c:out value="${customer.rate}"/></td>
                <td class="td_item">
                    <a href="/customer/delete?identToDelete=<c:out value="${customer.id}"/>">delete</a>
                </td>
                <td class="td_item">
                    <a href="/customer/detail?identToEdit=<c:out value="${customer.id}"/>">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>

