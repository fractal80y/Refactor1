package assignment1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;


public class MainClass {
	
	public static final String OUTPUT_FILE = "MyOutput.txt";
	public static final String TEST_FILE = "MyTest.txt";

	public MainClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String outputString = new Hospital().run();
		
		System.out.println(outputString);
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE));
	    writer.write(outputString);
	    writer.close();
	    
	   
	    
	    BufferedReader txtOut = new BufferedReader(new FileReader(OUTPUT_FILE));
	    BufferedReader txtRef = new BufferedReader(new FileReader(TEST_FILE));
	    
	   // Analyze each line characters for parity //
	    while(txtOut.ready() && txtRef.ready()) {
	    	String x = txtOut.readLine();         						
	    	String y = txtRef.readLine(); 
	    	if(x.contains(y)) System.out.println("istrue");
	    	else System.out.println("nottrue");
	    	
	    	
	    	
	    }
	    
	   
	    
	    
	    
	    
	    txtOut.close();
	    txtRef.close();
	   
	    
	}

}
