package ie.gmit.sw;

import java.rmi.Naming;

public class Request{
	
    //Global Request Variables
	String taskNumber;
    String word;	
	
	public Request(String task, String word){
		this.taskNumber = task;
        this.word = word;
	}
	
	// Getters and Setter Methods
	public String getTaskNumber() {
		return taskNumber;
	}
    public String getWord(){
        return word;
    }

	public void setTaskNumber(String taskNumber) {
		this.taskNumber = taskNumber;
	}
	public void setWord(String word){
        this.word = word;
    }
	public String doRequest(){
        String result;
		try{
			DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
			result = ds.search(this.word);
		}catch (Exception e) {
			result = "Error";
		}
		return result;
    }
	
}