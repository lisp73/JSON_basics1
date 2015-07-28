package main;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

//Parses a JSON file containing a USD to EUR exchange rate from 
/*http://rate-exchange.appspot.com
 * 
 */

public class JASONMain {
	
	public static final String JSON_FILE_NAME="rate-exchange.json";
	
	//Parse and display the JSON file. 
	public static void main(String[] args) throws FileNotFoundException{
		
		//FILE NAME
		
		//get a JSON parser
		JsonParser parser = Json.createParser(new FileReader(JSON_FILE_NAME));
		
		//parse the file
		while(parser.hasNext()){
			JsonParser.Event event=parser.next();
			if(event.equals(JsonParser.Event.KEY_NAME)){
				
				String key=parser.getString();
				parser.next();
				String value=parser.getString();
				System.out.printf(">> %s: %s\n", key, value);
				
			}
		}//end of while loop
				
	}//end of test-driver 

}//end of JSONMain
