import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListBinarySearchTree<E extends Comparable> {
    ListBinaryTree<E> binaryTree ;

    public boolean isEmpty(){
        return binaryTree.isEmpty();
    }

    public boolean contains(E el){
        return binaryTree.contains(el);
    }

    public ListBinarySearchTree(E root){
        binaryTree = new ListBinaryTree<>(root);
    }


    private Node addRecursive(Node current, E value) {
        if (current == null) {
            Node newNode = new Node(value);


            return new Node(value);
        }

        if (value.compareTo(current.value)<0) {
            current.leftSon = addRecursive(current.leftSon, value);
            current.leftSon.parent = current;
        } else if (value.compareTo(current.value)>0) {
            current.rightSon = addRecursive(current.rightSon, value);
            current.rightSon.parent = current;
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(E value) {
        addRecursive(binaryTree.list, value);
    }

    public String toString(){
        return binaryTree.toString();

    }

    public E findMinElement(ListBinarySearchTree tree){
        Node root = tree.binaryTree.list;
        return findMinElement((E)root.value,root);
    }

    private E findMinElement(E a,Node currentNode){
        E min = a;
        if(currentNode.leftSon==null && currentNode.rightSon==null){
            if(currentNode.value.compareTo(a)<0)return(E) currentNode.value;
            else return a;
        }

        if(currentNode.leftSon!=null){
            E leftS =(E) findMinElement(min,currentNode.leftSon);
            if(min.compareTo(leftS)>0)min = leftS;
        }

        if(currentNode.rightSon!=null){
            E rightS =(E) findMinElement(min,currentNode.rightSon);
            if(min.compareTo(rightS)>0)min = rightS;
        }
        return min;

    }

    public E findMaxElement(ListBinarySearchTree tree){
        Node  node = tree.binaryTree.list;
        return findMaxElement((E)node.value,node);
    }

    private E findMaxElement(E a,Node currentNode){
        E max = a;

        if(currentNode.leftSon==null && currentNode.rightSon==null){
            if(a.compareTo(currentNode.value)<0){
                max = (E)currentNode.value;
            }
             return max;
        }

        if(currentNode.leftSon!=null){
            E leftS = findMaxElement((E)currentNode.value,currentNode.leftSon);
            if(max.compareTo(leftS)<0)max = leftS;
        }

        if(currentNode.rightSon!=null){
            E rightS = findMaxElement((E)currentNode.value,currentNode.rightSon);
            if(max.compareTo(rightS)<0)max = rightS;
        }

        return max;
    }

    private Node findNode(E el,Node tree){
        Node currNode = null;
        if(el.equals(tree.value))currNode = tree;
        if(tree.leftSon!=null && currNode == null){
            currNode= findNode(el,tree.leftSon);
        }
        if(tree.rightSon!=null && currNode==null){
            currNode = findNode(el,tree.rightSon) ;
        }
        return currNode;
    }

    public Node findNode(E el){
        Node root = binaryTree.list;
        return findNode(el,root);
    }




    public void delete(E el){
        Node nodeToDel = findNode(el,binaryTree.list);

        if(nodeToDel==null)throw new NoSuchElementException();

        //if node has no kids
        if(nodeToDel.leftSon== null && nodeToDel.rightSon==null){

            if(nodeToDel.parent.leftSon == nodeToDel){
                nodeToDel.parent.leftSon = null;
                nodeToDel.parent=null;
            }
            else {
                nodeToDel.parent.rightSon = null;
                nodeToDel.parent=null;
            }
        }

        //if node has left kid
        if(nodeToDel.rightSon==null && nodeToDel.leftSon!=null){
            if(nodeToDel.parent.leftSon==nodeToDel){
            nodeToDel.parent.leftSon =  nodeToDel.leftSon ;}
            else nodeToDel.parent.rightSon = nodeToDel.leftSon;
            nodeToDel.leftSon.parent=nodeToDel.parent;
            nodeToDel.parent=null;
        }

        //if node has right kid
        if(nodeToDel.leftSon==null && nodeToDel.rightSon!=null){
            if(nodeToDel.parent.leftSon==nodeToDel){
                nodeToDel.parent.leftSon =  nodeToDel.rightSon ;
            }
            else nodeToDel.parent.rightSon =  nodeToDel.rightSon ;
            nodeToDel.rightSon.parent=nodeToDel.parent;
            nodeToDel.parent=null;
        }

        //if node has 2 kids
        if(nodeToDel.leftSon!=null && nodeToDel.rightSon!=null && nodeToDel.rightSon.leftSon!=null){

            Node currNode = nodeToDel.rightSon;


            while(currNode.leftSon!=null){
                currNode = currNode.leftSon;
            }
            currNode.parent.leftSon = null;
            if(nodeToDel.parent!=null&&nodeToDel.parent.leftSon==nodeToDel ){

                currNode.parent=nodeToDel.parent;
                nodeToDel.parent.leftSon = currNode;
            }
            else if(nodeToDel.parent!=null) {
                currNode.parent=nodeToDel.parent;
                nodeToDel.parent.rightSon = currNode;
            } else if(nodeToDel.parent==null){
                binaryTree.list = currNode;

            }

            currNode.rightSon = nodeToDel.rightSon;
            currNode.leftSon = nodeToDel.leftSon;
            nodeToDel.rightSon.parent = currNode;
            nodeToDel.leftSon.parent = currNode;
        }
        else if(nodeToDel.leftSon!=null && nodeToDel.rightSon!=null && nodeToDel.rightSon.leftSon==null ){
            Node currNode = nodeToDel.rightSon;
            if(nodeToDel.parent.leftSon==nodeToDel ){

                currNode.parent=nodeToDel.parent;
                nodeToDel.parent.leftSon = currNode;
            }
            else{

                currNode.parent=nodeToDel.parent;
                nodeToDel.parent.rightSon = currNode;
            }

            nodeToDel.leftSon.parent = currNode;
            currNode.leftSon = nodeToDel.leftSon;
        }

    }

    public void smallest(Node node,ArrayList list){
        if(node == null) return;

        smallest(node.leftSon,list);
       list.add(node.value);
        smallest(node.rightSon,list);
    }

    private void biggest(Node node,ArrayList list){
        if(node == null) return;
        biggest(node.rightSon,list);
        list.add(node.value);
        biggest(node.leftSon,list);
    }

    public ArrayList sortDesc(){
        Node  node  =binaryTree.list;
        ArrayList<E> answ = new ArrayList<>();
        biggest(node,answ);
        return answ;
    }



    public ArrayList sortAsc(){
        Node node = binaryTree.list;
        ArrayList<E> answ = new ArrayList();
        smallest(node,answ);
        return answ;
    }

}
