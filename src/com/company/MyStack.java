package com.company;

import java.util.NoSuchElementException;

public class MyStack<T>{
    private MyList<T> list;
    public MyStack(){
        list = new MyList<>();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public boolean push(T data){
        if (data == null) return false;
        list.insertFirst(data);
        return true;
    }
    public T pop(){
        if (isEmpty()) throw new NoSuchElementException();
        else return list.deleteFirst();
    }
}
