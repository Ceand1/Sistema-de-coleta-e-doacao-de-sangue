import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // URL de conexão com o banco de dados
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/TrabalhoFBD";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "phoenix12";

    // Carregar o driver JDBC
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Método para obter a conexão
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}