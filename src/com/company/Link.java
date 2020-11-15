package com.company;

public class Link<T> {
    T data;
    Link<T> next;
    Link(T data){
        this.data = data;
    }
}
