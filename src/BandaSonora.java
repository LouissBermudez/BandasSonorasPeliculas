import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BandaSonora {

    int idBandaSonora;
    private String pelicula;

    private String compositor;

    private int nMusicos;

    private int nCanciones;
    private int nCompositores;

    public BandaSonora(int idBandaSonora,String pelicula, int nMusicos, int nCanciones,int nCompositores, String compositor) {
        this.idBandaSonora = idBandaSonora;
        this.pelicula = pelicula;
        this.nMusicos = nMusicos;
        this.nCanciones = nCanciones;
        this.nCompositores = nCompositores;
        this.compositor = compositor;
    }


    /**
     *
     * @throws SQLException
     * @function
     * Este método se encarga de mostrar las Bandas Sonoras de cada película
     */
    public static void mostrarBandasSonoras() throws SQLException{
        System.out.println();
        System.out.print("Selecciona una película por su ID: ");
        System.out.println();
        int seleccion = Main.entrada.nextInt();
        String sql = "SELECT nombrePelicula, compositor, nMusicos, nCanciones FROM bandasonora WHERE idPelicula =" + seleccion;
        ResultSet resultSet = Main.sqlStatement.executeQuery(sql);
        if (resultSet.next()) {
            String pelicula = resultSet.getString("nombrePelicula");
            String compositor = resultSet.getString("compositor");
            int nMusicos = resultSet.getInt("nMusicos");
            int nCanciones = resultSet.getInt("nCanciones");
            System.out.printf("%-68s %s%n", "Banda sonora de la película seleccionada: ----->", pelicula);
            System.out.printf("%-68s %s%n", "Compositor de la Banda Sonora de la película seleccionada: ----->", compositor);
            System.out.printf("%-68s %d%n", "Número de músicos de la película seleccionada: ----->", nMusicos);
            System.out.printf("%-68s %d%n", "Número de canciones de la Banda Sonora de la película seleccionada:", nCanciones);
            System.out.print("¿Quieres mostrar las canciones de esta banda sonora? si/no: ");

            Main.entrada.nextLine();
            String sqlCanciones = "SELECT idBandaSonora, nombreCancion FROM canciones WHERE idBandaSonora = " + seleccion;
            String canciones = Main.entrada.nextLine();
            Cancion.mostrarCanciones(canciones, sqlCanciones);

        } else {
            System.out.println("No se encontró la película seleccionada.");
        }
    }

    public  void setBandaSonora (){
       try{
           String consulta = "INSERT INTO bandasonora  VALUES ('"+ idBandaSonora +"','"+ pelicula +"','" + nMusicos + "', '" + nCanciones +"','"+ nCompositores + "','" + idBandaSonora +"','"+ compositor + "')";
           Main.sqlStatement.executeUpdate(consulta);
       }catch (SQLException e){
           System.out.println("ID no valido");
       }
    }
    public static void actualizarnMusicos( int idBanda) throws SQLException{
        String sqlSelect = "SELECT nMusicos FROM bandasonora WHERE idPelicula = ?";
        PreparedStatement stmtSelect = connectionBD.conexion.prepareStatement(sqlSelect);
        stmtSelect.setInt(1, idBanda);
        ResultSet rs = stmtSelect.executeQuery();
        int nMusicos = 0;
        if (rs.next()) {
            nMusicos = rs.getInt("nMusicos");
        }

        String sqlUpdate = "UPDATE bandasonora SET nMusicos = ? WHERE idPelicula = ?";
        PreparedStatement stmtUpdate = connectionBD.conexion.prepareStatement(sqlUpdate);
        stmtUpdate.setInt(1, nMusicos + 1);
        stmtUpdate.setInt(2, idBanda);
        stmtUpdate.executeUpdate();
        stmtUpdate.close();
        rs.close();
    }


}
