package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JsplitPaneUI extends JFrame {
	 public JsplitPaneUI(String title) {
		super(title);
		addControl();
		addEvent();
	}
	
	public void addControl() {
		Container con =getContentPane();
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(200,0));
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
		sp.setOneTouchExpandable(true);
		con.add(sp);
		
		JPanel pnRight1 = new JPanel();
		JPanel pnRight2= new JPanel();
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnRight1, pnRight2);
		pnRight1.setPreferredSize(new Dimension(0,200));
		spRight.setOneTouchExpandable(true);
		pnRight.add(spRight,BorderLayout.CENTER);
		
		
		
	}
	
	public void addEvent() {
		
	}
	

	public void showWindow() {
		this.setSize(650, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
