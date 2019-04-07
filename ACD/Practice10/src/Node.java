public class Node<E extends Comparable>{
    E value;
    public Node<E> leftSon;
    public Node<E> rightSon;
    public Node<E> parent;



    public Node(E val){
        this.value  = val;
        leftSon = null;
        rightSon = null;
        parent = null;

    }

    public Node getLeftSon(){
        return leftSon;
    }

    public void setLeftSon(Node leftSon){
        this.leftSon = leftSon;
    }

    public Node getRight(){
        return rightSon;
    }

    public void setRightSon(Node rightSon){
        this.rightSon = rightSon;
    }




}