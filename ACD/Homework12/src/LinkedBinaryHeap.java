import java.util.NoSuchElementException;

public class LinkedBinaryHeap<T extends Comparable>{
    public ListBinaryTree tree;
    boolean isMax;
    public Node last;

    public LinkedBinaryHeap(boolean isMax){
        tree = new ListBinaryTree();
        this.isMax = isMax;
        last = null;
    }

    public boolean isEmpty(){
        return tree.isEmpty();
    }

    public boolean contains (T element){
        return tree.contains(element);
    }

    public T peek(){
        return (T)tree.list.value;
    }

    public int size(){
        return tree.size;
    }

    public String toString(){
        return tree.toString();
    }

    public void add(T element){
        if(element==null)throw new NullPointerException();
        if(last==null){
            tree = new ListBinaryTree(element);
            last = tree.list;
            return;
        }

        Node current;
        if(((tree.size & tree.size +1)==0)){
            current = tree.list;
            while(current.leftSon!=null){
                current = current.leftSon;
            }
            tree.addLeftSon(current.value,element);
            last = current.leftSon;
        }else {
            current = last;
            while(current.parent.rightSon == current){
                current = current.parent;
            }
            current = current.parent;
            if(current.rightSon==null){
                tree.addRightSon(current.value,element);
                last = current.rightSon;
            }else {
                current = current.rightSon;
                while(current.leftSon!=null){
                    current = current.leftSon;
                }
                tree.addLeftSon(current.value,element);
                last = current.leftSon;
            }
        }
        heapifyUp(last);
    }

    public void heapifyUp(Node node){
        if(node.equals(tree.list))return;
        Node father = node.parent;
        if(isHigher((T)node.value,(T)father.value)){
            swap(node,father);
            heapifyUp(father);
        }

    }

    public void swap(Node a,Node b){
        T temp =(T) a.value;
        a.value = b.value;
        b.value = temp;

    }

    public boolean isHigher(T a,T b){
        if(isMax && a.compareTo(b)>0 || !isMax && a.compareTo(b)<0)return true;
        return false;
    }

    public void heapifyDown(Node node){
        Node leftSon = node.leftSon;
        Node rightSon = node.rightSon;
        Node biggest ;
        if(leftSon==null && rightSon==null)return;
        if(leftSon==null)biggest = rightSon;
        else if(rightSon==null)biggest = leftSon;
        else if(isHigher((T)leftSon.value, (T)rightSon.value)){
            biggest = leftSon;
        }
        else biggest=rightSon;

        if(isHigher((T)biggest.value,(T)node.value)){
            swap(biggest,node);
            heapifyDown(biggest);
        }
    }

    public T remove(){
        if(isEmpty())throw new NoSuchElementException();
        T root = (T)tree.list.value;
        tree.list.value = last.value;

        Node current;
        if ((tree.size-1 & tree.size)==0){
            current = tree.list;
            while(current.rightSon!=null){
                current = current.rightSon;
            }
            tree.delete(last);
            last = current;
        }else{
            current = last;
            while(current.parent.leftSon == current){
                current = current.parent;
            }
            current = current.parent;
            current = current.leftSon;
            while(current.rightSon!=null){
                current = current.rightSon;
            }
            tree.delete(last);
            last = current;
        }

        if(!isEmpty()){
            heapifyDown(tree.list);
        }
        return root;

    }



}
