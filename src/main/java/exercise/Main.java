package exercise;

import addressbook.*;
import csv.*;
import java.io.File;
import java.util.List;
import person.Person;


public class Main {
    public static String getCsvPath(){
        String csvPath = "";
        try
        {
            csvPath = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            csvPath = csvPath.substring(0, csvPath.lastIndexOf("/")) + "/testdata/address-book.csv";
            System.out.println("csvPath = " + csvPath);

            // released path            
            File f = new File(csvPath);
            if (!f.exists()) {
                csvPath = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
                // debug path
                csvPath = csvPath.substring(0, csvPath.lastIndexOf("/"));
                csvPath = csvPath.substring(0, csvPath.lastIndexOf("/"));
                csvPath += "/testdata/address-book.csv";
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return csvPath;
    }
    
    public static void main(String[] args) {
        String csvPath = getCsvPath();
        ICsvHandler csvHandler = new CsvHandler(csvPath);        
        boolean isLoaded = csvHandler.load();
        if(isLoaded){
            List<List<String>> listPerson = csvHandler.getData();
            IAddressBook addressBook = new AddressBook();
            addressBook.importRecords(listPerson);

            List<Person> femaleRecords = addressBook.filterDataByGender(Person.Gender.Female);
            System.out.println("Number of females inside address book: " + femaleRecords.size());

            addressBook.sortByAgeDesc();
            List<Person> sortedData = addressBook.getData();
            Person oldestPerson = sortedData.get(0);
            System.out.println("Oldest person inside address book: " + oldestPerson.getName());
        }else{
            System.out.println("Failed to load csv.");
            System.out.println(csvHandler.getlastError());
        }
    }

}
