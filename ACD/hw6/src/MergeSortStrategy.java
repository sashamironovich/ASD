import java.util.Comparator;

public class MergeSortStrategy<T>  {
    private static <T> boolean less(Comparable<T> v,Comparable<T> w){
        return v.compareTo((T)w)<0;
    }

    @SuppressWarnings("unchecked")
    public static <T> void mergeAsc(Comparable<T> arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Comparable<T>[] L = new Comparable [n1];
        Comparable<T>[]R = new Comparable[n2];

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
            if (L[i].compareTo((T)R[j])<=0)
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


    public static <T> void sortMergeAsc(Comparable<T> arr[], int l, int r)
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

    public static <T> void MergeSortAsc(Comparable<T> arr[]){
        sortMergeAsc(arr, 0, arr.length-1);
    }


    @SuppressWarnings("unchecked")
    public static <T> void mergeAsc(Comparable<T> arr[],Comparator<T> comparator, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Comparable<T>[] L = new Comparable [n1];
        Comparable<T>[]R = new Comparable[n2];

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
            if (comparator.compare((T)L[i],(T)R[j])<=0)
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




    public static <T> void sortMergeAsc(Comparable<T> arr[],Comparator<T> comparator, int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sortMergeAsc(arr,comparator, l, m);
            sortMergeAsc(arr ,comparator, m+1, r);

            // Merge the sorted halves
            mergeAsc(arr,comparator, l, m, r);
        }
    }

    public static <T> void MergeSortAsc(Comparable<T> arr[],Comparator<T> comparator){
        sortMergeAsc(arr, comparator,0,arr.length-1);


    }

    @SuppressWarnings("unchecked")
    public static <T> void mergeDesc(Comparable<T> arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Comparable<T>[] L = new Comparable [n1];
        Comparable<T>[]R = new Comparable[n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];



        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i].compareTo((T)R[j])>=0)
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


    public static <T> void sortMergeDesc(Comparable<T> arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sortMergeDesc(arr, l, m);
            sortMergeDesc(arr , m+1, r);

            // Merge the sorted halves
            mergeDesc(arr, l, m, r);
        }
    }

    public static <T> void MergeSortDesc(Comparable<T> arr[]){
        sortMergeDesc(arr, 0, arr.length-1);
    }


    @SuppressWarnings("unchecked")
    public static <T> void mergeDesc(Comparable<T> arr[],Comparator<T> comparator, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Comparable<T>[] L = new Comparable [n1];
        Comparable<T>[]R = new Comparable[n2];

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
            if (comparator.compare((T)L[i],(T)R[j])>=0)
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
    public static <T> void sortMergeDesc(Comparable<T> arr[],Comparator<T> comparator, int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sortMergeDesc(arr,comparator, l, m);
            sortMergeDesc(arr ,comparator, m+1, r);

            // Merge the sorted halves
            mergeDesc(arr,comparator, l, m, r);
        }
    }

    public static <T> void MergeSortDesc(Comparable<T> arr[],Comparator<T> comparator){
        sortMergeDesc(arr, comparator,0,arr.length-1);
    }




    public void sortAsc(Comparable<T>[] a) {
        MergeSortAsc(a);

    }


    public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
        MergeSortAsc(a,comparator);

    }


    public void sortDesc(Comparable<T>[] a) {
        MergeSortDesc(a);

    }


    public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
        MergeSortDesc(a,comparator);

    }
}
