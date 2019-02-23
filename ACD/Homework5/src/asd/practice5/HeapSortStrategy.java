package asd.practice5;

import java.util.Comparator;

public class HeapSortStrategy<T> implements SortStrategy<T> {

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

    //HEAPSORT
    @SuppressWarnings("unchecked")
    public static <T> void heapifyAsc(Comparable<T>[] a,int n ,int i) {

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && a[l].compareTo((T) a[largest]) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && a[r].compareTo((T) a[largest]) > 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            Comparable<T> swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapifyAsc(a, n, largest);

        }
    }

    public static <T> void heapSortAsc(Comparable<T>[] a){
        int n = a.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyAsc(a, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            Comparable<T> temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // call max heapify on the reduced heap
            heapifyAsc(a, i, 0);

        }


    }

    @SuppressWarnings("unchecked")
    public static <T> void heapifyAsc(Comparable<T>[] a,Comparator<T> comparator,int n ,int i) {

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && comparator.compare((T)a[l],(T)a[largest]) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && comparator.compare((T)a[r],(T)a[largest]) > 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            Comparable<T> swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapifyAsc(a,comparator, n, largest);

        }
    }

    public static <T> void heapSortAsc(Comparable<T>[] a,Comparator<T> comparator){
        int n = a.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyAsc(a,comparator, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            Comparable<T> temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // call max heapify on the reduced heap
            heapifyAsc(a,comparator, i, 0);

        }


    }

    //HEAPSORT
    @SuppressWarnings("unchecked")
    public static <T> void heapifyDesc(Comparable<T>[] a,int n ,int i) {

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && a[l].compareTo((T) a[largest]) < 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && a[r].compareTo((T) a[largest]) < 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            Comparable<T> swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapifyDesc(a, n, largest);

        }
    }

    public static <T> void heapSortDesc(Comparable<T>[] a){
        int n = a.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyDesc(a, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            Comparable<T> temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // call max heapify on the reduced heap
            heapifyDesc(a, i, 0);

        }


    }

    @SuppressWarnings("unchecked")
    public static <T> void heapifyDesc(Comparable<T>[] a,Comparator<T> comparator,int n ,int i) {

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && comparator.compare((T)a[l],(T)a[largest]) < 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && comparator.compare((T)a[r],(T)a[largest]) < 0)
            largest = r;

        // If largest is not root
        if (largest != i) {
            Comparable<T> swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapifyDesc(a,comparator, n, largest);

        }
    }

    public static <T> void heapSortDesc(Comparable<T>[] a,Comparator<T> comparator){
        int n = a.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyDesc(a,comparator, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            Comparable<T> temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // call max heapify on the reduced heap
            heapifyDesc(a,comparator, i, 0);

        }






    }



    @Override
    public void sortAsc(Comparable<T>[] a) {
        heapSortAsc(a);

    }

    @Override
    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        heapSortAsc(a,comparator);

    }

    @Override
    public void sortDesc(Comparable<T>[] a) {
        heapSortDesc(a);

    }

    @Override
    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        heapSortDesc(a,comparator);

    }
}
