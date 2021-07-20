package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JtableUI extends JFrame {
	
	DefaultTableModel dft ;
	JTable tblSinhVien ;
	
	JButton btnThem, btnXoa ;
	
	public JtableUI(String titile) {
		super(titile);
		addControl();
		addEvent();
	}
	
	public void addControl() {
		Container con =getContentPane();
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(400,0));
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
		sp.setOneTouchExpandable(true);
		con.add(sp);
		
		dft = new DefaultTableModel();
		dft.addColumn("Ma");
		dft.addColumn("Ten");
		dft.addColumn("Dia chi");
		
		String row1[] = {"SV1","Vinh","Ha Noi"};
		String row2[] = {"SV2","Ly","Hai Phong"};
		String row3[] = {"SV3","Tit","Nam Dinh"};
		String row4[] = {"SV4","Phong","Hue"};
		String row5[] = {"SV5","Quyen","Da Nang"};
		dft.addRow(row1);
		dft.addRow(row2);
		dft.addRow(row3);
		dft.addRow(row4);
		dft.addRow(row5);
		
		Vector<String>vec = new Vector<String>();
		vec.add("SV11");
		vec.add("Tuan");
		vec.add("Lang Son");
		dft.addRow(vec);
		
		
		tblSinhVien = new JTable(dft);
		JScrollPane scTable = new JScrollPane(tblSinhVien,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.setLayout(new BorderLayout());
		pnLeft.add(scTable,BorderLayout.CENTER);
		
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		pnLeft.add(pnButton,BorderLayout.SOUTH);
		btnThem = new JButton("Them");
		btnXoa = new JButton("Xoa");
		pnButton.add(btnThem);
		pnButton.add(btnXoa);
	}
	
	public void addEvent() {
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Vector<String>vec1 = new Vector<String>();
				vec1.add("Ma xxx");
				vec1.add("Ten yyy");
				vec1.add("Dia chi zzz");
				dft.addRow(vec1);
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tblSinhVien.getSelectedRow();
				if(row == -1)return;
				 dft.removeRow(row);// Xoa dong da chon
			}
		});
		
		
		tblSinhVien.addMouseListener(new MouseListener() {
			
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
				int row = tblSinhVien.getSelectedRow();
				if(row == -1)return;
				String ma = tblSinhVien.getValueAt(row, 0)+"";
				String ten = tblSinhVien.getValueAt(row, 1)+"";
				String diaChi = tblSinhVien.getValueAt(row, 2)+"";
				JOptionPane.showMessageDialog(null, "Ma:"+ma+"\n"+"Ten:"+ten+"\n"
						+"Dia chi:"+diaChi);
		  }
		});
	}
	
	public void showWindow() {
		this.setSize(650, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
