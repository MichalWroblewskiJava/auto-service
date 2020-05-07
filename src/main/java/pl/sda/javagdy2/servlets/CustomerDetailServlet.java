package pl.sda.javagdy2.servlets;

import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/customer/detail")
public class CustomerDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identToEditString = req.getParameter("identToEdit");

        if(identToEditString == null || identToEditString.isEmpty()){
            resp.sendRedirect(getServletContext().getContextPath()+"/customer/list");
            return;
        }

        Long identToEdit = Long.parseLong(identToEditString);
        EntityDao dao = new EntityDao();
        Customer customer = dao.getById(Customer.class, identToEdit);

        if(customer == null){
            resp.sendRedirect(getServletContext().getContextPath()+"/customer/list");
            return;
        }

        req.setAttribute("customerDetails", customer);

        req.getRequestDispatcher("/customer_detail.jsp").forward(req, resp);
    }
}
