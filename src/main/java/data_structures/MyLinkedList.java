package week3;

import week2.data_structures.MyList;

/**
 * Created by valentina on 13.06.17.
 */
public class MyLinkedList implements MyList{

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
    }

    @Override
    public boolean add(Object o) {
        MyNode node = new MyNode(o);

        if(size == 0) {
            head = tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(Object o, int index) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean set(Object o, int index) {
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
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
