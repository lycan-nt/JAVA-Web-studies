package br.com.owlsystems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:3306/dio_jpa", "root", "131216");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Falha na conexão com o DB");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Falha no Driver do Postgresql");
			e.printStackTrace();
		}
		return con;
	}
	
}
