package pl.sda.javagdy2.servlets;


import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Custamer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/custamer/add")
public class CustamerAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/custamer_form.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Custamer custamer = Custamer.builder()
                .name(req.getParameter("name"))
                .surname(req.getParameter("surname"))
                .cars_qty(Integer.parseInt(req.getParameter("cars_qty")))
                /* jeśli pełnoletni jest zaznaczone, to przyjmuje wartość "on" - text/String/on */
                .tips(req.getParameter("tips") != null)
                .rate(Integer.parseInt(req.getParameter("rate")))
                .build();
        EntityDao dao = new EntityDao();
        dao.saveOrUpdate(custamer);
        resp.sendRedirect("/custamer/list");
    }

}
