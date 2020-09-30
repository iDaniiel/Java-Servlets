<%@page errorPage="/WEB-INF/ManejoErrores.jsp" %>%>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>%>
<%
    String nombreArchivo = "Reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de excel</title>
    </head>
    <body>
        <h1>El cabecero de Reporte de Excel</h1>
        <br />
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis basica de JAVA</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
            <tr>
                <td>2. Programacion con JAVA</td>
                <td>Pondremos en practica conceptos de la programacion orientada a objetos</td>
                <td><%= Conversiones.format(new Date())%></td>
            </tr>
        </table>
    </body>
</html>
