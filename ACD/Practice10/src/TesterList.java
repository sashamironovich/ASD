public class TesterList {
    public static void main(String[] args) {
        ListBinaryTree tree = new ListBinaryTree(1);
        System.out.println(tree.countVertex());
        System.out.println(tree.isEmpty());
        System.out.println(tree.contains(2));
        tree.addRightSon(1,3);
        tree.addLeftSon(1,2);
        tree.addLeftSon(2,4);
        tree.addRightSon(2,5);
        tree.addLeftSon(4,6);
        tree.addRightSon(4,7);
        tree.addLeftSon(5,8);
        tree.addRightSon(5,9);
        System.out.println(tree.toString());
        tree.delete(2);
        System.out.println(tree.toString());
    }
}
