package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;



public class TaiSanUI extends JFrame {
	
	DefaultTableModel dftTaiSan;
	JTable tblTaiSan ;
	
	Connection conn = null;
	java.sql.Statement statement = null;
	
	public TaiSanUI(String title) {
		super(title);
		addControl();
		AddEvent();
		ketnoiCSDLMySQL();
		hienthiToanBoTaiSan();
	}

	private void hienthiToanBoTaiSan() {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from taisan";
			statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			dftTaiSan.setRowCount(0);
			
			while(result.next()) {
				Vector<Object>vec = new Vector<Object>();
				vec.add(result.getString(1));
				vec.add(result.getString(2));
				vec.add(result.getDate(3));
				vec.add(result.getInt(4));
				vec.add(result.getInt(5));
				dftTaiSan.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private void ketnoiCSDLMySQL() {
		// TODO Auto-generated method stub
		try {
			String strlConn = "jdbc:mysql://localhost/dbtaisan";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			
			Driver driver = new Driver();
			conn = driver.connect(strlConn, pro);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private void AddEvent() {
		// TODO Auto-generated method stub
		
	}

	private void addControl() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JLabel lblTitle = new JLabel("Chương trình quản lý tài sản");
		lblTitle.setFont(new Font("arial",Font.BOLD,15));
		lblTitle.setForeground(Color.BLUE);
		pnNorth.add(lblTitle);
		con.add(pnNorth,BorderLayout.NORTH);
		
		dftTaiSan = new DefaultTableModel();
		dftTaiSan.addColumn("Mã tài sản");
		dftTaiSan.addColumn("Tên tài sản");
		dftTaiSan.addColumn("Ngày nhập");
		dftTaiSan.addColumn("Số năm khấu hao");
		dftTaiSan.addColumn("Giá trị tài sản");
		
		tblTaiSan = new JTable(dftTaiSan);
		JScrollPane scTable = new JScrollPane(tblTaiSan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		con.add(scTable,BorderLayout.CENTER);
	}
	
	public void showWindow() {
   		this.setSize(700, 350);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setVisible(true);
   	}

}
