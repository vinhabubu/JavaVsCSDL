package topica.edu.vn.connect;

import java.sql.Connection;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MySqlService {
	protected Connection conn =null;
	public MySqlService() {
		try {
			String strConn = "jdbc:mysql://localhost/dbquanlysach";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			Driver driver = new Driver();
			conn = driver.connect(strConn, pro);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
