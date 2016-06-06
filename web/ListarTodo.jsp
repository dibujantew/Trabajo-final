
<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.Negocio"%>
<%@page import="Beans.Atleta"%>
<%@ taglib uri="http://displaytag.sf.net"  prefix="display" %>
<html>
    <head>
        <style type="text/css" >
            .pagination{list-style: none; margin: 0px;padding: 0px}
            .pagination li{float: left; margin: 3px}
            .pagination li a{display: block; padding: 3px 5px; color: #fff; background-color: #44b0dd; text-decoration: none}
        </style>

        <script type="text/javascript" src="http://c.fzilla.com/1286136086-jquery.js"></script>
        <script type="text/javascript" src="http://c.fzilla.com/1291523190-jpaginate.js"></script>

        <!--<script align="center">
            $(document).ready(function () {
                $("#tabla").jPaginate({items: 4});

            });

            /*$('#tabla').jqPagination({
             paged: function(page) {
             // do something with the page variable
             }
             });*/
        </script>-->
    </head>
    <body>
              
            
             <%
        List lista=new ArrayList();
        lista=Negocio.LisAtl();

        request.setAttribute("listado", lista);

        %>
        <center>
            <font  face="arial" size="5" color="red"> LISTADO TABLA CUSTOMERS</font><br>
            <br>
            <br>
            <display:table name="requestScope.listado" id="tabla1" pagesize="5" export="true"
                           style="border:'0';padding:'4'" width="40%">
                <display:column property="cod_atl"
                               title="cod_atl" paramId="id"
                               sortable="true" headerClass="sortable"
                               href="BusquedaPorMapa1.jsp" style="background-color:#DDDDDD;width:200px">
                  </display:column>
                <display:column property="nom_atl"
                               title="nom_atl" style="background-color:#DDDDDD;width:200px">
                  </display:column>
                <display:column property="dni_atl"
                               title="dni_atl" style="background-color:#DDDDDD;width:200px">
                  </display:column>
                  <display:column property="sex_atl"
                               title="Contacto" style="background-color:#DDDDDD;width:200px">
                  </display:column>
                      <display:column property="eda_atl"
                               title="eda_atl" style="background-color:#DDDDDD;width:200px">
                  </display:column>
                      <display:column property="talla"
                               title="talla" style="background-color:#DDDDDD;width:200px">
                  </display:column>

              </display:table>
        </center>

    </body>
</html>
