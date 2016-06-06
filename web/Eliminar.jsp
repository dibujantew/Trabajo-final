<%@page import="Dao.Negocio"%>
<%@page import="Beans.Atleta"%>
<html>
    <body>
        <table align="center" width="600" border="1">
            <th>CODIGO</th> 
            <th>NOMBRE</th> 
            <th>DNI</th> 
            <th>SEXO</th> 
            <th>EDAD</th> 
            <th>TALLA</th>
            <th>Select</th>
            <%
                for(Atleta a:Negocio.ListarAtleta()){
            %>
            <tr>
            <td><%=a.getCod_atl() %></td>
            <td><%=a.getNom_atl() %></td>
            <td><%=a.getDni_atl() %></td>
            <td><%=a.getSex_atl() %></td>
            <td><%=a.getEda_atl() %></td>
            <td><%=a.getTalla() %></td>
            <td><a href="Verificar.jsp?cod=<%=a.getCod_atl() %>">Select</a></td>
            </tr>
            <%
            }
            %>
           </table>
    </body>
</html>
