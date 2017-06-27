package data_structures;

import java.util.Iterator;

/**
 * Created by valentina on 13.06.17.
 */
public class MyLinkedList<E> implements MyList<E>{

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
    }

    @Override
    public boolean add(E o) {
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
    public boolean add(E o, int index) {
        if(index > size || index < 0) return false;

        MyNode myNode = new MyNode(o);

        if(size == 0 && index == 0) {
            head = tail = myNode;

        } else if(index == 0) {
            myNode.next = head;
            head.previous = myNode;
            head = myNode;

        } else if(index == size) {
            myNode.previous = tail;
            tail.next = myNode;
            tail = myNode;

        } else {
            myNode.previous = getNode(index - 1);
            myNode.next = getNode(index + 1);
            myNode.previous.next = myNode;
            myNode.next.previous = myNode;
        }

        size++;
        return true;
    }

//    get node by index and return it
    private MyNode getNode(int index) {
        if(size < index || index < 0) return null;

        MyNode currentNode = head;
        for (int i = 0; i < size; i++) {
            if(i == index) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    @Override
    public boolean contains(E o) {
        return findNode(o) != null;
    }

    @Override
    public boolean set(E o, int index) {
        if(index >= size || index < 0) return false;

        MyNode myNode = getNode(index);
        myNode.value = o ;
        return true;
    }

    @Override
    public void clear() {
        if(size == 0) return;

        for (int i = 0; i < size; i++) {
            remove(get(i));
        }

        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

//    Get value of MyNode with specified index
    @Override
    public E get(int index) {
        if(size < index || size == 0 || index < 0) return null;
        MyNode currentNode = head;

        for (int i = 0; i < size; i++) {
            if(index == i) return currentNode.value;
            currentNode = currentNode.next;
        }

        return null;
    }

    @Override
    public boolean remove(E o) {

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

        toRemove.clearNode();

        size--;
        return true;
    }

    @Override
    public E remove(int index) {
        if(index >= size || index < 0) return null;

        MyNode myNode = getNode(index);
        E o = myNode.value;
        remove(myNode.value);
        return o;
    }


    @Override
    public int size() {
        return this.size;
    }

    private MyNode findNode(E o) {
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
    public Iterator<E> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<E>{
        private int currentPosition;

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public E next() {

            return getNode(currentPosition++).value;
        }
    }

    private class MyNode {
        private MyNode next;
        private MyNode previous;
        private E value;

        private MyNode(E value) {
            this.value = value;
        }

        private void clearNode() {
            next = null;
            previous = null;
            value = null;
        }
    }
}
