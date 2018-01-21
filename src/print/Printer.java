package print;

import java.awt.print.PrinterJob;
import java.io.File;
import java.net.MalformedURLException;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;

import files.FileLoader;

public class Printer {
	
	FileLoader fl;
	PrintService[] services; 
	
	String userUpdate;
	
	public void init() {
		fl = new FileLoader();
	}
	
	public String[] scanForPrinters() {
		services = PrinterJob.lookupPrintServices();
		String s[] = new String[services.length];
		for(int i = 0; i < s.length; i++) s[i] = services[i].getName();
		return s;
	}
	
	public String print(int id, String path) {
		File files[] = fl.getAllFiles(path);
		if(files.length == 0) {
			return "No files in path";
		}
		
		DocPrintJob jobs[] = new DocPrintJob[files.length]; 
		for(int i = 0; i < jobs.length; i++) jobs[i] = services[id].createPrintJob();
		
		for(int i = 0; i < files.length; i++) {
			try {
				SimpleDoc sd = new SimpleDoc(files[i].toURL(), DocFlavor.URL.AUTOSENSE, null);
				jobs[i].print(sd, null);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (PrintException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Jobs sent to printer";
	}
	
	public void cancelAll() {
		
	}

}
