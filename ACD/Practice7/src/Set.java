public class Set {
    private Integer[] set;
    private String title;

    public Set(String title) {
        this.title = title;
        set = new Integer[100];
        for (int index = 0; index < set.length; index++) {
            set[index] = 0;
        }
    }

    public Integer[] getSet() {
        return set;
    }

    public boolean member(Integer n, Set set){
        if(set.getSet()[n-1] == 1) return true;
        else return false;
    }

    public void insert(Integer n, Set A){
        if(member(n,A))return;
        else {A.getSet()[n-1]  = 1;}
    }

    public void delete(Integer n , Set A){
        if(member(n,A)){
            A.getSet()[n-1] = 0;
        }
    }

    public Set union(Set A,Set B,Set C){

        for (int i = 1; i <=C.getSet().length; i++) {
            if(member(i,B) || member(i,A))C.insert(i,C);
        }
        return C;
    }

    public void makeNull(Set A){
        for(int i = 1;i <=A.getSet().length;i++){
            A.getSet()[i-1] = 0;
        }
    }

    public Set intersection(Set A,Set B,Set C){
        for (int i = 1; i <C.getSet().length ; i++) {
            if(member(i,B) && member(i,A))insert(i,C);
        }
        return C;
    }

    public Set difference(Set A,Set B,Set C){
        for(int i = 1;i<=A.getSet().length;i++){
            if(member(i,A) && !member(i,B))insert(i,C);
        }
        return C;
    }

    public boolean equal(Set A,Set B){
        boolean result = true;
        for(int i = 1;i<A.getSet().length;i++){
            if(A.getSet()[i-1] != B.getSet()[i-1])return false;

        }
        return true;
    }

    public boolean haveSameElem(Set A, Set B){
        for (int i = 1; i <A.getSet().length ; i++) {
            if(member(i,A) && member(i,B))return true;
        }
        return false;
    }

    public Set merge(Set A,Set B,Set C){
        if(!haveSameElem(A,B)){
            union(A,B,C);

        return C;}

        else {
            System.out.println("Sets have same elements");
            return null;
        }
    }

    public void assign(Set A,Set B){
        A.makeNull(A);
        for (int i = 1;i<=A.getSet().length;i++){
            if(member(i,B))insert(i,A);
        }
    }

    public int min(Set A){
        int min = 101;
        for (int i = 0; i < A.getSet().length; i++) {
            if( A.getSet()[i].compareTo(min)<0 && A.getSet()[i]!=0 && i<min) min = i;

        }
        if(min == 101)return -1;

        return min+1;
    }

    public int max(Set A){
       int max = 0;
        for (int i = 0; i < A.getSet().length; i++) {
            if(  A.getSet()[i]!=0 && i>max) max = i;

        }
        if(max == 0)return -1;

        return max+1;
    }

    public void showSet(Set A){
        System.out.println("Set "+ title);
        for (int i = 1; i < A.getSet().length; i++) {
            if(A.getSet()[i-1] !=0) System.out.print(i + " ");
        }
        System.out.println();
    }

    public String find(Set[] sets,Integer x){
        String nameOfSet ="No such element found";

        for (int i = 0; i < sets.length; i++) {
            for (int j = i+1; j < sets.length; j++) {
                if(sets[i].haveSameElem(sets[i],sets[j]))return "Some sets are joint";

            }

        }

        for (int i = 0; i < sets.length; i++) {
            for (int j = 0; j <sets[i].getSet().length ; j++) {
                if(sets[i].getSet()[x-1] == 1){
                    return "Element was found in a set " +sets[i].title;

                }

            }

        }
        return nameOfSet;

    }




}
