public class MyGraphAdjacency<E extends Comparable> {

    private MyLinkedList<MyLinkedList<E>> listOut  = new MyLinkedList<>();

    public MyGraphAdjacency(int[][] adjacencyMatrix) {

        for (int i = 0; i < adjacencyMatrix.length ; i++) {
            MyLinkedList<E> listIn = new MyLinkedList<>();
            for (int j = 0; j < adjacencyMatrix[i].length ; j++) {
                if(adjacencyMatrix[i][j] == 1){
                    MyLinkedListNode<E> node = new MyLinkedListNode(j);
                    if(listIn.isEmpty()){
                        listIn.append(node.getValue());
                    }else {
                        listIn.addAfter(node.getValue(), listIn.getLast());
                    }
                }

            }
            if(i == 0){
                listOut.append(listIn);
            }else {
                listOut.addAfter(listIn, listOut.getLast());
            }

        }
        }



        public String toString() {
            String str = "";
            for (int i = 0; i < listOut.toArray().length; i++) {

                System.out.println("Vertex " + i + " is connected to" + listOut.toArray()[i].toString());

            }
            return str;
        }
}