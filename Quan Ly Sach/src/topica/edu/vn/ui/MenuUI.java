package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

import topica.edu.vn.connect.NhaXuatBanService;
import topica.edu.vn.model.NhaXuatBan;

public class MenuUI extends JFrame {
	JTextField txtMaNXB, txtTenNXB, txtDiaChi, txtDienThoai;
	
	JButton btnVeTruoc, btnVeSau;
	 
	JLabel lblStep;
	
	JButton btnThem, btnLuu, btnSua, btnXoa;
	
	DefaultTableModel dftNXB;
	JTable tblNXB;
	
	JButton btnTimKiem;
	
	Connection conn = null;
	
	ArrayList<NhaXuatBan>dsNXB = null;
	
	JMenuItem mnuDelete;
	JPopupMenu popup;
	public MenuUI(String title) {
		super(title);
		addControl();
		addEvent();
		KetNoi();
		HienThiToanBoNXB();
	}

	private void HienThiToanBoNXB() {
		// TODO Auto-generated method stub
		NhaXuatBanService nxbService = new NhaXuatBanService();
		dsNXB = nxbService.layToanBoNXB();
		
		for(NhaXuatBan nxb: dsNXB) {
			Vector<Object>vector = new Vector<Object>();
			vector.add(nxb.getMaNhaXuatBan());
			vector.add(nxb.getTenNhaXuatBan());
			vector.add(nxb.getDiaChi());
			vector.add(nxb.getSoPhone());
			dftNXB.addRow(vector);
		}
		
	}

