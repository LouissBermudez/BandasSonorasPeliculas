import java.sql.*;

public class Peliculas {
    int idPelicula;
    String nombrePelicula;
    public Peliculas (int idPelicula, String nombrePelicula){
        this.idPelicula = idPelicula;
        this.nombrePelicula = nombrePelicula;
    }


public static String getPeliculas(){
        String sql = "SELECT * FROM peliculas";
                return sql;
}

public static void mostrarPeliculas ()throws SQLException {
    String mostrarDatos = getPeliculas();
    ResultSet resultSet = Main.sqlStatement.executeQuery(mostrarDatos);
    System.out.println("Datos de las Peliculas:");
    while (resultSet.next()) {
        int idPelicula = resultSet.getInt("idPelicula");
        String pelicula = resultSet.getString("nombrePelicula");
        System.out.println(idPelicula + ". " + pelicula);
    }
}
    public  void setPelicula() {
        try {
            String consulta = "INSERT INTO peliculas VALUES ('"+ idPelicula + "', '" + nombrePelicula + "')";
            Main.sqlStatement.executeUpdate(consulta);
        }catch (SQLException e){
            System.out.println("ID no valido");
        }

    }

public static void manejoErrores(){

}

}
