
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--dzięki lini poniżej możliwe jest wykonywanie dyrektyw z użyciem zmiennych adresując je przez ${}--%>
<%@ page isELIgnored="false" %>
<ul class="nav_list">
    <li class="nav_item">
        <a class="nav_link" href="${pageContext.request.contextPath}/index.jsp">Home page</a>
    </li>
    <li class="nav_item">
        <a class="nav_link" href="${pageContext.request.contextPath}/customer/add">Customer form</a>
    </li>
    <li class="nav_item">
        <a class="nav_link" href="${pageContext.request.contextPath}/customer/list">Customer list</a>
    </li>
</ul>
<%--<table>--%>
<%--    <tr>--%>
<%--        <td>--%>
<%--            <a href="index.jsp">Home page</a>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>--%>
<%--            <a href="customer_form.jsp">Customer form</a>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>--%>
<%--            <a href="customer_list.jsp">Customer list</a>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--</table>--%>