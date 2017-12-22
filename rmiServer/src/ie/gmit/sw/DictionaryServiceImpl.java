package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.HashMap;
import java.util.Map;
public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;

	Map<String,String> d;
	
	public DictionaryServiceImpl() throws FileNotFoundException, IOException{
		DictionaryReader dr = new DictionaryReader("dictionary.csv");
		d = dr.loadDict();
	}

	@Override
	public String search(String word) throws RemoteException {
		    String result = d.get(word);
		    if(result != null)
		    	return result;
		    return "Word not found.";	    	 
	}
	
	
}
