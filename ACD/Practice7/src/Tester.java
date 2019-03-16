import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        System.out.println("SET A");
        Set A = new Set("A");
        A.insert(4,A);
        A.insert(3,A);
        System.out.println(Arrays.toString(A.getSet()));

        System.out.println("SET B");
        Set B = new Set("B");
        B.insert(6,B);
        B.insert(5,B);
        B.insert(3,B);
        System.out.println(Arrays.toString(B.getSet()));

        System.out.println("SET C is the UNION of SET A and SET B");
        Set C = new Set("C");
        C.union(A,B,C);
        System.out.println(Arrays.toString(C.getSet()));


        System.out.println("SET C is the INTERSECTION of SET A and SET B");
        C.makeNull(C);
        C.intersection(A,B,C);
        System.out.println(Arrays.toString(C.getSet()));

        System.out.println("SET C is the DIFFERENCE of SETS A and B");
        C.makeNull(C);
        C.difference(A,B,C);
        System.out.println(Arrays.toString(C.getSet()));

        System.out.println("Merging SETS A and B");
        C.makeNull(C);
        C.merge(A,B,C);
        System.out.println(Arrays.toString(C.getSet()));

        System.out.println("But if we delete \"3\" from SET A");
        A.delete(3,A);
        C.merge(A,B,C);
        System.out.println(Arrays.toString(C.getSet()));

        System.out.println("Assigning set A to set B");
        System.out.println(Arrays.toString(A.getSet()));
        System.out.println(Arrays.toString(B.getSet()));
        A.assign(A,B);
        System.out.println(Arrays.toString(A.getSet()));

        System.out.println("MIN of SET A");
        System.out.println(Arrays.toString(A.getSet()));
        System.out.println(A.min(A));

        System.out.println("MAX of SET A");
        System.out.println(Arrays.toString(A.getSet()));
        System.out.println(A.max(A));

        System.out.println("Comparing sets A and B");
        A.showSet(A);
        B.showSet(B);
        System.out.println(A.equal(A,B));

        Integer x  = 7;
        System.out.println("Looking for a set where we can find " + x);
        B.makeNull(B);
        B.insert(13,B);
        B.insert(11,B);
        C.makeNull(C);
        C.insert(2,C);
        C.insert(7,C);
        A.showSet(A);
        B.showSet(B);
        C.showSet(C);
        Set[] sets = {A,B,C};
        System.out.println(A.find(sets,x));

    }
}
