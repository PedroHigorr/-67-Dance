package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    // O caminho do banco. Ele vai criar um arquivo danca_db.db na raiz do seu projeto.
    private static final String URL = "jdbc:sqlite:danca_db.db";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        // O SQLite vem com as chaves estrangeiras desligadas por padrão. Isso força a ativação.
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON;");
        }
        return conn;
    }

    public static void inicializarBanco() {
        String sqlPassos = "CREATE TABLE IF NOT EXISTS passos ("
                         + "id TEXT PRIMARY KEY, "
                         + "nome TEXT NOT NULL, "
                         + "historia TEXT NOT NULL, "
                         + "caminho_video TEXT NOT NULL"
                         + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlPassos);
            System.out.println("Vitoria: Banco de dados inicializado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Desastre ao inicializar o banco de dados: " + e.getMessage());
        }
    }
}