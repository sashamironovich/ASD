public class Tester {
    public static void main(String[] args) {

        System.out.println("BINARY MIN HEAP  ");
        BinaryHeap treeMIN = new BinaryHeap(false);
        System.out.println("is tree empty? " + treeMIN.isEmpty());
        System.out.println("what is the size of the tree after creating? " + treeMIN.size());
        treeMIN.add(10);
        treeMIN.add(5);
        treeMIN.add(7);
        treeMIN.add(3);

        System.out.println(treeMIN.toString());
        System.out.println("does the tree contain element 3? " + treeMIN.contains(3) );
        System.out.println("SIZE AFTER ADDING ELEMENTS = " + treeMIN.size());
        System.out.println("root before remove =" +treeMIN.peek());
        System.out.println();
        System.out.println("TREE AFTER REMOVE");
        treeMIN.remove();
        System.out.println("does the tree contain element 3? " + treeMIN.contains(3) );
        System.out.println(treeMIN.toString());
        System.out.println("SIZE AFTER REMOVE = " + treeMIN.size());
        System.out.println("root after remove  = " +treeMIN.peek() + "\n\n\n");

        System.out.println("BINARY MAX HEAP  ");
        BinaryHeap treeMAX = new BinaryHeap(true);
        System.out.println("is tree empty? " + treeMAX.isEmpty());
        System.out.println("what is the size of the tree after creating? " + treeMAX.size());
        treeMAX.add(10);
        treeMAX.add(5);
        treeMAX.add(7);
        treeMAX.add(25);
        treeMAX.add(3);

        System.out.println(treeMAX.toString());
        System.out.println("SIZE AFTER ADDING ELEMENTS IS " + treeMAX.size());
        System.out.println("root  = " +treeMAX.peek());
        System.out.println();
        System.out.println("TREE AFTER REMOVE ");
        treeMAX.remove();
        System.out.println(treeMAX.toString());
        System.out.println("SIZE AFTER REMOVE =" + treeMAX.size());
        System.out.println("root after remove = " +treeMAX.peek());

    }
}
