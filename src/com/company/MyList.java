package com.company;

public class MyList<T> {
    private int size;
    private Link<T> first;
    public MyList(){
        first = null;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(T data){
        Link<T> newLink = new Link<T>(data);
        newLink.next = first;
        first = newLink;
        size++;
    }
    public T deleteFirst(){
        T temp = first.data;
        first = first.next;
        size--;
        return temp;
    }
    public T first(){
        return first.data;
    }
    public int size(){
        return size;
    }
    public void displayList(){
        Link<T> current = first;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
