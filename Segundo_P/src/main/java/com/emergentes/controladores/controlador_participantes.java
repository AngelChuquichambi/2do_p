package com.emergentes.controladores;

import com.emergentes.dao.DAOparticipantes;
import com.emergentes.dao.ID_participantes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.emergentes.modelo.participantes;
import java.util.List;

@WebServlet(name = "controlador_participantes", urlPatterns = {"/controlador_participantes"})
public class controlador_participantes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            participantes par = new participantes();
            int id;
            DAOparticipantes dao = new ID_participantes();

            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "mostrar";

            switch (action) {
                case "nuevo":
                    request.setAttribute("participantes", par);
                    request.getRequestDispatcher("frm_participantes.jsp").forward(request, response);
                    break;
                case "actualizar":
                    id = Integer.parseInt(request.getParameter("id"));
                    par = dao.getById(id);
                    request.setAttribute("participantes", par);
                    request.getRequestDispatcher("frm_participantes.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("controlador_participantes");
                    break;
                case "mostrar":
                    List<participantes> lista = dao.getAll();
                    request.setAttribute("participante", lista);
                    request.getRequestDispatcher("index_participantes.jsp").forward(request, response);
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
        String apellidos = request.getParameter("apellidos");
        String nombres = request.getParameter("nombres");
        int id_seminario = Integer.parseInt(request.getParameter("seminario"));
        int confirmado = Integer.parseInt(request.getParameter("confirmado"));

        participantes par = new participantes();

        par.setId(id);
        par.setApellidos(apellidos);
        par.setNombres(nombres);
        par.setId_seminario(id_seminario);
        par.setConfirmado(confirmado);

        if (id == 0) {
            try {
                DAOparticipantes dao = new ID_participantes();
                dao.insert(par);
                response.sendRedirect("controlador_participantes");

            } catch (Exception ex) {
                System.out.println("ERROR AL INTRODUCIR UN NUEVO REGISRO" + ex.getMessage());
            }
        } else {
            DAOparticipantes dao = new ID_participantes();
            try {
                dao.update(par);
                response.sendRedirect("controlador_participantes");

            } catch (Exception ex) {
                System.out.println("ERROR AL EDITAR EL REGISTRO" + ex.getMessage());
            }
        }
        response.sendRedirect("controlador_participantes");
    }

}
