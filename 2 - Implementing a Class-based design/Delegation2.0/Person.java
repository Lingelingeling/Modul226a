/** -----------------------------------------------------------------------------------------------------------------
 * Person.java
 * ------------------------------------------------------------------------------------------------------------------
 */
 
 package delegation;
/**
 * Created by BeLINda 27.09.2018
 */
 
public class Person {
  private final String firstname;
  private final String surname;
  private final int age;
  private final String email;

  private Person(PersonBuilder personBuilder) {
    this.firstname = personBuilder.firstname;
    this.surname = personBuilder.surname;
    this.age = personBuilder.age;
    this.email = personBuilder.email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getSurname() {
    return surname;
  }

  public int getAge() {
    return age;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;

    Person person = (Person) object;

    if (age != person.age)
      return false;
    if (firstname != null ? !firstname.equals(person.firstname) : person.firstname != null)
      return false;
    if (surname != null ? !surname.equals(person.surname) : person.surname != null)
      return false;
    if (email != null ? !email.equals(person.email) : person.email != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 12 * result + (surname != null ? surname.hashCode() : 0);
    result = 39 * result + age;
    result = 78 * result + (email != null ? email.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("Person{");
    stringBuilder.append("firstname='").append(firstname).append('\'');
    stringBuilder.append(", surname='").append(surname).append('\'');
    stringBuilder.append(", age=").append(age);
    stringBuilder.append(", email='").append(email).append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }

  public static class PersonBuilder {
    private String firstname;
    private String surname;
    private int age;
    private String email;

    public PersonBuilder() {
    }

    public PersonBuilder(Person person) {
      this.firstname = person.firstname;
      this.surname = person.surname;
      this.age = person.age;
      this.email = person.email;
    }

    public PersonBuilder setFirstname(String firstname) {
      this.firstname = firstname;
      return this;
    }

    public PersonBuilder setSurname(String surname) {
      this.surname = surname;
      return this;
    }

    public PersonBuilder setAge(int age) {
      this.age = age;
      return this;
    }

    public PersonBuilder setEmail(String email) {
      this.email = email;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }
}
