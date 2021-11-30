package person;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FemaleTest {
    Female female;
    
    public FemaleTest() {
    }
        
    @BeforeEach
    public void setUp() {
        String name = "Jessica";
        LocalDate birthday = LocalDate.parse("1990-11-05");
        female = new Female(name, birthday);
    }
    
    @Test
    public void testGetName() {
        String expected = "Jessica";
        assertTrue(female.getName().equals(expected));
    }
    
    @Test
    public void testGetAge() {
        int expected = 31;
        assertEquals(expected, female.getAge());
    }

    @Test
    public void testGetGender() {
        Person.Gender expected = Person.Gender.Female;
        assertEquals(expected, female.getGender());
    }
}
