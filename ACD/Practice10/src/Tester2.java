public class Tester2 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(222);

        TreeList tree1 = new TreeList(node1);


        System.out.println(tree1.isEmpty());
        System.out.println(tree1.countVertex());
        System.out.println(tree1.checkIfExist(node1));
        tree1.addLeftSon(node2,node1);
        tree1.addRightSon(node3,node1);
        System.out.println(tree1.countVertex());
        tree1.addLeftSon(node4,node2);

        System.out.println(tree1.toString1());

        System.out.println(tree1.toString());
        //tree1.delete(node2);
        System.out.println(tree1.toString());
    }
}
