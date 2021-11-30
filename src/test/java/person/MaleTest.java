package person;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaleTest {
    Male male;
    
    public MaleTest() {
    }
        
    @BeforeEach
    public void setUp() {
        String name = "Paul";
        LocalDate birthday = LocalDate.parse("1985-03-09");
        male = new Male(name, birthday);
    }
    
    @Test
    public void testGetName() {
        String expected = "Paul";
        assertTrue(male.getName().equals(expected));
    }
    
    @Test
    public void testGetAge() {
        int expected = 36;
        assertEquals(expected, male.getAge());
    }

    @Test
    public void testGetGender() {
        Person.Gender expected = Person.Gender.Male;
        assertEquals(expected, male.getGender());
    }
}
