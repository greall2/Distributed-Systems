package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
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
		
		
			while(true){
			   String line = br.readLine();
			    if(line == null) break;
			    String[] splitted = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
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
