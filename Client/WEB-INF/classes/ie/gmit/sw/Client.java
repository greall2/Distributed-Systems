package ie.gmit.sw;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.*;

//Apdapted from Advanced Object Orientated Programme Module

public class Client implements Runnable {

    private volatile Queue<Request> inqueue;
	private Map<String, String> outqueue;

    public Client( Queue<Request> in, Map<String, String> out){

        this.inqueue = in;
		this.outqueue = out;
    }

    @Override
	public void run() { 

        while(true){

            Request r = inqueue.poll();

            if(r != null){
                String result = r.doRequest();
                outqueue.put(r.getTaskNumber(), result);
            }
        }
	}
}