	private void KetNoi() {
		// TODO Auto-generated method stub
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

	private void addControl() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JPanel pnCenter = new JPanel();
		JPanel pnSouth = new JPanel();
		con.add(pnNorth,BorderLayout.NORTH);
		con.add(pnCenter,BorderLayout.CENTER);
		con.add(pnSouth,BorderLayout.SOUTH);
		
		pnNorth.setLayout(new BorderLayout());
		JPanel pnChiTiet = new JPanel();
		JPanel pnThucHien = new JPanel();
		pnNorth.add(pnChiTiet,BorderLayout.CENTER);
		pnNorth.add(pnThucHien,BorderLayout.EAST);
		
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		
		JPanel pnNXB = new JPanel();
		JLabel lblNXB = new JLabel("Thông tin nhà xuất bản");
		lblNXB.setFont(new Font("arial",Font.BOLD,18));
		lblNXB.setForeground(Color.RED);
		pnNXB.add(lblNXB);
		pnChiTiet.add(pnNXB);
		
		JPanel pnMaNXB = new JPanel();
		JLabel lblMaNXB = new JLabel("Mã nhà xuất bản");
		lblMaNXB.setFont(new Font("arial",Font.PLAIN,15));
		lblMaNXB.setForeground(Color.BLACK);
		txtMaNXB = new JTextField(20);
		pnMaNXB.add(lblMaNXB);
		pnMaNXB.add(txtMaNXB);
		pnChiTiet.add(pnMaNXB);
		
		
		JPanel pnTenNXB = new JPanel();
		JLabel lblTenNXB = new JLabel("Tên nhà xuất bản");
		lblTenNXB.setFont(new Font("arial",Font.PLAIN,15));
		lblTenNXB.setForeground(Color.BLACK);
		txtTenNXB = new JTextField(20);
		pnTenNXB.add(lblTenNXB);
		pnTenNXB.add(txtTenNXB);
		pnChiTiet.add(pnTenNXB);
		
		
		JPanel pnDiaChi = new JPanel();
		JLabel lblDiaChi = new JLabel("Địa chỉ nhà xuất bản");
		lblDiaChi.setFont(new Font("arial",Font.PLAIN,15));
		lblDiaChi.setForeground(Color.BLACK);
		txtDiaChi = new JTextField(20);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnChiTiet.add(pnDiaChi);
		
		
		JPanel pnDienThoai = new JPanel();
		JLabel lblDienThoai = new JLabel("SĐT nhà xuất bản");
		lblDienThoai.setFont(new Font("arial",Font.PLAIN,15));
		lblDienThoai.setForeground(Color.BLACK);
		txtDienThoai = new JTextField(20);
		pnDienThoai.add(lblDienThoai);
		pnDienThoai.add(txtDienThoai);
		pnChiTiet.add(pnDienThoai);
		
		lblMaNXB.setPreferredSize(lblDiaChi.getPreferredSize());
		lblTenNXB.setPreferredSize(lblDiaChi.getPreferredSize());
		lblDienThoai.setPreferredSize(lblDiaChi.getPreferredSize());
		
		
	
		
		JPanel pnButtonChiTiet = new JPanel();
		btnVeTruoc = new JButton("Vế trước");
		lblStep = new JLabel("1/10");
		btnVeSau = new JButton("Vế sau");
		pnButtonChiTiet.add(btnVeTruoc);
		pnButtonChiTiet.add(lblStep);
		pnButtonChiTiet.add(btnVeSau);
		pnChiTiet.add(pnButtonChiTiet);
		
		
		pnThucHien.setLayout(new BoxLayout(pnThucHien, BoxLayout.Y_AXIS));
		JPanel pnButtonThem = new JPanel();
		btnThem = new JButton("Thêm");
		pnThucHien.add(pnButtonThem);
		pnButtonThem.add(btnThem);
		
		JPanel pnButtonLuu = new JPanel();
		btnLuu = new JButton("Lưu");
		pnThucHien.add(pnButtonLuu);
		pnButtonLuu.add(btnLuu);
		
		
		JPanel pnButtonSua = new JPanel();
		btnSua = new JButton("Sửa");
		pnThucHien.add(pnButtonSua);
		pnButtonSua.add(btnSua);
		
		
		JPanel pnButtonXoa = new JPanel();
		btnXoa = new JButton("Xóa");
		pnThucHien.add(pnButtonXoa);
		pnButtonXoa.add(btnXoa);
		
		
		pnCenter.setLayout(new BorderLayout());
		dftNXB = new DefaultTableModel();
		
		dftNXB.addColumn("Mã nhà xuất bản");
		dftNXB.addColumn("Tên nhà xuất bản");
		dftNXB.addColumn("Địa chỉ");
		dftNXB.addColumn("Điện thoại");
		
		tblNXB = new JTable(dftNXB);
		JScrollPane sc = new JScrollPane(tblNXB,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(sc,BorderLayout.CENTER);
		
		pnSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnButtonTimKiem = new JPanel();
		btnTimKiem = new JButton("Tìm kiếm");
		pnButtonTimKiem.add(btnTimKiem);
		pnSouth.add(pnButtonTimKiem);
		
		TitledBorder borderThongTinVaChiTiet = new TitledBorder(BorderFactory.createLineBorder(Color.BLUE),
				"Thông tin chi tiết");
		pnChiTiet.setBorder(borderThongTinVaChiTiet);
		
		TitledBorder borderThucHien = new TitledBorder(BorderFactory.createLineBorder(Color.RED),"Thực hiện");
		pnThucHien.setBorder(borderThucHien);
		
		TitledBorder borderCenter = new TitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Danh sách nhà xuất bản");
		pnCenter.setBorder(borderCenter);
		
		btnThem.setIcon(new ImageIcon("images/add.jpg"));
		btnLuu.setIcon(new ImageIcon("images/save.jpg"));
		btnSua.setIcon(new ImageIcon("images/edit2.jpg"));
		btnXoa.setIcon(new ImageIcon("images/delete 2.png"));
		btnVeTruoc.setIcon(new ImageIcon("images/previous.png"));
		btnVeSau.setIcon(new ImageIcon("images/next1.png"));
		btnTimKiem.setIcon(new ImageIcon("images/search1.png"));
		
		mnuDelete = new JMenuItem("Xóa");
		popup = new JPopupMenu();
		popup.add(mnuDelete);
		
		
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TimKiemUI ui = new TimKiemUI("Tìm Kiếm");
				ui.showWindow();
			}
		});
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyThem();
			}
		});
		
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLySua();
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyXoa();
			}
		});
		
		tblNXB.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.isPopupTrigger()) {
					int row = tblNXB.rowAtPoint(e.getPoint());
					int column = tblNXB.columnAtPoint(e.getPoint());
					if(! tblNXB.isRowSelected(row))
						tblNXB.changeSelection(row, column, false, false);
						
					popup.show(e.getComponent(),e.getX(),e.getY());
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				mnuDelete.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						xuLyXoa();
					}
				});
			}
		});
	}
	
	
	
	
	protected void xuLyXoa() {
		// TODO Auto-generated method stub
		try {
			String sql = "delete from nhaxuatban where MaNhaXuatBan =?";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, txtMaNXB.getText());
			int x = statement.executeUpdate();
			
			if(x>0) {
				
				dispose();
				MenuUI ui = new MenuUI("Menu");
				ui.showWindow();
			}
			dispose();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void xuLySua() {
		// TODO Auto-generated method stub
		try {
			String sql = "update nhaxuatban set TenNhaXuatBan =?, DiaChi =?, SoDienThoai =? where MaNhaXuatBan =?";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, txtTenNXB.getText());
			statement.setString(2, txtDiaChi.getText());
			statement.setString(3, txtDienThoai.getText());
			statement.setString(4, txtMaNXB.getText());
			int x = statement.executeUpdate();
			
			if(x>0) {
				dispose();
				MenuUI ui = new MenuUI("Menu");
				ui.showWindow();
				
			}
			dispose();
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	
	
	protected void xuLyThem() {
		// TODO Auto-generated method stub
		try {
			String sql = "insert into nhaxuatban values(?,?,?,?)";
			PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
			statement.setString(1, txtMaNXB.getText());
			statement.setString(2, txtTenNXB.getText());
			statement.setString(3, txtDiaChi.getText());
			statement.setString(4, txtDienThoai.getText());

			int x = statement.executeUpdate();
			if(x>0) {
				dispose();
				MenuUI ui = new MenuUI("Menu");
				ui.showWindow();

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void showWindow() {
   		this.setSize(550, 600);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setVisible(true);
   	}

}
