public class BubbleSortStrategy  implements SortStrategy {
    private static  boolean less(int v,int w){
        if (v<w)return true;
        else return false;
    }

    private static  void exch(int[] a,int i,int j){
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static  boolean isSorted(int[] a){
        for(int i =1;i<a.length;i++){
            if(a[i]<a[i-1]){
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
        int n = a.length;
        for(int i =n-1;i>=0;i--)
            for(int j = 0;j<i;j++){
                if(a[j]>a[j+1]){
                    exch(a,j,j+1);
                }

            }

    }

}
