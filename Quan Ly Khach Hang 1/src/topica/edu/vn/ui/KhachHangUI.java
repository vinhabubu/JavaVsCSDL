package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import topica.edu.vn.model.KhachHang;
import topica.edu.vn.model.NhomKhachHang;



public class KhachHangUI extends JFrame {
	DefaultMutableTreeNode root = null;
	JTree treeNhom;
	
	DefaultTableModel dft;
	JTable tblKhachHang;
	
	JTextField txtTen, txtMa, txtPhone, txtEmail;
	JButton btnLuu, btnXoa;
	
	ArrayList<NhomKhachHang>dsNhom;
	ArrayList<KhachHang>dsKhachHang;
	
	NhomKhachHang nhomSellected;
	
	public KhachHangUI(String title) {
		super(title);
		addControl();
		AddEvent();
		fakeData();
	}

	private void addControl() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(250,0));
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());
		JSplitPane sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		sp1.setOneTouchExpandable(true);
		con.add(sp1,BorderLayout.CENTER);
		
		
		
		JPanel pnRight1 = new JPanel();
		JPanel pnRight2 = new JPanel();
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pnRight1,pnRight2);
		pnRight1.setPreferredSize(new Dimension(0,120));
		spRight.setOneTouchExpandable(true);
		pnRight.add(spRight,BorderLayout.CENTER);
		
		
		
		pnLeft.setLayout(new BorderLayout());
		root = new DefaultMutableTreeNode("Cong ty trach nhiem huu han Abubu");
		treeNhom = new JTree(root);
		JScrollPane scTree = new JScrollPane(treeNhom, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(scTree,BorderLayout.CENTER);
		
		
		
		pnRight1.setLayout(new BorderLayout());
		dft = new DefaultTableModel();
		dft.addColumn("Ma khach hang");
		dft.addColumn("Ten khach hang");
		dft.addColumn("So dien thoai");
		dft.addColumn("Email khach hang");
		tblKhachHang = new JTable(dft);
		 
		
		
		JScrollPane scTable = new JScrollPane(tblKhachHang,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnRight1.add(scTable,BorderLayout.CENTER);
		  
		
		
		
		pnRight2.setLayout(new BoxLayout(pnRight2, BoxLayout.Y_AXIS));
		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout());
		JLabel lblMa = new JLabel("Ma khach hang:");
		txtMa = new JTextField(15);
		pnRight2.add(pnMa);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		
		
		
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTen = new JLabel("Ten khach hang:");
		txtTen = new JTextField(15);
		pnRight2.add(pnTen);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		
		
		
		JPanel pnPhone = new JPanel();
		pnPhone.setLayout(new FlowLayout());
		JLabel lblPhone = new JLabel("So dien thoai:");
		txtPhone = new JTextField(15);
		pnRight2.add(pnPhone);
		pnPhone.add(lblPhone);
		pnPhone.add(txtPhone);
		
		
		
		JPanel pnEmail = new JPanel();
		pnEmail.setLayout(new FlowLayout());
		JLabel lblEmail = new JLabel("Email khach hang:");
		txtEmail = new JTextField(15);
		pnRight2.add(pnEmail);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnLuu = new JButton("Luu");
		btnXoa = new JButton("Xoa");
		pnButton.add(btnLuu);
		pnButton.add(btnXoa);
		pnRight2.add(pnButton);
		
		
		lblMa.setPreferredSize(lblEmail.getPreferredSize());
		lblTen.setPreferredSize(lblEmail.getPreferredSize());
		lblPhone.setPreferredSize(lblEmail.getPreferredSize());
	  }

	
	private void AddEvent() {
		// TODO Auto-generated method stub
		treeNhom.addMouseListener(new MouseListener() {
			
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
				DefaultMutableTreeNode nodeSellected = (DefaultMutableTreeNode) treeNhom.getLastSelectedPathComponent();
				
				if(nodeSellected != null && nodeSellected.getLevel()==1) {
					nhomSellected = (NhomKhachHang) nodeSellected.getUserObject();
					hienthiDanhSachKhachHangTheoNhom();
				}
			}
		});
		
		tblKhachHang.addMouseListener(new MouseListener() {
			
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
				int row = tblKhachHang.getSelectedRow();
				if(row == -1)return;
				String ma = tblKhachHang.getValueAt(row, 0)+"";
				String ten = tblKhachHang.getValueAt(row, 1)+"";
				String phone = tblKhachHang.getValueAt(row, 2)+"";
				String email = tblKhachHang.getValueAt(row, 3)+"";
				txtMa.setText(ma);
				txtTen.setText(ten);
				txtPhone.setText(phone);
				txtEmail.setText(email);
			}
		});
		
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				KhachHang kh = new KhachHang(txtMa.getText(),
						txtTen.getText(),txtPhone.getText(),txtEmail.getText());
				nhomSellected.themKhachHang(kh);
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tblKhachHang.getSelectedRow();
				if(row == -1 )return;
				dft.removeRow(row);// xoa dong da chon
			
			}
		});
	}
	
	
	
	protected void hienthiDanhSachKhachHangTheoNhom() {
		// TODO Auto-generated method stub
		dft.setRowCount(0);
		for(KhachHang kh: nhomSellected.getKhachHangs()) {
			Vector<String>vec = new Vector<String>();
			vec.add(kh.getMa());
			vec.add(kh.getTen());
			vec.add(kh.getPhone());
			vec.add(kh.getEmail());
			dft.addRow(vec);
		}
	}

	public void fakeData() {
		dsNhom = new ArrayList<NhomKhachHang>();
		NhomKhachHang vip =  new NhomKhachHang("n1", "Khach hang vip");
		NhomKhachHang tiemnang =  new NhomKhachHang("n2", "Khach hang tiem nang");
		NhomKhachHang moi =  new NhomKhachHang("n3", "Khach hang moi");
		dsNhom.add(vip);
		dsNhom.add(tiemnang);
		dsNhom.add(moi);
		
				
		vip.getKhachHangs().add(new KhachHang("v1", "Vinh", "0972901883", "vinh@gmail.com"));
		vip.getKhachHangs().add(new KhachHang("v2", "Ly", "0972801883", "vinh@gmail.com"));
		vip.getKhachHangs().add(new KhachHang("v3", "Tuan", "0972501883", "vinh@gmail.com"));
		vip.getKhachHangs().add(new KhachHang("v4", "Tu", "0972661883", "vinh@gmail.com"));
		
		
		for(NhomKhachHang nhom: dsNhom) {
			DefaultMutableTreeNode nodeNhom = new DefaultMutableTreeNode(nhom);
			root.add(nodeNhom);
			
			for(KhachHang khach: nhom.getKhachHangs()) {
				DefaultMutableTreeNode nodeKhach = new DefaultMutableTreeNode(khach);
				nodeNhom.add(nodeKhach);
			}
			
		}
		
		treeNhom.expandRow(0);
		
	}
	
	public void showWindow() {
   		this.setSize(700, 350);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setVisible(true);
   	}

}
