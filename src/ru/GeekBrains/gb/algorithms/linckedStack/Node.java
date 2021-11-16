package ru.GeekBrains.gb.algorithms.linckedStack;

class Node<T> {
    Node prev;
    T value;
    Node next;

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(Node prev, T value, Node next) {
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

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
