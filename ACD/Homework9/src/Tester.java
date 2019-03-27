public class Tester {
    public static int[][] matr  = new int[2][3];

    public static void main(String[] args) {
        matr[0][0] = 1;
        matr[0][1] = 1;
        matr[0][2] = 0;
        matr[1][0] = 1;
        matr[1][1] = 0;
        matr[1][2] = 1;
        MyGraph graphIncidence = new MyGraph(matr);
        System.out.println(graphIncidence.toString());
    }


}
