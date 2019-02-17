
public class MergeWithComparing implements SortStrategy {

	@Override
	public void sort(int[] a ){
		mergeSort(a,a.length);

	}
	public String getName() {		
		return "MERGE WITH COMPARING SORT";
	}
	

	
	private static void change(int a[], int b[], int value_a, int value_b, int i, int j){
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
	        int  min_r = r[0];
	        int index_r = 0;
	        for(int i =0; i< l.length-1; i++) {
	        	if(l[i+1]>l[i] ) {
		        	max_l = l[i+1];
		        	index_l = i+1;
		        }
	        } 
	        for(int i =0; i< l.length-1; i++) {
	        	if(r[i]>r[i+1] ) {
		       		min_r = r[i+1];
		       		index_r = i+1;
		       	}
	        }	
	        	
	        change(l, r, max_l, min_r, index_l, index_r);
	        
	        mergeSort(l, mid);
		    mergeSort(r, n - mid);
	
	        mergeUp(a, l, r, mid, n - mid);
	}

	@SuppressWarnings("unchecked")
	public static <T> void mergeUp(int[] a, int[] l,
		   int[] r, int left, int right) {
			int i = 0, j = 0, k = 0;
			while (i < left && j < right) {
				 if (l[i]<=r[j])  {
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

}
