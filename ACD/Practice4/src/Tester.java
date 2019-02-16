import javafx.scene.paint.Stop;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Tester {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Sorter itemSorter = new Sorter();


        //1024
        int[] array1024Asc = new int[1024];
        for(int i = 0;i<array1024Asc.length;i++){
            array1024Asc[i] = i+1;
        }

        int[] array1024Desc = new int[1024];
        for(int i = 0;i<array1024Desc.length;i++){
            array1024Desc[i] = 1024-i;
        }

        int[] array1024Same = new int[1024];
        for(int i = 0;i<array1024Same.length;i++){
            array1024Same[i] = 1;
        }

        int[] array1024Random = new int[1024];
        for (int i = 0; i <array1024Random.length ; i++) {
            array1024Random[i] =(int) (Math.random()*1025);

        }

        //2048

        int[] array2048Asc = new int[2048];
        for(int i = 0;i<array2048Asc.length;i++){
            array2048Asc[i] = i+1;
        }

        int[] array2048Desc = new int[2048];
        for(int i = 0;i<array2048Desc.length;i++){
            array2048Desc[i] = 2048-i;
        }

        int[] array2048Same = new int[2048];
        for(int i = 0;i<array2048Same.length;i++){
            array2048Same[i] = 1;
        }

        int[] array2048Random = new int[2048];
        for (int i = 0; i <array2048Random.length ; i++) {
            array2048Random[i] =(int) (Math.random()*2048);

        }


        //4096

        int[] array4096Asc = new int[4096];
        for(int i = 0;i<array4096Asc.length;i++){
            array4096Asc[i] = i+1;
        }

        int[] array4096Desc = new int[4096];
        for(int i = 0;i<array4096Desc.length;i++){
            array4096Desc[i] = 4096-i;
        }

        int[] array4096Same = new int[4096];
        for(int i = 0;i<array4096Same.length;i++){
            array4096Same[i] = 1;
        }

        int[] array4096Random = new int[4096];
        for (int i = 0; i <array4096Random.length ; i++) {
            array4096Random[i] =(int) (Math.random()*4096);

        }

        //8192

        int[] array8192Asc = new int[8192];
        for(int i = 0;i<array8192Asc.length;i++){
            array8192Asc[i] = i+1;
        }

        int[] array8192Desc = new int[8192];
        for(int i = 0;i<array8192Desc.length;i++){
            array8192Desc[i] = 8192-i;
        }

        int[] array8192Same = new int[8192];
        for(int i = 0;i<array8192Same.length;i++){
            array8192Same[i] = 1;
        }

        int[] array8192Random = new int[8192];
        for (int i = 0; i <array8192Random.length ; i++) {
            array8192Random[i] =(int) (Math.random()*8192);

        }

        //16384

        int[] array16384Asc = new int[16384];
        for(int i = 0;i<array16384Asc.length;i++){
            array16384Asc[i] = i+1;
        }

        int[] array16384Desc = new int[16384];
        for(int i = 0;i<array16384Desc.length;i++){
            array16384Desc[i] = 16384-i;
        }

        int[] array16384Same = new int[16384];
        for(int i = 0;i<array16384Same.length;i++){
            array16384Same[i] = 1;
        }

        int[] array16384Random = new int[16384];
        for (int i = 0; i <array16384Random.length ; i++) {
            array16384Random[i] =(int) (Math.random()*16384);

        }

        //32768

        int[] array32768Asc = new int[32768];
        for(int i = 0;i<array16384Asc.length;i++){
            array32768Asc[i] = i+1;
        }

        int[] array32768Desc = new int[32768];
        for(int i = 0;i<array32768Desc.length;i++){
            array32768Desc[i] = 32768-i;
        }

        int[] array32768Same = new int[32768];
        for(int i = 0;i<array32768Same.length;i++){
            array32768Same[i] = 1;
        }

        int[] array32768Random = new int[32768];
        for (int i = 0; i <array32768Random.length ; i++) {
            array32768Random[i] =(int) (Math.random()*32768);

        }

        PrintWriter writer = new PrintWriter("times.txt", "UTF-8");
        writer.println("TEST");





        SortStrategy[] sortStrategy = new SortStrategy[8];
        sortStrategy[0] = new BubbleSortStrategy();
        sortStrategy[1] = new InsertionSortStrategy();
        sortStrategy[2] = new SelectionSortStrategy();
        sortStrategy[3] = new CombSortStrategy();
        sortStrategy[4] = new ShellSortStrategy();
        sortStrategy[5] = new MergeSortStrategy();
        sortStrategy[6] = new QuickSortStrategy();
        sortStrategy[7]= new HeapSortStrategy();

        for(int i = 0;i<sortStrategy.length;i++) {
            writer.println("==========================================================");
            writer.println("==========================================================");
            writer.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            itemSorter.setCurrentSortStrategy(sortStrategy[i]);
            System.out.println(sortStrategy[i].toString());
            writer.println(sortStrategy[i].toString());


            int arrayCopy[] = Arrays.copyOf(array1024Asc, array1024Asc.length);

            System.out.println("Array sized 1024 ascending sorted " );
            writer.println("Array sized 1024 ascending sorted " );
            Stopwatch timer1 = new Stopwatch();
            writer.println(timer1.elapsedTime());

            itemSorter.sort(arrayCopy);


            writer.println(timer1.elapsedTime());
            System.out.println(timer1.elapsedTime());

            arrayCopy = Arrays.copyOf(array1024Desc, array1024Desc.length);


            System.out.println("Array sized 1024 descending sorted " );
            writer.println("Array sized 1024 descending sorted " );

            Stopwatch timer2 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer2.elapsedTime());
            System.out.println(timer2.elapsedTime());

            arrayCopy = Arrays.copyOf(array1024Same, array1024Same.length);



            System.out.println("Array sized 1024 same elements sorted " );
            writer.println("Array sized 1024 same elements sorted " );

            Stopwatch timer3 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer3.elapsedTime());
            System.out.println(timer3.elapsedTime());


            arrayCopy = Arrays.copyOf(array1024Random, array1024Random.length);


            System.out.println("Array sized 1024 random sorted " );
            writer.println("Array sized 1024 random sorted " );

            Stopwatch timer4 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer4.elapsedTime());

            System.out.println(timer4.elapsedTime());
