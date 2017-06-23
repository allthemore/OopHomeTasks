package week2.data_structures;

import week3.MyNode;

import java.util.Comparator;

/**
 * Created by valentina on 18.06.17.
 */
public class MyTreeSet implements MySet{

    private MyNode<T> root;
    private int size;

    private Comparator<T> comparator;

    public MyTreeSet() {
    }

    public MyTreeSet(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean add(T o) {
        if(root == null) {
            root = new MyNode(o);
            size++;
            return true;
        }
        if(comparator == null) {
            Comparable comparable = (Comparable) o;
            MyNode<T> iter = root;
            int result = comparable.compareTo(iter.value);
        }
//        by comparable
        else {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
