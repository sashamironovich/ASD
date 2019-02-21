package asd.practice5;

import java.util.Comparator;

public class CombSortStrategy<T> implements SortStrategy<T> {

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
        if(isSorted(a))return;
        int gap = a.length;
        boolean swapped = true;
        while(gap>1 || swapped){
            if(gap>1) gap = (gap*10)/13;
            swapped=false;

            for(int i=0;i+gap<a.length;i++){

                if(a[i].compareTo((T)a[i+gap])>0){
                    exch(a,i,i+gap);
                    swapped=true;
                }
            }

        }
    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        int gap = a.length;
        boolean swapped = true;
        while(gap>1 || swapped){
            gap = (int)(gap/1.247330950103979);
            swapped= false;
            for(int i = 0;i<a.length-gap;i++){
                if(comparator.compare((T) a[i],(T) a[i+gap])>0){
                    exch(a,i,i+gap);
                }
            }

        }

    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        if(isSorted(a))return;
        int gap = a.length;
        boolean swapped = true;
        while(gap>1 || swapped){
            if(gap>1) gap = (gap*10)/13;
            swapped=false;

            for(int i=0;i+gap<a.length;i++){

                if(a[i].compareTo((T)a[i+gap])<0){
                    exch(a,i,i+gap);
                    swapped=true;
                }
            }

        }

    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {

        int gap = a.length;
        boolean swapped = true;
        while(gap>1 || swapped){
            gap = (int)(gap/1.247330950103979);
            swapped= false;
            for(int i = 0;i<a.length-gap;i++){
                if(comparator.compare((T) a[i],(T) a[i+gap])<0){
                    exch(a,i,i+gap);
                }
            }

        }
    }
}
