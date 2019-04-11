public class Tester {
    public static void main(String[] args) {
        ListBinarySearchTree tree = new ListBinarySearchTree(5);
        tree.add(2);
        tree.add(12);
        tree.add(-4);
        tree.add(3);
        tree.add(9);
        tree.add(21);

        tree.add(25);
        tree.add(26);

        System.out.println("Is tree empty? " + tree.isEmpty());
        System.out.println("Does the tree contain -4? " + tree.contains(-4));
        System.out.println("Does the tree contain 777? " + tree.contains(777));

        System.out.println(tree.toString());
        System.out.println("After deleting node 12");
        tree.delete(12);
        System.out.println(tree.toString());


        System.out.println("Sorted Asc");
        System.out.println(tree.sortAsc().toString());

        System.out.println("Sorted Desc");
        System.out.println(tree.sortDesc().toString());
        tree.delete(5);
        System.out.println(tree);





    }
}
