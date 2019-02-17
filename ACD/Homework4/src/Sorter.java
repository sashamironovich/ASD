public class Sorter {
    public Sorter(){}

    private SortStrategy currentSortStrategy;

    public void setCurrentSortStrategy(SortStrategy currentSortStrategy) {
        this.currentSortStrategy = currentSortStrategy;
    }

    public void sort(int[] a ){
        currentSortStrategy.sort(a);
    }

}
