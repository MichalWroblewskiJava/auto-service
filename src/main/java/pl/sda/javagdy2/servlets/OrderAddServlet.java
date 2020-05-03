package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Customer;
import pl.sda.javagdy2.database.model.Fault;
import pl.sda.javagdy2.database.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/add")
public class OrderAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String customerId = req.getParameter("customerId");
       if(customerId==null || customerId.isEmpty()){
           resp.sendRedirect("/customer/list");
           return;
       }
       req.setAttribute("customer_identifier",customerId);
       req.setAttribute("orders", Fault.values());
       req.getRequestDispatcher("/order_form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String faultString = req.getParameter("fault");
        String plateString = req.getParameter("car_plate");
        String paidString = req.getParameter("paid");
        if(plateString==null||faultString==null||plateString.isEmpty()|| faultString.isEmpty()){
            resp.sendRedirect("/customer/list");// sparwdzanie dlaczego przenosi do listy klientów
            return;
        }

        Fault faultOrder = Fault.valueOf(faultString);
        boolean paid = Boolean.parseBoolean(paidString);
        Order order = new Order(faultOrder,plateString,paid);
        String customerId = req.getParameter("customerOrderID");
        if(customerId==null || customerId.isEmpty()){
            resp.sendRedirect("/customer/list");
            return;
        }
        Long customerIdLong= Long.parseLong(customerId);
        EntityDao dao = new EntityDao();
        Customer customer = dao.getById(Customer.class,customerIdLong);
        order.setCustomer(customer);
        dao.saveOrUpdate(order);
        resp.sendRedirect("/customer/detail?identToEdit="+customerId);
    }
}
