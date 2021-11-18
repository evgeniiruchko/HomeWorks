package ru.GeekBrains.gb.repetition.lists;

class Node<T> {
    Node<T> prev;
    T value;
    Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(Node<T> prev, T value, Node<T> next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}
