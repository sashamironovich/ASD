public class Quick3wayBarsStrategy implements SortStrategy {
    @Override
    public String getName() {
        return "QUICK DIJKSTRA";
    }

//    public static void sort(double[] a) {
//        // StdRandom.shuffle(a);
//
//        sort(a, 0, a.length - 1);
//
//    }
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