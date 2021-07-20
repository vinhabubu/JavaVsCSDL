package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;




public class JtreeUI extends JFrame {
	
	DefaultMutableTreeNode root = null;
	JTree tree;
  public JtreeUI(String title) {
	  super(title);
	  addControl();
	  addEvent();
  
  
}

       private void addEvent() {
	// TODO Auto-generated method stub
    	   tree.addMouseListener(new MouseListener() {
			
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
				Object obj = tree.getLastSelectedPathComponent();
				DefaultMutableTreeNode nodeSelected = (DefaultMutableTreeNode) obj;
				JOptionPane.showMessageDialog(null, nodeSelected.getUserObject()+"");
			}
		});
	
}

       private void addControl() {
	// TODO Auto-generated method stub
    	   Container con = getContentPane();
    	   JPanel pnTree = new JPanel();
    	   pnTree.setLayout(new BorderLayout());
    	   root = new DefaultMutableTreeNode("Topica Eduma11");
    	   tree = new JTree(root);
    	   DefaultMutableTreeNode nodePhtgv = new DefaultMutableTreeNode("Phong hop tac gian vien");
    	   root.add(nodePhtgv);
    	   
    	   DefaultMutableTreeNode nodeKd = new DefaultMutableTreeNode("Phong kinh doanh");
    	   root.add(nodeKd);
    	   
    	   DefaultMutableTreeNode nodeKt = new DefaultMutableTreeNode("Phong ke toan");
    	   root.add(nodeKt);
    	   
    	   DefaultMutableTreeNode nodeGv =new DefaultMutableTreeNode("Giang vien");
    	   nodePhtgv.add(nodeGv);
    	 
    	   JScrollPane sc =new JScrollPane(tree,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    	   pnTree.add(sc,BorderLayout.CENTER);
    	   
    	  
    	   JPanel pnRight = new JPanel();
    	   JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnTree,pnRight);
    	   sp.setOneTouchExpandable(true);
    	   
    	   
    	   con.setLayout(new BorderLayout());
    	   pnTree.setPreferredSize(new Dimension(300,0));
    	   con.add(sp,BorderLayout.CENTER);
	
}
       public void showWindow() {
   		this.setSize(650, 350);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setVisible(true);
   	}


}
