public class CombSortStrategy implements SortStrategy {
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
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }


    @Override
    public void sort(int[] a) {
        if(isSorted(a))return;
        int gap = a.length;
        boolean swapped = true;
        while(gap>1 || swapped){
            if(gap>1) gap = (gap*10)/13;
            swapped=false;

            for(int i=0;i+gap<a.length;i++){

                if(a[i]>a[i+gap]){
                    exch(a,i,i+gap);
                    swapped=true;
                }
            }

        }

    }
}
