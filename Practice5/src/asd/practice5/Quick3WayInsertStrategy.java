package asd.practice5;

import java.util.Comparator;

public class Quick3WayInsertStrategy<T> implements SortStrategy<T> {


    public void insertSort(Comparable<T>[] array,  int l, int r) {
        int z;
        for (int i = l+1; i <= r; i++) {
            z = i;
            while (z > l && (array[z].compareTo((T)array[z - 1])<0)) {
                exch(array, z, z - 1);
                z--;
            }
        }
    }


    private void sortBoth(Comparable<T>[] array,  int l, int r) {
        if (l >= r)
            return;

        // Insertion for arrays<15
        if (r - l < 15) {
            insertSort(array, l, r);
            return;
        }
        //

        Comparable<T> middle = array[l];
        int i = l + 1;
        // l..lEdge-1 is less then middle
        // rEdge+1..r is more then middle
        int lEdge = l;
        int rEdge = r;

        while (i <= rEdge) {
            if (middle.compareTo((T)array[i])>0) {
                exch(array, lEdge, i);
                i++;
                lEdge++;
            } else if (middle ==  array[i]) {
                i++;
            } else if (middle.compareTo((T)array[i])<0) {
                exch(array, rEdge, i);
                rEdge--;
            }
        }

        sortBoth(array,  l, lEdge - 1);
        sortBoth(array,  rEdge + 1, r);

    }




    private  void exch(Comparable[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private  boolean less(Comparable<T> v,Comparable<T> w){
        if (v.compareTo((T)w)<0)return true;
        else return false;
    }

    private   boolean isSorted(Comparable<T>[] a){
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
        sortBoth(a,0,a.length-1);
    }

    @Override
    public void sortDesc(Comparable<T>[] a) {

    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {

    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {

    }
}
