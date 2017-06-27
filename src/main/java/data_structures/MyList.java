package data_structures;

/**
 * Created by valentina on 31.05.17.
 */
public interface MyList<E> extends MyCollection<E>{
    boolean add(E o, int index);
    boolean set(E o, int index);
    Object get(int index);
    Object remove(int index);
}
