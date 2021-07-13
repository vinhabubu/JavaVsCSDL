package topica.edu.vn.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class BorderVaJtextArea extends JFrame{
	JTextField txtTen ;
	JTextArea txtDiaChi;
	JButton btnOk ;
	
	public BorderVaJtextArea(String title) {
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
		Font fonTitle = new Font("arial", Font.BOLD, 20);
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
		borderTitleThongtin.setTitleColor(Color.RED);
		borderTitleThongtin.setTitleJustification(TitledBorder.CENTER);
		
	
			
		
		JPanel pnOk = new JPanel();
		pnOk.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnOk = new JButton("Ok");
		btnOk.setFont(fonTitle);
		pnOk.add(btnOk);
		pnMain.add(pnOk);
		
		//lblDiaChi.setPreferredSize(lblTen.getPreferredSize());
		
	}
	
	public void addEvent() {
		
	}
	public void showWindow() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}


}
