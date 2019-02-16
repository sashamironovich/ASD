public class MergeSortStrategy implements SortStrategy {

    public static void mergeAsc(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int [n1];
        int[]R = new int[n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i]<= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    public static void sortMergeAsc(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sortMergeAsc(arr, l, m);
            sortMergeAsc(arr , m+1, r);

            // Merge the sorted halves
            mergeAsc(arr, l, m, r);
        }
    }

    public static void MergeSortAsc(int arr[]){
        sortMergeAsc(arr, 0, arr.length-1);
    }

    private static  boolean less(int v,int w){
        if (v<w)return true;
        else return false;
    }

    private static  boolean isSorted(int[] a){
        for(int i =1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }






    @Override
    public void sort(int[] a) {
        if(isSorted(a)){
            return;
        }
        MergeSortAsc(a);

    }
}
