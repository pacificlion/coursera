package com.pacificlion.freecodecamp;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue<T> implements Iterable<T>, Queue<T>{

    private LinkedList<T> list = new LinkedList<>();

    @Override
    public void offer(T elem) {

        list.addFirst(elem);
    }

    @Override
    public T poll() {
        if(this.isEmpty()){
            throw new RuntimeException("Queue Empty");
        }

        T elem = list.removeLast();
        return elem;
    }

    @Override
    public T peek() {
        if(this.isEmpty()){
            throw new RuntimeException("Queue Empty");
        }

        return list.peekLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
    
}
