package topica.edu.vn;

import java.sql.Connection;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class TestConnectionToMySql {

	public static void main(String[] args) {
		try
		{
			String strConn="jdbc:mysql://localhost/dbtaisan";
			//String strConn="jdbc:mysql://127.0.0.1/dbtaisan";
			Properties pro=new Properties();
			pro.put("user", "root");//root là account mặc dinh lúc ta cài đặt XAMP
			pro.put("password", "");
			Driver driver=new Driver();
			Connection conn= driver.connect(strConn, pro);
			if(conn!=null)
				System.out.println("Kết nối tới CSDL dbtaisan thành công");
			else
				System.err.println("Kết nối tới CSDL dbtaisan thất bại");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
