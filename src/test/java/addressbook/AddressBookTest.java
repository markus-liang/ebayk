package addressbook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import person.Male;
import person.Female;
import person.Person;

public class AddressBookTest {
    IAddressBook addressBook;
    
    public AddressBookTest() {
    }

    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook();
    }

    @Test
    public void testInputRecord() {
        String name = "Paul";
        LocalDate birthday = LocalDate.parse("1985-03-09");
        Person person = new Male(name, birthday);
        
        assertEquals(0, addressBook.getData().size()); //before        
        addressBook.inputRecord(person);
        assertEquals(1, addressBook.getData().size()); //after
    }

    @Test
    public void testImportRecords() {
        List<List<String>> data = new ArrayList<List<String>>();
        
        List<String> inputLines = new ArrayList<String>();
        inputLines.add("Paul");
        inputLines.add("Male");
        inputLines.add("1985-03-09");
        data.add(inputLines);
        
        inputLines = new ArrayList<String>();
        inputLines.add("Jessica");
        inputLines.add("Female");
        inputLines.add("1990-11-05");
        data.add(inputLines);
        
        assertEquals(0, addressBook.getData().size()); //before        
        addressBook.importRecords(data);
        assertEquals(2, addressBook.getData().size()); //after
    }

    @Test
    public void testSortByAgeDesc() {
        String name = "Paul";
        LocalDate birthday = LocalDate.parse("1985-03-09"); // middle
        Person middle = new Male(name, birthday);
        addressBook.inputRecord(middle);
        
        name = "Jessica";
        birthday = LocalDate.parse("1990-11-05"); // youngest
        Person youngest = new Female(name, birthday);
        addressBook.inputRecord(youngest);

        name = "Sarah";
        birthday = LocalDate.parse("1980-08-17"); // oldest
        Person oldest = new Female(name, birthday);
        addressBook.inputRecord(oldest);

        addressBook.sortByAgeDesc();
        List<Person> records = addressBook.getData();
        assertTrue(records.get(0).getName().equals(oldest.getName()));
        assertTrue(records.get(1).getName().equals(middle.getName()));
        assertTrue(records.get(2).getName().equals(youngest.getName()));
    }

    @Test
    public void testFilterDataByGenderMale() {
        String name = "Paul";
        LocalDate birthday = LocalDate.parse("1985-03-09"); // middle
        Person middle = new Male(name, birthday);
        addressBook.inputRecord(middle);
        
        name = "Jessica";
        birthday = LocalDate.parse("1990-11-05"); // youngest
        Person youngest = new Female(name, birthday); 
        addressBook.inputRecord(youngest);

        name = "Sarah";
        birthday = LocalDate.parse("1980-08-17"); // oldest
        Person oldest = new Female(name, birthday);        
        addressBook.inputRecord(oldest);
        
        List<Person> males = addressBook.filterDataByGender(Person.Gender.Male);
        int expected = 1;
        assertEquals(expected, males.size());
    }
    
    @Test
    public void testFilterDataByGenderFemale() {
        String name = "Paul";
        LocalDate birthday = LocalDate.parse("1985-03-09"); // middle
        Person middle = new Male(name, birthday);
        addressBook.inputRecord(middle);
        
        name = "Jessica";
        birthday = LocalDate.parse("1990-11-05"); // youngest
        Person youngest = new Female(name, birthday); 
        addressBook.inputRecord(youngest);

        name = "Sarah";
        birthday = LocalDate.parse("1980-08-17"); // oldest
        Person oldest = new Female(name, birthday);        
        addressBook.inputRecord(oldest);
        
        List<Person> males = addressBook.filterDataByGender(Person.Gender.Female);
        int expected = 2;
        assertEquals(expected, males.size());
    }
}
