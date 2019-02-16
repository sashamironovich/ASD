public class QuickSortStrategy implements SortStrategy {
    private static  boolean less(int v,int w){
        if (v<w)return true;
        else return false;
    }

    private static  void exch(int[] a,int i,int j){
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void quickSortAsc(int[] a,int low,int high){

        if(low<high){
            int pi = partitionAsc(a,low,high);

            quickSortAsc(a,low,pi-1);
            quickSortAsc(a,pi+1,high);


        }
    }

    public static int partitionAsc(int[] a,int low,int high){
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
    private static  boolean isSorted(int[] a){
        for(int i =1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }


//    public void sortUp(int[] arr, int begin, int end) {
//        if (begin < end) {
//            int partitionIndex = partitionUp(arr, begin, end);
//
//            sortUp(arr, begin, partitionIndex-1);
//            sortUp(arr, partitionIndex+1, end);
//        }
//    }
//
//    public static  int partitionUp(int[] arr, int begin, int end) {
//        int pivot = arr[end];
//        int i = (begin-1);
//
//        for (int j = begin; j < end; j++) {
//            if (arr[j]<=pivot) {
//                i++;
//
//               int swapTemp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = swapTemp;
//            }
//        }
//
//       int swapTemp = arr[i+1];
//        arr[i+1] = arr[end];
//        arr[end] = swapTemp;
//
//        return i+1;
//    }



    @Override
    public void sort(int[] a) {
        if(isSorted(a))return;
        //sortUp(a,0,a.length-1);
        quickSortAsc(a,0,a.length-1);
    }
}
