import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack <T extends Comparable> {
    int maxSize;
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void Stack(){
        list = new MyLinkedList<>();

    }


    public T push (T data){

        if(list.isEmpty()){
            list.append(data);
        }
        else {
            MyLinkedListNode<T> last = list.getLast();
            list.addAfter(data,last);
        }
        return data;

    }

    public String toString(){
        String answ = "[";
        Comparable[] arr = list.toArray();
        for (int i = 0; i <arr.length ; i++) {
            answ+=arr[i] + " ";

        }
        return answ ;
    }

    public T pop() {

        MyLinkedListNode<T> last = null;
        try{
            if(list.isEmpty())throw new EmptyStackException();
            last = list.getLast();
            list.delete(last);
        }catch (EmptyStackException e){
            System.out.println("You've got an EmptyStackException");
        }
        finally {
            if(last==null)return null;
            return last.getValue();
        }
    }

    public T peek(){
        MyLinkedListNode<T> last = null;
        try{
            if(list.isEmpty())throw new EmptyStackException();
            last = list.getLast();
        }catch (EmptyStackException e){
            System.out.println("You've got an EmptyStackException");
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
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i] == o){
                answ.add(i+1);
            }

        }
        return answ.toString();

    }

}
