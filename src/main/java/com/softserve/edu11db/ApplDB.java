package com.softserve.edu11db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * CREATE USER 'java'@'localhost' IDENTIFIED BY 'Lv-2022DevOps';
 * GRANT ALL ON *.* TO 'java'@'localhost';
 *
 * CREATE USER 'java'@'%' IDENTIFIED BY 'Lv-2022DevOps';
 * GRANT ALL ON *.* TO 'java'@'%';
 *
 * SELECT user,plugin from mysql.user;
 * ALTER USER 'java'@'%' IDENTIFIED WITH mysql_native_password BY 'Lv-2022DevOps';
 *
 */
public final class ApplDB {
	private static Connection con = null;
	/*
	private static String username = "java";
	private static String password = "Lv-2022DevOps";
	//private static String URL = "jdbc:mysql://192.168.198.130:3306/";
	private static String URL = "jdbc:mysql://192.168.198.130:3306/ujp";
	*/
	//
	// /*
	private static String username = "postgres";
	private static String password = "root";
	//private static String URL = "jdbc:postgresql://localhost:5432/";
	private static String URL = "jdbc:postgresql://localhost:5432/lv696";
	// */

	public static void main(String[] args) throws SQLException {
		System.out.println("Start...");
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		//DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		con = DriverManager.getConnection(URL, username, password);
		if (con != null) {
			System.out.println("Connection Successful! \n");
		} else {
			System.out.println("Connection ERROR \n");
			System.exit(1);
		}
		Statement st = con.createStatement();
		//
		/* Create Database
		st.execute("CREATE DATABASE ujp;");
		*/
		//
		/* Create Table
		st.execute("USE ujp;");
		//
		// MySQL
		String query = "CREATE TABLE temp "
			+ "( id int unsigned not null auto_increment primary key, "
			+ "name varchar(20), "
			+ "login varchar(20), "
			+ "password varchar(30), "
			+ "age int );";
		//
		// PostGreSQL
		//
//		String query = "CREATE TABLE public.temp"
//		+ "( id integer NOT NULL,"
//    	+ "name character varying(255),"
//    	+ "login character varying(255),"
//    	+ "password character varying(255),"
//    	+ "age integer,"
//    	+ "CONSTRAINT id_key PRIMARY KEY (id),"
//    	+ "CONSTRAINT uniq UNIQUE (id));";
    	//nextval('library.authors_id_seq'::regclass)
//		String query = "CREATE TABLE temp "
//			+ "( id int not null primary key, "
//			+ "name varchar(20), "
//			+ "login varchar(20), "
//			+ "password varchar(30), "
//			+ "age int );";
		//
		st.execute(query);
		*/
		//
		/* Insert Data
		//
		// MySQL
		//String query = "INSERT INTO temp (name,login,password,age) VALUES ('Ivan3','iva','qwerty',21);";
		//String query = "INSERT INTO temp (name,login,password,age) VALUES ('Petro3','pet3','1234562',22);";
		//
		// PostGreSQL
		//String query = "INSERT INTO temp (id,name,login,password,age) VALUES (2,'Ivan','iva','qwerty',21);";
		String query = "INSERT INTO temp (id,name,login,password,age) VALUES (1,'Petro','pet','123456',22);";
		//
		//con.setAutoCommit(false);
		st.execute(query);
		//con.commit();
		//con.rollback();
		*/
		//
		/* Update Data
		//
		//st.executeUpdate("UPDATE temp SET name='Ira' WHERE id=1;");
		//st.execute("UPDATE temp SET name='Tolik' WHERE login LIKE 'p%';");
		*/
		//
		/* Delete Data
		//
		boolean res = st.execute("DELETE FROM temp WHERE name='Tolik';");
		//boolean res = st.execute("DELETE FROM temp WHERE name='Ira';");
		System.out.println("res = " + res);
		*/
		//
		// /* Read Data
		//
		//st.execute("USE ujp;");
		//ResultSet rs = st.executeQuery("select * from temp;");
		//
		ResultSet rs = null;
		boolean res = st.execute("select * from temp;");
		System.out.println("res = " + res);
		if (res) {
			rs = st.getResultSet();
		}
		//
		int columnCount = rs.getMetaData().getColumnCount();
		// Resultset.getMetaData() get the information
		for (int i = 1; i <= columnCount; i++) {
			System.out.print(rs.getMetaData().getColumnName(i) + "\t");
		    //System.out.print(rs.getMetaData().getColumnLabel(i) + "\t");
		}
		System.out.println();
		//
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
		System.out.println("before close");
		if (rs != null) {
			rs.close();
		}
		//
		//con.commit(); // Close transaction
		// */
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
		System.out.println("DONE");
	}
}
