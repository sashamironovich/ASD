import com.sun.istack.internal.NotNull;

import java.util.NoSuchElementException;

public class BinaryTree <E > {
    int maxCapacity = 100;

    Node[] array ;


    public  BinaryTree(Node element){
        array = new Node[maxCapacity];
        try{if(element.value == null)throw new NullPointerException();
            array[0]=element;

        }catch (NullPointerException e){
            System.out.println("NullPointerException");
        }

    }



    public boolean isEmpty(){
        if(this.array[0] == null)return true;
        else return false;
    }

    public int countVertex(){
        int num = 0;
        for (Node element:array) {
            if(element!=null)num++;

        }
        return num;
    }

    public boolean checkIfExist(Node value){
        for (Node i : array) {if (i == value) return true;
        }
        return false;
    }

    public void addLeftSon(Node son,Node parent){
        try{
            if(checkIfExist(son))throw new IllegalArgumentException();
            if(!checkIfExist(parent))throw new NoSuchElementException();
            if(son == null )throw new NullPointerException();
            if(parent.leftSon!=null)throw new IllegalArgumentException();
            int parentIndex =0;
            int sonIndex ;
            for (int i = 0; i <array.length ; i++) {
                if(parent == array[i])parentIndex = i;
                }
                sonIndex = 2*parentIndex+1;
            parent.leftSon = son;
            array[sonIndex] = son;
            son.index = sonIndex;
            son.parent = parent;
            son.aLeftSon = true;

        }catch (NoSuchElementException e ){
            System.out.println("NoSuchElementException");
        }catch (NullPointerException e ){
            System.out.println("NullPointerException");
        }catch (IllegalArgumentException e ){
            System.out.println("IllegalArgumentException");
        }


    }

    public void addRightSon(Node son,Node parent){
        try{
            if(checkIfExist(son))throw new IllegalArgumentException();
            if(!checkIfExist(parent))throw new NoSuchElementException();
            if(son == null)throw new NullPointerException();
            if(parent.rightSon!=null)throw new IllegalArgumentException();
            int parentIndex = 0;
            int sonIndex = 0;
            for (int i = 0; i <array.length ; i++) {
                if(parent == array[i])parentIndex = i;
            }
            sonIndex = 2*parentIndex+2;
            parent.leftSon = son;
            array[sonIndex] = son;
            son.index = sonIndex;
            son.parent = array[parentIndex];

        }catch (NoSuchElementException e ){
            System.out.println("NoSuchElementException");
        }catch (NullPointerException e ){
            System.out.println("NullPointerException");
        }catch (IllegalArgumentException e ){
            System.out.println("IllegalArgumentException");
        }

    }

    public String toString1(){
        String str = "";
        for (int i = 0; i <array.length ; i++) {
            if(array[i]==null)continue;
                str+= "( " + array[i].value +" ( ";
                if(array[i*2+1]!=null){
                str+= array[i*2+1].value + " ,";}
                else str+= " null, ";

                if(array[i*2+2]!=null){
                    str+= array[i*2+2].value + " )) \n";}
                else str+= " null )) \n";

                }

            return str;
        }


    public String toString(){
        String str = "";
        for (int i = 0; i < array.length; i++) {
            if(array[i] == null)str+= " | null ";
            else str+=" | " + array[i].value;

        }
        return str;
    }

    public void delete(Node node){

        try {
            if (!checkIfExist(node)){
                throw new NoSuchElementException();
            }
            if (node.value == null){
                throw new NullPointerException();
            }
            if(node.leftSon == null && node.rightSon==null){
                array[node.index] = null;
                if(node.aLeftSon)node.parent.leftSon = null;
                else node.parent.rightSon = null;
            }
            if(node.leftSon!=null && node.rightSon==null  ){
                if(node.aLeftSon){
                    node.parent.leftSon = node.leftSon;
                    node.leftSon.parent = node.parent;
                    node.leftSon.index = node.index;
                    array[node.index] = node.leftSon;
                    for (int i = node.index; 2*(2*i+1)+1 <array.length ; i = 2*i+1) {
                        array[2*i+1] = array[2*(2*i+1)+1];

                    }

                }else {
                    node.parent.leftSon = node.leftSon;
                    node.leftSon.parent = node.parent;
                    node.leftSon.index = node.index;
                    array[node.index] = node.leftSon;
                    for (int i = node.index; 2*(2*i+1)+1 <array.length ; i = 2*i+1) {
                        array[2*i+1] = array[2*(2*i+1)+1];

                    }

                }





            }
            if(node.leftSon==null && node.rightSon!=null  ){
                if(node.parent.leftSon == node){
                    node.parent.leftSon = node.rightSon;
                    System.out.println("WW2W");

                }else node.parent.rightSon = node.rightSon;
                System.out.println("WWW3");
            }
        }catch(NoSuchElementException e){
            System.out.println("NoSuchElementException");
        }
        catch(NullPointerException e){
            System.out.println("NullPoInterException");
        }
    }

}
