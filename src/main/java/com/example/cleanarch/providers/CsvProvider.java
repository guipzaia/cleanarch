package com.example.cleanarch.providers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVWriter;

@Component
public class CsvProvider {

	public void wirteData(String filePath, List<String[]> data) 
	{ 
	    try {
	    	File file = new File(filePath);
	    	
	        FileWriter outputfile = new FileWriter(file); 
	   
	        CSVWriter writer = new CSVWriter(outputfile, ';', 
	                                         CSVWriter.NO_QUOTE_CHARACTER, 
	                                         CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
	                                         CSVWriter.DEFAULT_LINE_END);
	        writer.writeAll(data);
	   
	        writer.close(); 
	    } 
	    catch (IOException e) { 
	        e.printStackTrace(); 
	    } 
	} 
}
