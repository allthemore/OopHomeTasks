package week2;

/**
 * Created by valentina on 20.05.17.
 */
public abstract class Person {
    private String name;
    private String surname;
    private String middleName;
    private int age;
    private char sex;

    public Person(String name, String surname, String middleName, int age, char sex) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.sex = sex;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }


    private String asString() {
        final StringBuilder sb = new StringBuilder("Person");
        return sb.toString();
    }
}
