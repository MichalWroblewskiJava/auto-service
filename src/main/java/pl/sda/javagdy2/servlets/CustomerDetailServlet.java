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
        // jeśli identyfikator (parametr) nie został podany, to
        // przekierowujemy użytkownika na listę studentów
        if(identToEditString == null || identToEditString.isEmpty()){
            resp.sendRedirect("/customer/list");
            return;
        }
        // parsowanie identyfikatora na long.
        Long identToEdit = Long.parseLong(identToEditString);
        EntityDao dao = new EntityDao();
        Customer customer = dao.getById(Customer.class, identToEdit);
        // jeśli nie uda się odnaleźć takiego użytkownika
        if(customer == null){
            resp.sendRedirect("/customer/list");
            return;
        }
        // załadowanie studenta jako atrybutu żeby mieć możliwość
        // zaprezentowania wartości jego pól w widoku (jsp)
        req.setAttribute("customerDetails", customer);
        // wyświetlenie widoku
        req.getRequestDispatcher("/customer_detail.jsp").forward(req, resp);
    }
}
