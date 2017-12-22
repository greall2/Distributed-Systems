package ie.gmit.sw;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Apdapted from Advanced Object Orientated Programme Module

public class ServiceHandler extends HttpServlet {

	private static long jobNumber = 0;


	private static volatile Queue<Request> inQueue = new LinkedList<Request>();
	private static Map<String, String> outQueue = new LinkedHashMap<String, String>();
	private Thread 	client = new Thread(new Client(inQueue, outQueue));


	// Run on servlet class initialized.
	public void init() throws ServletException {
		ServletContext ctx = getServletContext(); //The servlet context is the application itself.
		
	
		if (!client.isAlive()){
			client.start();
		}
	}


	// HTTP Methods.

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html"); 
		PrintWriter out = resp.getWriter(); 
		String str = req.getParameter("searchStr");
		String taskNumber = req.getParameter("frmTaskNumber");
		String result = outQueue.get(taskNumber);
		int counter = 1;
		
		//Tracking asynchronous tasks
		if (taskNumber == null){
			taskNumber = new String("T" + jobNumber);
			jobNumber++;
			Request request = new Request(taskNumber, str);
			inQueue.offer(request);
			printLoadingPage(out, str, taskNumber, counter);				
			
		}else{
		
			if(result !=null)
			{	
				printResultPage(out, str, taskNumber, result);	
			} else{
				if (req.getParameter("counter") != null){
					counter = Integer.parseInt(req.getParameter("counter"));
					counter++;
				}
				printLoadingPage(out, str, taskNumber, counter);	
			}				
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}

	// Handler Methods

	public void printHeader(PrintWriter out){
		out.print("<html><head><title>Dictionary</title>");	
		out.print("</head>");		
		out.print("<body>");
	}
	public void printFooter(PrintWriter out){
		out.print("</body>");	
		out.print("</html>");	
	}
	public void printScript(PrintWriter out){
		out.print("<script>");
		out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);"); //Refresh every 5 seconds
		out.print("</script>");
	}
	public void printLoadingPage(PrintWriter out, String str, String taskNumber, Integer counter){
		printHeader(out);
		//Output some headings at the top of the generated page
		out.print("<H1> Request for Task#: " + taskNumber + "</H1>");
		out.print("<H3>String: " + str + "</H3>");
		
		out.print("<div id=\"r\"></div>");
		out.print("<form name=\"frmRequestDetails\" action=\"doProcess\">");
		out.print("<input name=\"searchStr\" type=\"hidden\" value=\"" + str + "\">");
		out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
		out.print("<input name=\"counter\" type=\"hidden\" value=\"" + counter + "\">");
		out.print("</form>");
		printFooter(out);
		printScript(out);
	}
	public void printResultPage(PrintWriter out, String str, String taskNumber, String result){
		out.print("<center>");
		out.print("<H1>Found " + taskNumber + "</H1>");
		out.print("<H3>Search query: " + str + "</H3>");
		out.print(result);
		out.print("<br><br><a class=\"button\" href=\"index.jsp\">Make Another Query</a>");
		out.print("<form name=\"frmRequestDetails\">");
		out.print("<input name=\"searchStr\" type=\"hidden\" value=\"" + str + "\">");
		out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
		out.print("</form>");
		printFooter(out);
	}
}