//___________________________________________________________________________________

            arrayCopy = Arrays.copyOf(array2048Asc, array2048Asc.length);

            System.out.println("Array sized 2048 ascending sorted " );
            writer.println("Array sized 2048 ascending sorted ");
            Stopwatch timer5 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer5.elapsedTime());

            System.out.println(timer5.elapsedTime());



            arrayCopy = Arrays.copyOf(array2048Desc, array2048Desc.length);


            System.out.println("Array sized 2048 descending sorted " );
            writer.println("Array sized 2048 descending sorted ");


            Stopwatch timer6 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer6.elapsedTime());
            System.out.println(timer6.elapsedTime());


            arrayCopy = Arrays.copyOf(array2048Same, array2048Same.length);



            System.out.println("Array sized 2048 same elements sorted ");
            writer.println("Array sized 2048 same elements sorted " );

            Stopwatch timer7 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer7.elapsedTime());
            System.out.println(timer7.elapsedTime());


            arrayCopy = Arrays.copyOf(array2048Random, array2048Random.length);


            System.out.println("Array sized 2048 random sorted " );
            writer.println("Array sized 2048 random sorted " );

            Stopwatch timer8 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer8.elapsedTime());


            System.out.println(timer8.elapsedTime());


            //___________________________________________________________________________________

            arrayCopy = Arrays.copyOf(array4096Asc, array4096Asc.length);

            System.out.println("Array sized 4096 ascending sorted " );
            writer.println("Array sized 4096 ascending sorted " );
            Stopwatch timer9 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            System.out.println(timer9.elapsedTime());
            writer.println(timer9.elapsedTime());


            arrayCopy = Arrays.copyOf(array4096Desc, array4096Desc.length);


            System.out.println("Array sized 4096 descending sorted " );
            writer.println("Array sized 4096 descending sorted ");


            Stopwatch timer10 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer10.elapsedTime());
            System.out.println(timer10.elapsedTime());


            arrayCopy = Arrays.copyOf(array4096Same, array4096Same.length);



            System.out.println("Array sized 4096 same elements sorted " );
            writer.println("Array sized 4096 same elements sorted ");

            Stopwatch timer11 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer11.elapsedTime());
            System.out.println(timer11.elapsedTime());


            arrayCopy = Arrays.copyOf(array4096Random, array4096Random.length);


            System.out.println("Array sized 4096 random sorted " );
            writer.println("Array sized 4096 random sorted " );

            Stopwatch timer12 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer12.elapsedTime());


            System.out.println(timer12.elapsedTime());

            //___________________________________________________________________________________

            arrayCopy = Arrays.copyOf(array8192Asc, array8192Asc.length);

            System.out.println("Array sized 4096 ascending sorted " );
            writer.println("Array sized 4096 ascending sorted " );
            Stopwatch timer13 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            System.out.println(timer13.elapsedTime());
            writer.println(timer13.elapsedTime());


            arrayCopy = Arrays.copyOf(array8192Desc, array8192Desc.length);


            System.out.println("Array sized 8192 descending sorted " );
            writer.println("Array sized 8192 descending sorted " );


            Stopwatch timer14 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer14.elapsedTime());
            System.out.println(timer14.elapsedTime());


            arrayCopy = Arrays.copyOf(array8192Same, array8192Same.length);



            System.out.println("Array sized 8192 same elements sorted ");
            writer.println("Array sized 8192 same elements sorted " );

            Stopwatch timer15 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer15.elapsedTime());
            System.out.println(timer15.elapsedTime());


            arrayCopy = Arrays.copyOf(array8192Random, array8192Random.length);


            System.out.println("Array sized 8192 random sorted " );
            writer.println("Array sized 8192 random sorted ");

            Stopwatch timer16 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer16.elapsedTime());


            System.out.println(timer16.elapsedTime());


            //___________________________________________________________________________________

            arrayCopy = Arrays.copyOf(array16384Asc, array16384Asc.length);

            System.out.println("Array sized 16384 ascending sorted " );
            writer.println("Array sized 16384 ascending sorted " );
            Stopwatch timer17 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            System.out.println(timer17.elapsedTime());
            writer.println(timer17.elapsedTime());


            arrayCopy = Arrays.copyOf(array16384Desc, array16384Desc.length);


            System.out.println("Array sized 16384 descending sorted " );
            writer.println("Array sized 16384 descending sorted " );


            Stopwatch timer18 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer18.elapsedTime());
            System.out.println(timer18.elapsedTime());


            arrayCopy = Arrays.copyOf(array16384Same, array16384Same.length);



            System.out.println("Array sized 16384 same elements sorted " );
            writer.println("Array sized 16384 same elements sorted ");

            Stopwatch timer19 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer19.elapsedTime());
            System.out.println(timer19.elapsedTime());


            arrayCopy = Arrays.copyOf(array16384Random, array16384Random.length);


            System.out.println("Array sized 16384 random sorted " );
            writer.println("Array sized 16384 random sorted ");

            Stopwatch timer20 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer20.elapsedTime());
            System.out.println(timer20.elapsedTime());


            //___________________________________________________________________________________

            arrayCopy = Arrays.copyOf(array32768Asc, array32768Asc.length);

            System.out.println("Array sized 32768 ascending sorted " );
            writer.println("Array sized 32768 ascending sorted " );
            Stopwatch timer21 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            System.out.println(timer21.elapsedTime());
            writer.println(timer21.elapsedTime());


            arrayCopy = Arrays.copyOf(array32768Desc, array32768Desc.length);


            System.out.println("Array sized 32768 descending sorted " );
            writer.println("Array sized 32768 descending sorted ");


            Stopwatch timer22 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer22.elapsedTime());
            System.out.println(timer22.elapsedTime());


            arrayCopy = Arrays.copyOf(array32768Same, array32768Same.length);



            System.out.println("Array sized 32768 same elements sorted ");
            writer.println("Array sized 32768 same elements sorted " );

            Stopwatch timer23 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer23.elapsedTime());
            System.out.println(timer23.elapsedTime());


            arrayCopy = Arrays.copyOf(array32768Random, array32768Random.length);


            System.out.println("Array sized 32768 random sorted " );
            writer.println("Array sized 32768 random sorted ");

            Stopwatch timer24 = new Stopwatch();

            itemSorter.sort(arrayCopy);

            writer.println(timer24.elapsedTime());
            System.out.println(timer24.elapsedTime());







        }

        writer.close();

    }
}
