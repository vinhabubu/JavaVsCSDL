package topica.edu.vn.connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import topica.edu.vn.model.NhaXuatBan;
import topica.edu.vn.ui.MenuUI;

public class NhaXuatBanService extends MySqlService {
	
	public  ArrayList<NhaXuatBan>layToanBoNXB(){
		ArrayList<NhaXuatBan>dsNXB = new ArrayList<NhaXuatBan>();
		
		try {
			String sql = "select * from NhaXuatBan";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				NhaXuatBan nxb = new NhaXuatBan();
				nxb.setMaNhaXuatBan(result.getString(1));
				nxb.setTenNhaXuatBan(result.getString(2));
				nxb.setDiaChi(result.getString(3));
				nxb.setSoPhone(result.getString(4));
				dsNXB.add(nxb);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsNXB;
		
	}
}
