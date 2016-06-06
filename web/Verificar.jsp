<%@page import="Dao.Negocio"%>
<%@page import="Beans.Atleta"%>
<html>
    <body>
        <h2 align="center">¿Desea eliminar?</h2>

        <form action="Verificar.jsp" method="post">
            <%if(request.getParameter("cod")!=null){
                Atleta a = Negocio.AtletaXcodigo(Integer.parseInt(request.getParameter("cod")));
            %>
            <table align="center" border="1">
                <tr><td>CODIGO:</td><td><input name="caja1" value="<%=a.getCod_atl()%>" readonly ></td></tr>
                <tr><td>NOMBRE:</td><td><input name="caja2" value="<%=a.getNom_atl()%>" readonly></td></tr>
                <tr><td>DNI:</td><td><input name="caja3" value="<%=a.getDni_atl()%>" readonly></td></tr>
                <tr><td>SEXO:</td><td><input name="caja4" value="<%=a.getSex_atl()%>" readonly></td></tr>
                <tr><td>EDAD:</td><td><input name="caja5" value="<%=a.getEda_atl()%>" readonly></td></tr>
                <tr><td>TALLA:</td><td><input name="caja6" value="<%=a.getTalla()%>" readonly></td></tr>
                <tr><td colspan="2" align="right"><button type="submit" />SI</td><td><a href="Eliminar.jsp"><input value="NO" type="button" /></a></td></tr>
                <%}%>
            </table>
        </form>
        <%
            if (request.getParameter("caja1") != null && request.getParameter("caja2") != null && request.getParameter("caja3") != null
                    && request.getParameter("caja4") != null && request.getParameter("caja5") != null && request.getParameter("caja6") != null) {
                Atleta at = new Atleta();
                        at.setCod_atl(Integer.parseInt(request.getParameter("caja1")));

                boolean rpta = Negocio.EliminarAtleta(at);
                if (rpta == true) {
                    response.sendRedirect("Mensaje.jsp?men=Atleta fue eliminado.");
                } else {
                    response.sendRedirect("Mensaje.jsp?men=Ocurrio un error.");
                }
            }
        %>
    </body>
</html>
