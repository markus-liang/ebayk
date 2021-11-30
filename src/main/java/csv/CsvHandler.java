package csv;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CsvHandler implements ICsvHandler {
    private String path;
    private String lastError;
    private List<List<String>> data;

    public CsvHandler(){
        data = new ArrayList<List<String>>();
        setPath("");
        lastError = "";
    }
    
    public CsvHandler(String aPath){
        data = new ArrayList<List<String>>();
        setPath(aPath);
        lastError = "";
    }

    public CsvHandler(List<List<String>> aData){
        data = new ArrayList<List<String>>();
        data = aData;
        lastError = "";
    }
    
    public void setPath(String aPath){
        path = aPath;
    }
    
    public String getPath(){
        return path;
    }
    
    public boolean load(){
        try{
            data = new ArrayList<List<String>>();
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String inputLine = reader.nextLine();
                String[] splittedLine = inputLine.split(", ");
                
                if(splittedLine.length == 3){
                    List<String> parsedLine = new ArrayList<String>(
                            Arrays.asList(splittedLine));

                    data.add(parsedLine);
                }
            }
            reader.close();            
            lastError = "";            
            return true;
        }catch (Exception e){
            lastError = e.getMessage();
            return false;
        }
    }
    
    public List<List<String>> getData(){
        return data;
    }
    
    public String getlastError(){
        return lastError;
    }
}
