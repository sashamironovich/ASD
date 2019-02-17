import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.setCurrentSortStrategy(new QuickSortStrategy());
        int[] arr = new int[20000];
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = 30000-i;

        }
        System.out.println(Arrays.toString(arr));
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
