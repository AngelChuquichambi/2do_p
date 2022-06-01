package com.emergentes.controladores;

import com.emergentes.dao.DAOseminarios;
import com.emergentes.dao.IDseminario;
import com.emergentes.modelo.seminarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controlador_seminarios", urlPatterns = {"/controlador_seminarios"})
public class controlador_seminarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            seminarios sem = new seminarios();
            int id;
            DAOseminarios dao = new IDseminario();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "mostrar";

            switch (action) {
                case "nuevo":
                    request.setAttribute("seminarios", sem);
                    request.getRequestDispatcher("frm_seminarios.jsp").forward(request, response);
                    break;
                case "actualizar":
                    id = Integer.parseInt(request.getParameter("id"));
                    sem = dao.getById(id);
                    request.setAttribute("seminarios", sem);
                    request.getRequestDispatcher("frm_seminarios.jsp").forward(request, response);
                    break;
                case "sliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("controlador_seminarios");
                    break;
                case "mostrar":
                    List<seminarios> lista = dao.getAll();
                    request.setAttribute("seminario", lista);
                    request.getRequestDispatcher("index_seminarios.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("ERROR AL " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fecha");
        int cupo = Integer.parseInt(request.getParameter("cupo"));

        seminarios sem = new seminarios();

        sem.setId(id);
        sem.setTitulo(titulo);
        sem.setFecha(fecha);
        sem.setCupo(cupo);

        if (id == 0) {
            try {
                DAOseminarios dao = new IDseminario();
                dao.insert(sem);
                response.sendRedirect("controlador_seminarios");

            } catch (Exception ex) {
                System.out.println("ERROR AL INTRODUCIR UN NUEVO REGISRO" + ex.getMessage());
            }
        } else {
            try {
                DAOseminarios dao = new IDseminario();
                dao.update(sem);
                response.sendRedirect("controlador_seminarios");

            } catch (Exception ex) {
                System.out.println("ERROR AL EDITAR EL REGISTRO" + ex.getMessage());
            }
        }
        response.sendRedirect("controlador_seminarios");

    }
}
