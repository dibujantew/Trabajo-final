<%@page import="javax.swing.JOptionPane"%>
<%@page import="Dao.Negocio"%>
<%@page import="Beans.Atleta"%>

<html>
      <body>
        <form action="Reporte.jsp" method="post" >
                <table align="center">
                    <tr><td>Ing. talla:</td><td> <input name="ttalla"></td><td><input type="submit" value="Consultar"></td></tr>
            </table>
            </form>
        <br>
                 <form action="GeneradorReporte" method="get">
    <tr><table align="center">
        <tr><td><input type="hidden" name="ac" value="<%=request.getParameter("ttalla") %>">
               
        <tr><td><input type="submit"  value="Gerenerar reporte">
    </td></tr>
    </table>

       </form>
        <table align="center" width="550">
            <th>CODIGO</th>
              <th>NOMBRE</th>
                <th>DNI</th>
                  <th>TALLA</th>
            <%
            if(request.getParameter("ttalla")!=null){
                for(Atleta a: Negocio.ListarAtletaXtalla(Double.parseDouble(request.getParameter("ttalla")))){
              %>
            <tr><th><%=a.getCod_atl() %></th><th><%=a.getNom_atl() %></th><th><%=a.getDni_atl() %></th><th><%=a.getTalla()%></th></tr>
            <%}}%>
            
        </table>
   
     </body>
 
</html>
