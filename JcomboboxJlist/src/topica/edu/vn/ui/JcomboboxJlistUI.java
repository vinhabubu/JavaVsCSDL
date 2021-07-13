package topica.edu.vn.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class JcomboboxJlistUI extends JFrame{
	JComboBox cboSo;
	JList listSo;
	JButton btnOk;
	
	public JcomboboxJlistUI (String title) {
		super(title);
		addControl();
		addEvent();
	}
	public void addControl() {
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		JPanel pnCombo = new JPanel();
		pnCombo.setLayout(new FlowLayout());
		JLabel lblSo = new JLabel("Chon so");
		pnCombo.add(lblSo);
		con.add(pnCombo);
		
		cboSo = new JComboBox();
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
			int x = rd.nextInt(1000);
			cboSo.addItem(x);
		}
		pnCombo.add(cboSo);
		
		
		JPanel pnList = new JPanel();
		pnList.setLayout(new FlowLayout());
		JLabel lblSo1 = new JLabel("Chon so :");
		pnList.add(lblSo1);
		con.add(pnList);
		
		
		listSo = new JList();
		Vector<Integer>vec = new Vector<Integer>();
		for (int i = 0; i < 100; i++) {
			int x1 = rd.nextInt(500);
			vec.add(x1);
			
		}
		listSo.setListData(vec);
		
		JScrollPane scList = new JScrollPane(listSo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnList.add(scList);
		
		
		JPanel pnOk = new JPanel();
		pnOk.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnOk = new JButton("Ok");
		pnOk.add(btnOk);
		con.add(pnOk);
	}
	
	
	public void addEvent() {
		cboSo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int vt = cboSo.getSelectedIndex();
				if(vt != -1) 
					JOptionPane.showMessageDialog(null, "Vi tri chon "+vt +
							",co gia tri la "+ cboSo.getSelectedItem());
				
			}
		});
		
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyGiaTriCuaList();
			}
		});
	}
	
	
	protected void xuLyGiaTriCuaList() {
		// TODO Auto-generated method stub
		Object obj = listSo.getSelectedValue();
		int vt =listSo.getSelectedIndex();
		JOptionPane.showMessageDialog(null, "List: vi tri "+vt+" Gia tri "+obj);
		
	}
	
	
	
	public void showWindow() {
		this.setSize(700, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
