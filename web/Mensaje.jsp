
<html>
    <body>
        <h3 align="center">
            <%
            if(request.getParameter("men")!=null){
                out.println(request.getParameter("men"));
            }
            %>
        </h3>
        <h4 align="center"><a href="Pagina.jsp">Atras</a></h4>
    </body>
</html>
