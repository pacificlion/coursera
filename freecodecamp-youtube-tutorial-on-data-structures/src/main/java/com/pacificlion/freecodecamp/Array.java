package com.pacificlion.freecodecamp;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T>{

    int capacity=0;
    T[] arr;
    int len=0;


    @Override
    public Iterator<T> iterator() {

        return new java.util.Iterator<T>(){
            int index = 0;
            public boolean hasNext(){
                 return index<len;
            }
            public T next(){
                    return arr[index++];
            }
        };
    }

    
    // default 16
    public Array(){
        this(16);
    }

    public Array(int capacity){
        if(capacity<0){
            throw new IllegalArgumentException("capacity cannot be negative");
        }
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size(){
        return this.len;
    }

    public int indexOf(Object obj){

        for(int i=0;i<len;i++){
            if(arr[i].equals(obj)){
                return i;
            }
        }

        return -1;

    }

    public boolean contains(Object obj){
        return (indexOf(obj)!=-1);
    }
    public boolean isEmpty(){
        return this.len==0;
    }

    public T get(int index){
        if(index<0||index>=len){
            throw new IllegalArgumentException("invalid values for index");
        }
        return arr[index];
    }

    public void set(int index, Object elem){
        if(index<0||index>=len){
            throw new IllegalArgumentException("invalid values for index");
        }
        arr[index] = (T)elem;
    }

    public void add(T elem){
        if(this.len==this.capacity){
            //Double it
            this.capacity*=2;

            T[] newArr = (T[]) new Object[capacity];
            for(int i=0;i<this.len;i++){
                    newArr[i] = this.arr[i];                
            }

            
            this.arr = newArr;
        }

            this.arr[this.len] = elem;
            this.len++;
    }
    public void clear(){
        this.arr =(T[]) new Object[capacity];
        this.len=0;
        this.capacity=0;

    }

    public T removeAt(int index){
        if(index<0||index>=len){
            throw new IllegalArgumentException("invalid values for index");
        }

        T[] newArr = (T[]) new Object[capacity];
        int j=0;
        T elemRemoved = this.arr[index];
        for(int i=0;i<len;i++){
            if(i!=index){
                newArr[j++] = this.arr[i];
            }
            
        }

        this.arr= newArr;
        this.len--;

        return elemRemoved;

    }
    public void remove(T elem){
        if(this.isEmpty()){
            throw new IllegalArgumentException("Cannot remove from empty Array");
        }

        T[] newArr = (T[]) new Object[capacity];
        int j=0;
        for(int i=0;i<len;i++){
            if(!arr[i].equals(elem)){
                newArr[j++] = this.arr[i];
            }
            
        }

        this.arr= newArr;
        this.len--;
    }
}