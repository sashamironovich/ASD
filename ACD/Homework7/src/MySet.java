public class MySet <E extends Comparable>{

    private MyLinkedList<E> list;

    public MySet(){
        list = new MyLinkedList();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public boolean contains(E a ){
        return list.contains(a);
    }

    public void clear(){
        list.clear();
    }

    public void add(E a ){
        MyLinkedListNode<E> node = list.getHead();
        if(list.isEmpty() || a.compareTo(node.getValue())<0){
            list.append(a);
            return;
        }
        while (node.getNext()!=null && a.compareTo(node.getNext().getValue())>0 ){
            node = node.getNext();
        }
        if(node.getNext() == null || a.compareTo(node.getNext().getValue())<0 ){
            list.addAfter(a,node);
        }
    }

    public void delete(E a ){

        MyLinkedListNode<E> node = list.getHead();
        if(!list.contains(a))return;
        while(node!=null){
            if(a == node.getValue()) {
                list.delete(node);
                return;
            }
            node = node.getNext();
        }
    }
    public String toString(){
        return "" + list;
    }

    public Comparable[] toArray(){
        return list.toArray();
    }

    public MySet union(MySet A,MySet B){
        MySet C = new MySet();
        Comparable[] arrA = A.toArray();
        Comparable[] arrB = B.toArray();
        for (int i = 0; i <arrA.length ; i++) {
            C.add(arrA[i]);
        }
        for (Comparable value: arrB) {
            C.add(value);
        }
        return C;
    }

    public MySet intersection(MySet A,MySet B){
        MySet C = new MySet();
        Comparable[] arrA = A.toArray();
        Comparable[] arrB = B.toArray();
        for (int i = 0; i <arrA.length ; i++) {
            if(arrA[i] == arrB[i]){
                C.add(arrA[i]);
            }
        }
        return C;
    }

    public MySet difference (MySet A,MySet B){
        MySet C = new MySet();
        Comparable[] arrA = A.toArray();
        Comparable[] arrB = B.toArray();
        for (int i = 0; i <arrA.length ; i++) {
            if(!B.contains(arrA[i]))C.add(arrA[i]);

        }
        return C;
    }

    public MySet merge(MySet A,MySet B){
        MySet C = new MySet();
        Comparable[] arrA = A.toArray();
        Comparable[] arrB = B.toArray();
        for (int i = 0; i < arrA.length; i++) {
            if(B.contains(arrA[i])){
                System.out.println("Sets have same elements");
                return null;
            }
        }
        C = union(A,B);
        return C;
    }

    public MySet makeNull(MySet A){
        A.list.clear();
        return A;
    }

    public MySet assign(MySet A,MySet B){
        A.makeNull(A);
        Comparable[] arrB = B.toArray();
        for (Comparable value: arrB) {
            A.add(value);
        }
        return A;
    }

    public  Comparable min(MySet A) {
        Comparable[] array = A.toArray();
        return array[0];
    }

    public  Comparable max(MySet A) {
        Comparable[] array = A.toArray();
        return array[array.length-1];
    }

    public  boolean equal(MySet A, MySet B) {
        Comparable[] array1 = A.toArray();
        Comparable[] array2 = B.toArray();
        if (array1.length != array2.length)
            return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i])
                return false;
        }
        return true;
    }


    public  MySet find(Comparable x, MySet... sets) {
        for (int i = 0; i < sets.length - 1; i++) {
            for (int k = i + 1; k < sets.length; k++) {
                if (!intersection(sets[i], sets[k]).isEmpty())
                    return null;
            }
        }
        for (int i = 0; i < sets.length; i++) {
            if (sets[i].contains(x))
                return sets[i] ;
        }
        return null;
    }
}
