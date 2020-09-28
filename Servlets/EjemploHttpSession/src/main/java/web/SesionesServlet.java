
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = req.getSession();
        String titulo = null;
        
        //pedir el atyributo contador visitas a la sesion
        Integer contadorvisitas = (Integer)sesion.getAttribute("contadorvisitas");
        if(contadorvisitas == null){
            contadorvisitas = 1;
            titulo = "Bienvenido por primera ves";
        }else{
            
         contadorvisitas++;
         titulo = "Bienvenido nuevamente";
        }
        sesion.setAttribute("contadorvisitas", contadorvisitas);
        PrintWriter out = res.getWriter();
        out.print(titulo);
        out.print("<br>");
        out.print("no. de accesos al recurso " + contadorvisitas);
        out.print("<br>");
        out.print("Id de session " + sesion.getId());
        out.close();
        
    }
}
