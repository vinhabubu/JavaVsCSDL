package topica.edu.vn.ui;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CuaSoCuaToi extends JFrame{
	public CuaSoCuaToi(String tieude) {
		//super(tieude);
		this.setTitle(tieude);
		addControl();
	}
	public void addControl() {
		//Lay lop chua ra cua so
		Container con = getContentPane();
		//Tao 1 lop chua control
		JPanel pn = new JPanel();
		pn.setBackground(Color.BLUE);
		
		JButton jb = new JButton("Day la nut ");
		pn.add(jb);
		//dua lop ra cua so
		con.add(pn);
	}
	public void showWindow() {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
