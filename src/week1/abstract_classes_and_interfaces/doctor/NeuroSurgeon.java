package week1.abstract_classes_and_interfaces.doctor;

/**
 * Created by valentina on 22.05.17.
 */
public class NeuroSurgeon implements Doctor{
    private String name;
    private String surname;
    private int age;
    private String specialization;
    private int yearsOfExperience;
    private int salary;

    public NeuroSurgeon(String name, String surname, int age, String specialization, int yearsOfExperience, int salary) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void work(){
        System.out.println("Do neuro-surgery");
    }
}
