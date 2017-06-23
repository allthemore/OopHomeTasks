package data_structures;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by valentina on 31.05.17.
 */
public class MyArrayList implements MyList{

    private static final int DEFAULT_CAPACITY = 10;
    private  Object[] elementData;
    private int size;

    public MyArrayList() {
//        this.elementData = new Object[DEFAULT_CAPACITY];
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        this.elementData = new Object[capacity];
    }

    @Override
    public boolean add(Object o) {
        if(size == elementData.length) increaseCapacity();
        elementData[size++] = o;
        return true;
    }

    private void increaseCapacity() {
        Object[] newElementData = new Object[(elementData.length * 3) / 2 + 1];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

    @Override
    public boolean add(Object o, int index) {
        if(index > size) return false;
        if(size == elementData.length) increaseCapacity();
        shiftElementsToTheRight(index);
        elementData[index] = o;
        size++;
        return true;
    }

    private void shiftElementsToTheRight(int index) {
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
    }

    private void shiftElementsToTheLeft(int index) {
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
    }

    @Override
    public boolean contains(Object o) {
        if(size == 0) return false;
        for (Object elem : elementData) {
            if(o != null ? o.equals(elem) : elem == null) return true;
        }
        return false;
    }

    @Override
    public boolean set(Object o, int index) {
        if(index >= size) return false;
        elementData[index] = o;
        return true;
    }

    @Override
    public void clear() {
        if(size == 0) return;

        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) {
        if(index >= size) return null;
        return elementData[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object remove(int index) {
        if(index >= size) return null;
        Object tmp = get(index);
        shiftElementsToTheLeft(index);
        elementData[size--] = null;
        return tmp;
    }

    @Override
    public boolean remove(Object o) {

        if(o == null){
            for (int i = 0; i < size; i++) {
                if (o == elementData[i]) {
                    System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                    elementData[size--] = null;
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < size; i++) {
            if(o.equals(elementData[i])) {
                System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                elementData[size--] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyArrayList: ");
        sb.append("elementData = ").append(Arrays.toString(elementData));
        sb.append(", size = ").append(size());
        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator{
        private int currentPosition;

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Object next() {
            return elementData[currentPosition++];
        }
    }
}
