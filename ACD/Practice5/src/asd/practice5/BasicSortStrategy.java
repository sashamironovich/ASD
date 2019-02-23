package asd.practice5;

import java.util.Comparator;


public class BasicSortStrategy<T> implements SortStrategy<T> {
	
	@SuppressWarnings("unchecked")
	private static <T> boolean less(Comparable<T> v, Comparable<T> w) {
		return v.compareTo((T) w) < 0;
	}

	private static <T> void exch(Comparable<T>[] a, int i, int j) {
		Comparable<T> swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static <T> boolean isSorted(Comparable<T>[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void sortAsc(Comparable<T>[] a) {
		int n = a.length;
		if (isSorted(a)) {
			return;
		}
		for (int i = 0; i < n; i++)
			for (int j = i; j > 0; j--) {
				if (a[j].compareTo((T) a[j - 1]) < 0) {
					exch(a, j, j - 1);
				}
				else 
					break;
			}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sortDesc(Comparable<T>[] a) {
		int n = a.length;
		if (isSorted(a)) {
			return;
		}
		for (int i = 0; i < n; i++)
			for (int j = i; j > 0; j--) {
				if (a[j].compareTo((T) a[j - 1]) > 0) {
					exch(a, j, j - 1);
				}
				else 
					break;
			}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sortAsc(Comparable<T>[] a, Comparator<T> comparator) {
		int n = a.length;
		if (isSorted(a)) {
			return;
		}
		for (int i = 0; i < n; i++)
			for (int j = i; j > 0; j--) {
				if (comparator.compare((T) a[j], (T) a[j - 1]) < 0) {
					exch(a, j, j - 1);
				}
				else 
					break;
			}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sortDesc(Comparable<T>[] a, Comparator<T> comparator) {
		int n = a.length;
		if (isSorted(a)) {
			return;
		}
		for (int i = 0; i < n; i++)
			for (int j = i; j > 0; j--) {
				if (comparator.compare((T) a[j], (T) a[j - 1]) > 0) {
					exch(a, j, j - 1);
				}
				else 
					break;
			}		
	}
}
