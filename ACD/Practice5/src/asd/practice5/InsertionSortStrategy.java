package asd.practice5;

import java.util.Comparator;

public class InsertionSortStrategy<T>implements SortStrategy<T> {
    private static <T> boolean less(Comparable<T> v,Comparable<T> w){
        return v.compareTo((T)w)<0;
    }

    private static <T> void exch(Comparable<T>[] a,int i,int j){
        Comparable<T> swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static <T> boolean isSorted(Comparable<T>[] a){
        for(int i =1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    @Override
    public void sortAsc(Comparable<T>[] a) {
        for(int i = 0 ;i<a.length;i++){
            for(int j = i;j>0 && a[j-1].compareTo((T)a[j])>0;j--){
                exch(a,j-1,j);
            }
        }
    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 0;i<a.length;i++){
            for(int j = i;j>0 && comparator.compare((T)a[j-1],(T)a[j])>0;j--){
                exch(a,j-1,j);
            }
        }

    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        for(int i = 0 ;i<a.length;i++){
            for(int j = i;j>0 && a[j-1].compareTo((T)a[j])<0;j--){
                exch(a,j-1,j);
            }
        }

    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        for(int i = 0;i<a.length;i++){
            for(int j = i;j>0 && comparator.compare((T)a[j-1],(T)a[j])<0;j--){
                exch(a,j-1,j);
            }
        }

    }
}
