package asd.practice5;

import org.junit.Ignore;


import java.util.Arrays;
import java.util.Comparator;

public class MergeWithInsertAndComparing<T> implements SortStrategy<T> {


    @Override
    public void sortAsc(Comparable<T>[] a){
        if(isSorted(a))return;
        mergeSort(a,0,a.length-1);

    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        mergeSortDesc(a,0,a.length-1);

    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        mergeSort(a,comparator,0,a.length-1);

    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        mergeSortDesc(a,comparator,0,a.length-1);

    }



    private void mergeSort(Comparable<T>[] array,  int l, int r) {

        ///////////////////////// Insertion for small arrays
        if (r - l < 50) {
           insertSort(array, l, r);
            return;
        }
        //////////////////////////

        int m = (l + r) / 2;
       Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
        if (l != m)
            mergeSort(tmp,  l, m);
        if (m + 1 != r)
           mergeSort(tmp, m + 1, r);

        ////////////////////////////// Compare before merge

        if (tmp[m].compareTo((T)tmp[m + 1])<=0) {
            for (int i = l; i <= r; i++)
                array[i] = tmp[i];
            return;
        }

        //////////////////////////////

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
            } else if (tmp[i].compareTo((T)tmp[z])<0) {
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[z];
                z++;
            }
            k++;
        }
    }

    private void mergeSort(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {

        ///////////////////////// Insertion for small arrays
        if (r - l < 50) {
            insertSort(array,comparator, l, r);
            return;
        }
        //////////////////////////

        int m = (l + r) / 2;
        Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
        if (l != m)
            mergeSort(tmp,comparator,  l, m);
        if (m + 1 != r)
            mergeSort(tmp,comparator, m + 1, r);

        ////////////////////////////// Compare before merge

        if (comparator.compare((T)tmp[m],(T)tmp[m + 1])<=0) {
            for (int i = l; i <= r; i++)
                array[i] = tmp[i];
            return;
        }

        //////////////////////////////

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
            } else if (comparator.compare((T)tmp[i],(T)tmp[z])<0) {
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[z];
                z++;
            }
            k++;
        }
    }


    private void mergeSortDesc(Comparable<T>[] array,  int l, int r) {

        ///////////////////////// Insertion for small arrays
        if (r - l < 50) {
            insertSortDesc(array, l, r);
            return;
        }
        //////////////////////////

        int m = (l + r) / 2;
        Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
        if (l != m)
            mergeSortDesc(tmp,  l, m);
        if (m + 1 != r)
            mergeSortDesc(tmp, m + 1, r);

        ////////////////////////////// Compare before merge

        if (tmp[m].compareTo((T)tmp[m + 1])>=0) {
            for (int i = l; i <= r; i++)
                array[i] = tmp[i];
            return;
        }

        //////////////////////////////

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
            } else if (tmp[i].compareTo((T)tmp[z])>0) {
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[z];
                z++;
            }
            k++;
        }
    }



    private void mergeSortDesc(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {

        ///////////////////////// Insertion for small arrays
        if (r - l < 50) {
            insertSortDesc(array,comparator, l, r);
            return;
        }
        //////////////////////////

        int m = (l + r) / 2;
        Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
        if (l != m)
            mergeSortDesc(tmp,comparator,  l, m);
        if (m + 1 != r)
            mergeSortDesc(tmp,comparator, m + 1, r);

        ////////////////////////////// Compare before merge

        if (comparator.compare((T)tmp[m],(T)tmp[m + 1])>=0) {
            for (int i = l; i <= r; i++)
                array[i] = tmp[i];
            return;
        }

        //////////////////////////////

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
            } else if (comparator.compare((T)tmp[i],(T)tmp[z])>0) {
                array[k] = tmp[i];
                i++;
            } else {
                array[k] = tmp[z];
                z++;
            }
            k++;
        }
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

    private   boolean less(Comparable<T> v,Comparable<T> w){
        if (v.compareTo((T)w)<0)return true;
        else return false;
    }

    private  boolean isSorted(Comparable<T>[] a){
        for(int i =1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }




}

