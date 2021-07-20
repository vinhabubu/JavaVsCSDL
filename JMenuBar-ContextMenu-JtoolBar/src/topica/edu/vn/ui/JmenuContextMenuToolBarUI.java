package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.MenuShortcut;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;



public class JmenuContextMenuToolBarUI extends JFrame {
	
	JMenuBar mnuBar;
	
	JMenu mnuFile, mnuEdit, mnuHelp;
	
	JMenuItem mnuFileNew, mnuFileOpen, mnuFileExit;	
	JMenuItem mnuEditCopy, mnuEditPaste, mnuEditDelete;	
	JMenuItem mnuHelpGui, mnuHelpAbout ;
	
	JButton btn1, btn2 ;
	
	JMenuItem mnuPopUpBlue, mnuPopUpRed ;
	
	JButton btnLastedChoose = null;
	
	JToolBar toolBar;
	JButton btnLenh1, btnLenh2 ;
	JCheckBox chk1, chk2 ;
	
	
	public JmenuContextMenuToolBarUI(String title) {
		super(title);
		addControl();
		addEvent();
		
	}
	
	
	private void addControl() {
		mnuBar = new JMenuBar();
		setJMenuBar(mnuBar);
		mnuFile = new JMenu("File");
		mnuBar.add(mnuFile);
		mnuEdit = new JMenu("Edit");
		mnuBar.add(mnuEdit);
		mnuHelp = new JMenu("Help");
		mnuBar.add(mnuHelp);
		
		mnuFileNew = new JMenuItem("New");
		mnuFileNew.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		//MenuItem mi = new MenuItem("Copy", new MenuShortcut(KeyEvent.VK_C));
		mnuFileOpen = new JMenuItem("Open");
		mnuFileExit = new JMenuItem("Exit");
		mnuFileExit.setAccelerator(KeyStroke.getKeyStroke('A', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		mnuFileExit.setIcon(new ImageIcon("Hinh1/download.jpg"));
		mnuFile.add(mnuFileNew);
		mnuFile.add(mnuFileOpen);
		mnuFile.addSeparator();
		mnuFile.add(mnuFileExit);
			
		
		mnuEditCopy =new JMenuItem("Copy");
		mnuEditPaste = new JMenuItem("Paste");
		mnuEditDelete = new JMenuItem("Delete");
		mnuEdit.add(mnuEditCopy);
		mnuEdit.add(mnuEditPaste);
		mnuEdit.add(mnuEditDelete);
		
		mnuHelpGui = new JMenuItem("Gui");
		mnuHelpAbout = new JMenuItem("About");
		mnuHelp.add(mnuHelpGui);
		mnuHelp.add(mnuHelpAbout);
		
		
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new FlowLayout());
		btn1 = new JButton("Bam chuot phai vao day");
		pnMain.add(btn1);
		con.add(pnMain,BorderLayout.CENTER);
		
		btn2 = new JButton("Button2");
		pnMain.add(btn2);
		 
		
		btn1.addMouseListener(new PopClickListener());
		btn2.addMouseListener(new PopClickListener());
		
		toolBar = new JToolBar();
		btnLenh1 = new JButton("Lenh 1");
		btnLenh2 = new JButton("Lenh 2");
		chk1 = new JCheckBox("Tu dong luu 1");
		chk2 = new JCheckBox("Tu dong luu 2");
		toolBar.add(btnLenh1);
		toolBar.add(btnLenh2);
		toolBar.add(chk1);
		toolBar.add(chk2);
		con.add(toolBar,BorderLayout.NORTH);
		
	}
		/*
		 * class PopUpDemo extends JPopupMenu { JMenuItem anItem; public PopUpDemo() {
		 * anItem = new JMenuItem("Click me"); add(anItem); } }
		 */
		class PopUpDemo extends JPopupMenu {
		    
		    public PopUpDemo() {
		        mnuPopUpBlue = new JMenuItem("To mau xanh");
		        add(mnuPopUpBlue);
		        
		        mnuPopUpRed = new JMenuItem("To mau do");
		        add(mnuPopUpRed);
		        
		        
		        mnuPopUpBlue.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						btnLastedChoose.setBackground(Color.BLUE);
					}
				});
		        
		        
		        mnuPopUpRed.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						btnLastedChoose.setBackground(Color.RED);
					}
				});
		    }
		}
		
		class PopClickListener extends MouseAdapter {
		    public void mousePressed(MouseEvent e) {
		        if (e.isPopupTrigger())
		            doPop(e);
		    }

		    public void mouseReleased(MouseEvent e) {
		        if (e.isPopupTrigger())
		            doPop(e);
		    }

		    private void doPop(MouseEvent e) {
		        PopUpDemo menu = new PopUpDemo();
		        btnLastedChoose = (JButton) e.getComponent();
		        menu.show(e.getComponent(), e.getX(), e.getY());
		    }
		}

		
	

	private void addEvent() {
		// TODO Auto-generated method stub
		mnuFileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		mnuFileNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Ban vua go Ctrol N");
			}
		});
		
		btnLenh1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Ban chon lenh 1 trn ToolBar");
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
