package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DictionaryReader {
	
	String fileName;
	
	public DictionaryReader(String fileName) {
		this.fileName = fileName;
		}
	
	public Map<String, String> loadDict(){
		try{
			Map<String,String> d = new HashMap<String, String>();
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringBuilder definition = new StringBuilder();
			
			br.readLine();//reading in first line incase nothing there
			
			String content = "";
			while(true){
			   String line = br.readLine();
			    if(line == null) break;
			    String[] splitted = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			    System.out.println(splitted[0] + splitted[1]);
			    
			    //content += line;
			    d.put(splitted[0], splitted[1]);
			}
			
		
		br.close();	
		return d;
	}catch(Exception e){
		e.printStackTrace();
	}
	 return null;
	}
	

}
