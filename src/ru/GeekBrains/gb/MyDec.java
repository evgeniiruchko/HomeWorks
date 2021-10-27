package ru.GeekBrains.gb;

public class MyDec<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    //0 1 2 3 4
    //      B
    //  E
    //4     3 2

    public MyDec(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        list = (T[]) new Object[capacity];
    }

    public MyDec() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertRight(T item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        size++;
        begin = prevIndex(begin);
        list[begin] = item;
    }

    public T removeLeft() {
        list[end] = null;
        end = prevIndex(end);
        T temp = peekRight();
        size--;
        return temp;
    }

    public T removeRight() {
        T temp = peekLeft();
        list[begin] = null;
        begin = nextIndex(begin);
        size--;
        return temp;
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list[begin];
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list[end];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }


    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevIndex(int index) {
        return (index - 1) < 0 ? list.length - 1 : (index - 1) % list.length;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = begin, j = 0; j < size; i = nextIndex(i), j++) {
            sb.append(list[i]).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
