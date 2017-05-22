package week2;

/**
 * Created by valentina on 20.05.17.
 */
public class Patient extends Person {
    private String diagnose;
    private double weight;
    private double height;

    public Patient(String name, String surname, String middlename, int age, char sex, String diagnose, double weight, double height) {
        super(name, surname, middlename, age, sex);
        this.diagnose = diagnose;
        this.weight = weight;
        this.height = height;
    }

    public String asString() {
        return null;
    }
}
