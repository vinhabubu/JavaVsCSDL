package topica.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class DeleteUI extends JFrame {
Connection conn = null;
	
	
	JTextField txtTen, txtMa, txtGiaTri, txtNgayNhap, txtSoNamKhauHao;
	JButton btnLuu, btnBack;
	
	public  DeleteUI(String title) {
		super(title);
		addControl();
		addEvent();
		KetNoi();
		
	}

	private void KetNoi() {
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
		Container con =getContentPane();
		con.setLayout(new FlowLayout());
		JPanel pnTitleAdd = new JPanel();
		JLabel lblTitleAdd = new JLabel("Xóa thông tin tài sản");
		lblTitleAdd.setFont(new Font("arial",Font.BOLD,15));
		lblTitleAdd.setForeground(Color.RED);
		pnTitleAdd.add(lblTitleAdd);
		con.add(pnTitleAdd);
		
		JPanel pnAdd = new JPanel();
		pnAdd.setLayout(new BoxLayout(pnAdd, BoxLayout.Y_AXIS));
		JPanel pnMa = new JPanel();
		JLabel lblMa = new JLabel("Mã tài sản");
		txtMa = new JTextField(20);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnAdd.add(pnMa);
		con.add(pnAdd);
		
		
		JPanel pnButton = new JPanel();
		btnLuu = new JButton("Xóa");
		btnBack = new JButton("Back");
		pnButton.add(btnLuu);
		pnButton.add(btnBack);
		con.add(pnButton);
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLuu();
			}
		});
		
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
	
	
	protected void xuLyLuu() {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from taisan where Ma =?";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, txtMa.getText());
			int x = statement.executeUpdate();
			
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Xóa tài sản thành công");
				
			}
			dispose();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
	}

	public void showWindow() {
   		this.setSize(400, 300);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setVisible(true);
   	}

}
