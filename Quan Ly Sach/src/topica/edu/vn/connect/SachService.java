package topica.edu.vn.connect;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import topica.edu.vn.model.NhaXuatBan;
import topica.edu.vn.model.Sach;

public class SachService extends MySqlService {
	public ArrayList<Sach>timSachTheoNXB(String maNXB){
		ArrayList<Sach>dsSach = new ArrayList<Sach>();
		try {
			String sql = "select * from sach where MaNhaXuatBan = ?";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, maNXB);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Sach s = new Sach();
				s.setMaSach(result.getString(1));
				s.setTenSach(result.getString(2));
				s.setMaNhaXuatBan(result.getString(3));
				s.setSoTrang(result.getInt(4));
				dsSach.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsSach;
		
	}

}
