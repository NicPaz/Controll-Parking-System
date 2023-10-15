package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection conexao;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://127.0.0.1/parking?characterEncoding=latin1";
        String usuario = "root";
        String senha = "bancodedados";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection(url, usuario, senha);
        return conexao;
    }
}