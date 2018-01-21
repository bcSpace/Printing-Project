package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel {

	private JButton print;
	private JButton scan; 
	private JTextField path;
	
	private JLabel userUpdate; 
	
	private JComboBox displayBox;
	private DefaultComboBoxModel box; 
	
	private boolean printPressed;
	private boolean scanPressed;
	
	private boolean hasScanResults;
	
	public void init() {
		print = new JButton("Print All");
		scan = new JButton("Scan for printers");
		path = new JTextField("C:\\", 20);
		box = new DefaultComboBoxModel();
		displayBox = new JComboBox(box);
		userUpdate = new JLabel();
		
		setLayout(new FlowLayout());
		add(userUpdate);
		add(scan);
		add(print);
		add(path);
		add(displayBox);
		
		printPressed = false;
		scanPressed = false;
		hasScanResults = false;
		addListeners();
	}
	
	public void sendScanResults(String results[]) {
		box.removeAllElements();
		for(int i = 0;i < results.length; i++) box.addElement(results[i]);
		displayBox = new JComboBox(box);
		System.out.println("Got");
		userUpdate.setText("Scanning done");
		hasScanResults = true;
	}
	
	public void sendUserUpdate(String s) {
		userUpdate.setText(s);
	}
	
	private void addListeners() {
		
		print.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  if(!hasScanResults) {
					  userUpdate.setText("Scan first");
				  } else {
					  userUpdate.setText("");
					  printPressed = true;
				  }
			  } 
		});
		
		scan.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  userUpdate.setText("Scanning");
				  scanPressed = true;
			  } 
		});
		
	}

	public boolean getScanPressed() {boolean b=scanPressed; scanPressed = false; return b;}
	public boolean getPrintPressed() {boolean b=printPressed; printPressed = false; return b;}
	
	public String getPath() {return path.getText();}
	public int getIndex() {return displayBox.getSelectedIndex();}
	
	
}
