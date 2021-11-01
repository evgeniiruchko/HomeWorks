package ru.GeekBrains.gb;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class MyLinkedStack<T> {
    private MyLinkedList<T> list;

    public MyLinkedStack() {
        this.list = new MyLinkedList<>();
    }

    public void push(T item) {
        list.insertLast(item);
    }

    public T remove() {
        return list.deleteLast();
    }

    public T peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public ListIterator<T> listIterator() {
        return new ListIter();
    }

    private class ListIter implements ListIterator<T> {
        Node<T> current = list.getNodeFirst();
        int index = 0;
        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T temp = (T) current.getNext().getValue();
                current = current.next;
                index++;
                return temp;
            }
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return current.getPrev() != null;
        }

        @Override
        public T previous() {
            if (hasPrevious()) {
                T temp = (T) current.getPrev().getValue();
                current = current.prev;
                index--;
                return temp;
            }
            return null;
        }

        @Override
        public int nextIndex() {
            if (hasNext())
                return index + 1;
            return -1;
        }

        @Override
        public int previousIndex() {
            if (hasPrevious())
                return index - 1;
            return -1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }
}
