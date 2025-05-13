package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public T get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index not found.");
        }else {
            return (T) elements[index];
        }
    }

    @Override
    public T set(int index, T element) {
        elements[index] = element;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        if (o == null) throw new NullPointerException();
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size++] = o;
        return true;
    }


    @Override
    public boolean contains(Object o) {
        boolean found = false;
        for (Object element: elements) {
            if (element.equals(o)){
                found = true;
            }
        }
        return found;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) throw new NullPointerException();
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

}