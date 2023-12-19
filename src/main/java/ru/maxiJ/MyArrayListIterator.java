package ru.maxiJ;

import java.util.Iterator;

//Iterator for my array list
public class MyArrayListIterator<E> implements Iterator {
    private int index = 0;
    private E[] collection;

    public MyArrayListIterator(E[] collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.length;
    }

    @Override
    public E next() {
        return collection[index++];
    }
}
