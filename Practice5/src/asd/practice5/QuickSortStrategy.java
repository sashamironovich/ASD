package asd.practice5;

import java.util.Comparator;

public class QuickSortStrategy<T> implements SortStrategy<T> {
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
    @SuppressWarnings("unchecked")
    public static <T> void quickSortAsc(Comparable<T>[] a,int low,int high){

        if(low<high){
            int pi = partitionAsc(a,low,high);

            quickSortAsc(a,low,pi-1);
            quickSortAsc(a,pi+1,high);


        }
    }
    @SuppressWarnings("unchecked")
    public static <T> int partitionAsc(Comparable<T>[]a,int low,int high){
        Comparable<T> pivot = a[high];
        int i = low-1;

        for(int j = low;j<high;j++){
            if(a[j].compareTo((T)pivot)<=0){
                i++;

                exch(a,j,i);
            }
        }

        exch(a,i+1,high);

        return i+1;

    }
    @SuppressWarnings("unchecked")
    public static <T> int partitionAsc(Comparable<T>[] a , Comparator<T> comparator,int low,int high){
        Comparable<T> pivot = a[high];
        int i = low - 1;

        for(int j = low;j<high;j++){
            if(comparator.compare((T)a[j],(T)pivot)<=0){
                i++;
                exch(a,j,i);
            }
        }

        exch(a,i+1,high);
        return i+1;
    }
    @SuppressWarnings("unchecked")
    public static <T> void quickSortAsc(Comparable<T>[] a,Comparator<T> comparator,int low,int high){
        if(low<high){
            int pi =partitionAsc(a,comparator,low,high);

            quickSortAsc(a,comparator,low,pi-1);
            quickSortAsc(a,comparator,pi+1,high);
        }

    }

    //DESC
    @SuppressWarnings("unchecked")
    public static <T> void quickSortDesc(Comparable<T>[] a,int low,int high){

        if(low<high){
            int pi = partitionDesc(a,low,high);

            quickSortDesc(a,low,pi-1);
            quickSortDesc(a,pi+1,high);


        }
    }
    @SuppressWarnings("unchecked")
    public static <T> int partitionDesc(Comparable<T>[]a,int low,int high){
        Comparable<T> pivot = a[high];
        int i = low-1;

        for(int j = low;j<high;j++){
            if(a[j].compareTo((T)pivot)>=0){
                i++;

                exch(a,j,i);
            }
        }

        exch(a,i+1,high);

        return i+1;

    }
    @SuppressWarnings("unchecked")
    public static <T> int partitionDesc(Comparable<T>[] a , Comparator<T> comparator,int low,int high){
        Comparable<T> pivot = a[high];
        int i = low - 1;

        for(int j = low;j<high;j++){
            if(comparator.compare((T)a[j],(T)pivot)>=0){
                i++;
                exch(a,j,i);
            }
        }

        exch(a,i+1,high);
        return i+1;
    }
    @SuppressWarnings("unchecked")
    public static <T> void quickSortDesc(Comparable<T>[] a,Comparator<T> comparator,int low,int high){
        if(low<high){
            int pi =partitionDesc(a,comparator,low,high);

            quickSortDesc(a,comparator,low,pi-1);
            quickSortDesc(a,comparator,pi+1,high);
        }

    }

    @Override
    public void sortAsc(Comparable<T>[] a) {
        quickSortAsc(a,0,a.length-1);

    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        quickSortAsc(a,comparator,0,a.length-1);

    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        quickSortDesc(a,0,a.length-1);

    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        quickSortDesc(a,comparator,0,a.length-1);

    }
}
