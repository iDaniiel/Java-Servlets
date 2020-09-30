<%-- Agrtegamos una declaracion de JSP --%>
<%!
    //declaramos una variable con su metodo get
    private String usuario = "Daniel";

    public String getUsuario() {
        return this.usuario;
    }

    //Declaramos un contador de visitas
    private int contadorCitas = 1;
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de declaraciones con JSPs</title>
    </head>
    <body>
        <h1>Uso de declaraciones con JSPs</h1>
        <br>
        Valor de usuario por medio del atributo : <%= this.usuario %>
        <br>
        Valor de usuario por metodo: <%= this.getUsuario() %>
        <br>
        Valor de variable contador visitas: <%= this.contadorCitas++ %>
    </body>
</html>
