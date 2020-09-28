/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Dell_OP
 */
@WebServlet("/ContadorvisitasServlet")
public class ContadorvisitasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        //Variable contador
        int contador = 0;
        //Revisar si ya existen la cookie conmtador visitas
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("contadorvisitas")) {
                    contador = Integer.parseInt(c.getValue());
                    break;
                }
            }
        }

        //incrementar en contador en 1
        contador++;
        Cookie c = new Cookie("contadorvisitas", Integer.toString(contador));
        //la cookie se almacenara en el cliente por una hora + 3600 segundos
        c.setMaxAge(3600);
        res.addCookie(c);

        //enviar eespiesta al navegador
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.print("Contador de visita por cada cleinte" + contador);
    }
}
