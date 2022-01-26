package businesslogic;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.Provider.Service;

import org.junit.After;
import org.junit.Before;

class Ashwini_Junit {

	

		@Before
		public void setUp() throws Exception 
		{
			System.out.println("Setting up");
		}

		@After
		public void tearDown() throws Exception 
		{
			System.out.println("Testing is Done");
		}

		@SuppressWarnings("resource")
		
		public void test() {
			try
			{    
				URL url=new URL("http://www.example.com");    
				URLConnection urlcon=url.openConnection();    
				InputStream stream=urlcon.getInputStream();    
				FileOutputStream fos=new FileOutputStream("C:/Users/Shivansh/eclipse-workspace/Ashwini/src/web-content.txt");
				while(true)
				{
					int i=stream.read();
					if(i==-1)
						break;
					System.out.print((char)i);
					fos.write(i);
				}
	        }
		 catch(Exception e)
		 {
			System.out.println(e);
		 }    
		}

	}