package exercise;

import addressbook.*;
import csv.*;
import java.util.List;
import person.Person;


public class Main {
    public static void main(String[] args) {
        String csvPath = "/Users/maku_tachi/Downloads/coding-challenge-csv-master/src/testdata/address-book.csv";
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
