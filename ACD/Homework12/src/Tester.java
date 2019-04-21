public class Tester {
    public static void main(String[] args) {
        System.out.println("Creating MAX BINARY HEAP");
        LinkedBinaryHeap maxHeap = new LinkedBinaryHeap(true);
        System.out.println("Чи дерево порожнє? " +maxHeap.isEmpty());
        maxHeap.add(10);
        maxHeap.add(12);
        System.out.println("Чи дерево порожнє після додавання елеентів? " +maxHeap.isEmpty());
        maxHeap.add(5);
        maxHeap.add(3);
        maxHeap.add(11);
        System.out.println(maxHeap.toString());
        System.out.println("Елемент голова: " + maxHeap.peek());
        System.out.println("Чи дерево містить елемент 12? " + maxHeap.contains(12));

        System.out.println("heap after removing root " + maxHeap.remove());
        System.out.println("Чи дерево містить елемент 12? " + maxHeap.contains(12));


        System.out.println(maxHeap.toString());

        System.out.println("\n\nCreating MIN BINARY HEAP");
        LinkedBinaryHeap minHeap = new LinkedBinaryHeap(false);
        System.out.println("Чи дерево порожнє? " +maxHeap.isEmpty());
        minHeap.add(10);
        minHeap.add(12);
        minHeap.add(5);
        minHeap.add(3);
        System.out.println("Чи дерево порожнє? " +maxHeap.isEmpty());
        minHeap.add(11);
        System.out.println(minHeap.toString());
        System.out.println("Чи дерево містить елемент 3? " + minHeap.contains(3));
        System.out.println("heap after removing root " + minHeap.remove());
        System.out.println("Чи дерево містить елемент 3? " + minHeap.contains(3));
        System.out.println(minHeap.toString());


    }
}
