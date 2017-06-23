package week2.data_structures;

/**
 * Created by valentina on 31.05.17.
 */
public interface MyList extends MyCollection{
    boolean add(Object o, int index);
    boolean set(Object o, int index);
    Object get(int index);
    Object remove(int index);
}
