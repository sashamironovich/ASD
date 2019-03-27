public class MyLinkedList<E extends Comparable> implements Comparable<E> {

    private MyLinkedListNode<E> head;
    private MyLinkedListNode<E> last;
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
        if(head!=null){head.setPrev(newNode);}
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

//    public void deleteLast(){
//        MyLinkedListNode<E> last = ;
//        MyLinkedListNode<E> prev ;
//        while(curr.getNext()!=null){
//            curr=  curr.getNext();
//        }
//        if(curr != null){
//            curr.setPrev(null);
//            prev = curr.gerPrev();
//
//            prev.setNext(null);
//        }
//        size--;
//    }

    public void clear(){
        while(!isEmpty()){
            deleteHead();
        }
    }

    public MyLinkedListNode getLast(){
        MyLinkedListNode curr = head;

        if(head == null) {
            return null;
        }
        while(curr.getNext() != null){
            curr = curr.getNext();
        }
        return curr;

    }

    public void addAfter(E a,MyLinkedListNode prev){
        MyLinkedListNode<E> newNode = new MyLinkedListNode(a);
        MyLinkedListNode next = prev.getNext();
        if(next!=null){
        newNode.setNext(next);
            next.setPrev(newNode);}

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

    public int getSize(){
        return this.size;
    }


    @Override
    public int compareTo(E o) {
        return 0;
    }
}
