public class MergeInsertionSortStrategy implements SortStrategy {

    @Override
    public String getName() {
        return "MERGE WITH INSERT INTO";
    }
    static final int THRESHOLD = 10;
    static void mergeSort(int f[],int lb, int ub){
        if (ub - lb <= THRESHOLD)
            insertionSort(f, lb, ub);
        else
        {
            int mid = (lb+ub)/2;
            mergeSort(f,lb,mid);
            mergeSort(f,mid,ub);
            merge(f,lb,mid,ub);
        }
    }

    static void merge (int f[],int p, int q, int r){
        //p<=q<=r
        int i =p; int j = q;
        //use temp array to store merged sub-sequence
        int temp[] = new int[r-p]; int t = 0;
        while(i<q && j<r){
            if(f[i]<=f[j]){
                temp[t] =f[i];
                i++;t++;
            }
            else{
                temp[t] = f[j];
                j++;
                t++;
            }

            //tag on remaining sequence
            while(i<q){
                temp[t] = f[i];
                i++;
                t++;

            }
            while(j<r){
                temp[t]=f[j];
                j++;
                t++;
            }
            //copy temp back to f
            i=p;t=0;
            while(t<temp.length){
                f[i]=temp[t];
                i++;
                t++;
            }
        }
    }


    public static void insertionSort(int array[], int n, int b){
        for (int i = 1; i < n; i++){
            int j = i;
            int B = array[i];
            while ((j > 0) && (array[j-1] > B)){
                array[j] = array[j-1];
                j--;
            }
            array[j] = B;
        }
    }

    @Override
    public void sort(int[] a) {
        mergeSort(a,0,a.length-1);
    }
}
