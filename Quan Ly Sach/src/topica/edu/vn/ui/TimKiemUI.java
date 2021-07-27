package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import topica.edu.vn.connect.SachService;
import topica.edu.vn.model.Sach;

public class TimKiemUI extends JFrame {
	JTextField txtNhapNXB;
	
	JButton btnTimKiemNXB, btnBack;
	
	DefaultTableModel dftSach;
	JTable tblSach;
	
	public TimKiemUI(String title) {
		super(title);
		addControl();
		addEvent();
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
		JPanel pnNhapNXB = new JPanel();
		JLabel lblNhapNXB = new JLabel("Nhập hoặc chọn mã NXB");
		lblNhapNXB.setFont(new Font("arial",Font.BOLD,15));
		lblNhapNXB.setForeground(Color.BLUE);
		txtNhapNXB = new JTextField(20);
		pnNhapNXB.add(lblNhapNXB);
		pnNhapNXB.add(txtNhapNXB);
		pnNorth.add(pnNhapNXB,BorderLayout.CENTER);
		
		JPanel pnButtonTimKiemNXB = new JPanel();
		btnTimKiemNXB = new JButton("Tìm kiếm");
		pnButtonTimKiemNXB.add(btnTimKiemNXB);
		pnNorth.add(pnButtonTimKiemNXB,BorderLayout.EAST);
		
		pnCenter.setLayout(new BorderLayout());
		dftSach = new DefaultTableModel();
		
		dftSach.addColumn("Mã sách");
		dftSach.addColumn("Tên sách");
		dftSach.addColumn("Mã nhà xuất bản");
		dftSach.addColumn("Số trang");
		
		tblSach = new JTable(dftSach);
		
		JScrollPane scSach = new JScrollPane(tblSach,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnCenter.add(scSach,BorderLayout.CENTER);
		
		TitledBorder borderTimKiem = new TitledBorder(BorderFactory.createLineBorder(Color.RED),"Tìm Kiếm");
		pnNorth.setBorder(borderTimKiem);
		
		btnTimKiemNXB.setIcon(new ImageIcon("images/search1.png"));
		
		pnSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnBack = new JButton("Back");
		pnSouth.add(btnBack);
		
		
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				MenuUI ui = new MenuUI("Menu");
				ui.showWindow();
			}
		});
		
		btnTimKiemNXB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyTimKiem();
			}
		});
		
	}
	

	protected void xuLyTimKiem() {
		// TODO Auto-generated method stub
		SachService sservice = new SachService();
		ArrayList<Sach>dsSach = sservice.timSachTheoNXB(txtNhapNXB.getText());
		dftSach.setRowCount(0);
		for(Sach s: dsSach) {
			Vector<Object>vector = new Vector<Object>();
			vector.add(s.getMaSach());
			vector.add(s.getTenSach());
			vector.add(s.getMaNhaXuatBan());
			vector.add(s.getSoTrang());
			
			dftSach.addRow(vector);
		}
		
	}

	public void showWindow() {
   		this.setSize(600, 400);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setVisible(true);
   	}

}
