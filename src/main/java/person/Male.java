package person;

import java.time.LocalDate;

public class Male extends Person {
    public Male(String aName, LocalDate aBirthday){
        name = aName;
        gender = Gender.Male;
        birthday = aBirthday;
    }
}
