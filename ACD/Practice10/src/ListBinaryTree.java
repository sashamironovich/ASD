import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ListBinaryTree <T extends Comparable> {
    Node<T> list ;
    int size = 0;


    public  ListBinaryTree(T root){
        list = new Node<>(root);
        if(root == null)throw new NullPointerException();
        size=1;
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
        if(fatherNode.leftSon!=null || contains(son))throw new IllegalArgumentException();
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

    public void moveNode(T fromElement,T toElement){
        Node toNode = getNode(toElement);
        Node fromNode = getNode(fromElement);

        if(fromNode.parent.leftSon==fromNode){
            fromNode.parent.leftSon = null;
        }else fromNode.parent.rightSon=null;
        if(toNode.parent.leftSon == toNode){
            toNode.parent.leftSon = fromNode;
        }else toNode.parent.rightSon = fromNode;
        fromNode.parent = toNode.parent;
    }


    public void delete(T element){
        if(null == element)throw new NullPointerException();
        if(!contains(element))throw new NoSuchElementException();
        Node nodeToDel = getNode(element);
        if(nodeToDel.leftSon!=null && nodeToDel.rightSon!=null){
            Node lowestLeft = nodeToDel.leftSon;
            while(lowestLeft.leftSon!=null){
                lowestLeft = lowestLeft.leftSon;
            }
            Comparable x = -1;
            addLeftSon((T)lowestLeft.value,  (T)x);
            moveNode((T)nodeToDel.rightSon.value, (T)x);
            moveNode((T)nodeToDel.leftSon.value,(T)nodeToDel.value);

        }
        if(nodeToDel.leftSon!=null){
            moveNode((T)nodeToDel.leftSon.leftSon,(T)nodeToDel.value);
        }
        if(nodeToDel.rightSon!=null){
            moveNode((T)nodeToDel.rightSon.value,(T)nodeToDel.value);
        }
        size--;
    }




}
