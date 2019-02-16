public class ShellSortStrategy implements SortStrategy {
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
        for(int gap = a.length/2;gap>=1;gap/=2){
            for(int i = gap;i<a.length;i++){
                for(int j = i;j>=gap && a[j-gap]>a[j];j-=gap){
                    exch(a,j,j-gap);
                }
            }
        }

    }
}
