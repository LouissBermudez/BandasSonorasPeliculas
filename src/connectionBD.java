import java.sql.*;

public class connectionBD {
    static Connection conexion;

    public connectionBD(String url, String usuario, String contraseña ) throws SQLException{
        conexion = DriverManager.getConnection(url, usuario, contraseña);
    }
    public static connectionBD conexion () throws SQLException{
        String url = "jdbc:mysql://localhost:3306/bandasonorapeliculas";
        String usuario = "root";
        String password = "LAScacas12321@";
        connectionBD conex = new connectionBD(url, usuario, password) ;
        return conex;
    }
    public  Statement mostrarDatos()throws SQLException{
        Statement sqlStatement = conexion.createStatement();
        return sqlStatement;
    }
    public static void cerrarConexion() throws SQLException{
        conexion.close();
    }


}
