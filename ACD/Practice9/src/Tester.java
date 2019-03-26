public class Tester {
    public static int[][] matr  = new int[3][4];

    public static void main(String[] args) {
        matr[0][0] = 0;
        matr[0][1] = 1;
        matr[0][2] = 0;
        matr[1][0] = 1;
        matr[1][1] = 0;
        matr[1][2] = 1;
        matr[2][0] = 0;
        matr[2][1] = 1;
        matr[2][2] = 0;
        MyGraph graph = new MyGraph(matr);
        System.out.println(graph.toString());


    }


}
