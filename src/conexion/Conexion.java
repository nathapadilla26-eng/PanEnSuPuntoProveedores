package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/pan_en_su_punto";
    private static final String USUARIO = "root";
    private static final String CLAVE = "";

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return con;
    }
}
