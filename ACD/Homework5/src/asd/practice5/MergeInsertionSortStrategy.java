package asd.practice5;

import java.util.Arrays;
import java.util.Comparator;

public class MergeInsertionSortStrategy<T> implements SortStrategy<T> {


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

    public void insertSortDesc(Comparable[] array,  int l, int r) {
        int z;
        for (int i = l+1; i <= r; i++) {
            z = i;
            while (z > l && (array[z].compareTo(array[z - 1])>0)) {
                exch(array, z, z - 1);
                z--;
            }
        }
    }
    public <T> void insertSortDesc(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {
        int z;
        for (int i = l+1; i <= r; i++) {
            z = i;
            while (z > l && (comparator.compare((T)array[z],(T)array[z - 1])>0)) {
                exch(array, z, z - 1);
                z--;
            }
        }
    }
    public <T> void insertSort(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {
        int z;
        for (int i = l+1; i <= r; i++) {
            z = i;
            while (z > l && (comparator.compare((T)array[z],(T)array[z - 1])<0)) {
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


    private void mergeSort(Comparable[] array,  int l, int r) {

        // Insertion for arrays<50
        if (r - l < 50) {
            insertSort(array, l, r);
            return;
        }
        //

        int m = (l + r) / 2;
        Comparable tmp[] = Arrays.copyOf(array, array.length);
        if (l != m)
            mergeSort(tmp,  l, m);
        if (m + 1 != r)
            mergeSort(tmp,  m + 1, r);

        int i = l;
        int z = m + 1;
        int k = l;

        while (i <= m || z <= r) {
            if (i > m) {
                array[k] = tmp[z];
                z++;
            } else if (z > r) {
                array[k] = tmp[i];
                i++;
            } else if (tmp[i].compareTo(tmp[z])<0){
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[z];
                z++;
            }
            k++;
        }
    }

    private <T> void mergeSort(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {

        // Insertion for arrays<50
        if (r - l < 50) {
            insertSort(array,comparator, l, r);
            return;
        }
        //

        int m = (l + r) / 2;
        Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
        if (l != m)
            mergeSort(tmp,  l, m);
        if (m + 1 != r)
            mergeSort(tmp,  m + 1, r);

        int i = l;
        int z = m + 1;
        int k = l;

        while (i <= m || z <= r) {
            if (i > m) {
                array[k] = tmp[z];
                z++;
            } else if (z > r) {
                array[k] = tmp[i];
                i++;
            } else if (comparator.compare((T)tmp[i],(T)tmp[z])<0){
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[z];
                z++;
            }
            k++;
        }
    }

    private <T> void mergeSortDesc(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {

        // Insertion for arrays<50
        if (r - l < 50) {
            insertSortDesc(array,comparator, l, r);
            return;
        }
        //

        int m = (l + r) / 2;
        Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
        if (l != m)
            mergeSort(tmp,  l, m);
        if (m + 1 != r)
            mergeSort(tmp,  m + 1, r);

        int i = l;
        int z = m + 1;
        int k = l;

        while (i <= m || z <= r) {
            if (i > m) {
                array[k] = tmp[z];
                z++;
            } else if (z > r) {
                array[k] = tmp[i];
                i++;
            } else if (comparator.compare((T)tmp[i],(T)tmp[z])>0){
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[z];
                z++;
            }
            k++;
        }
    }


    private void mergeSortDesc(Comparable[] array,  int l, int r) {

        // Insertion for arrays<50
        if (r - l < 50) {
            insertSortDesc(array, l, r);
            return;
        }
        //

        int m = (l + r) / 2;
        Comparable tmp[] = Arrays.copyOf(array, array.length);
        if (l != m)
            mergeSort(tmp,  l, m);
        if (m + 1 != r)
            mergeSort(tmp,  m + 1, r);

        int i = l;
        int z = m + 1;
        int k = l;

        while (i <= m || z <= r) {
            if (i > m) {
                array[k] = tmp[z];
                z++;
            } else if (z > r) {
                array[k] = tmp[i];
                i++;
            } else if (tmp[i].compareTo(tmp[z])>0){
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[z];
                z++;
            }
            k++;
        }
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
    public void sortAsc(Comparable[] a) {
        if(isSorted(a))return;
        mergeSort(a,0,a.length-1);
    }

    @Override
    public void sortDesc(Comparable[] a){
        //
        mergeSortDesc(a,0,a.length-1);
    }

    @Override
    public void sortAsc(Comparable[] a, Comparator comparator) {
        mergeSort(a,comparator,0,a.length-1);
    }

    @Override
    public void sortDesc(Comparable[] a, Comparator comparator) {
        mergeSortDesc(a,comparator,0,a.length-1);
    }


}
