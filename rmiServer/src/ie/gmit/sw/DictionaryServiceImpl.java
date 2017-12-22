package ie.gmit.sw;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
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
		//checking if word entered is in the hashmap and returning the result if found
		    String result = d.get(word);
		    if(result != null)
		    	return result;
		    //Otherwise printing out the following if not
		    return "String not found!";	    	 
	
	}
	
	
}
