package com.example.demo1;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class PostgreSQLTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Carica il driver JDBC di PostgreSQL
        Class.forName("org.postgresql.Driver");

        // Definisci le informazioni di connessione al database
        String url = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "Database510!";

        // Crea la connessione al database
        Connection conn = DriverManager.getConnection(url, username, password);

        // Crea lo statement per eseguire la query
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM actor");

        // Stampa i risultati della query
        while (rs.next()) {
            System.out.println(rs.getString("actor_id") + ", " + rs.getString("first_name"));

        }

        // Chiudi la connessione al database
        rs.close();
        stmt.close();
        conn.close();
    }
}
