package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicMenuUI;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SelectUI extends JFrame {
	Connection conn = null;
	Statement statement = null;
	
	JButton btnBack;
	
	DefaultTableModel dftTaiSan ;
	JTable tblTaiSan;
	public SelectUI(String title) {
		super(title);
		addControl();
		ketNoi();
		addEvent();
		HienThiToanBoTaiSan();
	}

	private void HienThiToanBoTaiSan() {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from taisan where GiaTri>?";
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setInt(1, 10);
			dftTaiSan.setRowCount(0);
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				Vector<Object>vector = new Vector<Object>();
				vector.add(result.getString(1));
				vector.add(result.getString(2));
				vector.add(result.getDate(3));
				vector.add(result.getInt(4));
				vector.add(result.getInt(5));
				
				dftTaiSan.addRow(vector);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void ketNoi() {
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

	private void addControl() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		dftTaiSan = new DefaultTableModel();
		
		dftTaiSan.addColumn("Mã tài sản");
		dftTaiSan.addColumn("Tên tài sản");
		dftTaiSan.addColumn("Ngày nhập");
		dftTaiSan.addColumn("Số năm khấu hao");
		dftTaiSan.addColumn("Giá trị tài sản");
		
		tblTaiSan = new JTable(dftTaiSan);
		JScrollPane sc = new JScrollPane(tblTaiSan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		con.add(sc,BorderLayout.CENTER);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnBack = new JButton("Back");
		pnButton.add(btnBack);
		con.add(pnButton,BorderLayout.SOUTH);
				
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				MainUI ui = new MainUI("Main");
				ui.showWindow();
			}
		});
	}
	
	public void showWindow() {
   		this.setSize(600, 400);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setVisible(true);
   	}

}
