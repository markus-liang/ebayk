package csv;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


public class CsvHandlerTest {
    ICsvHandler csvHandler;

    public CsvHandlerTest() {
    }

    @BeforeEach
    public void setUp() {
        csvHandler = new CsvHandler();
    }

    @Test
    public void testSetGetPath() {
        String expected = "";
        assertTrue(csvHandler.getPath().equals(expected));
        expected = "/some_path/";
        csvHandler.setPath(expected);
        assertTrue(csvHandler.getPath().equals(expected));
    }

    @Test
    public void testLoadFailed() {
        boolean expected = false;
        assertEquals(expected, csvHandler.load());
    }

    @Test
    public void testGetData() {
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

        int expected = 0;
        assertEquals(expected, csvHandler.getData().size());
        csvHandler = new CsvHandler(data);
        expected = 2;
        assertEquals(expected, csvHandler.getData().size());        
    }

    @Test
    public void testGetlastError() {
        String expected = "";
        assertTrue(csvHandler.getlastError().equals(expected));
        csvHandler.load();
        assertFalse(csvHandler.getlastError().equals(expected));
    }
    
}
