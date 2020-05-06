package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.CustomerOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/remove")
public class OrderRemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerOrderId = req.getParameter("orderId");
        if (customerOrderId == null || customerOrderId.isEmpty()) {
            resp.sendRedirect("customer/list");
            return;
        }
        Long orderIdLong = Long.parseLong(customerOrderId);
        EntityDao dao = new EntityDao();
        CustomerOrder order = dao.getById(CustomerOrder.class, orderIdLong);
        if (order == null) {
            resp.sendRedirect("customer/list");
            return;
        }
        dao.delete(order);
        resp.sendRedirect("/customer/detail?identToEdit=" + order.getCustomer().getId());
    }
}
