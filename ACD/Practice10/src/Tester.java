public class Tester {
    public static void main(String[] args) {
        ArrayBinaryTree tree = new ArrayBinaryTree(1);
        tree.addLeftSon(1,2);
        tree.addRightSon(1,3);
        tree.addRightSon(2,5);
        tree.addLeftSon(2,4);
        tree.addLeftSon(4,8);
        tree.addRightSon(4,9);
        tree.addLeftSon(5,10);
        tree.addRightSon(5,11);
        System.out.println(tree.toString());
        tree.delete(2);
        System.out.println(tree.toString());

    }
}
