
/** -----------------------------------------------------------------------------------------------------------------
 * Main.java
 * ------------------------------------------------------------------------------------------------------------------
 */
 
 package delegation;

import delegation.Person.*;

public class Main {

  public static void main(String[] args) {
    Person person1 = new PersonBuilder().setFirstname("beLINda").setSurname("Stifani").setAge(37)
        .setEmail("beLINda@gmail.com").build();

    Person person2 = new PersonBuilder(person1).setFirstname("Lin").setSurname("Schuehle").setAge(17)
        .setEmail("beLINda@mail.net").build();

    Person person3 = new PersonBuilder().setFirstname("Belinda").setSurname("Stifani").setAge(20)
        .setEmail("beLINda@gmail.com").build();
    
    System.out.println(person3);
    System.out.println(person2);
    System.out.println("Together:");
    System.out.println(person1);
  }
}
