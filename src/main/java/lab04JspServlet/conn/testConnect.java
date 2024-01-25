package lab04JspServlet.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class testConnect {
public static void main(String[] args)
throws ClassNotFoundException,SQLException {
	System.out.println("Get connection ... ");
	// Lấy ra đối tượng Connection kết nối vàodatabase.

	Connection conn = ConnectionUtils.getMSSQLConnection();

	System.out.println("Get connection " + conn);
	System.out.println("Done!");
	
}
}