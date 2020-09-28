package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html; charset=UTF-8");

        //Recuperamos el objeto httpsession
        HttpSession sesion = req.getSession();

        //Recuperar la lista de articlos si ya existe
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        String articuloNuevo = req.getParameter("articulo");

        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }

            PrintWriter out = res.getWriter();
            out.print("<h1>Lista de articulos</h1>");
            out.print("<br>");
            //iteramos todos los articluso
            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");
            }

            out.print("<br >");
            out.print("<a href='/EjemploCarritoCompras'>Regresar al inicio</a>");
            out.close();      
        
    }
}
