package person;

import java.time.LocalDate;

public class Female extends Person {
    public Female(String aName, LocalDate aBirthday){
        name = aName;
        gender = Gender.Female;
        birthday = aBirthday;
    }    
}
