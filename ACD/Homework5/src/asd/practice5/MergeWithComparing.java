package asd.practice5;

import java.util.Arrays;
import java.util.Comparator;

public class MergeWithComparing<T> implements SortStrategy<T> {





	private void mergeSort(Comparable<T>[] array,  int l, int r) {
		int m = (l + r) / 2;
		Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
		if (l != m)
			mergeSort(tmp, l, m);
		if (m + 1 != r)
			mergeSort(tmp, m + 1, r);

		// Compare before merge

		if(tmp[m].compareTo((T)tmp[m + 1])<=0) {
			for (int i = l; i <= r; i++)
				array[i] = tmp[i];
			return;
		}

		//

		int i = l;
		int z = m + 1;
		int k = l;

		while (i <= m || z <= r) {
			if (i > m) {
				array[k] = tmp[z];
				z++;
			} else if (z > r) {
				array[k] = tmp[i];
				i++;
			} else if (tmp[i].compareTo((T)tmp[z])<0) {
				array[k] = tmp[i];
				i++;
			} else {
				array[k] = tmp[z];
				z++;
			}
			k++;
		}
	}

	private void mergeSort(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {
		int m = (l + r) / 2;
		Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
		if (l != m)
			mergeSort(tmp,comparator, l, m);
		if (m + 1 != r)
			mergeSort(tmp,comparator, m + 1, r);

		// Compare before merge

		if(comparator.compare((T)tmp[m],(T)tmp[m + 1])<=0) {
			for (int i = l; i <= r; i++)
				array[i] = tmp[i];
			return;
		}

		//

		int i = l;
		int z = m + 1;
		int k = l;

		while (i <= m || z <= r) {
			if (i > m) {
				array[k] = tmp[z];
				z++;
			} else if (z > r) {
				array[k] = tmp[i];
				i++;
			} else if (comparator.compare((T)tmp[i],(T)tmp[z])<0) {
				array[k] = tmp[i];
				i++;
			} else {
				array[k] = tmp[z];
				z++;
			}
			k++;
		}
	}

	private void mergeSortDesc(Comparable<T>[] array,  int l, int r) {
		int m = (l + r) / 2;
		Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
		if (l != m)
			mergeSortDesc(tmp, l, m);
		if (m + 1 != r)
			mergeSortDesc(tmp, m + 1, r);

		// Compare before merge

		if(tmp[m].compareTo((T)tmp[m + 1])>=0) {
			for (int i = l; i <= r; i++)
				array[i] = tmp[i];
			return;
		}

		//

		int i = l;
		int z = m + 1;
		int k = l;

		while (i <= m || z <= r) {
			if (i > m) {
				array[k] = tmp[z];
				z++;
			} else if (z > r) {
				array[k] = tmp[i];
				i++;
			} else if (tmp[i].compareTo((T)tmp[z])>0) {
				array[k] = tmp[i];
				i++;
			} else {
				array[k] = tmp[z];
				z++;
			}
			k++;
		}
	}

	private void mergeSortDesc(Comparable<T>[] array,Comparator<T> comparator,  int l, int r) {
		int m = (l + r) / 2;
		Comparable<T> tmp[] = Arrays.copyOf(array, array.length);
		if (l != m)
			mergeSortDesc(tmp,comparator, l, m);
		if (m + 1 != r)
			mergeSortDesc(tmp, comparator,m + 1, r);

		// Compare before merge

		if(comparator.compare((T)tmp[m],(T)tmp[m + 1])>=0) {
			for (int i = l; i <= r; i++)
				array[i] = tmp[i];
			return;
		}

		//

		int i = l;
		int z = m + 1;
		int k = l;

		while (i <= m || z <= r) {
			if (i > m) {
				array[k] = tmp[z];
				z++;
			} else if (z > r) {
				array[k] = tmp[i];
				i++;
			} else if (comparator.compare((T)tmp[i],(T)tmp[z])>0) {
				array[k] = tmp[i];
				i++;
			} else {
				array[k] = tmp[z];
				z++;
			}
			k++;
		}
	}

	private  boolean isSorted(Comparable<T>[] a){
		for(int i =1;i<a.length;i++){
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return true;
	}

	private  boolean less(Comparable<T> v,Comparable<T> w){
		if (v.compareTo((T)w)<0)return true;
		else return false;
	}

	@Override
	public void sortAsc(Comparable<T>[] a) {
		if(isSorted(a))return;
		mergeSort(a,0,a.length-1);

	}

	@Override
	public void sortDesc(Comparable<T>[] a) {
		mergeSortDesc(a,0,a.length-1);

	}

	@Override
	public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
		mergeSort(a,comparator,0,a.length-1);

	}

	@Override
	public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
		mergeSortDesc(a,comparator,0,a.length-1);

	}





}
