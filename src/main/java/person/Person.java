package person;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    public static enum Gender {
      Male,
      Female
    }
    
    String name;
    Gender gender;
    LocalDate birthday;
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        LocalDate today = LocalDate.now();
        int age = Period.between(birthday, today).getYears();
        return age;
    }
    
    public Gender getGender(){
        return gender;
    }
}
