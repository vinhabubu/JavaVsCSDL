package topica.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhuongTrinhBac1 extends JFrame {
	JTextField txtHeSoa,txtKetQua;
	JTextField txtHeSob;
	JButton btnGiai , btnThoat ,btnHelp;
	
	ActionListener eventGiai = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			xulyGiaiPhuongTrinhBac1();
			
		}

		
	};
	
	public PhuongTrinhBac1(String title) {
		super(title);
		addControl();
		addEvent();
	}
	
	protected void xulyGiaiPhuongTrinhBac1() {
		// TODO Auto-generated method stub
		String hsa = txtHeSoa.getText();
		String hsb = txtHeSob.getText();
		double a = Double.parseDouble(hsa);
		double b = Double.parseDouble(hsb);
		if (a==0 && b==0) {
			txtKetQua.setText("Phuong trinh vo so nghiem");
			
		} else if (a==0 && b!= 0){
			txtKetQua.setText("He phuong trinh vo nghiem");
			
		}
		else {
			double x = -b/a;
			txtKetQua.setText("x= "+x);

		}
		
	}

	public void addEvent() {
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		btnGiai.addActionListener(eventGiai);
		btnHelp.addActionListener(new HelpEvent());
	}
	
	public void addControl() {
		Container con = getContentPane();
		JPanel pnMain =new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTitle = new JLabel("Phuong trinh bac nhat");
		pnTitle.add(lblTitle);
		pnMain.add(pnTitle);	
		lblTitle.setForeground(Color.BLUE);
		Font fontTieuDe = new Font("arial", Font.BOLD, 20);
		lblTitle.setFont(fontTieuDe);
		
		
		JPanel pnHeSoa = new JPanel();
		pnHeSoa.setLayout(new FlowLayout());
		JLabel lblHeSoa = new JLabel("He so a: ");
		txtHeSoa = new JTextField(15);
		pnHeSoa.add(lblHeSoa);
		pnHeSoa.add(txtHeSoa);
		pnMain.add(pnHeSoa);
		lblHeSoa.setForeground(Color.BLUE);
		lblHeSoa.setFont(fontTieuDe);
		
		
		
		JPanel pnHeSob = new JPanel();
		pnHeSoa.setLayout(new FlowLayout());
		JLabel lblHeSob = new JLabel("He so b: ");
		txtHeSob = new JTextField(15);
		pnHeSob.add(lblHeSob);
		pnHeSob.add(txtHeSob);
		pnMain.add(pnHeSob);
		lblHeSob.setForeground(Color.BLUE);
		lblHeSob.setFont(fontTieuDe);
		
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnGiai = new JButton("Giai");
		btnThoat = new JButton("Thoat");
		btnHelp = new JButton("Help");
		pnButton.add(btnGiai);
		pnButton.add(btnThoat);
		pnButton.add(btnHelp);
		pnMain.add(pnButton);
		btnGiai.setForeground(Color.DARK_GRAY);
		btnThoat.setForeground(Color.DARK_GRAY);
		btnHelp.setForeground(Color.DARK_GRAY);
		btnGiai.setFont(fontTieuDe);
		btnThoat.setFont(fontTieuDe);
		btnHelp.setFont(fontTieuDe);
		
		
		
		
		JPanel pnKetQua = new JPanel();
		pnHeSoa.setLayout(new FlowLayout());
		JLabel lblKetQua = new JLabel("Ket qua: ");
		txtKetQua = new JTextField(15);
		pnKetQua.add(lblKetQua);
		pnKetQua.add(txtKetQua);
		pnMain.add(pnKetQua);
		lblKetQua.setForeground(Color.BLUE);
		lblKetQua.setFont(fontTieuDe);
				
	}
	class HelpEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, 
					"Muon biet them chi tiet xin vui long lien he vs chung toi theo sdt");
		}
		
	}
	
	public void showWindow() {
		this.setSize(500, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
