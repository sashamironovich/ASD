public class Tester {
    public static void main(String[] args) {
        System.out.println("ADD()");
        Queue<Integer> queue = new Queue<>();
        Queue<Integer> queue1 = new Queue<>(4,false);
        Queue<Integer> emptyQueue = new Queue<>();
        Queue<Integer> queue2 = new Queue<>(3,false);

        queue.add(2);
        queue.add(34);
        queue.add(3333);
        System.out.println(queue.toString());

        System.out.println("was 11 added? " + queue1.add(11));
        System.out.println("was 12 added? " + queue1.add(12));
        System.out.println("was null added? " + queue1.add(null));
        System.out.println("was 13 added? " + queue1.add(13));
        System.out.println("was 14 added? " + queue1.add(14));
        System.out.println("was 15 added? " + queue1.add(15));
        System.out.println(queue1.toString()+"\n \n \n");

        System.out.println("ELEMENT()");
        System.out.print("Head of queue " + queue.toString() + " is : ");
        System.out.println(queue.element());
        System.out.print("Head of empty queue " + emptyQueue.toString() + " is : ");
        System.out.println(emptyQueue.element()+"\n \n \n");
        System.out.println("PEEK()");
        System.out.print("Head of empty queue " + emptyQueue.toString() + " is : ");

        System.out.println(emptyQueue.peek()+"\n \n \n");


        System.out.println("OFFER()");

        System.out.println("was 11 added? " + queue2.offer(11));
        System.out.println("was 12 added? " + queue2.offer(12));

        System.out.println("was null added? " + queue2.offer(null));


        System.out.println("was 13 added? " + queue2.offer(13));
        System.out.println("was 14 added? " + queue2.offer(14));

        System.out.println(queue2.toString()+"\n \n \n");

        System.out.println("POLL()");
        System.out.println(queue2.toString());
        System.out.println(queue2.poll());
        System.out.println(queue2.toString());
        System.out.println(emptyQueue.toString());
        System.out.println(emptyQueue.poll());
        System.out.println(queue2.toString() +"\n \n \n");


        System.out.println("REMOVE()");
        System.out.println(queue2.toString());
        System.out.println(queue2.remove());
        System.out.println(queue2.toString());
        System.out.println(emptyQueue.toString());
        System.out.println(emptyQueue.remove());
        System.out.println(queue2.toString()+"\n \n \n");

        System.out.println("EMPTY()");
        System.out.println("IS emptyQueue empty? " + emptyQueue.empty());
        System.out.println("IS not emptyQueue empty? " + queue1.empty()+"\n \n \n");

        System.out.println("SEARCH()");
        System.out.println(queue.add(34));
        System.out.println(queue.toString());
        System.out.println(queue.search(34));


    }
}
