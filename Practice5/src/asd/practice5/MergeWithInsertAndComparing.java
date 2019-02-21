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

    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {

    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {

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

    private  void exch(Comparable<T>[] a, int i, int j) {
        Comparable t = a[i];
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



//    private static void change(int a[], int b[],int value_a, int value_b, int i, int j){
//        b[j] = value_a;
//        a[i] = value_b;
//    }




 //   @SuppressWarnings("unchecked")
//    public void mergeSort(int[] a, int n) {
//        if (n < 2) {
//            return;
//        }
//        int mid = n / 2;
//        int[] l =  new int[mid];
//       int[] r = new int[n - mid];
//
//        for (int i = 0; i < mid; i++) {
//            l[i] = a[i];
//        }
//        for (int i = mid; i < n; i++) {
//            r[i - mid] = a[i];
//        }
//
//        int max_l = l[0];
//        int index_l = 0;
//        int min_r = r[0];
//        int index_r = 0;
//        for(int i =0; i< l.length-1; i++) {
//            if(l[i+1]>l[i]) {
//                max_l = l[i+1];
//                index_l = i+1;
//            }
//        }
//        for(int i =0; i< l.length-1; i++) {
//            if(r[i]>r[i+1]) {
//                min_r = r[i+1];
//                index_r = i+1;
//            }
//        }
//
//        change(l, r, max_l, min_r, index_l, index_r);
//
//        if(mid < 20) {
//            insort(l, mid);
//            insort(r, n - mid);
//        }else {
//            mergeSort(l, mid);
//            mergeSort(r, n - mid);
//        }
//
//        mergeUp(a, l, r, mid, n - mid);
//    }
//
//    @SuppressWarnings("unchecked")
//    public static  void mergeUp(int[] a, int[] l,
//                                   int[] r, int left, int right) {
//        int i = 0, j = 0, k = 0;
//        while (i < left && j < right) {
//            if (l[i]<=r[j]) {
//                a[k++] = l[i++];
//            }
//            else {
//                a[k++] = r[j++];
//            }
//        }
//        while (i < left) {
//            a[k++] = l[i++];
//        }
//        while (j < right) {
//            a[k++] = r[j++];
//        }
//    }
//
//
//    @SuppressWarnings("unchecked")
//    public void insort(int[] a, int n) {
//        int temp;
//        int j;
//        for(int i = 0; i < n - 1; i++){
//            if (a[i]> a[i+1]) {
//                temp =  a[i + 1];
//                a[i + 1] = a[i];
//                j = i;
//                while (j > 0 && temp<a[j - 1]) {
//                    a[j] = a[j - 1];
//                    j--;
//                }
//                a[j] = temp;
//            }
//        }
//    }
}

