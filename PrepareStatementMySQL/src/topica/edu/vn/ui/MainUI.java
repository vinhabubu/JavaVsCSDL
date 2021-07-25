package topica.edu.vn.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import topica.edu.vn.ui.SelectUI;

public class MainUI extends JFrame {
	JButton btnSelect, btnInsert, btnUpdate, btnDelete, btnDelete2;
	
	public MainUI(String title) {
		super(title);
		addControl();
		addEvent();
	}

	private void addControl() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new FlowLayout());
		btnSelect = new JButton("PreparedStatement - select");
		btnInsert = new JButton("PreparedStatement - insert");
		btnUpdate = new JButton("PreparedStatement - update");
		btnDelete = new JButton("PreparedStatement - delete");
		btnDelete2 = new JButton("PreparedStatement - delete2");
		con.add(pnMain);
		pnMain.add(btnSelect);
		pnMain.add(btnInsert);
		pnMain.add(btnUpdate);
		pnMain.add(btnDelete);
		pnMain.add(btnDelete2);
		
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		btnSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelectUI ui = new SelectUI("Select");
				ui.showWindow();
			}
		});
		
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InsertUI ui = new InsertUI("Insert");
				ui.showWindow();
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UpdateUI ui = new UpdateUI("Update");
				ui.showWindow();
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteUI ui = new DeleteUI("Delete");
				ui.showWindow();
			}
		});
		btnDelete2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Delete2UI ui = new Delete2UI("Delete2");
				ui.showWindow();
			}
		});
	}
	
	public void showWindow() {
   		this.setSize(400, 300);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setVisible(true);
   	}


}
