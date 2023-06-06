import java.sql.ResultSet;
import java.sql.SQLException;

public class Musico extends Persona{
    int idMusico;
    int idBandaSonora;
    public Musico (int idMusico, String nombre, String apellido, int idBandaSonora){
        super(nombre, apellido);
        this.idMusico = idMusico;
        this.idBandaSonora = idBandaSonora;
    }


    public static String sqlStatement(){
        String sql = "SELECT * FROM musicos";
        return sql;
    }

    public static void mostrarMusicos () throws SQLException {
        ResultSet rs = Main.sqlStatement.executeQuery(sqlStatement());
        while (rs.next()){
            int idMusico = rs.getInt("idMusico");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int idBandaSonora = rs.getInt("idBandaSonora");
            System.out.println("ID del músico: " + idMusico);
            System.out.println("ID de la banda sonora: " + idBandaSonora );
            System.out.println("Nombre del músico: " + nombre);
            System.out.println("Apellido del músico: " + apellido);
            System.out.println("---------------------------------------------");
        }
    }

    public void setMusico()  {
        try {
            String consulta = "INSERT INTO musicos VALUES ('"+ idMusico + "', '" + nombre + "','" + apellido +"','"+ idBandaSonora+"')";
            Main.sqlStatement.executeUpdate(consulta);
        }catch (SQLException e){
            System.out.println("ID no valido");
        }
    }
}
