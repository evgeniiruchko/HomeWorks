package ru.GeekBrains.gb.repetition.lists;

import java.util.Iterator;

public final class MyLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;

    public int size() {
        return size;
    }

    private int size;

    public void insertFirst(T item) {
        Node<T> newNode = new Node<T>(item, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        Node<T> newNode = new Node<T>(last, item, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public void deleteFirst() {
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
    }

    public void deleteLast() {
        last = last.getPrev();
        if (isEmpty()) {
            first = null;
        } else {
            last.setNext(null);
        }
        size--;
    }

    public T getFirst() {
        if (!isEmpty()) {
            return first.getValue();
        } else
            throw new NullPointerException();
    }

    public T getLast() {
        if (!isEmpty()) {
            return last.getValue();
        } else
            throw new NullPointerException();
    }

    public int indexOf(T item) {
        Node<T> current = first;
        int index = 0;
        while (current != null) {
            if (item.equals(current.getValue())) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }

        if (index == size) {
            insertLast(item);
            return;
        }
        Node<T> current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        Node<T> newNode = new Node<>(current, item, current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        size++;
    }

    public void delete(T item) {
        if (isEmpty()) {
            return;
        }
        if (item.equals(first.getValue())) {
            deleteFirst();
            return;
        }

        Node<T> current = first;
        while (current != null && !item.equals(current.getValue())) {
            current = current.getNext();
        }
        if (current == null) {
            return;
        }

        if (current == last) {
            deleteLast();
            return;
        }

        current.getNext().setPrev(current.getPrev());
        (current.getPrev()).setNext(current.getNext());
        size--;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current = current.getNext();
            return current.getValue();
        }
    }
}
