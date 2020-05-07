package pl.sda.javagdy2.servlets;

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

@WebServlet("/customer/edit")
public class CustomerEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long customerEditId = Long.parseLong(req.getParameter("customerEditId"));
            EntityDao dao = new EntityDao();
            Customer customer = dao.getById(Customer.class, customerEditId);
            req.setAttribute("customerToEdit", customer);
            req.setAttribute("name", customer.getName());
            req.setAttribute("surname", customer.getSurname());
            req.setAttribute("cars_qty", customer.getCars_qty());
            req.setAttribute("tips", customer.isTips());
            req.setAttribute("rate", customer.getRate());
            req.getRequestDispatcher("/customer_form.jsp").forward(req, resp);
        } catch (NumberFormatException | NullPointerException ne) {
            resp.sendRedirect(getServletContext().getContextPath()+"/customer/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long editedCustomerId = Long.parseLong(req.getParameter("editedCustomer"));
            EntityDao dao = new EntityDao();
            Customer customer = dao.getById(Customer.class, editedCustomerId);

            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            Integer cars_qty = Integer.parseInt(req.getParameter("cars_qty"));
            boolean tips = Boolean.parseBoolean(req.getParameter("tips"));
            Integer rate = Integer.parseInt(req.getParameter("rate"));

            customer.setName(name);
            customer.setSurname(surname);
            customer.setCars_qty(cars_qty);
            customer.setTips(tips);
            customer.setRate(rate);
            dao.saveOrUpdate(customer);

            resp.sendRedirect(getServletContext().getContextPath()+"/customer/detail?identToEdit=" + customer.getId());
        } catch (NumberFormatException | NullPointerException ne) {
            resp.sendRedirect(getServletContext().getContextPath()+"/customer/list");
        }
    }


}
