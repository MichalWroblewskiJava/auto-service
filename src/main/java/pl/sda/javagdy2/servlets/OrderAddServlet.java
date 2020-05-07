package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Customer;
import pl.sda.javagdy2.database.model.Fault;
import pl.sda.javagdy2.database.model.CustomerOrder;

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
        if (customerId == null || customerId.isEmpty()) {
            resp.sendRedirect(getServletContext().getContextPath()+"/customer/list");
            return;
        }
        req.setAttribute("customer_identifier", customerId);
        req.setAttribute("faults", Fault.values());
        req.getRequestDispatcher("/order_form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String faultString = req.getParameter("fault");
//        String plateString = req.getParameter("car_plate");
//        boolean paid = req.getParameter("paid") !=null;

//        if(plateString==null||faultString==null||plateString.isEmpty()|| faultString.isEmpty()){
//            resp.sendRedirect("/customer/list");// sparwdzanie dlaczego przenosi do listy klientów
//            return;
//        }

//        Fault faultOrder = Fault.valueOf(faultString);
//        Order order = new Order(faultOrder,plateString,paid);
        EntityDao dao = new EntityDao();
        String customerId = req.getParameter("customerOrderID");
        Long customerIdLong= Long.parseLong(customerId);
        CustomerOrder order = CustomerOrder.builder()
                .fault(Fault.valueOf(req.getParameter("fault")))
                .car_plate(req.getParameter("car_plate"))
                .paid(req.getParameter("paid") !=null)
                .customer(dao.getById(Customer.class,customerIdLong))
                .build();



//        if(customerId==null || customerId.isEmpty()){
//            resp.sendRedirect("/customer/list");
//            return;
//        }



        //Customer customer = dao.getById(Customer.class,customerIdLong);
        //order.setCustomer(customer);
        dao.saveOrUpdate(order);
        resp.sendRedirect(getServletContext().getContextPath()+"/customer/detail?identToEdit="+customerId);




    }
}
