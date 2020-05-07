package pl.sda.javagdy2.servlets;


import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/add")
public class CustomerAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerId = req.getParameter("customerId");
        if (customerId == null || customerId.isEmpty()) {
            req.getRequestDispatcher("/customer_form.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("customer_EditId", customerId);
        req.getRequestDispatcher("/customer_form.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = Customer.builder()
                .name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .cars_qty(Integer.parseInt(req.getParameter("cars_qty")))
                /* jeśli pełnoletni jest zaznaczone, to przyjmuje wartość "on" - text/String/on */
                .tips(req.getParameter("tips") != null)
                .rate(Integer.parseInt(req.getParameter("rate")))
                .build();
        EntityDao dao = new EntityDao();
        dao.saveOrUpdate(customer);
        resp.sendRedirect(getServletContext().getContextPath()+"/customer/list");
    }

}
