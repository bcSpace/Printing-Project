package files;

import java.io.File;

public class FileLoader {
	
	public File[] getAllFiles(String path) {
		System.out.println("Path: " + path);
//		path = path.replace("\\", File.separator);
		System.out.println("Path: " + path);
		
		File folder = new File(path);
		File[] list = folder.listFiles();
		int counter = 0;
		
		if(list == null) {
			return new File[] {};
		}
		
		File nList[] = new File[list.length];
		for(int i = 0; i < list.length; i++) {
			if(list[i].isFile()) {
				System.out.println(list[i].getPath());
				nList[counter] = list[i];
				counter++;
			}
		}
		File n[] = new File[counter];
		for(int i = 0; i < counter; i++) n[i] = nList[i];
		return n;
	}
	

}
