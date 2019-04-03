import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TreeList <E > {
       LinkedList<Node> list ;


        public  TreeList(Node element){
            list = new LinkedList();
            try{if(element.value == null)throw new NullPointerException();
                list.addFirst(element);
                for (int i = 0; i <100 ; i++) {
                    list.add(null);

                }

            }catch (NullPointerException e){
                System.out.println("NullPointerException");
            }

        }



        public boolean isEmpty(){
           return list.isEmpty();
        }

        public int countVertex(){
            int num = 0;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)!=null)num++;

            }
            return num;
        }

        public boolean checkIfExist(Node value){
            for (Node i : list) {if (i == value) return true;
            }
            return false;
        }

        public void addLeftSon(Node son,Node parent){
            try{
                if(checkIfExist(son))throw new IllegalArgumentException();
                if(!checkIfExist(parent))throw new NoSuchElementException();
                if(son == null )throw new NullPointerException();
                if(parent.leftSon!=null)throw new IllegalArgumentException();
                int parentIndex =0;
                int sonIndex ;
                for (int i = 0; i <list.size() ; i++) {
                    if(parent == list.get(i))parentIndex = i;
                }
                sonIndex = 2*parentIndex+1;
                parent.leftSon = son;
                list.add(sonIndex,son);
                son.index = sonIndex;
                son.parent = list.get(parentIndex);

            }catch (NoSuchElementException e ){
                System.out.println("NoSuchElementException");
            }catch (NullPointerException e ){
                System.out.println("NullPointerException");
            }catch (IllegalArgumentException e ){
                System.out.println("IllegalArgumentException");
            }


        }

        public void addRightSon(Node son,Node parent){
            try{
                if(checkIfExist(son))throw new IllegalArgumentException();
                if(!checkIfExist(parent))throw new NoSuchElementException();
                if(son == null)throw new NullPointerException();
                if(parent.rightSon!=null)throw new IllegalArgumentException();
                int parentIndex = 0;
                int sonIndex = 0;
                for (int i = 0; i <list.size() ; i++) {
                    if(parent == list.get(i))parentIndex = i;
                }
                sonIndex = 2*parentIndex+2;
                parent.leftSon = son;
                list.add(sonIndex,son) ;
                son.index = sonIndex;
                son.parent =list.get(parentIndex);

            }catch (NoSuchElementException e ){
                System.out.println("NoSuchElementException");
            }catch (NullPointerException e ){
                System.out.println("NullPointerException");
            }catch (IllegalArgumentException e ){
                System.out.println("IllegalArgumentException");
            }

        }

        public String toString1(){
            String str = "";
            for (int i = 0; i <list.size(); i++) {
                if(list.get(i)==null)continue;
                str+= "( " + list.get(i).value +" ( ";
                if(list.get(i*2+1)!=null){
                    str+= list.get(i*2+1).value + " ,";}
                else str+= " null, ";

                if(list.get(i*2+2)!=null){
                    str+= list.get(i*2+2).value + " )) \n";}
                else str+= " null )) \n";

            }

            return str;
        }


        public String toString(){
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == null)str+= " | null ";
                else str+=" | " + list.get(i).value;

            }
            return str;
        }

//        public void delete(Node node){
//
//            try {
//                if (!checkIfExist(node)) throw new NoSuchElementException();
//                if (node.value == null) throw new NullPointerException();
//                if(node.leftSon == null && node.rightSon==null){
//                    array[node.index] = null;
//                }
//                if(node.leftSon!=null && node.rightSon==null  ){
//                    if(node.parent.leftSon == node){
//                        node.parent.leftSon = node.leftSon;
//                    }else node.parent.rightSon = node.leftSon;
//
//
//                }
//                if(node.leftSon==null && node.rightSon!=null  ){
//                    if(node.parent.leftSon == node){
//                        node.parent.leftSon = node.rightSon;
//                    }else node.parent.rightSon = node.rightSon;
//
//                }
//            }catch(NoSuchElementException e){
//                System.out.println("NoSuchElementException");
//            }
//            catch(NullPointerException e){
//                System.out.println("NullPoInterException");
//            }
//        }
//


}
