<%@page import="Dao.Negocio"%>
<%@page import="Beans.Atleta"%>
<html>
    <body>
        <form action="Pagina.jsp" method="post">
            <table align="center" bgcolor="lightgreen" width="180">
                <tr><th align="left">NOMBRE</th>
                <tr><td><input name="caja1" type="text"></td></tr>
                <th align="left">DNI</th>
                <tr><td><input name="caja2" type="text"></td></tr>
                <th align="left">SEXO</th>
                <tr><td><input name="caja3" type="text"></td></tr>
                <th align="left">EDAD</th>
                <tr><td><input name="caja4" type="number"></td></tr>
                <th align="left">TALLA</th>
                <tr><td><input name="caja5" ></td></tr>
                <tr><td colspan="2" align="center"><button type="submit" />Guardar</td></tr>
            </table><br><br>
            <table align="center"><tr><td><a href="Eliminar.jsp">Eliminar</a></td></tr>
                <td><a href="Reporte.jsp">Reporte</a></td>
                <td><a href="ListarTodo.jsp">Paginacion</a></td>
            </table>
            
        </form>

        <%
            if (request.getParameter("caja1") != null && request.getParameter("caja2") != null && request.getParameter("caja3") != null
                    && request.getParameter("caja4") != null && request.getParameter("caja5") != null) {
                Atleta a=new Atleta();
                a.setNom_atl(request.getParameter("caja1"));
                 a.setDni_atl(Integer.parseInt(request.getParameter("caja2")));
                  a.setSex_atl(request.getParameter("caja3"));
                   a.setEda_atl(Integer.parseInt(request.getParameter("caja4")));
                    a.setTalla(Double.parseDouble(request.getParameter("caja5")));
                   boolean rpta=Negocio.RegistrarAtleta(a);
                   if(rpta==true){
                       response.sendRedirect("Mensaje.jsp?men=Atleta fue agregado.");
                   }else{
                       response.sendRedirect("Mensaje.jsp?men=Ocurrio un error.");
                   }
            }
        %>
    </body>
</html>
