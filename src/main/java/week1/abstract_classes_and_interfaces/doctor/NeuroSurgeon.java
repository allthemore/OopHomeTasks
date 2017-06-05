package week1.abstract_classes_and_interfaces.doctor;

/**
 * Created by valentina on 22.05.17.
 */
public class NeuroSurgeon extends Surgeon{

    public NeuroSurgeon(String name, String surname, int age, String specialization, int yearsOfExperience, int salary) {
        super(name, surname, age, specialization, yearsOfExperience, salary);
    }

    @Override
    public void work(){
        System.out.println("Do neuro-surgery");
    }
}
