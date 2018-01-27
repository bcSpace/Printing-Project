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
	private JTextField path;

	private JComboBox displayBox;
	private DefaultComboBoxModel box; 
	
	private boolean printPressed;
	
	
	public void init() {
		print = new JButton("Print All");
		path = new JTextField("C:\\", 20);
		box = new DefaultComboBoxModel();
		displayBox = new JComboBox(box);
		
		setLayout(new FlowLayout());
		add(print);
		add(path);
		add(displayBox);
		
		printPressed = false;
		addListeners();
	}
	
	public void sendScanResults(String results[]) {
		box.removeAllElements();
		for(int i = 0;i < results.length; i++) box.addElement(results[i]);
		displayBox = new JComboBox(box);
		System.out.println("Got");
	}
	
	
	private void addListeners() {
		
		print.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
					  printPressed = true;
			  } 
		});
		
		
	}

	public boolean getPrintPressed() {boolean b=printPressed; printPressed = false; return b;}
	
	public String getPath() {return path.getText();}
	public int getIndex() {return displayBox.getSelectedIndex();}
	
	
}
