package topica.edu.vn.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BorderVaJtextAreaCheckBoxRadiaoUI extends JFrame{
	JTextField txtTen ;
	JTextArea txtDiaChi;
	JButton btnOk ;
	
	JCheckBox chkDiBoi, chkDiXemPhim,chkDiDao;
	JRadioButton radNam, radNu;
	ButtonGroup groupGioiTinh ;
	
	public BorderVaJtextAreaCheckBoxRadiaoUI(String title) {
		super(title);
		addControl();
		addEvent();
	}
	public void addControl() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		pnMain.add(pnThongTin);
		
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTen = new JLabel("Ten: ");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnThongTin.add(pnTen);
		lblTen.setForeground(Color.BLACK);
		Font fonTitle = new Font("arial", Font.BOLD, 15);
		lblTen.setFont(fonTitle);
		
		JPanel pnDiaChi = new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblDiaChi = new JLabel("Dia chi: ");
		txtDiaChi = new JTextArea(5, 20);
		
		txtDiaChi.setWrapStyleWord(true);
		txtDiaChi.setLineWrap(true);
		
		JScrollPane sc = new JScrollPane(txtDiaChi, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(sc);
		pnThongTin.add(pnDiaChi);
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(fonTitle);
		
		
		
		Border borderThongTin = BorderFactory.createBevelBorder(WIDTH, Color.BLACK, Color.CYAN);
		TitledBorder borderTitleThongtin = new TitledBorder(borderThongTin,"Thong tin");
		pnThongTin.setBorder(borderTitleThongtin);
		Font font1 = new Font("arial", Font.BOLD, 20);
		borderTitleThongtin.setTitleColor(Color.RED);
		borderTitleThongtin.setTitleJustification(TitledBorder.CENTER);
		borderTitleThongtin.setTitleFont(font1);
		
		
		JPanel pnSoThichVaGioiTinh = new JPanel();
		pnSoThichVaGioiTinh.setLayout(new BoxLayout(pnSoThichVaGioiTinh, BoxLayout.X_AXIS));
		pnMain.add(pnSoThichVaGioiTinh);
		
		
		
		JPanel pnSoThich = new JPanel();
		pnSoThich.setPreferredSize(new Dimension(500,200));
		pnSoThich.setLayout(new BoxLayout(pnSoThich, BoxLayout.Y_AXIS));
		chkDiBoi = new JCheckBox("Di boi");
		chkDiXemPhim  = new JCheckBox("Di xem phim");
		chkDiDao = new JCheckBox("Di dao");
		chkDiBoi.setForeground(Color.BLUE);
		chkDiBoi.setFont(fonTitle);
		chkDiXemPhim.setForeground(Color.BLUE);
		chkDiXemPhim.setFont(fonTitle);
		chkDiDao.setForeground(Color.BLUE);
		chkDiDao.setFont(fonTitle);
		
		
		
		Border borderSoThich = BorderFactory.createBevelBorder(WIDTH, Color.GREEN, Color.RED);
		TitledBorder borderTitleSoThich = new TitledBorder("So thich");
		pnSoThich.setBorder(borderTitleSoThich);
		borderTitleSoThich.setTitleFont(font1);
		borderTitleSoThich.setTitleColor(Color.BLACK);
	
		
		pnSoThich.add(chkDiBoi);
		pnSoThich.add(chkDiXemPhim);
		pnSoThich.add(chkDiDao);
		pnSoThichVaGioiTinh.add(pnSoThich);
		
		JPanel pnGioiTinh =new JPanel();
		pnGioiTinh.setPreferredSize(new Dimension(300,100));
		pnGioiTinh.setLayout(new BoxLayout(pnGioiTinh, BoxLayout.Y_AXIS));
		radNam = new JRadioButton("Nam                      ");
		radNu = new JRadioButton("Nu                        ");
		groupGioiTinh = new ButtonGroup();
		groupGioiTinh.add(radNam);
		groupGioiTinh.add(radNu);
		pnGioiTinh.add(radNam);
		pnGioiTinh.add(radNu);
		pnSoThichVaGioiTinh.add(pnGioiTinh);
		
		Border borderGioiTinh = BorderFactory.createBevelBorder(WIDTH, Color.BLACK, Color.RED);
		TitledBorder borderTitleGioiTinh = new TitledBorder("Gioi tinh");
		pnGioiTinh.setBorder(borderTitleGioiTinh);
		borderTitleGioiTinh.setTitleFont(font1);
		borderTitleGioiTinh.setTitleColor(Color.BLACK);
	
		
	
			
		
		JPanel pnOk = new JPanel();
		pnOk.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnOk = new JButton("Ok");
		btnOk.setFont(fonTitle);
		pnOk.add(btnOk);
		pnMain.add(pnOk);
		
		//lblDiaChi.setPreferredSize(lblTen.getPreferredSize());
		
	}
	
	public void addEvent() {
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLayThongTin();
				
			}
		});
	}
	protected void xuLyLayThongTin() {
		// TODO Auto-generated method stub
		String msg = txtTen.getText()+ "\n";
		msg += txtDiaChi.getText() +"\n";
		
		String sothich ="";
		
		if(chkDiBoi.isSelected())
			sothich += chkDiBoi.getText() + "\n";
		if (chkDiXemPhim.isSelected())
			sothich += chkDiXemPhim.getText() + "\n";
		if(chkDiDao.isSelected())
			sothich += chkDiDao.getText();
		
		msg += sothich + "\n";
		
		String gioitinh = "";
		if(radNam.isSelected())
			gioitinh += radNam.getText();
		if(radNu.isSelected())
			gioitinh += radNu.getText();
		
		msg += gioitinh;
		JOptionPane.showMessageDialog(null, msg);
	}
	public void showWindow() {
		this.setSize(700, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}


}
