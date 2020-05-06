package pl.sda.javagdy2.servlets;

import lombok.Builder;
import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Customer;
import pl.sda.javagdy2.database.model.CustomerOrder;
import pl.sda.javagdy2.database.model.Fault;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/edit")
public class OrderEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long customerOrderId = Long.parseLong(req.getParameter("orderId"));
            EntityDao dao = new EntityDao();
            CustomerOrder order = dao.getById(CustomerOrder.class, customerOrderId);
            req.setAttribute("orderToEdit", order);
            req.setAttribute("customer_identifier", order.getCustomer().getId());
            req.setAttribute("faults", Fault.values());
            req.setAttribute("car_plate", order.getCar_plate());
            req.setAttribute("paid", order.isPaid() );
            req.getRequestDispatcher("/order_form.jsp").forward(req, resp);
        } catch (NumberFormatException | NullPointerException ne) {
            resp.sendRedirect("/customer/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long editedGradeId = Long.parseLong(req.getParameter("editedOrder"));
            EntityDao dao = new EntityDao();
            CustomerOrder order = dao.getById(CustomerOrder.class, editedGradeId);
            Fault fault = Fault.valueOf(req.getParameter("fault"));
            order.setFault(fault);
            boolean paid = Boolean.parseBoolean(String.valueOf(req.getParameter("paid")));
            order.setPaid(paid);
            String car_plate = req.getParameter("car_plate");
            order.setCar_plate(car_plate);
            dao.saveOrUpdate(order);

            resp.sendRedirect("/customer/detail?identToEdit=" + order.getCustomer().getId());
        } catch (NumberFormatException | NullPointerException ne) {
            resp.sendRedirect("/customer/list");
        }
    }
}
