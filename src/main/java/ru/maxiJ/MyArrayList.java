package ru.maxiJ;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements IMyArrayList<E> {

    private E[] collection;

    //default create collection
    public MyArrayList() {
        collection = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = collection;
            collection = (E[]) new Object[temp.length + 1];

            //copy array for add item to last position new element
            System.arraycopy(temp, 0, collection, 0, temp.length);
            collection[collection.length - 1] = e;
            return true;
            //try|catch for "(E[])" wildcards
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = collection;
            collection = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, collection, 0, index);
            int countOfAfterIndex = temp.length - index - 1;

            //copy the first part of the array starting from the first
            //element to the deleted one and then from the index to the last
            System.arraycopy(temp, index + 1, collection, index, countOfAfterIndex);
        } catch (ClassCastException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return collection[index];
    }

    @Override
    public int size() {
        return collection.length;
    }

    //set method ArrayList
    @Override
    public void update(int index, E e) {
        collection[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>(collection);
    }

    @Override
    public String toString() {
        E[] temp = (E[]) new Object[size()];
        System.arraycopy(collection, 0, temp, 0, size());

        return Arrays.toString(temp);
    }
}
