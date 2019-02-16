public class HeapSortStrategy implements SortStrategy {


    private static  boolean less(int v,int w){
        if (v<w)return true;
        return false;
    }

    private static  boolean isSorted(int[] a){
        for(int i =1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }


    public static  void heapifyAsc(int[] a,int n ,int i) {

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && a[l]>a[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && a[r]>a[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapifyAsc(a, n, largest);

        }
    }

    public static void heapSortAsc(int[] a){
        int n = a.length;
        if(isSorted(a)){
            return;
        }

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapifyAsc(a, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // call max heapify on the reduced heap
            heapifyAsc(a, i, 0);

        }


    }

    @Override
    public void sort(int[] a) {
//        if(isSorted(a))return;
        heapSortAsc(a);


    }
}
