package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame {
	
	JFrame frame;
	MainPanel mp; 
	
	public void init() {
		frame = new JFrame("Printing");
		frame.setSize(600, 100);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		mp = new MainPanel();
		mp.init();
		
		frame.setLayout(new BorderLayout());
		frame.add(mp, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	
	public void sendResults(String r[]) {
		mp.sendScanResults(r);
	}
	
	public boolean printPressed() {return mp.getPrintPressed();}
	
	public String getPath() {return mp.getPath();}
	public int getIndex() {return mp.getIndex();}
	
}
