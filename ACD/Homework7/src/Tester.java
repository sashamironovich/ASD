public class Tester {
    public static void main(String[] args) {
        MySet A = new MySet();
        A.add(2);
        A.add(7);
        A.add(11);
        System.out.println("SET A");
        System.out.println(A.toString());
        MySet B = new MySet();
        B.add(4);
        B.add(7);
        B.add(14);
        System.out.println("SET B");
        System.out.println(B.toString());
        MySet C = new MySet();
        C = C.union(A,B);
        System.out.println("Set C is the Union of Sets A and B");
        System.out.println(C.toString());

        C = C.intersection(A,B);
        System.out.println("Intersection of A and B is");
        System.out.println(C.toString());


        C=C.difference(A,B);
        System.out.println("Difference of Sets A and B ");
        System.out.println(C.toString());


        System.out.println("Merging A and B");
        A.delete(7);
        System.out.println("Set A " + A.toString());
        System.out.println("Set B " + B.toString());
        C=C.merge(A,B);
        System.out.println(C.toString());

        System.out.println("Making set  C NULL");
        C.makeNull(C);
        System.out.println(C.toString());

        System.out.println("Assigning A to B");
        System.out.println("set A " + A.toString());
        System.out.println("Set B " + B.toString());
        A.assign(A,B);
        System.out.println(A.toString());

        System.out.println("min and max of Set A");
        System.out.println("min "+A.min(A));
        System.out.println("max " + A.max(A));

        System.out.println("A == B ?    =>   " + A.equal(A,B));

        A.makeNull(A);
        A.add(22);
        A.add(33);
        A.add(66);
        C.add(44);
        C.add(55);
        C.add(77);
        System.out.println(C.find(55,A ,B ,C));


    }
}
