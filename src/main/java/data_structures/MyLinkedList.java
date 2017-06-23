package data_structures;

import java.util.Iterator;

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
            tail.next = node;
            node.previous = tail;
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
        return findNode(o) != null;
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
        return size == 0;
    }

    @Override
    public Object get(int index) {
        if(size < index || size == 0) return null;
        MyNode iterator = head;

        for (int i = 0; i < size; i++) {
            if(index == i) return iterator;
            iterator = iterator.next;
        }

        return null;
    }

    @Override
    public boolean remove(Object o) {

        MyNode toRemove = findNode(o);

        if(toRemove == null) return false;

        if(size == 1) {
            head = tail = null;

        } else if(toRemove == head) {

            toRemove.next.previous = null;
            head = toRemove.next;

        } else if(toRemove == tail) {

            toRemove.previous.next = null;
            tail = toRemove.previous;

        } else {

            toRemove.previous.next = toRemove.next;
            toRemove.next.previous = toRemove.previous;

        }

        toRemove.next = null;
        toRemove.previous = null;
        toRemove.value = null;

        size--;
         return true;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private MyNode findNode(Object o) {
        MyNode currentNode = head;

        if(o == null) {

            for (int i = 0; i < size; i++) {
                if(o == currentNode.value) {
                    return currentNode;
                }
                currentNode = currentNode.next;
            }

        } else {

            for (int i = 0; i < size; i++) {
                if(o.equals(currentNode.value)) {
                    return currentNode;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator{
        private int currentPosition;

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Object next() {
            MyNode iterator = head;

            if (currentPosition < size) {
                currentPosition++;
                return iterator.next;
            }
            return null;
        }
    }

    private static class MyNode {
        private MyNode next;
        private MyNode previous;
        private Object value;

        private MyNode(Object value) {
            this.value = value;
        }
    }
}
