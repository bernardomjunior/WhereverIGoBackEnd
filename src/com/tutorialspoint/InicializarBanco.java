package com.tutorialspoint;

import java.sql.*;

public class InicializarBanco {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/";
	
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "1234";
	
	public InicializarBanco() throws SQLException{
		inicializarBanco();
	}
	
	/*public static void main(String[] args) {
		try {
			InicializarBanco inicializar = new InicializarBanco();
			UsuarioDao dao = new UsuarioDao();
			Usuario usu = dao.getUsuario("bernardodems");
			usu.getClass();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public void inicializarBanco() throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		   
		    //STEP 4: Execute a query
		    stmt = conn.createStatement();
		    
		    //Criacao do banco
		    //String sql1 = "DROP SCHEMA IF exists whereverigo";
		    //stmt.executeUpdate(sql1);
		    
		    String sql2 = "Create Database if not exists whereverigo";
		    stmt.executeUpdate(sql2);
		    
		    String sql3 = "USE  whereverigo";
		    stmt.executeUpdate(sql3);
		    
		    String sql4 = "CREATE TABLE  if not exists whereverigo.usuario  ("
		    		+ "id integer primary key AUTO_INCREMENT,"
		    		+ "email varchar(50) NOT NULL,"
		    		+ "senha varchar(50) NOT NULL)";
		    stmt.executeUpdate(sql4);
		    
/*		    String sql5 = "CREATE TABLE pessoa ("
		    		+ "codMat varchar(11) NOT NULL,"
		    		+ "descricao varchar(100) NOT NULL,"
		    		+ " PRIMARY KEY (codMat)"
		    		+ ")";
		    stmt.executeUpdate(sql5);
		    */
		    
		    
		    
		    }catch(SQLException se){
		    	//Handle errors for JDBC
		        se.printStackTrace();
		    }catch(Exception e){
		    	//Handle errors for Class.forName
		    	e.printStackTrace();
		    }finally{
		    	//finally block used to close resources
		    	try{
		    		if(stmt!=null)
		    			stmt.close();
		    	}catch(SQLException se2){
		    	}// nothing we can do
		    	try{
		    		if(conn!=null)
		    			conn.close();
		    	}catch(SQLException se){
		    		se.printStackTrace();
		    	}//end finally try
		    }//end try
	}
	
}
