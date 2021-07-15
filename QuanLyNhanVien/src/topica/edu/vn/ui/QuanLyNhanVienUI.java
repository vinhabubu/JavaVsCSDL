package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import topica.edu.vn.model.NhanVien;
import topica.edu.vn.model.PhongBan;

public class QuanLyNhanVienUI extends JFrame {
	
	JComboBox<PhongBan>cboPhongBan;
	JList<NhanVien>listNhanVien;
	JTextField txtMa, txtTen, txtNgayVaoLam, txtNgaySinh;
	JButton btnLuu, btnXoa, btnThoat;
	
	ArrayList<PhongBan>dsPhongBan;
	ArrayList<NhanVien>dsNhanVienTheoPhongBan;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	PhongBan pbSellected = null;
	NhanVien nvSellected = null;
	public  QuanLyNhanVienUI(String title) {
		super(title);
		addControl();
		addEvent();
		fakeData();
		
	}
	
	public void addControl() {
		Container con = getContentPane();
		con.setBackground(Color.black);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		
		JPanel pnPhongBan = new JPanel();
		pnPhongBan.setLayout(new FlowLayout());
		JLabel lblPhongBan = new JLabel("Chon phong ban: ");
		Font fontTitle = new Font("arial", Font.BOLD, 20);
		lblPhongBan.setForeground(Color.BLUE);
		lblPhongBan.setFont(fontTitle);
		pnMain.add(pnPhongBan);
		pnPhongBan.add(lblPhongBan);
		
		
		cboPhongBan = new JComboBox<PhongBan>();
		cboPhongBan.setPreferredSize(new Dimension(200, 25));
		pnPhongBan.add(cboPhongBan);
		
		
		JPanel pnDanhSachVaChiTiet = new JPanel();
		pnDanhSachVaChiTiet.setLayout(new BoxLayout(pnDanhSachVaChiTiet, BoxLayout.X_AXIS));
		pnMain.add(pnDanhSachVaChiTiet);
		JPanel pnDanhSach = new JPanel();
		pnDanhSach.setLayout(new BorderLayout());
		
		Border borderDanhSach = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorderDanhSach = new TitledBorder(borderDanhSach, "Danh sach nhan vien");
		pnDanhSach.setBorder(titleBorderDanhSach);
		titleBorderDanhSach.setTitleJustification(TitledBorder.CENTER);
		Font font1 = new Font("arial", Font.BOLD, 17);
		titleBorderDanhSach.setTitleFont(font1);
		titleBorderDanhSach.setTitleColor(Color.green);
		
		listNhanVien = new JList<NhanVien>();
		JScrollPane sc= new JScrollPane(listNhanVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//listNhanVien.setPreferredSize(new Dimension(5,1));
		sc.setPreferredSize(new Dimension(10,10));
		pnDanhSach.add(sc,BorderLayout.CENTER);
		pnDanhSachVaChiTiet.add(pnDanhSach);
		//pnDanhSach.add(sc);
		
		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		pnDanhSachVaChiTiet.add(pnChiTiet);
		  
		Border borderChiTiet = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titleBorderChiTiet = new TitledBorder(borderChiTiet, "Chi tiet");
		pnChiTiet.setBorder(titleBorderChiTiet);
		titleBorderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titleBorderChiTiet.setTitleFont(font1);
		titleBorderChiTiet.setTitleColor(Color.green);
		
		
		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout());
		JLabel lblMa = new JLabel("Ma: ");
		txtMa = new JTextField(15);
		pnChiTiet.add(pnMa);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		
		
		JPanel pnTen =new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTen = new JLabel("Ten: ");
		txtTen = new JTextField(15);
		pnChiTiet.add(pnTen);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		
		

		JPanel pnNgayVaoLam =new JPanel();
		pnNgayVaoLam.setLayout(new FlowLayout());
		JLabel lblNgayVaoLam = new JLabel("Ngay vao: ");
		txtNgayVaoLam = new JTextField(15);
		pnChiTiet.add(pnNgayVaoLam);
		pnNgayVaoLam.add(lblNgayVaoLam);
		pnNgayVaoLam.add(txtNgayVaoLam);
		
		
		JPanel pnNgaySinh =new JPanel();
		pnNgaySinh.setLayout(new FlowLayout());
		JLabel lblNgaySinh = new JLabel("Ngay sinh: ");
		txtNgaySinh = new JTextField(15);
		pnChiTiet.add(pnNgaySinh);
		pnNgaySinh.add(lblNgaySinh);
		pnNgaySinh.add(txtNgaySinh);
		
		
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		Border borderButton = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderButton = new TitledBorder(borderButton, "Chon chuc nang");
		pnButton.setBorder(titleBorderButton);
		titleBorderButton.setTitleJustification(TitledBorder.CENTER);
		titleBorderButton.setTitleFont(font1);
		titleBorderButton.setTitleColor(Color.GREEN);

		btnLuu = new JButton("Luu");
		btnXoa = new JButton("Xoa");
		btnThoat = new JButton("Thoat");
		pnMain.add(pnButton);
		pnButton.add(btnLuu);
		pnButton.add(btnThoat);
		pnButton.add(btnXoa);
		
		
		lblMa.setPreferredSize(lblNgaySinh.getPreferredSize());
		lblTen.setPreferredSize(lblNgaySinh.getPreferredSize());
		lblNgayVaoLam.setPreferredSize(lblNgaySinh.getPreferredSize());
		}
	    
