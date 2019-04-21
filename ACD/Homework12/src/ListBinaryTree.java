import java.util.NoSuchElementException;

public class ListBinaryTree <T extends Comparable> {
    Node<T> list ;
    int size ;


    public  ListBinaryTree(){
        list = new Node<>(null);
        size=0;
    }

    public  ListBinaryTree(T el){

        if(el == null)throw new NullPointerException();
        list = new Node<>(el);
        size++;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int countVertex(){
        return size;
    }

    public Node<T> getNode(T element, Node root){
        if(root==null)return null;
        if(root.value.equals(element))return root;
        Node<T> search = getNode(element,root.leftSon);
        if(search!=null)return search;
        search = getNode(element,root.rightSon);
        if (search!=null)return search;
        return null;
    }

    public Node<T> getNode(T element){
        if(element==null)throw new NullPointerException();
        Node search =  getNode(element,list);
        if(search==null)throw new NoSuchElementException();
        return search;
    }

    public boolean contains(T element){
        if(element==null)throw  new NullPointerException();
        try{Node search = getNode(element);
        if(search!=null)return true;
        else return false;}catch (NoSuchElementException e){
            return false;
        }
    }

    public void addRightSon(T father,T son){
        if(!contains(father))throw new NoSuchElementException();
        if(son==null)throw new NullPointerException();
        Node fatherNode = getNode(father);
        if(fatherNode.rightSon!=null || contains(son))throw new IllegalArgumentException();
        Node child = new Node(son);
        fatherNode.rightSon = child;
        child.parent = fatherNode;
        size++;
    }


    public void addLeftSon(T father,T son){
        if(!contains(father))throw new NoSuchElementException();
        if(son==null)throw new NullPointerException();
        Node fatherNode = getNode(father);
        //if(fatherNode.leftSon!=null || contains(son))throw new IllegalArgumentException();
        Node child = new Node(son);
        fatherNode.leftSon = child;
        child.parent = fatherNode;
        size++;
    }

    public String toString(){
        return "( " + getToString(list) + " )";
    }

    public String getToString(Node root){
        if(root==null) return "null";
        String str = "";
        str+=root.value ;
        Node<T> leftSon = root.leftSon;
        Node<T> rightSon = root.rightSon;
        str+= "( " + getToString(leftSon) + " , " + getToString(rightSon) + " )";
        return str;
    }

    public void moveNode(Node fromElement, Node toElement){


        if(toElement == list){
            list = fromElement;
            fromElement.parent = null;
            return;
        }
        Node fromParent = fromElement.parent;
        Node toParent = toElement.parent;
        if (fromParent.getRight() == fromElement)
            fromParent.parent= null;
        if (fromParent.leftSon == fromElement)
            fromParent.leftSon = null;
        if (toParent.leftSon == toElement)
            toParent.leftSon = fromElement;
        if (toParent.getRight() == toElement)
            toParent.rightSon = fromElement;
        fromElement.parent = (toParent);
    }
    public void delete(Node elNode) {
        Node parentNode = elNode.parent;
        Node leftNode = elNode.leftSon;
        Node rightNode = elNode.rightSon;
        size--;
        if (leftNode != null && rightNode != null) {
            Node firstLeftNull = leftNode;
            while (firstLeftNull.leftSon != null)
                firstLeftNull = firstLeftNull.leftSon;
            // place for insertion is found - left child of firstLeftNull
            firstLeftNull.leftSon = new Node(null);
            firstLeftNull.leftSon.parent = firstLeftNull;
            moveNode(rightNode, firstLeftNull.leftSon);
            moveNode(leftNode, elNode);
        } else if (leftNode != null)
            moveNode(leftNode, elNode);
        else if (rightNode != null)
            moveNode(rightNode, elNode);
        else if(parentNode != null){
            // if there are no children and element is not the head of the tree
            if (parentNode.leftSon == elNode)
                parentNode.leftSon = null;
            if (parentNode.getRight() == elNode)
                parentNode.rightSon = null;
        } else
            // if there are no children and element is the head of the tree
            list = null;
    }



//    public void delete(T element){
//        if(null == element)throw new NullPointerException();
//        if(!contains(element))throw new NoSuchElementException();
//        Node nodeToDel = getNode(element);
//        if(nodeToDel.leftSon!=null && nodeToDel.rightSon!=null){
//            Node lowestLeft = nodeToDel.leftSon;
//            while(lowestLeft.leftSon!=null){
//                lowestLeft = lowestLeft.leftSon;
//            }
//            Comparable x = -1;
//            addLeftSon((T)lowestLeft.value,  (T)x);
//            moveVertex((T)nodeToDel.rightSon.value, (T)x);
//            moveVertex((T)nodeToDel.leftSon.value,(T)nodeToDel.value);
//
//        }
//        if(nodeToDel.leftSon!=null){
//            moveVertex((T)nodeToDel.leftSon.leftSon,(T)nodeToDel.value);
//        }
//        if(nodeToDel.rightSon!=null){
//            moveVertex((T)nodeToDel.rightSon.value,(T)nodeToDel.value);
//        }
//        size--;
//    }




}
