package Servlets;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class SerGrafico extends HttpServlet {

    private XYDataset GenerarDatos(){
        XYSeriesCollection xyseriesCollection=new XYSeriesCollection();
        XYSeries serie1=new XYSeries("Atletas");
        try{
        String sql="select * from atleta";
        PreparedStatement pst=Conexion.Conecta.getconexion().prepareCall(sql);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
        serie1.add(rs.getInt(1),rs.getInt(5));
        xyseriesCollection.addSeries(serie1);
        }
        }catch(Exception e){
            System.out.println(e);
        }
        return xyseriesCollection;
    }
    
    private static JFreeChart GeneraGraficos(XYDataset xydataset1) {
        JFreeChart jfreechart=ChartFactory.createXYLineChart("Atletas por Tallas y Edad", "Edad","Talla", xydataset1, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot=(XYPlot)jfreechart.getPlot();
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setBackgroundPaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer xylineAndShapeRenderer =(XYLineAndShapeRenderer) xyplot.getRenderer();
        xylineAndShapeRenderer.setBaseLinesVisible(true);
        return jfreechart;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        //try (PrintWriter out = response.getWriter()) {
response.setContentType("image/jpeg");
OutputStream ot=response.getOutputStream();
XYDataset xy=GenerarDatos();
JFreeChart grafico=GeneraGraficos(xy);
ChartUtilities.writeChartAsJPEG(ot, grafico, 300, 400);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
