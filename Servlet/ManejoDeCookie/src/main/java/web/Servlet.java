package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //obtener arreglo de cookie
        Cookie[] cookies = req.getCookies();

        //Crear una variable nuevo usuario
        boolean nuevoUsuario = true;

        //v=buscar si exioste cookie creada con anteiodidad y esta cokkie se llama visitanterecurrente
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitanteRecurente") && c.getValue().equals("si")) {
                    nuevoUsuario=false;
                    break;
                }
            }
        }
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitantecookie = new Cookie("visitanteRecurente", "si");
            res.addCookie(visitantecookie);
            mensaje = "Gracias por visitar nbuestro sitio por primera vez";
        }else{
            mensaje = "Gracias por visitar nuevamente nuestro sitio";
            
        }
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.print("Mensaje " + mensaje);
        out.close();
    }
}
