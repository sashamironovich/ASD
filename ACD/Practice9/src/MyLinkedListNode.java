public class MyLinkedListNode<E extends Comparable> {

    private E value;
    private MyLinkedListNode next;
    private MyLinkedListNode prev;

    public MyLinkedListNode(E value){
        this.value = value;
        next = null;
        prev = null;
    }

    public E getValue(){
        return value;
    }

    public MyLinkedListNode getNext(){
        return next;
    }

    public void setNext(MyLinkedListNode next){
        this.next = next;
    }

    public MyLinkedListNode gerPrev(){
        return prev;
    }

    public void setPrev(MyLinkedListNode prev){
        this.prev = prev;
    }
}
