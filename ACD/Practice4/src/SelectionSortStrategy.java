public class SelectionSortStrategy implements SortStrategy {
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
        if (isSorted(a))return;
        for(int i = 0;i<a.length;i++){
            int min = i;
            for (int j =i;j<a.length;j++ ){
                if(a[j]<a[min]) min = j;
            }
            if(min!=i) exch(a,i,min);
        }

    }
}
