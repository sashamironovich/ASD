import java.util.Arrays;
import java.util.Random;

public class Tester {
    public static int itemsCopy[];
    public static int itemsCopy_duplc[];
    public static int itemsCopy_back[];
    public static int  length;
    public static int best;
    public static int final_i;
    public static void main(String[] args) {
        Out out = new Out("output.txt");

        Random random = new Random();

        SortStrategy sortStrategies[] = new SortStrategy[8];
        sortStrategies[0] = new MergeSortStrategy();
        sortStrategies[1] = new MergeInsertionSortStrategy();
        sortStrategies[2] = new MergeWithComparing();
        sortStrategies[3] = new MergeWithInsertAndComparing();
        sortStrategies[4] = new QuickSortStrategy();
        sortStrategies[5] = new QuickInsertSortStrategy();
        sortStrategies[6] = new Quick3wayBarsStrategy();
        sortStrategies[7] = new Quick3WayInsertStrategy();

        Sorter itemSorter = new Sorter();

        length = 1024;

        for( int k = 0; k < 6; k++) {
            out.println("======================================" + length + "======================================");
            for(int j=0; j<4; j++) {
                if(j==0) {
                    out.println("--------------------------------RANDOM NUMBERS----------------------------------");
                    int[] items_random = new int[length];
                    for (int i = 0; i<length; i++) {
                        items_random[i] =  (random.nextInt(100000));
                    }
                    itemsCopy_duplc = Arrays.copyOf(items_random,length);
                    itemsCopy= Arrays.copyOf(items_random, length);
                }else if(j == 1) {
                    out.println("--------------------------------SORTED NUMBERS----------------------------------");
                    int[] items_sorted = new int[length];
                    items_sorted[0] = (0);
                    for (int i = 1; i<length; i++) {
                        items_sorted[i] = random.nextInt(10000*i);
                        while(items_sorted[i-1]>items_sorted[i]) {
                            items_sorted[i] = (random.nextInt(10000*i));
                        }
                    }
                    itemsCopy_duplc = Arrays.copyOf(items_sorted, length);
                    itemsCopy = Arrays.copyOf(items_sorted, length);
                    itemsCopy_back= Arrays.copyOf(items_sorted, length);
                }else if(j == 2) {
                    out.println("---------------------------SORTED BACKWARDS NUMBERS-----------------------------");
                    int[] items_sorted_back = new int[length];
                    for(int i = 0; i< length; i++) {
                        items_sorted_back[i] = itemsCopy_back[length-i-1];
                    }
                    itemsCopy_duplc = Arrays.copyOf(items_sorted_back, length);
                    itemsCopy = Arrays.copyOf(items_sorted_back, length);
                }else {
                    out.println("---------------------------------SAME NUMBERS-----------------------------------");
                    int[] items_same = new int[length];
                    items_same[0] = (random.nextInt(100000));
                    for (int i = 1; i<length; i++) {
                        items_same[i] = items_same[0];
                    }
                    itemsCopy_duplc = Arrays.copyOf(items_same, length);
                    itemsCopy = Arrays.copyOf(items_same, length);
                }

                for(int i = 0; i<sortStrategies.length; i++) {

                    out.print("Algorithm: " + sortStrategies[i].getName() + "-> ");
                    itemSorter.setCurrentSortStrategy(sortStrategies[i]);

                    Stopwatch stopwatch = new Stopwatch();
                    itemSorter.sort(itemsCopy);
                    out.println("Sorting completed in: " + stopwatch.elapsedTime());

                    if (i == 0) {
                        best = (int)stopwatch.elapsedTime();
                        final_i = i;
                    }else{
                        int current = (int)stopwatch.elapsedTime();
                        if(current < best){
                            best = current;
                            final_i = i;
                        }
                    }
                    itemsCopy = Arrays.copyOf(itemsCopy_duplc, length);
                }
                out.println("BEST SORTING: "+ sortStrategies[final_i].getName());
            }
            length = length*2;
        }
        out.close();
    }
}
