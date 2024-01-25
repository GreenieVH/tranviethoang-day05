package lab04JspServlet.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        // URL kết nối đến SQL Server 2019
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;instance=SQL2019;databaseName=Lab04JspServletJDBC";

        // Tên người dùng (user) - thay thế bằng tên người dùng của bạn
        String username = "ADMIN-PC";

        // Load driver JDBC
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Tạo kết nối
        Connection connection = DriverManager.getConnection(jdbcUrl, username, null);

        return connection;
    }

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		}catch(Exception e){
			
		}
	}
	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		}catch(Exception e){
			
		}
	}
}
