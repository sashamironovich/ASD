package asd.practice5;

import java.util.Comparator;

public class Quick3wayBarsStrategy<T> implements SortStrategy<T> {

private boolean isSorted(Comparable<T>[] a) {
    return isSorted(a, 0, a.length - 1);
}

    private  boolean isSorted(Comparable<T>[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    private void sort(Comparable<T>[] array, int l, int r) {
        if (l >= r)
            return;
        Comparable<T> middle = array[l];
        int i = l + 1;
        // l to middle-1 is less then middle
        //  middle+1..r is more then middle
        int lEdge = l;
        int rEdge = r;

        while (i <= rEdge) {
            if (middle.compareTo((T)array[i])>0) {
                exch(array, lEdge, i);
                i++;
                lEdge++;
            } else if (middle == array[i]) {
                i++;
            } else if (middle.compareTo((T)array[i])<0) {
                exch(array, rEdge, i);
                rEdge--;
            }
        }

        sort(array,  l, lEdge - 1);
        sort(array,  rEdge + 1, r);

    }

    private boolean less(Comparable<T> v, Comparable<T> w) {
        return v.compareTo((T)w)<0;
    }

    private  void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    @Override
    public void sortAsc(Comparable[] a) {
    sort(a,0,a.length-1);

    }

    @Override
    public void sortDesc(Comparable[] a) {

    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {

    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {

    }
}