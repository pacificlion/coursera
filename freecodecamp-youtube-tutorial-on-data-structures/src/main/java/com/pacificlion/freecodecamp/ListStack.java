package com.pacificlion.freecodecamp;

import java.util.Iterator;
import java.util.LinkedList;

public class ListStack<T> implements Iterable<T>,Stack<T>{

    // doubly linked list so addFirst, addLast both have O(1) complexity
    private LinkedList<T> list = new LinkedList<>();

    public int size(){
        return list.size();
    }

        
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }


     public ListStack(T obj){
        add(obj);
     }


     public boolean isEmpty(){
        return list.isEmpty();
     }

     public void add(T data){
        list.addFirst(data);
     }

  

     public T pop(){

        if(this.isEmpty()){
            throw new RuntimeException("Stack Empty");
        }
        T nodeToRemove = list.removeFirst();
        return nodeToRemove;
     }

     public T peek(){
        if(this.isEmpty()){
            throw new RuntimeException("Queue Empty");
        }
        return list.peek();
     }

     public void clear(){

        if(this.isEmpty()){
            throw new RuntimeException("Stack Empty");
        }
        
        list.clear();
     }

    public void push(T elem) {
        list.addFirst(elem);
    }





    
}
