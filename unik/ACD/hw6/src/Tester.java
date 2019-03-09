import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Tester {
    private final static File TASK2 = new File("task2.txt");
    private static String[]  task2Array = {"line1","line2","line3","abc","dge"};



    public static void main(String[] args) {

        System.out.println("TASK1");
        System.out.println("READING FROM INPUT.TXT TO ARRAY");
        System.out.println(Arrays.toString(Homework6.task1(new File("input.txt"))));
        System.out.println("________________________________");
        System.out.println("TASK2");
        Homework6.task2(task2Array,TASK2);
        System.out.println("________________________________");
        System.out.println("TASK3");
        System.out.println(Homework6.task3("abc",new File("task2.txt")));
        System.out.println("TASK4");
        System.out.println("Looking for a string \"41\" : ");
            ArrayList<int[]> index = Homework6.task4("41",new File("input.txt"));
            for (int[] i : index) { System.out.println(Arrays.toString(i)); }
        System.out.println("Task5");
        System.out.println("Sorted ascending");
        Homework6.task5Asc(new File("names.txt"));
        System.out.println(Arrays.toString(Homework6.task1(new File("names_sorted_asc.txt"))));
        System.out.println("Sorted descending");
        Homework6.task5Desc(new File("names.txt"));
        System.out.println(Arrays.toString(Homework6.task1(new File("names_sorted_desc.txt"))));

        System.out.println("TASK6");
        System.out.println("Changing subline \"vych\" to \"va\"");
        Homework6.task6(new File("names.txt"),"vych","va");


    }

}
