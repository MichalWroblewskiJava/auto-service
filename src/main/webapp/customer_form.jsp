<%--
  Created by IntelliJ IDEA.
  User: mWroblewski
  Date: 21.04.2020
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>customer form</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
</head>
<body>

<header id="header">
    <div class="link_description">
        <h1>Customer form: <c:out value="${requestScope.customerToEdit.id}"/></h1>
    </div>
    <nav class="nav">

        <jsp:include page="/menu.jsp"/>

    </nav>
</header>
<main>

    <form action="${pageContext.request.contextPath}${(requestScope.customerToEdit==null ?"/customer/add":'/customer/edit')}"
          method="post">
        <input type="hidden" name="customerEditID" value="<c:out value="${requestScope.customer_EditId}"/>">
        <input type="hidden" name="editedCustomer" value="<c:out value="${requestScope.customerToEdit.id}"/>">

        Name: <input type="text" name="name" value="${requestScope.customerToEdit.name}"/>
        <br/>
        Surname: <input type="text" name="surname" value="${requestScope.customerToEdit.surname}"/>
        <br/>
        Cars_Quantity: <input type="number" name="cars_qty" min="1" value="${requestScope.customerToEdit.cars_qty}"/>
        <br/>
        Tips: <input type="checkbox" name="tips" ${(requestScope.customerToEdit.tips)? "checked": ""} value="true"/>
        <br/>
        Rate: <input type="number" name="rate" min="1" max="10"
                     value="${requestScope.customerToEdit.rate}"/> <%--zmiennoprzecinkowe dzięki step--%>
        <br/>
        <input type="submit">
    </form>
</main>
</body>
</html>
