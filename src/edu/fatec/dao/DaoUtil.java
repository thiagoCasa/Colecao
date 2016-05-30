package edu.fatec.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoUtil {
	private static final String JDBC_CLASS = "com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/colecao";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS =	"root";
	private static DaoUtil instancia;
	private Connection con;
	private DaoUtil() { 
		try {
			Class.forName( JDBC_CLASS );
			con = DriverManager.getConnection( JDBC_URL, JDBC_USER, JDBC_PASS );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static DaoUtil getInstance() { 
		if (instancia == null) { 
			instancia = new DaoUtil();
		}
		return instancia;
	}
	
	public Connection getConnection() { 
		return con;
	}
}
