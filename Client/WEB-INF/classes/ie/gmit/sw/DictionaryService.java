package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Apdapted from Advanced Object Orientated Programme Module

public interface DictionaryService extends Remote{
	
	public String search(String word) throws RemoteException;
}
