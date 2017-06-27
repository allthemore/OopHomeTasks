package data_structures;

/**
 * Created by valentina on 31.05.17.
 */
public interface MyCollection<E> extends Iterable<E>{
    boolean add (E o);
    boolean contains (E o);
    void clear();
    boolean isEmpty();
    boolean remove(E o);
    int size();
}
