package Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conecta {
    public static void main(String[] args) {
        getconexion();
    }
    public static Connection getconexion(){
        Connection cn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Prueba;user=RENZO;password=RENZO;");
            if(cn!=null){
                System.out.println("Conexion exitosa.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return cn;
    }
}
