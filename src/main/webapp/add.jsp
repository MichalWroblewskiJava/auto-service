<%@ page import="pl.sda.javagdy2.database.model.Custamer" %>
<%@ page import="pl.sda.javagdy2.database.EntityDao" %><%--
  Created by IntelliJ IDEA.
  User: mWroblewski
  Date: 19.04.2020
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<!-- cokolwiek wpiszemy nie bedzie wyswieltone jest to tylko strona przejsciowa-->

<%
    /*TODO: stworzyć warunek sprawdzający czy któreś pole nie jest puste.
       Jeśli użytkownik nie wypełnił któregoś pola, to w ogóle nie wykonujemy tych
       czynnośi poniżej, tylko od razu przechodzimy do "response.sendRedirect..." */
    Custamer custamer = Custamer.builder()
            .name(request.getParameter("name"))
            .surname(request.getParameter("surname"))
            .cars_qty(Integer.parseInt(request.getParameter("cars_qty")))
            /* jeśli pełnoletni jest zaznaczone, to przyjmuje wartość "on" - text/String/on */
            .tips(request.getParameter("tips") != null)
            .rate(Integer.parseInt(request.getParameter("rate")))
            .build();
    EntityDao dao = new EntityDao();
    dao.saveOrUpdate(custamer);
    response.sendRedirect("custamer_list.jsp");
%>




</body>
</html>