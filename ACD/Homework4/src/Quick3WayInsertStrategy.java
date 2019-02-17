public class Quick3WayInsertStrategy implements SortStrategy {

    @Override
    public String getName() {
        return "QUICK INSERT AND DIJKSTRA";
    }

    public static void insertionSort(int[] list, int start, int end)
    {
        for (int x = start + 1; x < end; x++)
        {
            int val = list[x];
            int j = x - 1;
            while (j >= 0 && val < list[j])
            {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = val;
        }
    }

    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static void sort(int[] a, int lo, int hi) {

        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = a[lo];
        int i = lo;


        if ((hi-lo) < 9){

            insertionSort(a,lo, hi + 1);
        }else
        while (i <= gt)
            if (less(v, a[i])) exch(a, i, gt--);
            else if (less(a[i], v)) exch(a, lt++, i++);
            else i++;

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Override
    public void sort(int[] a) {
        isSorted(a);
        sort(a,0,a.length-1);
    }
}
