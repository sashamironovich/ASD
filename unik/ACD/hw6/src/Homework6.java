
import ua.princeton.lib.In;
import ua.princeton.lib.Out;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class Homework6 {



    public static String[] task1(File file){

        In in = new In(file);
        int len = 0;
       while(!in.isEmpty()){
           String s = in.readLine();
           len++;

       }
       in.close();
       String[] nums = new String[len];

       in = new In(file);
       for (int i = 0; i<nums.length; i++) {
           String s = in.readLine();
           nums[i] = s;
       }
        return nums;
    }

    public static void task2(String[] array,File file){

        // write to a file
        String nameOfFile = file.getName();
        Out out= new Out(nameOfFile);
        for (String aTask2Array : array) {
            out.println(aTask2Array);
        }
        out.close();
    }

    public static boolean task3(String str,File file){
        In in= new In(file);
        System.out.println("Looking for a string \"" + str + "\" in a file " + file);
        while(in.hasNextLine()){
            String s = in.readLine();
            if(s.equals(str))return true;

        }
        return false;

    }

    public static ArrayList getSubLineInAString(String subLine,String line){
        ArrayList<Integer> indexes = new ArrayList<>();
        String leftLine = line;
        while(leftLine.contains(subLine)){
            int i = leftLine.lastIndexOf(subLine);
            leftLine = leftLine.substring(0,i);
            indexes.add(i);

        }
        return indexes;

    }

    public static ArrayList task4(String subline,File file){
        String[] lines = task1(file);
        ArrayList<int[]> indexes = new ArrayList<>();
        int lineNumber = 1;
        for (String line: lines) {

            ArrayList<Integer> lineIndexes = getSubLineInAString(subline,line);
            for (Integer i :lineIndexes) {
                indexes.add(new int[]{lineNumber,i});
            }
            lineNumber++;
        }
        return indexes;
        
    }

    public static void task5Asc(File file){
        String fileName = file.getName();
        String[] lines = task1(file);
        new MergeSortStrategy<String>().sortAsc(lines);
        int dotIndex = fileName.indexOf('.');
        File SortAscFile = new File(fileName.substring(0,dotIndex) + "_sorted_asc.txt");
        task2(lines,SortAscFile);
    }

    public static void task5Desc(File file){
        String fileName = file.getName();
        String[] lines = task1(file);
        new MergeSortStrategy<String>().sortDesc(lines);
        int dotIndex = fileName.indexOf('.');
        File SortDescFile = new File(fileName.substring(0,dotIndex) + "_sorted_desc.txt");
        task2(lines,SortDescFile);
    }


    public static void task6(File file,String strA,String strB){
        if(task4(strA,file)==null)return;

        File outputFile = new File("replaced.txt");
        Out out = new Out("replace.txt");
        String[] lines = task1(file);
        for (String line: lines) {


            while(line.contains(strA)){
                int i =line.lastIndexOf(strA);
                String rightPart = line.substring(i-1+strA.length(),line.length()-1);
                if(i == 0){
                    line = strB + rightPart;
                }
                line = line.substring(0,i) + strB +  rightPart;
            }
            out.println(line);
        }


    }























//    public static int[] task4(String str , File file){
//        In in = new In(file);
//        int numOfLine  = 0;
//        int numOfMatch = 0;
//        int[][] answer = new int[100][2];
//        Character[] strArr = new Character[str.length()];
//        for (int i = 0; i < strArr.length; i++) {
//            strArr[i] = (str.charAt(i));
//
//        }
//        System.out.println(Arrays.toString(strArr));
//        while(in.hasNextLine()){
//            numOfLine++;
//            String s = in.readLine();
//
//
//            Character[] lineToChar = new Character[s.length()];
//            for (int i = 0; i < strArr.length ; i++) {
//                for (int j = 0; j < lineToChar.length; j++) {
//                    if(i == strArr.length-1 && lineToChar[j]==strArr[i]){
//                        numOfMatch++;
//                        answer[numOfLine][]
//
//
//                    }
//                    if(lineToChar[j]==strArr[i]){
//                        i++;
//
//                    }
//
//                }
//
//            }
////            for (int i = 0; i <s.length() ; i++) {
////                lineToChar[i] = s.charAt(i);
////
////            }
////            for(int j = 0;j<str.length();j++){
////                for (int k = 0;k<lineToChar.length;k++){
////                    if(strArr[j] == lineToChar[k]);
////                }
////            }
//
//        }
//
//        return new int[] {2,3};
//    }
}
