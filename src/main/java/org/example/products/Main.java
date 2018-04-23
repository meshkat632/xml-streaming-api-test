package org.example.products;
import javax.xml.stream.XMLStreamException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, XMLStreamException {

        List<Map<String,String>> table = new ArrayList<>();

        int iterator = 0;
        int iterator2 = 0;

        XmlReader reader = new XmlReader("products.xml");
        Map<String,String> document;
        Gson gson = new Gson();        
        

        while ((document = reader.getNextDocument()) != null) {
        	System.out.println("-------------------------");
        	String json = gson.toJson(document);
        	 
        	
        	System.out.println(json);
        	
            System.out.println("-------------------------");
            table.add(document);
            
            iterator++;

            System.out.println(iterator);
             

            
            if (iterator == 1) {
                break;
            }
            
        }
    }
    
    public static void writeToFile(String content, String fileName) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("./data/"+fileName))) {
			

			bw.write(content);
			
			// no need to close it.
			//bw.close();

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}