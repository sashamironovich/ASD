package asd.practice5;

import java.util.Comparator;


public interface SortStrategy<T> {
	
	void sortAsc(Comparable<T>[] a);	
	void sortDesc(Comparable<T>[] a);
	
	void sortAsc(Comparable<T>[] a, Comparator<T> comparator);
	void sortDesc(Comparable<T>[] a, Comparator<T> comparator);
	
}
