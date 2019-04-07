package queue;

public class MyList<E> {

    private MyListNode<E> first;
    private int size;

    public MyList() {
        first = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public MyListNode getFirst() {
        return first;
    }

    public MyListNode getNumber(int number) {
        if (number >= size || number < 0)
            return null;
        MyListNode<E> curr = first;
        for (int i = 0; i < number; i++)
            curr = curr.getNext();
        return curr;
    }

    public void addFirst(E a) {
        MyListNode<E> newNode = new MyListNode(a);
        newNode.setNext(first);
        first = newNode;
        size++;
    }

    public void addLast(E a) {
        addNumber(a, size);
    }

    public void addNumber(E element, int number) {
        if (number > size || number < 0)
            return;
        if (number == 0) {
            addFirst(element);
            return;
        }
        MyListNode<E> curr = first;
        for (int i = 0; i < number - 1; i++)
            curr = curr.getNext();
        MyListNode<E> newNode = new MyListNode<>(element);
        newNode.setNext(curr.getNext());
        curr.setNext(newNode);
        size++;
    }

    public void delFirst() {
        first = first.getNext();
        size--;
    }

    public void delNumber(int number) {
        if (number >= size || number < 0)
            return;
        if (number == 0) {
            delFirst();
            return;
        }
        MyListNode<E> curr = first;
        for (int i = 0; i < number - 1; i++)
            curr = curr.getNext();
        curr.setNext(curr.getNext().getNext());
        size--;
    }

    public void clear() {
        while (!empty()) {
            delFirst();
        }
    }

    public Comparable[] toArray() {
        Comparable[] array = new Comparable[size];
        MyListNode<E> curr = first;
        for (int i = 0; i < size; i++) {
            array[i] = (Comparable) curr.getValue();
            curr = curr.getNext();
        }
        return array;
    }

    public String toString() {
        String res = "[";
        MyListNode<E> curr = first;
        while (curr != null) {
            res += " " + curr.getValue() + " ";
            curr = curr.getNext();
        }
        res += "]";
        return res;
    }

}
