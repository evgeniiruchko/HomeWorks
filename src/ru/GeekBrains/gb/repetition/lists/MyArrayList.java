package ru.GeekBrains.gb.repetition.lists;

import java.util.Arrays;
import java.util.Iterator;

public final class MyArrayList<T> {

    private T[] list;
    private int size;
    private int capacity;

    public int size() {
        return size;
    }

    public MyArrayList() {
        this.list =  (T[]) new Object[10];
        this.capacity = 10;
    }

    public MyArrayList(int capacity) {
        this.list =  (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    private void resize() {
        this.capacity = (int) (capacity * 1.5 + 1);
        T[] newList = (T[]) new Object[this.capacity];
        System.arraycopy(list, 0, newList, 0, size);
        this.list = newList;
    }

    public void add(T item) {
        list[size] = item;
        size++;
        if (size == capacity) {
            resize();
        }
    }
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        T[] tempList = (T[]) new Object[size - index];
        System.arraycopy(list, index, tempList, 0, size - index);
        list[index] = item;
        System.arraycopy(tempList, 0, list, index + 1, tempList.length);
        size++;
        if (size == capacity) {
            resize();
        }
    }

    public T get(int index) {
        return list[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (index < 0 || index > size || isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            list[size] = null;
            size--;
            return;
        }

        T[] tempList = (T[]) new Object[size - index];
        System.arraycopy(list, index + 1, tempList, 0, size - index);
        list[size] = null;
        System.arraycopy(tempList, 0, list, index, tempList.length);
        size--;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "list=" + Arrays.toString(Arrays.copyOfRange(list,0 , size)) +
                '}';
    }
}
