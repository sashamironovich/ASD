public class Tester {
    public static void main(String[] args) {
        System.out.println("PUSH");
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(6);
        stack.push(4);

        System.out.println(stack.toString());

        System.out.println("POP");
        stack.pop();
        System.out.println(stack.toString());
        Stack<Integer> stack2 = new Stack<>();
        stack2.pop();
        System.out.println(stack2.toString());

        System.out.println("PEEK");
        System.out.println(stack.peek());
        System.out.println(stack.toString());

        System.out.println("EMPTY");
        System.out.println(stack.toString());
        System.out.println("Is this stack empty?"+stack.empty());
        System.out.println(stack2.toString());
        System.out.println("Is this stack empty?" + stack2.empty());

        stack.push(2);
        stack.push(22);
        stack.push(55);
        stack.push(2);
        stack.push(444);
        System.out.println("First stack"+stack.toString());
        System.out.println("Looking for 2 , indexes : " +stack.search(2));

        stack2.push(6);
        System.out.println("Second stack" + stack2.toString());
        System.out.println("Looking for 3 , indexes : " + stack2.search(3));
    }
}
