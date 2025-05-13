package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private int capacity;

    public CustomQueue(int capacity) {
        list = new CustomLinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public boolean add(Object t) {
        if (list.size() >= capacity){
            throw new IllegalArgumentException();
        }
        list.addLast((T) t);
        return true;
    }

    @Override
    public boolean offer(Object t) {
        if (list.size() >= capacity) {
            return false;
        }
        else {
            list.addLast((T) t);
            return true;
        }
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }else {
            T t = list.getLast();
            list.removeLast();
            return t;
        }
    }

    @Override
    public T poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }


    @Override
    public T element() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.getFirst();
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    // TODO: Override and fill the methods to complete the data structure

}