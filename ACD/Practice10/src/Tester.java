public class Tester {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        BinaryTree<Integer> tree1 = new BinaryTree(node1);


        System.out.println(tree1.isEmpty());
        System.out.println(tree1.countVertex());
        System.out.println(tree1.checkIfExist(node1));
        tree1.addLeftSon(node2,node1);
        tree1.addRightSon(node3,node1);
        System.out.println(tree1.countVertex());
        tree1.addLeftSon(node4,node2);
        tree1.addLeftSon(node5,node4);
        tree1.addLeftSon(node6,node5);
        tree1.addLeftSon(node7,node6);

        System.out.println(tree1.toString1());

        System.out.println(tree1.toString());
        tree1.delete(node2);
        System.out.println(tree1.toString());
        System.out.println(tree1.toString1());
    }
}