	public void fakeData() {
		dsPhongBan = new ArrayList<PhongBan>();
		
		PhongBan phtgv = new PhongBan();
		phtgv.setMaPhong("p1");
		phtgv.setTenPhong("Phong hop tac giang vien");
		
		PhongBan pkd = new PhongBan();
		pkd.setMaPhong("p2");
		pkd.setTenPhong("Phong kinh doanh");
		
		PhongBan pkt = new PhongBan();
		pkt.setMaPhong("p3");
		pkt.setTenPhong("Phong ke toan");
		
		dsPhongBan.add(phtgv);
		dsPhongBan.add(pkd);
		dsPhongBan.add(pkt);
		
		phtgv.themNhanVien(new NhanVien("nv1", "Nguyen Vinh", new Date(2016-1900, 1, 1), new Date(2000-1900, 12, 15)));
		phtgv.themNhanVien(new NhanVien("nv2", "Nguyen Van Tit1", new Date(2017-1900, 6, 1), new Date(1999-1900, 12, 10)));
		phtgv.themNhanVien(new NhanVien("nv3", "Dinh Thi Tit2", new Date(2018-1900, 3, 1), new Date(2001-1900, 12, 1)));
		phtgv.themNhanVien(new NhanVien("nv4", "Pham Van Tit3", new Date(2019-1900, 9, 1), new Date(1997-1900, 12, 18)));
		
		pkd.themNhanVien(new NhanVien("nv5", "Bui Van Tit4", new Date(2015-1900, 9, 1), new Date(1995-1900, 12, 18)));
		pkd.themNhanVien(new NhanVien("nv6", "Le Thi Tit5", new Date(2013-1900, 9, 1), new Date(1996-1900, 12, 18)));
		pkd.themNhanVien(new NhanVien("nv7", "Le Tuan Tit6", new Date(2010-1900, 9, 1), new Date(1993-1900, 12, 18)));
		
		
		pkt.themNhanVien(new NhanVien("nv8", "Bui Le Tit7", new Date(2008-1900, 9, 1), new Date(1999-1900, 1, 18)));
		pkt.themNhanVien(new NhanVien("nv9", "Nguyen Thanh Tit8", new Date(2011-1900, 9, 1), new Date(1991-1900, 2, 18)));
		pkt.themNhanVien(new NhanVien("nv10", "Nguyen Tit9", new Date(2012-1900, 9, 1), new Date(1990-1900, 11, 18)));
		
		
		for(PhongBan pb: dsPhongBan) {
			cboPhongBan.addItem(pb);
		}
		
		}
	
	
	public void addEvent() {
		cboPhongBan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cboPhongBan.getSelectedIndex() ==-1)return;
				
				pbSellected = (PhongBan) cboPhongBan.getSelectedItem();
				
				listNhanVien.setListData(pbSellected.getNhanViens());
			}
		});
		
		listNhanVien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				if(listNhanVien.getSelectedIndex() == -1)return;
				 nvSellected = listNhanVien.getSelectedValue();
				
				txtMa.setText(nvSellected.getMaNhanVien());
				txtTen.setText(nvSellected.getTenNhanVien());
				txtNgayVaoLam.setText(sdf.format(nvSellected.getNgayVaoLamViec()));
				txtNgaySinh.setText(sdf.format(nvSellected.getNgaySinh()));
			}
		});
		
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLuu();
			}
		});
		
		
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyThoat();
			}
		});
		  
		
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyXoa();
			}
		});
	}
	
	
	
	protected void xuLyXoa() {
		// TODO Auto-generated method stub
		if(nvSellected != null) {
			pbSellected.getNhanViens().remove(nvSellected);
			nvSellected = null;
			listNhanVien.setListData(pbSellected.getNhanViens());
		}
		
		
	}

	
	
	protected void xuLyThoat() {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	
	
	protected void xuLyLuu() {
		// TODO Auto-generated method stub
		try {
			NhanVien nv = new NhanVien(txtMa.getText(),
					                   txtTen.getText(),
					                   sdf.parse(txtNgayVaoLam.getText()),
					                   sdf.parse(txtNgaySinh.getText()));
			
			if(pbSellected != null) {
				pbSellected.themNhanVien(nv);
				listNhanVien.setListData(pbSellected.getNhanViens());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	
	
	public void showWindow() {
		this.setSize(650, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
