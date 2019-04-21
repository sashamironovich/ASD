import java.util.NoSuchElementException;

public class ArrayBinaryTree<T extends Comparable> {
    protected T[] array;
    protected int size;

    public ArrayBinaryTree(){
        array = (T[]) new Comparable[3];
        size = 0;
    }

    public ArrayBinaryTree(T root){
            array = (T[]) new Comparable[3];
            array[0] = root;
            size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void expand(){
        Comparable[] newArray = new Comparable[array.length*2+2];
        for (int i = 0; i <array.length ; i++) {
            newArray[i] = array[i];
        }
        array = (T[]) newArray;

    }

    public int nubVertex(){
        int numb = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] != null){
                numb++;
            }
        }
        return numb;
    }

    public int indexOf(T el){
        if(!contains(el))return 0;
        for (int i = 0; i <array.length ; i++) {
            if(el.equals(array[i]))return i;

        }
        throw new NoSuchElementException();

    }

//    public boolean exist(T el){
//        checkNull(el);
//        for (int i = 0; i < array.length; i++) {
//            if(array[i].equals(el))return true;
//        }
//        throw new NoSuchElementException();
//    }

    private void checkNull(T el){
        if(el == null)throw new NullPointerException();

    }

    public boolean contains(T el){
        checkNull(el);
        for (int i = 0; i < array.length; i++) {
            if (el.equals(array[i])) return true;
        }
        return false;
    }

    public void addLeftSon(T father ,T son){
        contains(father);
        checkNull(son);
        int fatherInd = indexOf(father);
        if(array.length<fatherInd*2+2)expand();
        if(array[fatherInd*2+1] != null)throw new IllegalArgumentException();
        else {
            if(array.length<fatherInd*2+2)expand();
            array[fatherInd*2+1]=son;
            size++;
            expand();
        }

    }

    public void addRightSon(T father ,T son){
        contains(father);
        checkNull(son);
        int fatherInd = indexOf(father);
        if(array.length<fatherInd*2+2)expand();
        if(array[fatherInd*2+2] != null)throw new IllegalArgumentException();
        else {
            if(array.length<fatherInd*2+2)expand();
            array[fatherInd*2+2]=son;
            size++;
            expand();
        }
    }

    private void moveVertex(int fromInd, int toInd){
        MyQueue<int[]> queue = new MyQueue<>();
        queue.add(new int[]{fromInd,toInd});
        int from,to;
        while(!queue.empty()){
            from = queue.peek()[0];
            to = queue.poll()[1];
            if(array[from]==null)continue;
            array[to] = array[from];
            array[from] = null;
            queue.add(new int[]{from*2+1,to*2+1});
            queue.add(new int[]{from*2+2,to*2+2});
            if(to*2+1>= array.length)expand();

        }
    }

    public void delete(T el){
        int index = indexOf(el);
        int leftSonIndex = index*2+1;
        int rightSonIndex = index*2+2;
        array[index]=null;
        size--;
        if(array[leftSonIndex]!=null && array[rightSonIndex]!=null){
            int lowestLeftNullNode = leftSonIndex;
            while(array[lowestLeftNullNode]!=null){
                lowestLeftNullNode = lowestLeftNullNode*2+1;
            }
            moveVertex(rightSonIndex,lowestLeftNullNode);
            moveVertex(leftSonIndex,index);
        }
        else if(array[leftSonIndex]!= null){
            moveVertex(leftSonIndex,index);
        }
        else if(array[rightSonIndex]!=null){
            moveVertex(rightSonIndex,index);
        }
    }

    public String toString(){
        String str = "";
        for (int i = 0; i <array.length ; i++) {
            if(array[i]!=null){
                str+= "( "+ array[i] + " (" +  array[2*i+1] + " , " + array[2*i+2] + ")) \n";
            }

        }
        return str;
    }
}
