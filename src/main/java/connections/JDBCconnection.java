package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCconnection {
	
	private static Connection con;
	private static final String drive="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://127.0.0.1:3306/crud";
	private static final String user="root";
	private static final String password="root";
	
	static {
        try {
            Class.forName(drive);             
        } catch (ClassNotFoundException e) {
        	System.out.println("Driver class not found" );
        	e.printStackTrace();
        } 
	}
	
    public static Connection getMyConnection() throws SQLException{   
        con=DriverManager.getConnection(url,user,password);
        return con;
	}
    
    public static void closeConnection(Connection con)throws SQLException{
		if(con != null) {
			con.close();
		}
	}
    
    public static void closePreparedStatement(PreparedStatement stmt)throws SQLException{
		if(stmt != null) {
			stmt.close();
		}
	}
    
    public static void closeResulrSet(ResultSet rs)throws SQLException{
		if(rs != null) {
			rs.close();
		}
	}
    
    
    
}		
