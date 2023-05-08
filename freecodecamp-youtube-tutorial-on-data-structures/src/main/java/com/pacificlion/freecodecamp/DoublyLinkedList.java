package com.pacificlion.freecodecamp;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;
    private int len = 0;
    

    private class Node<T>{
        T data;
        Node<T> prev, next;
        public Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public String toString(){
            return data.toString();
        }
    }

    public int size(){
        return len;
    }

        
    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>(){
            int index = 0;
            Node<T> temp = head;
            public boolean hasNext(){
                return index<len;
            }
            public T next(){
                Node<T> curr = temp;
                temp = temp.next;
                index++;
                return curr.data;
            }
        };
    }
    /*
     * Functions to implement
     * constructor - done
     * insertFirst - done
     * insertLast - done
     * clear
     * iterator - done
     * remove with node- private
     * remove with T obj
     * removeAt - done
     * contains - done
     * indexOf - done
     * removeFirst - done
     * removeLast - done
     * toString() - done
     */

     public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
     }

     public DoublyLinkedList(T data){
        this.head = this.tail = new Node<T>(data, null, null);
        this.len=1;
     }

     public boolean isEmpty(){
        return this.len==0;
     }

     public void insertFirst(T data){
        if(isEmpty()){
            this.head = this.tail = new Node<T>(data, null, null);
        }
        else{
            Node<T> temp = new Node<>(data, null, head);
            this.head.prev = temp;
            this.head = temp;
        }
        
        this.len+=1;
     }

     public void insertLast(T data){
        if(isEmpty()){
            this.head = this.tail = new Node<T>(data, null, null);
        }
        else{
            Node<T> temp = new Node<>(data, tail, null);
            this.tail.next = temp;
            this.tail = temp;
        }
        
        this.len+=1;
     }

     public T removeFirst(){

        T nodeToRemove = null;
        if(isEmpty()){
            throw new RuntimeException("Cannot remove from empty list");
        }
        else if(len==1){
            
            nodeToRemove = this.head.data;
            this.head = null;
            this.tail = null;
        }
        else{

            nodeToRemove = this.head.data;
            Node<T> temp = head.next;
            temp.prev = null;
            this.head = temp;
        }
        this.len-=1;

        return nodeToRemove;
     }

     public T removeLast(){
        T nodeToRemove = null;
        if(isEmpty()){
            throw new RuntimeException("Cannot remove from empty list");
        }
        else if(len==1){
            nodeToRemove = this.tail.data;
            this.head = null;
            this.tail = null;
        }
        else{

            nodeToRemove = this.tail.data;
            Node<T> temp = tail.prev;
            temp.next = null;
            this.tail = temp;
        }
        this.len-=1;

        return nodeToRemove;
     }

     public void clear(){
        
        Node<T> trav = this.head;
        while(trav!=null){
            Node<T> next = trav.next;
            trav.prev = trav.next = null;
            trav.data =null;
            trav = next;
        }
        this.head = null;
        this.tail = null;
        this.len=0;
     }

     public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<T> temp = this.head;

        while(temp!=null){
            sb.append(temp.toString()+",");
        }
        sb.append("]");

        return sb.toString();
     }

     public int indexOf(Object obj){

        Node<T> temp = this.head;
        int index = 0;
        while(temp!=null){
            if(obj==null){
                if(temp.data==null){
                    return index;
                }
            }
            else{
                if(obj.equals(temp.data)){
                    return index;
                }
            }

            index++;
            temp = temp.next;
        }

        return -1;
     }

     public boolean contains(Object obj){
        return indexOf(obj)!=-1;
     }

     public T get(int query){
        if(isEmpty()){
            throw new RuntimeException("Cannot remove from empty list");
        }
        else if(query <0 || query>=len){
            throw new RuntimeException("Incorrect index provided");
        }

        Node<T> temp = this.head;
        int index = 0;
        while(index<query){
            
            temp = temp.next;
            index++;
        }

        return temp.data;

     }

     public void set(int query, T data){
        if(isEmpty()){
            throw new RuntimeException("Cannot remove from empty list");
        }
        else if(query <0 || query>=len){
            throw new RuntimeException("Incorrect index provided");
        }

        Node<T> temp = this.head;
        int index = 0;
        while(index<query){
            
            temp = temp.next;
            index++;
        }

        temp.data =data;

     }

     public void remove(Object obj){

        if(isEmpty()){
            throw new RuntimeException("Cannot remove from empty list");
        }

        Node<T> temp = head;
        boolean found = false;
        while(temp!=null){
            if(obj==null){
                if(temp.data==null){
                    found = true;
                    break;
                }
            }
            else{
                if(obj.equals(temp.data)){
                    found = true;
                    break;
                }
            }
            temp = temp.next;
        }

        if(found){
            if(temp.prev==null){
                removeFirst();
            }
            else if(temp.next==null){
                removeLast();
            }
            else{
                Node<T> prev = temp.prev;
                Node<T> next = temp.prev;
                prev.next = next;
                next.prev = prev;
            }
        }
     }

     public T removeAt(int index){
        T nodeToRemove = null;
        if(isEmpty()){
            throw new RuntimeException("Cannot remove from empty list");
        }
        else if(index <0 || index>=len){
            throw new RuntimeException("Incorrect index provided");
        }
        else if(index==0){
            return removeFirst();
        }
        else if(index==len-1){
            return removeLast();
        }
        else{
            if(index<len/2){
                Node<T> temp = this.head;
                int q = 0;
                while(q<index){
                    temp = temp.next;
                    q++;
                }
                nodeToRemove = temp.next.data;
                temp.next = temp.next.next;
                temp.next.prev = temp;

            }
            else{
                int target =len-index-1;
                Node<T> temp = this.tail;
                int q = 0;
                while(q<target){
                    temp = temp.prev;
                    q++;
                }
                nodeToRemove = temp.prev.data;
                temp.prev = temp.prev.prev;
                temp.prev.next = temp;

            }
        }


        return nodeToRemove;
     }




    
}
