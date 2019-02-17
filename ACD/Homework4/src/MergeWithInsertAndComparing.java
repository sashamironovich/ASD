
public class MergeWithInsertAndComparing implements SortStrategy {

    @Override
    public String getName() {
        return "MERGE WITH INSERT AND COMPARING";
    }

    @Override
    public void sort(int[] a){
        mergeSort(a,a.length);

    }

    private static void change(int a[], int b[],int value_a, int value_b, int i, int j){
        b[j] = value_a;
        a[i] = value_b;
    }



    @SuppressWarnings("unchecked")
    public void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l =  new int[mid];
       int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        int max_l = l[0];
        int index_l = 0;
        int min_r = r[0];
        int index_r = 0;
        for(int i =0; i< l.length-1; i++) {
            if(l[i+1]>l[i]) {
                max_l = l[i+1];
                index_l = i+1;
            }
        }
        for(int i =0; i< l.length-1; i++) {
            if(r[i]>r[i+1]) {
                min_r = r[i+1];
                index_r = i+1;
            }
        }

        change(l, r, max_l, min_r, index_l, index_r);

        if(mid < 20) {
            insort(l, mid);
            insort(r, n - mid);
        }else {
            mergeSort(l, mid);
            mergeSort(r, n - mid);
        }

        mergeUp(a, l, r, mid, n - mid);
    }

    @SuppressWarnings("unchecked")
    public static  void mergeUp(int[] a, int[] l,
                                   int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i]<=r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    @SuppressWarnings("unchecked")
    public void insort(int[] a, int n) {
        int temp;
        int j;
        for(int i = 0; i < n - 1; i++){
            if (a[i]> a[i+1]) {
                temp =  a[i + 1];
                a[i + 1] = a[i];
                j = i;
                while (j > 0 && temp<a[j - 1]) {
                    a[j] = a[j - 1];
                    j--;
                }
                a[j] = temp;
            }
        }
    }
}

