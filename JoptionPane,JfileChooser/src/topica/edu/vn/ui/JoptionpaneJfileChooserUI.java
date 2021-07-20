package topica.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

public class JoptionpaneJfileChooserUI extends JFrame {
	
	JMenuBar mnuBar ;
	JMenu mnuFile;
	JMenuItem mnuFileSave, mnuFileOpen, mnuFileExit ;
	
	JTextArea txtData ;
	
	JFileChooser chooser ;
	public JoptionpaneJfileChooserUI(String title) {
		super(title);
		addControl();
		addEvent();
	}

	
	
	private void addControl() {
		// TODO Auto-generated method stub
		setupMenuBar();
		
	    Container con = getContentPane();
	    con.setLayout(new BorderLayout());
	    txtData = new JTextArea(50,50);
	    txtData.setLineWrap(true);
	    txtData.setWrapStyleWord(true);
	    JScrollPane sc = new JScrollPane(txtData,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	    		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    con.add(sc,BorderLayout.CENTER);
	    
	    
	    chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Tap tin.txt";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".txt");
			}
		});
			
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Word 2007,2016 ";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".doc")||f.getAbsolutePath().endsWith(".docx");
			}
		});
		
	}

	
	
	private void setupMenuBar() {
		// TODO Auto-generated method stub
		mnuBar = new JMenuBar();
		setJMenuBar(mnuBar);
		mnuFile = new JMenu("Hệ thống");
		mnuBar.add(mnuFile);
		
		mnuFileSave = new JMenuItem("Save");
		mnuFileOpen = new JMenuItem("Open");
		mnuFileExit = new JMenuItem("Exit");
		mnuFile.add(mnuFileSave);
		mnuFile.add(mnuFileOpen);
		mnuFile.addSeparator();
		mnuFile.add(mnuFileExit);
		
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		mnuFileExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xulyExit();
			}		
		});
		
		mnuFileOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xulyOpen();
			}
		});	
		
		
		mnuFileSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xulySave();
			}
		});
	}
	
	
	
	
	protected void xulySave() {
		// TODO Auto-generated method stub
		if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			String data = txtData.getText();
			try {
				FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile());
				OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
				osw.write(data);
				osw.close();
				fos.close();
				JOptionPane.showMessageDialog(null, "Luu file Thanh cong ");
				
			} catch (Exception e) {
				// TODO: handle exception
				
			}
		}
	}



	protected void xulyOpen() {
		// TODO Auto-generated method stub
		 chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Tap tin.txt";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".txt");
			}
		});
			
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Word 2007,2016 ";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".doc")||f.getAbsolutePath().endsWith(".docx");
			}
		});
		
		
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {		
			
			try {
				File fileSellected = chooser.getSelectedFile();
				FileInputStream fis = new FileInputStream(fileSellected);
				InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String line = br.readLine();
				StringBuilder buider = new  StringBuilder();
				
				while(line != null) {
					buider.append(line);
					line = br.readLine();
				}
				
				br.close();
				txtData.setText(buider.toString());
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	protected void xulyExit() {
		// TODO Auto-generated method stub
		int ret = JOptionPane.showConfirmDialog(null, "Ban co chac chan muon thoat phan mem nay khong ? ",
				"Xac nhan thoat",JOptionPane.YES_NO_OPTION);
		if(ret == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void showWindow() {
   		this.setSize(650, 350);
   		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
   		this.setLocationRelativeTo(null);
   		this.setVisible(true);
   	}

}
