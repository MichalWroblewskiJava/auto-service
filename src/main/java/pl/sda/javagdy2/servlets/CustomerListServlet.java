package pl.sda.javagdy2.servlets;


import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet("/customer/list")
public class CustomerListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityDao dao = new EntityDao();
        List<Customer> lista = dao.list(Customer.class);


        lista.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
//                return o1.getId().compareTo(o2.getId());
                return Long.compare(o1.getId(), o2.getId());
            }
        });
        req.setAttribute("customers",lista);

        RequestDispatcher dispatcher= req.getRequestDispatcher("/customer_list.jsp");
        dispatcher.forward(req,resp);
    }
}
