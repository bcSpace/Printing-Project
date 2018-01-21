package main;

import javax.swing.JOptionPane;

import files.FileLoader;
import gui.MainFrame;
import print.Printer;

public class Main {

	private MainFrame mf;
	private FileLoader fl;
	private Printer printer; 
	
	private boolean running; 
	
	Main() {
		System.out.println("Started");
		mf = new MainFrame();
		mf.init();
		
		fl = new FileLoader();
		
		printer = new Printer();
		printer.init();
		
		running = true;
		
		while(running) {
			
			if(mf.scanPressed()) {
				mf.sendResults(printer.scanForPrinters());
			} 
			
			if(mf.printPressed()) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to print for " + mf.getPath() + ", " + fl.getAllFiles(mf.getPath()).length + " total files","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
				  // Saving code here
					mf.sendUserUpdate(printer.print(mf.getIndex(), mf.getPath()));
				} else {
					
				}
			}
			
			sleep(100);
		}
		
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	private void sleep(long time) {try {Thread.sleep(time);} catch (InterruptedException e) {}}
	
}
