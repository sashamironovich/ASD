import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queue <T extends Comparable> {
    private int maxSize;
    private boolean areNullElementsAllowed;
    private MyLinkedList<T> list ;
    public  Queue(){
        this.maxSize = Integer.MAX_VALUE;
        this.areNullElementsAllowed = true;
        this.list = new MyLinkedList<>();

    }

    public Queue(int maxSize,boolean areNullElementsAllowed){
        if(maxSize<=0){
            this.maxSize = Integer.MAX_VALUE;
        }else{
            this.maxSize = maxSize;
        }
        this.list = new MyLinkedList<>();
        this.areNullElementsAllowed = areNullElementsAllowed;
    }

    public T element(){
        MyLinkedListNode<T> last = null;
        try{
            if(list.isEmpty())throw new NoSuchElementException();
            last = list.getLast();
        }catch (NoSuchElementException e){
            System.out.print("You've got an NoSuchElementException cause last element == ");

        }
        finally {
            if(last==null)return null;
            return last.getValue();
        }
    }

    public T peek(){
        MyLinkedListNode<T> last = null;
        try{
            if(list.isEmpty())throw new NoSuchElementException();
            last = list.getLast();
        }catch (NoSuchElementException e){
            //System.out.print("You've got an NoSuchElementException cause last element == ");

        }
        finally {
            if(last==null)return null;
            return last.getValue();
        }
    }


    public boolean offer(T item){
        boolean answ = false;
        try{
            if(list.getSize()>=maxSize)throw new IllegalStateException();
            if(!this.areNullElementsAllowed && item == null)throw new  NullPointerException();

            else{
                list.append(item);
                answ = true;
            }
        }catch (IllegalStateException e){
            //System.out.println("Illegal State Exception");

        }catch (NullPointerException e){
            System.out.println("Null Pointer Exception");
        }
        finally {
            return answ;
        }

    }

    public boolean add(T item){
        boolean answ = false;
        try{
            if(list.getSize()>=maxSize)throw new IllegalStateException();
                    if(!this.areNullElementsAllowed && item == null)throw new  NullPointerException();

            else{
                list.append(item);
                answ = true;
            }
        }catch (IllegalStateException e){
            System.out.println("Illegal State Exception");

        }catch (NullPointerException e){
            System.out.println("Null Pointer Exception");
        }
        finally {
            return answ;
        }
    }

    public String toString(){
        String answ = "\" end -> \"[ ";
        Comparable[] arr = list.toArray();
        for (int i = 0; i <arr.length ; i++) {
            answ+=arr[i] + " ";

        }
        return answ + "] \"<- head \"";
    }

    public T remove(){
        MyLinkedListNode<T> last = null;
        MyLinkedListNode<T> prev = null;
        try{
            if(list.isEmpty())throw new NoSuchElementException();
            last = list.getLast();
            list.delete(last);
        }catch (NoSuchElementException e){
            System.out.println("You've got an NoSuchElementException");
        }
        finally {
            if(last==null)return null;
            return last.getValue();
        }
    }

    public T poll(){
        MyLinkedListNode<T> last = null;
        MyLinkedListNode<T> prev = null;
        try{
            if(list.isEmpty())throw new NoSuchElementException();
            last = list.getLast();
            list.delete(last);
        }catch (NoSuchElementException e){
           // System.out.println("You've got an NoSuchElementException");
        }
        finally {
            if(last==null)return null;
            return last.getValue();
        }

    }

    public boolean empty(){
        return list.isEmpty();
    }

    public String search(T o){
        ArrayList<Integer> answ = new ArrayList<>();
        if(!list.contains(o)){
            return "-1";

        }
        Comparable[] arr = list.toArray();
        for (int i = 0, j = arr.length-1; i <arr.length ; i++,j--) {
            if(arr[i] == null)continue;
            if(arr[i] == o){
                answ.add(j+1);
            }

        }
        return answ.toString();

    }

}
