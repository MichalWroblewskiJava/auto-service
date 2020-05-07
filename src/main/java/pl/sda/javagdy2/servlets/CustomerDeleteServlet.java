package pl.sda.javagdy2.servlets;


import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/delete")
public class CustomerDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identToDelete = req.getParameter("identToDelete");
        if (identToDelete == null || identToDelete.isEmpty()) {
            resp.sendRedirect(getServletContext().getContextPath()+"/customer/list");
            return;
        }

        Long id = Long.parseLong(req.getParameter("identToDelete"));
        EntityDao dao = new EntityDao();
        Customer customer = dao.getById(Customer.class, id);
        dao.delete(customer);
        resp.sendRedirect(getServletContext().getContextPath()+"/customer/list");
    }

}
