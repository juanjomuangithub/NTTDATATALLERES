package com.nttdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class App {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = connect();
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexion a la BBDD");
			e.printStackTrace();
		}

		String sql = "SELECT * FROM nttdata_t1mysql_employees where id_service = ?";
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 1);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				System.out.println("Nombre: " + rs.getString("name"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	private static Connection connect() throws SQLException, SQLSyntaxErrorException {
		String url = "jdbc:mysql://localhost:3306/nttdata_hibernate_taller1";
		return DriverManager.getConnection(url, "root", "num95360");
	}
}
