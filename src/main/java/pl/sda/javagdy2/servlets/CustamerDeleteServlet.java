package pl.sda.javagdy2.servlets;


import pl.sda.javagdy2.database.EntityDao;
import pl.sda.javagdy2.database.model.Custamer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/custamer/delete")
public class CustamerDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identToDelete = req.getParameter("identToDelete");
        if (identToDelete == null || identToDelete.isEmpty()) {
            resp.sendRedirect("/custamer/list");
            return;
        }

        Long id = Long.parseLong(req.getParameter("identToDelete"));
        EntityDao dao = new EntityDao();
        Custamer student = dao.getById(Custamer.class, id);
        dao.delete(student);
        resp.sendRedirect("/custamer/list");
    }

}
