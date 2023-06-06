import java.sql.*;
import java.util.Scanner;
public class Main {

    static Statement sqlStatement;
    static connectionBD bd;
    static {
        try {
            bd = connectionBD.conexion();
            sqlStatement = bd.mostrarDatos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws SQLException{
        mostrarMenu();
    }


    /**
     *
     * @throws SQLException
     * @function
     * Este método se encarga de mostrar el menu
     */
    public static void mostrarMenu() throws SQLException {
        int opcion;
        do{
            System.out.println("Bienvenido");
            System.out.println("---------------------------------------");
            System.out.println("                 MENU                  ");
            System.out.println("---------------------------------------");
            System.out.println("0. Inserte 0 si deseea salir");
            System.out.println("1. Mostrar Peliculas");
            System.out.println("2. Mostrar Músicos ");
            System.out.println("3. Insertar Datos ");
            System.out.print("Qué quieres hacer?: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("Te has desconectado con exito");
                    connectionBD.cerrarConexion();
                    break;
                case 1:
                    Peliculas.mostrarPeliculas();
                    BandaSonora.mostrarBandasSonoras();
                    System.out.println();
                    break;
                case 2:
                    Musico.mostrarMusicos();
                    break;
                case 3:
                    System.out.println("-----------------------------");
                    System.out.println("        INSERCIÓN DATOS      ");
                    System.out.println("-----------------------------");
                    System.out.println("1. Insertar Película");
                    System.out.println("2. Insertar canciones");
                    System.out.println("3. Insertar Músicos");
                    System.out.print("Que deseas hacer?: ");
                    int option = entrada.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Inserte el ID de la Película");
                            int idPelicula = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Inserte el nombre de la película a la que pertenece");
                            String nombrePelicula = entrada.nextLine();
                            Peliculas pelicula = new Peliculas(idPelicula, nombrePelicula);
                            pelicula.setPelicula();
                            System.out.println("Inserte el número de compositores de la banda sonora");
                            int nCompositores = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Inserte el/los compositor/es de la banda sonora");
                            String compositor = entrada.nextLine();
                            System.out.println("Inserte el número de músicos de la banda sonora");
                            int nMusicos = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Inserte el número de canciones de la banda sonora");
                            int nCanciones = entrada.nextInt();
                            entrada.nextLine();
                            BandaSonora bandaSonora = new BandaSonora(idPelicula,nombrePelicula, nMusicos, nCanciones,nCompositores, compositor);
                            bandaSonora.setBandaSonora();
                            break;
                        case 2:
                            System.out.println("Inserte el ID de la canción");
                            int idSong = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Inserte el ID de la banda sonora a la que pertenece la canción:");
                            int idBanda = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Inserte el nombre de la cancion");
                            String nombreCancion = entrada.nextLine();

                            Cancion canciones = new Cancion(idSong, idBanda, nombreCancion);
                            canciones.setCanciones();
                            break;

                        case 3 :
                            System.out.println("Inserte el ID de la banda sonora a la que pertenece el músico");
                            int idBandaSonora = entrada.nextInt();
                            entrada.nextLine();
                            System.out.println("Inserte el ID del músico");
                            int idMusico = entrada.nextInt();

                            BandaSonora.actualizarnMusicos(idBandaSonora);
                            entrada.nextLine();
                            System.out.println("Inserte el nombre del músico");
                            String nombreMusico = entrada.nextLine();
                            System.out.println("Inserte el apellido del músico");
                            String apellidoMusico = entrada.nextLine();
                            Musico nuevoMusico = new Musico(idMusico, apellidoMusico, nombreMusico, idBandaSonora);
                            nuevoMusico.setMusico();


                    }
            }
        }while (opcion != 0);



    }




}