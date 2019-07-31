package dbquery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DBQuery {
	private DataSource dataSource;

	public DBQuery(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int count() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from MEMBER");
			rs.next();
			return rs.getInt(1);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
	}
}
