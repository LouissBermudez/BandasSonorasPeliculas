import java.sql.*;
import java.util.Scanner;

public class Cancion {
    int idCancion;
    int idBandaSonora;
    String nombreCancion;
    public Cancion(int idCancion, int idBandaSonora, String nombreCancion){
        this.idCancion = idCancion;
        this.idBandaSonora = idBandaSonora;
        this. nombreCancion = nombreCancion;
    }

    public static void mostrarCanciones(String canciones, String sqlCanciones) throws SQLException{
        if (canciones.equals("si")){
            ResultSet rs = Main.sqlStatement.executeQuery(sqlCanciones);
            System.out.println("ID Banda Sonora" + " | "+ "Nombre de la canción");
            while (rs.next()){
                int idBandaSonora = rs.getInt("idBandaSonora");
                String nombreCancion = rs.getString("nombreCancion");
                System.out.println("       " + idBandaSonora  + "          " + nombreCancion);
            }
        }
    }

    public void setCanciones () {
        try {
            String consulta = "INSERT INTO canciones VALUES ('"+ idCancion + "', '" + idBandaSonora + "','"+ nombreCancion + "')";
            Main.sqlStatement.executeUpdate(consulta);
        }catch (SQLException e){
            System.out.println("ID no Valido");
        }




    }


}
