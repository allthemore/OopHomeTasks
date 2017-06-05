package week1.abstract_classes_and_interfaces.doctor;

/**
 * Created by valentina on 22.05.17.
 */
public interface Doctor {
    String getName();
    String getSurname();
    String getSpecialization();
    int getAge();
    int getYearsOfExperience();

    void work();
}
