public class MyListNode<E> {

    private E value;
    private MyListNode next;

    public MyListNode(E value) {
        this.value = value;
        next = null;
    }

    public E getValue() {
        return value;
    }

    public MyListNode getNext() {
        return next;
    }

    public void setNext(MyListNode next) {
        this.next = next;
    }

}
