import java.sql.*;

import javax.swing.JOptionPane;

public class JavaConnection {
	static Connection conn;

	public static Connection ConnerDb() {
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bank?user=root&password=1234");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}

