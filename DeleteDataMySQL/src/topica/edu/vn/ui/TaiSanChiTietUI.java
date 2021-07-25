package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

public class TaiSanChiTietUI extends JDialog {
	public static JTextField txtMa;
	JTextField txtTen;
	JTextField txtNgayNhap;
	JTextField txtSoNamKhauHao;
	JTextField txtGiaTri;
	JButton btnLuu;
	
	Connection conn = TaiSanUI.conn;
	Statement statement = (Statement) TaiSanUI.statement;
	
	public static int ketqua =-1;
	
	public String matsChon ="";
	
	public TaiSanChiTietUI(String title) {
		this.setTitle(title);
		addControl();
		addEvent();
		if(matsChon.length() != 0) {
			HienThiThongTinChiTiet();
			
		}
		
	}

	public void HienThiThongTinChiTiet() {
		// TODO Auto-generated method stub
		
		try {
			String sql = "Select * from taisan where ma = '"+matsChon+"'" ;
			statement = (Statement) conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				txtMa.setText(result.getString(1));
				txtTen.setText(result.getString(2));
				txtNgayNhap.setText(result.getDate(3)+"");
				txtSoNamKhauHao.setText(result.getInt(4)+"");
				txtGiaTri.setText(result.getInt(5)+"");

			}
			txtMa.setEditable(false);
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private void addEvent() {
		// TODO Auto-generated method stub
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xulyLuu();
			}
		});
	}

	protected void xulyLuu() {
		// TODO Auto-generated method stub
		if(matsChon.length() == 0) {
			try {
				String sql = "insert into taisan values('"+txtMa.getText()+"','"+txtTen.getText()+"','"+txtNgayNhap.getText()+"','"+txtSoNamKhauHao.getText()+"','"+txtGiaTri.getText()+"')";
				statement = (Statement) conn.createStatement();
				int x = statement.executeUpdate(sql);

				ketqua = x;
				dispose();//ẩn màn hình này đi


			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else {
			try {
				String sql = "update taisan set Ten = '"+txtTen.getText()+"',"
						+ "NgayNhap ='"+txtNgayNhap.getText()+"',"
						+ "SoNamKhauHao = '"+txtSoNamKhauHao.getText()+"',"
						+ "giatri = '"+txtGiaTri.getText()+"' "
						+ "where Ma = '"+txtMa.getText()+"'";
				
				statement = (Statement) conn.createStatement();
				int x =statement.executeUpdate(sql);
				ketqua = x;
				dispose();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	private void addControl() {
		// TODO Auto-generated method stub
		Container con =getContentPane();
		con.setLayout(new FlowLayout());
		JPanel pnTitleAdd = new JPanel();
		JLabel lblTitleAdd = new JLabel("Thêm và Sửa thông tin tài sản");
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
		
		JPanel pnTen = new JPanel();
		JLabel lblTen = new JLabel("Tên tài sản");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnAdd.add(pnTen);
		
		JPanel pnNgayNhap = new JPanel();
		JLabel lblNgayNhap = new JLabel("Ngày nhập");
		txtNgayNhap = new JTextField(20);
		pnNgayNhap.add(lblNgayNhap);
		pnNgayNhap.add(txtNgayNhap);
		pnAdd.add(pnNgayNhap);
		
		JPanel pnSoNamKhauHao = new JPanel();
		JLabel lblSoNamKhauHao = new JLabel("Số năm khấu hao");
		txtSoNamKhauHao = new JTextField(20);
		pnSoNamKhauHao.add(lblSoNamKhauHao);
		pnSoNamKhauHao.add(txtSoNamKhauHao);
		pnAdd.add(pnSoNamKhauHao);
		
		
		JPanel pnGiaTri = new JPanel();
		JLabel lblGiaTri = new JLabel("Giá trị tài sản");
		txtGiaTri = new JTextField(20);
		pnGiaTri.add(lblGiaTri);
		pnGiaTri.add(txtGiaTri);
		pnAdd.add(pnGiaTri);
		
		lblMa.setPreferredSize(lblSoNamKhauHao.getPreferredSize());
		lblTen.setPreferredSize(lblSoNamKhauHao.getPreferredSize());
		lblNgayNhap.setPreferredSize(lblSoNamKhauHao.getPreferredSize());
		lblGiaTri.setPreferredSize(lblSoNamKhauHao.getPreferredSize());
		
		JPanel pnButton = new JPanel();
		btnLuu = new JButton("Lưu");
		pnButton.add(btnLuu);
		
		con.add(pnButton);
		
	
	}
	
	public void showWindow() {
   		this.setSize(400, 300);
   		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setModal(true);
   		this.setVisible(true);
   	}

}
