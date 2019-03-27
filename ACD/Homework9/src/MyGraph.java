public class MyGraph {
    private int[][] adjacencyMatrix;
    private MyGraphAdjacency adjacencyGraph;

    public MyGraph(int[][] incidenceMatrix) {
        adjacencyMatrix = new int[incidenceMatrix[0].length][incidenceMatrix[0].length];
        for (int[] anIncidenceMatrix : incidenceMatrix) {

            int indX = 0;
            int indY = 0;

            for (int j = 0; j < incidenceMatrix[0].length; j++) {
                if (indX == 0 && anIncidenceMatrix[j] == 1) {
                    indX = j;
                } else if (anIncidenceMatrix[j] == 1) {
                    indY = j;
                }
            }

            adjacencyMatrix[indX][indY] = 1;
            adjacencyMatrix[indY][indX] = 1;

        }
    }

    public String toString(){
        adjacencyGraph = new MyGraphAdjacency(adjacencyMatrix);
        return adjacencyGraph.toString();
    }


}
