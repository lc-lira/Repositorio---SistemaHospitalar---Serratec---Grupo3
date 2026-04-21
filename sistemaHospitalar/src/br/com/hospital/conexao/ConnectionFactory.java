package br.com.hospital.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private String url = "jdbc:postgresql://ep-cold-sunset-ac3dirxl-pooler.sa-east-1.aws.neon.tech:5432/sistema_hospitlar?sslmode=require&channel_binding=require";
    private String usuario = "neondb_owner";
    private String senha = "npg_j0iWzkZYGt3g";
    
    public Connection getConnection() {
        System.out.println("Conectando no banco de dados....");

        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso!");
            return connection;

        } catch (SQLException e) {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}