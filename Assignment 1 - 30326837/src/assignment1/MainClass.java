package assignment1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));
	    writer.write(outputString);
	    writer.close();
	    	    
	}

}
