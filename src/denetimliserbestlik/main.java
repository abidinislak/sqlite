package denetimliserbestlik;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class main {

	public static void connect() {

	}

	/**
	 * @param args the command line arguments
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		// new File(filename) does not create a new
		// file in your file system
		File file = new File("/home/relax/asd.db");

		if (file.exists()) { // the file already existed and the program will enter this block
			JOptionPane.showInternalMessageDialog(null, "varmışş");
			String url = "jdbc:sqlite:/home/relax/asd.db";
			// create a connection to the database
			conn = DriverManager.getConnection(url);
		} else { // the file did not exist and you can send your error msg
			JOptionPane.showInternalMessageDialog(null, "yokmuşş");
			try {
				// db parameters
				String url = "jdbc:sqlite:/home/relax/asd.db";
				// create a connection to the database
				conn = DriverManager.getConnection(url);

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println(conn.createStatement());

		try {
			Statement stmt = conn.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS contacts (first_name TEXT NOT NULL)";

			stmt.execute(sql);
			stmt.execute("INSERT INTO contacts (first_name) VALUES('111');");
			stmt.execute("INSERT INTO contacts (first_name) VALUES('222');");
			ResultSet res = stmt.executeQuery("SELECT first_name FROM contacts     ");
			while (res.next()) {

				System.out.println(res.getString("first_name"));
			}

		}

		finally {
			JOptionPane.showInternalMessageDialog(null, "bitti....");
		}

	}
}