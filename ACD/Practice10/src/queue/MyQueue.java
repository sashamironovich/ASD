package queue;

import java.util.NoSuchElementException;

public class MyQueue<E> {

    private MyList<E> list;
    private int maxSize;        // maxSize <= 0 then queue is unbounded
    private boolean areNullElementsAllowed;

    public MyQueue() {
        this(-1, true);
    }

    public MyQueue(int maxSize, boolean areNullElementsAllowed) {
        list = new MyList<>();
        this.maxSize = maxSize;
        this.areNullElementsAllowed = areNullElementsAllowed;
    }

    public boolean add(E item) {
        if (!areNullElementsAllowed && item == null)
            throw new NullPointerException();
        if (maxSize > 0 && list.getSize() == maxSize)
            throw new IllegalStateException();
        list.addLast(item);
        return true;
    }

    public E element() {
        if (empty())
            throw new NoSuchElementException();
        MyListNode<E> head = list.getFirst();
        return head.getValue();
    }

    public boolean offer(E item) {
        if (!areNullElementsAllowed && item == null)
            throw new NullPointerException();
        if (maxSize > 0 && list.getSize() == maxSize)
            return false;
        list.addLast(item);
        return true;
    }

    public E poll() {
        if (empty())
            return null;
        MyListNode<E> head = list.getFirst();
        list.delFirst();
        return head.getValue();
    }

    public E remove() {
        if (empty())
            throw new NoSuchElementException();
        MyListNode<E> head = list.getFirst();
        list.delFirst();
        return head.getValue();
    }

    public E peek() {
        if (empty())
            return null;
        MyListNode<E> head = list.getFirst();
        return head.getValue();
    }

    public boolean empty() {
        return list.empty();
    }

    public int search(E element) {
        MyListNode<E> curr = list.getFirst();
        int i = 1;
        while (curr != null && curr.getValue() != element) {
            curr = curr.getNext();
            i++;
        }
        if (curr == null)
            return -1;
        return i;
    }

    public int size() {
        return list.getSize();
    }

    public Comparable[] toArray() {
        return list.toArray();
    }

    public String toString() {
        return list.toString();
    }
}
