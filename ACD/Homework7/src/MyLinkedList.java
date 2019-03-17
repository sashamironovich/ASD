public class MyLinkedList<E extends Comparable> {

    private MyLinkedListNode<E> head;
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public MyLinkedListNode getHead(){
        return head;
    }

    public void append(E a){
        MyLinkedListNode<E> newNode = new MyLinkedListNode(a);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void deleteHead(){
        head = head.getNext();
        if(head != null){
            head.setPrev(null);
        }
        size--;
    }

    public void clear(){
        while(!isEmpty()){
            deleteHead();
        }
    }

    public void addAfter(E a,MyLinkedListNode prev){
        MyLinkedListNode<E> newNode = new MyLinkedListNode(a);
        MyLinkedListNode next = prev.getNext();
        if(next!=null){
        newNode.setNext(next);}
        prev.setNext(newNode);
        newNode.setPrev(prev);
        size++;
    }

    public void delete(MyLinkedListNode node){
        MyLinkedListNode<E> prev = node.gerPrev();
        MyLinkedListNode<E> next = node.getNext();
        if(prev==null){
            deleteHead();
            return;
        }
        prev.setNext(next);
        if(next!=null){
            next.setPrev(prev);}

            size--;
    }

    public Comparable[] toArray(){
        Comparable[] arr = new Comparable[size];
        MyLinkedListNode<E> currentNode = head;
        for (int i = 0; i <arr.length ; i++) {
            arr[i] =currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return arr;
    }

    public boolean contains(E a){
        MyLinkedListNode<E> node = head;
        while(node!=null){
            if(a.compareTo(node.getValue())==0){
                return true;
            }

            node = node.getNext();
        }
        return false;
    }

    public String toString(){
        String answer = "(";
        MyLinkedListNode<E> node = head;
        while(node!=null){
            answer= answer + " " + node.getValue() + " ";
            node=node.getNext();
        }
        answer = answer + ")";
        return answer;
    }



}
