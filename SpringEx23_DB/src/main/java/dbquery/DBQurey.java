package dbquery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;

public class DBQurey {
	private DataSource dataSource;
	
	public DBQurey(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int count() {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			try(Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT count(*) FROM member")){
				rs.next();
				return rs.getInt(1);
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if(con != null)
				try {
					con.close();
				}catch(SQLException e) {}
		}
	}
}
