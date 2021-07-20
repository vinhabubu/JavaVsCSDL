package topica.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class JtappedPaneUI extends JFrame {
	
	JTabbedPane tab;
	public  JtappedPaneUI(String title) {
		super(title);
		addControl();
		addEvent();
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		
	}

	private void addControl() {
		// TODO Auto-generated method stub
		Container con =getContentPane();
		tab = new JTabbedPane(); 
		con.add(tab);
		
		JPanel pnTab1 = new JPanel();
		JPanel pnTab2 =new JPanel();
		JPanel pnTab3 =new JPanel();
		
		tab.add(pnTab1,"Cau hinh");
		tab.add(pnTab2, "Bao mat");
		tab.add(pnTab3, "Phan quyen");
		
		pnTab1.setBackground(Color.RED);
		pnTab2.setBackground(Color.black);
		pnTab3.setBackground(Color.BLUE);
		
		pnTab1.add(new JButton("Day la nut"));
		pnTab2.add(new JTextField(15));
	}
		
	
	
	 public void showWindow() {
	   		this.setSize(650, 350);
	   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   		this.setLocationRelativeTo(null);
	   		this.setVisible(true);
	   	}
	

}
