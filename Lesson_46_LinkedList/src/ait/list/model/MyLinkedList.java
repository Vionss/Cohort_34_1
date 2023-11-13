package ait.list.model;

import ait.list.interfaces.IList;

import java.util.Iterator;

public class MyLinkedList<E> implements IList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        Node<E> newNode = new Node<>(last, element, null);
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    @Override
    public void clear() {
        //TODO
        first = null;
        last = null;
        size = 0;

    }

//    public Node(Node<E> prev, E data, Node<E> next) {
//        this.prev = prev;
//        this.data = data;
//        this.next = next;
//    }
    @Override
    public boolean add(int index, E element) {
        if(index == size){
            return add(element);
        }
        // TODO
        Node<E> newNode = new Node<>(getNodeByIndex(index - 1), element, getNodeByIndex(index).next);
        getNodeByIndex(index - 1).next = newNode;
        size++;
        return true;
    }
    private Node<E> getNodeByIndex(int index) {
        checkcIndex(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void checkcIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public E get(int index) {
        Node<E> node = getNodeByIndex(index);
        return node.data;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o != null) {
            for (Node<E> node = first; node != null; node = node.next, index++) {
                if (o.equals(node.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next, index++) {
                if (o == node.data) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO
        int index = size -1;
        if (o != null) {
            for (Node<E> node = last; node != null; node = node.prev, index--) {
                if (o.equals(node.data)) {
                    return index;
                }
            }
        } else {
            for (Node<E> node = last; node != null; node = node.prev, index--) {
                if (o == node.data) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        Node<E> node = getNodeByIndex(index);

        return unLink(node);
    }

    private E unLink(Node<E> node) {
        E temp = node.data;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev != null) {
            prev.next = next;
            node.prev = null;
        } else {
            first = next;
        }
        if (next != null) {
            next.prev = prev;
            node.next = null;
        } else {
            last = prev;
        }
        node.data = null;
        size--;
        return temp;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNodeByIndex(index);
        E temp = node.data;
        node.data = element;
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return last != null;
            }

            @Override
            public E next() {
                Node<E> curr = (Node<E>) first.data;
                return null;
            }
        };
    }

    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E data, Node<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}
