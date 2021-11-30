package addressbook;

import java.util.List;
import person.Person;

public interface IAddressBook {
    void inputRecord(Person aPerson);
    void importRecords(List<List<String>> aRecords);
    void sortByAgeDesc();
    List<Person> getData();
    List<Person> filterDataByGender(Person.Gender aGender);    
}
