package Dao;

import Beans.Atleta;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Negocio {
    public static void main(String[] args) {
        //EjecutarReporte(Double.parseDouble("1.67"));
        Atleta a=new Atleta();
        a.setTalla(Double.parseDouble("1.68"));
       EjecutarReporte(a);
    }
    
    
    public  static List<Atleta> LisAtl(){
    List<Atleta> lista=new ArrayList();
    String sql="select * from Atleta";
    try{
     PreparedStatement st=Conexion.Conecta.getconexion().prepareStatement(sql);
    ResultSet rs=st.executeQuery();
    while(rs.next()){
        Atleta obj=new Atleta();
       obj.setCod_atl(rs.getInt(1));
       obj.setNom_atl(rs.getString(2));
       obj.setDni_atl(rs.getInt(3));
       obj.setSex_atl(rs.getString(4));
       obj.setEda_atl(rs.getInt(5));
       obj.setTalla(rs.getInt(6));
       lista.add(obj);
    }
    }catch(Exception e){
        
        e.printStackTrace();
    }
    return lista;
}

    
    
    
    
    
    
    
    public static List<Atleta>ListarTodo(){
        List<Atleta>lista=new ArrayList();
        try {
            CallableStatement cst=Conexion.Conecta.getconexion().prepareCall("{call sp_listartodo()}");
            ResultSet rs=cst.executeQuery();
            while(rs.next()){
                Atleta a=new Atleta(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getDouble(6));
                lista.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public static boolean EjecutarReporte(Atleta t) {
        
       try{
            String archivo = "E:\\Misreportes\\AtletasXtalla.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObject(archivo);
            Map parametro = new HashMap();
            parametro.put("talla", t.getTalla());
            JasperPrint jp = JasperFillManager.fillReport(reporte, parametro, Conexion.Conecta.getconexion());
            JasperViewer visor = new JasperViewer(jp, false);
            visor.setTitle("Atletas por Talla");
            visor.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
       return true;
    }

    public static boolean EliminarAtleta(Atleta cod) {
        boolean rpta = false;
        try {
            CallableStatement cst = Conexion.Conecta.getconexion().prepareCall("{call sp_eliminaratleta(?)}");
            cst.setInt(1, cod.getCod_atl());
            int i = cst.executeUpdate();
            if (i == 1) {
                rpta = true;
            } else {
                rpta = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rpta;
    }

    public static List<Atleta> ListarAtletaXtalla(double c) {
        List<Atleta> lista = new ArrayList();
        try {
            CallableStatement cst = Conexion.Conecta.getconexion().prepareCall("{call sp_atletaXtalla(?)}");
            cst.setDouble(1, c);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                Atleta a = new Atleta(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
                lista.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, lista);
        }
        return lista;
    }

    public static Atleta AtletaXcodigo(int at) {
        Atleta a = new Atleta();
        try {
            CallableStatement cst = Conexion.Conecta.getconexion().prepareCall("{call sp_atletaXcodigo(?)}");
            cst.setInt(1, at);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                a.setCod_atl(rs.getInt(1));
                a.setNom_atl(rs.getString(2));
                a.setDni_atl(rs.getInt(3));
                a.setSex_atl(rs.getString(4));
                a.setEda_atl(rs.getInt(5));
                a.setTalla(rs.getDouble(6));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return a;
    }

    public static List<Atleta> ListarAtleta() {
        List<Atleta> Lista = new ArrayList();
        try {
            CallableStatement cst = Conexion.Conecta.getconexion().prepareCall("{call sp_listaratleta()}");
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                Atleta a = new Atleta(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getDouble(6));
                Lista.add(a);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return Lista;
    }

    public static boolean RegistrarAtleta(Atleta a) {
        boolean rpta = false;
        try {
            CallableStatement cst = Conexion.Conecta.getconexion().prepareCall("{call sp_grabaratleta(?,?,?,?,?)}");
            cst.setString(1, a.getNom_atl());
            cst.setInt(2, a.getDni_atl());
            cst.setString(3, a.getSex_atl());
            cst.setInt(4, a.getEda_atl());
            cst.setDouble(5, a.getTalla());
            int i = cst.executeUpdate();
            if (i == 1) {
                rpta = true;
            } else {
                rpta = false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rpta;
    }
}
