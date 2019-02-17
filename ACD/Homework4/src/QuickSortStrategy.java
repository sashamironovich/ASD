//public class QuickSortStrategy implements SortStrategy {
//    private static  boolean less(int v,int w){
//        if (v<w)return true;
//        else return false;
//    }
//
//    @Override
//    public String getName() {
//        return "QUICK SORT";
//    }
//
//    private static  void exch(int[] a,int i,int j){
//        int swap = a[i];
//        a[i] = a[j];
//        a[j] = swap;
//    }
//
//    public static void quickSortAsc(int[] a,int low,int high){
//
//        if(low<high){
//            int pi = partitionAsc(a,low,high);
//
//            quickSortAsc(a,low,pi-1);
//            quickSortAsc(a,pi+1,high);
//
//
//        }
//    }
//
//    public static int partitionAsc(int[] a,int low,int high){
//        int pivot = a[high];
//        int i = low-1;
//
//        for(int j = low;j<high;j++){
//            if(a[j]<=pivot){
//                i++;
//
//                exch(a,j,i);
//            }
//        }
//
//        exch(a,i+1,high);
//
//        return i+1;
//
//    }
//    private static  boolean isSorted(int[] a){
//        for(int i =1;i<a.length;i++){
//            if(less(a[i],a[i-1])){
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//
//    @Override
//    public void sort(int[] a) {
//        if(isSorted(a))return;
//        //sortUp(a,0,a.length-1);
//        quickSortAsc(a,0,a.length-1);
//    }
//}
public class QuickSortStrategy implements SortStrategy {

    @SuppressWarnings("unchecked")
    private static<T>  boolean less(Comparable<T> v,Comparable<T> w){
        if (v.compareTo((T)w)<0)return true;
        else return false;
    }

    @Override
    public String getName() {
        return "QUICK SORT";
    }

    private static void exch(int[] a,int i,int j){
        int  swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void quickSortAsc(int [] a,int low,int high){
        if(low<high){
            int pi = partitionAsc(a,low,high);

            quickSortAsc(a,low,pi-1);
            quickSortAsc(a,pi+1,high);

        }
    }

    @SuppressWarnings("unchecked")
    public static<T> int partitionAsc(int[] a,int low,int high){
        int pivot = a[high];
        int i = low-1;

        for(int j = low;j<high;j++){
            if(a[j]<=pivot){
                i++;

                exch(a,j,i);
            }
        }

        exch(a,i+1,high);

        return i+1;

    }
    private static boolean isSorted(int[] a){
        for(int i =1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    @Override
    public void sort(int[] a) {
        if(isSorted(a))return;
        quickSortAsc(a, 0, a.length-1);
    }
}