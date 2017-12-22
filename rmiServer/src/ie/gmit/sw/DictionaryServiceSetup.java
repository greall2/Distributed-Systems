package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryServiceSetup {

	public static void main(String[] args) throws Exception {

		DictionaryService ds = new DictionaryServiceImpl();

		//Starting the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);

		//Bind our remote object to the registry with the human-readable name "dictionaryService"
		Naming.rebind("dictionaryService", ds);

		System.out.println("Server ready.");

	}
}
