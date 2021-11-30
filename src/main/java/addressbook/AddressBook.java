package addressbook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import person.*;

public class AddressBook implements IAddressBook {
    private List<Person> records;
    
    public AddressBook(){
        records = new ArrayList<Person>();
    }
    
    public void inputRecord(Person aPerson){
        records.add(aPerson);
    }

    public void importRecords(List<List<String>> aRecords){
        for(List<String> recordPerson: aRecords){
            Person person;
            if (recordPerson.get(1).equals("Male")) {
                person = new Male(recordPerson.get(0), 
                        LocalDate.parse(recordPerson.get(2)));
            }else{
                person = new Female(recordPerson.get(0), 
                        LocalDate.parse(recordPerson.get(2)));                
            }
            records.add(person);
        }
    }
    
    public void sortByAgeDesc(){
        records.sort((person1, person2) -> person2.getAge() - person1.getAge());
    }
    
    public List<Person> getData(){
        return records;
    }
    
    public List<Person> filterDataByGender(Person.Gender aGender){
        List<Person> filteredRecords = new ArrayList<Person>();
        for(Person person: records){
            if (person.getGender() == aGender){
                filteredRecords.add(person);
            }
        }
        return filteredRecords;
    }
}
