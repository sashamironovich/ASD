import java.util.NoSuchElementException;

public class BinaryHeap <T extends Comparable> {
    ArrayBinaryTree tree ;
    Boolean isMax;


    BinaryHeap (boolean isMax){
        this.isMax  = isMax;
        tree = new ArrayBinaryTree();

    }

    public boolean isEmpty(){
        return tree.isEmpty();
    }

    public int size(){
        return tree.nubVertex();
    }

    public T peek(){
        if (tree.array[0]==null)return null;
        return (T)tree.array[0];
    }

    public boolean contains(T element){
        return tree.contains(element);

    }

    public String toString(){
        return tree.toString();
    }


    public void add(T element){
        tree.expand();
        tree.array[size()] = element;
        tree.size++;
        heapifyUp();

    }

    public void swap(int index1, int index2){
        T temp = (T)tree.array[index1];
        tree.array[index1] = tree.array[index2];
        tree.array[index2] = temp;
    }


    public void heapifyUp(){
        int index = size()-1;
        if(isMax == false){
            while (tree.array[(index-1)/2] !=null &&  tree.array[(index-1)/2].compareTo(tree.array[index])>0){
                swap((index-1)/2,index);
                index = (index-1)/2;
            }
        }else{
            while (tree.array[(index-1)/2] !=null &&  tree.array[(index-1)/2].compareTo(tree.array[index])<0){
                swap((index-1)/2,index);
                index = (index-1)/2;
            }

        }
    }

    public void heapifyDown() {
        int index = 0;
        if(isMax==false) {
            while (tree.array[index * 2 + 1] != null) {
                int smallestChildInd = index * 2 + 1;
                if (tree.array[index * 2 + 2] != null && tree.array[smallestChildInd].compareTo(tree.array[index * 2 + 2]) > 0) {
                    smallestChildInd = index * 2 + 2;
                }

                if (tree.array[index].compareTo(tree.array[smallestChildInd]) < 0) {
                    break;
                } else {
                    swap(index, smallestChildInd);

                }
                index = smallestChildInd;
            }
        }else{
            while (tree.array[index * 2 + 1] != null) {
                int biggestChildInd = index * 2 + 1;
                if (tree.array[index * 2 + 2] != null && tree.array[biggestChildInd].compareTo(tree.array[index * 2 + 2]) < 0) {
                    biggestChildInd = index * 2 + 2;
                }

                if (tree.array[index].compareTo(tree.array[biggestChildInd]) > 0) {
                    break;
                } else {
                    swap(index, biggestChildInd);

                }
                index = biggestChildInd;
            }

        }

    }

    public T remove(){
        if(isEmpty())throw new NoSuchElementException();
        T root = (T)tree.array[0];
        tree.array[0] = tree.array[size()-1];
        tree.array[size()-1]=null;
        heapifyDown();
        return root;
    }

}
