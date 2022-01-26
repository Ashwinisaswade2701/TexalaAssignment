package businesslogic;

	import java.net.HttpURLConnection;
import java.net.MalformedURLException;
	import java.net.URL;
import java.net.URLConnection;
import java.io.*;

	public class ashwini_businesslogic 
	{
	public static void main(String[] args)
	{
		try 
	         {
	            String parseLine; /* variable definition *//* create objects */           
	            URL URL = new URL("http://www.example.com/"); 
	            BufferedReader br = new BufferedReader(new InputStreamReader(URL.openStream()));

	PrintWriter writer=new PrintWriter("C:/Users/Shivansh/eclipse-workspace/Ashwini/src/web_content.txt");
	            while ((parseLine = br.readLine()) != null) 
	            {
	                /* read each line */  
	                   writer.println(parseLine.toString());
	                   writer.println("\n");    
	                           
	               System.out.println(parseLine);
	            }
	           writer.close();

	            br.close();
	          } 
	       catch (MalformedURLException me)
	          {
	            System.out.println(me);
	          } 
	       catch (IOException ioe) 
	        {
	            System.out.println(ioe);
	        }
	   }//class end

		
		public void readingWebsitePage(String webSiteName)
		{

			URL url = null;
			String fName = webSiteName.split("\\.")[1];
			try 
			{
				//Creates a URL object from the String representation
				url = new URL(webSiteName);
			} catch (MalformedURLException e3) 
			{
				System.out.println("Erorr in creating URL for webSite : " + webSiteName);
				e3.printStackTrace();
			}

		
			URLConnection urlConnection = null;
			try {
				
				//Returns a URLConnection instance that represents a connection to the remote 
				// object referred to by the URL. 
				urlConnection = url.openConnection();
			} catch (IOException e2) {
				System.out.println("Error in open connection...");
				e2.printStackTrace();
			}
			HttpURLConnection connection = null;

			if (urlConnection instanceof HttpURLConnection) {
				connection = (HttpURLConnection) urlConnection;
			} else {
				System.out.println("Please enter an HTTP URL.");
				return;
			}

			InputStream inpStream = null;
			try {
				//Returns an input stream that reads from this open connection.
				inpStream = connection.getInputStream();
			} catch (IOException e1) {
				System.out.println("Error in getting stream from InputStream...");
				e1.printStackTrace();
			}
			
			InputStreamReader is = new InputStreamReader(inpStream);
			BufferedReader    in = new BufferedReader(is);

			String currentLine = null;

			
			// logic to write
			FileWriter file=null;
			try {
				file = new FileWriter(System.getProperty("user.dir")+ "/src/main/java/Pooja/" + fName + ".txt");
				System.out.println("fileName : " + System.getProperty("user.dir")+ "/src/test/java/Pooja/" + fName + ".txt");
			
			} catch (IOException e1) {
				System.out.println("Error in opening a file for writing...");
				e1.printStackTrace();
			}
			
			// Creates a BufferedWriter
			BufferedWriter output = new BufferedWriter(file);
		 
			// reading and writing to a file 
			try {
				while ((currentLine = in.readLine()) != null) {
					System.out.println(currentLine);
					output.write(currentLine);
				}
			} catch (IOException e) {
				System.out.println("Error in readding a line from bufferredInpurStream");
				e.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e) {
				System.out.println("Error in closing output file...");
				e.printStackTrace();
			}
		
		}


		public void put() {
			// TODO Auto-generated method stub
			
		}
	   }



