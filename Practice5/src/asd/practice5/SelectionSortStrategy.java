package asd.practice5;

import java.util.Comparator;

public class SelectionSortStrategy<T> implements SortStrategy<T> {
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
        if (isSorted(a))return;
        for(int i = 0;i<a.length;i++){
            int min = i;
            for (int j =i;j<a.length;j++ ){
                if(a[j].compareTo((T)a[min])<0) min = j;
            }
            if(min!=i) exch(a,i,min);
        }

    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        if (isSorted(a))return;
        for(int i = 0;i<a.length;i++){
            int min = i;
            for (int j =i;j<a.length;j++ ){
                if(comparator.compare((T)a[j],(T)a[min])<0) min = j;
            }
            if(min!=i) exch(a,i,min);
        }
    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        if (isSorted(a))return;
        for(int i = 0;i<a.length;i++){
            int min = i;
            for (int j =i;j<a.length;j++ ){
                if(a[j].compareTo((T)a[min])>0) min = j;
            }
            if(min!=i) exch(a,i,min);
        }

    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        if (isSorted(a))return;
        for(int i = 0;i<a.length;i++){
            int min = i;
            for (int j =i;j<a.length;j++ ){
                if(comparator.compare((T)a[j],(T)a[min])>0) min = j;
            }
            if(min!=i) exch(a,i,min);
        }

    }
}
