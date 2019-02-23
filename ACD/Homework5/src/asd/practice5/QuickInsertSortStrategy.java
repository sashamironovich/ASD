package asd.practice5;

import java.util.Comparator;

public class QuickInsertSortStrategy<T> implements SortStrategy<T> {

    private void quickInsert(Comparable<T>[] array,  int l, int r) {

        if (l >= r)
            return;

        // Insertion for  arrays<15
        if (r - l < 15) {
            insertSort(array, l, r);
            return;
        }
        //

        int i = l;
        int k = r - 1;
        while (i < k) {
            while (i < r && array[i].compareTo((T)array[r])<=0)
                i++;
            while (k > l && (array[k].compareTo((T)array[r])>=0))
                k--;
            if (i < k)
                exch(array, i, k);
        }
        if ((array[i].compareTo((T)array[r])>0))
            exch(array, i, r);
        quickInsert(array,  l, i - 1);
        quickInsert(array,  i + 1, r);
    }

    private void quickInsert(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {

        if (l >= r)
            return;

        // Insertion for  arrays<15
        if (r - l < 15) {
            insertSort(array,comparator, l, r);
            return;
        }
        //

        int i = l;
        int k = r - 1;
        while (i < k) {
            while (i < r && comparator.compare((T)array[i],(T)array[r])<=0)
                i++;
            while (k > l && comparator.compare((T)array[k],(T)array[r])>=0)
                k--;
            if (i < k)
                exch(array, i, k);
        }
        if ((comparator.compare((T)array[i],(T)array[r])>0))
            exch(array, i, r);
        quickInsert(array,comparator,  l, i - 1);
        quickInsert(array,comparator,  i + 1, r);
    }

    private void quickInsertDesc(Comparable<T>[] array,  int l, int r) {

        if (l >= r)
            return;

        // Insertion for  arrays<15
        if (r - l < 15) {
            insertSortDesc(array, l, r);
            return;
        }
        //

        int i = l;
        int k = r - 1;
        while (i < k) {
            while (i < r && array[i].compareTo((T)array[r])>=0)
                i++;
            while (k > l && (array[k].compareTo((T)array[r])<=0))
                k--;
            if (i < k)
                exch(array, i, k);
        }
        if ((array[i].compareTo((T)array[r])<0))
            exch(array, i, r);
        quickInsertDesc(array,  l, i - 1);
        quickInsertDesc(array,  i + 1, r);
    }

    private void quickInsertDesc(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {

        if (l >= r)
            return;

        // Insertion for  arrays<15
        if (r - l < 15) {
            insertSortDesc(array,comparator, l, r);
            return;
        }
        //

        int i = l;
        int k = r - 1;
        while (i < k) {
            while (i < r && comparator.compare((T)array[i],(T)array[r])>=0)
                i++;
            while (k > l && comparator.compare((T)array[k],(T)array[r])<=0)
                k--;
            if (i < k)
                exch(array, i, k);
        }
        if ((array[i].compareTo((T)array[r])<0))
            exch(array, i, r);
        quickInsertDesc(array,comparator,  l, i - 1);
        quickInsertDesc(array,comparator,  i + 1, r);
    }



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
    public void insertSort(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {
        int z;
        for (int i = l+1; i <= r; i++) {
            z = i;
            while (z > l && comparator.compare((T)array[z],(T)array[z - 1])<0) {
                exch(array, z, z - 1);
                z--;
            }
        }
    }

    public void insertSortDesc(Comparable<T>[] array,  int l, int r) {
        int z;
        for (int i = l+1; i <= r; i++) {
            z = i;
            while (z > l && (array[z].compareTo((T)array[z - 1])>0)) {
                exch(array, z, z - 1);
                z--;
            }
        }
    }

    public void insertSortDesc(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {
        int z;
        for (int i = l+1; i <= r; i++) {
            z = i;
            while (z > l && comparator.compare((T)array[z],(T)array[z - 1])>0) {
                exch(array, z, z - 1);
                z--;
            }
        }
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
        quickInsert(a,0,a.length-1);
    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        quickInsertDesc(a,0,a.length-1);

    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        quickInsert(a,comparator,0,a.length-1);

    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
       quickInsertDesc(a,comparator,0,a.length-1);

    }
}
