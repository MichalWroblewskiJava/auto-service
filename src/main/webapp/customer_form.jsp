<%--
  Created by IntelliJ IDEA.
  User: mWroblewski
  Date: 21.04.2020
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>customer form</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/styles/main.css">
</head>
<body>

<header id="header">
    <div class="link_description">
        <h1>Customer form</h1>
    </div>
    <nav class="nav">

        <jsp:include page="/menu.jsp"/>

    </nav>



</header>

<main>

<form action="/customer/add" method="post">
    Name: <input type="text" name="name"/>
    <br/>
    Surname: <input type="text" name="surname"/>
    <br/>
    Cars_Quantity: <input type="number" name="cars_qty" min="1" />
    <br/>
    Tips: <input type="checkbox" name="tips"/>
    <br/>
    Rate: <input type="number" name="rate" min="1" max="10"/> <%--zmiennoprzecinkowe dzięki step--%>
    <br/>
    <input type="submit">
</form>
</main>
</body>
</html>
