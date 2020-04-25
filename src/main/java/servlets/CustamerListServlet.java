package servlets;


import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Custamer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/custamer/list")
public class CustamerListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityDao dao = new EntityDao();
        List<Custamer> lista = dao.list(Custamer.class);
        req.setAttribute("custamers",lista);

        RequestDispatcher dispatcher= req.getRequestDispatcher("/custamer_list.jsp");
        dispatcher.forward(req,resp);
    }
}
