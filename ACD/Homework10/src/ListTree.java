
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ListTree<T>  {

	public Element root;
	private int size;
	static String j = "";
    
    public static class Element<Q> {
        private String value; 
        public Element<Q> left;
        public Element<Q> right;
        public Element<Q> father;
        
        public Element(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }


        //перевіряємо чи дорівнює значення поточного вузла значенню вузла на вхід
        @SuppressWarnings("unused")
        public boolean equals(Element<String> el) {
            if (el == null) {
                return false;
            }
            
            if ((el.value == null) && (this.value == null)) {
                return true;
            }
            
            if ((el.value == null) || (this.value == null)) {
                return false;
            }
            
            return (el.value.equals(this.value));
        }
    }

    
    public ListTree(final String rootElement) {
        root = new Element<String>(rootElement);
        size = 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
    

    public int getSize() {
        return size;
    }

    public Element<String> getRoot() {
        return root;
    }

    //Обхід по дереву в глибину
	public Element<String> getElementByValue(final Element<String> head, final String value) {
		if (head == null || head.getValue() == null) {
			return null;
		}

		if (head.getValue().equals(value)) {
			return head;
		}

		Element<String> leftSearchResult = getElementByValue(head.left, value);
		return ( leftSearchResult != null ? leftSearchResult : getElementByValue(head.right, value));
	}


	//додажмо елемент знаходжуючи батька за значенням
    public void addValue(String newValue, String fatherValue, boolean isAddingAsLeftSon) {
        
        if (null == newValue) {
            throw new NullPointerException();
        }
        
        if (null != getElementByValue(root, newValue)) {
            throw new SecurityException();
        }
        
        Element<String> fatherElement = getElementByValue(root, fatherValue);
        if (null == fatherElement) {
            throw new NoSuchElementException();
        }
        
        if (isAddingAsLeftSon) {
            if (null == fatherElement.left) {
                fatherElement.left = new Element<String>(newValue);
                fatherElement.left.father=fatherElement;
                size++;
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            if (null == fatherElement.right) {
                fatherElement.right = new Element<String>(newValue);
                fatherElement.right.father=fatherElement;
                size++;
            } else {
                throw new IllegalArgumentException();
            }
        }        
    }
    

    public Element<String> getElement(ListTree<String> a){
    	return a.getRoot();
    }
    public String toString() {

        return subtreeToString(root);
    }
    
    private String subtreeToString(final Element<String> rootElement) {
        if (null == rootElement) {
            return "NULL";
        }
        return String.format("( %s ( %s, %s )", 
                (null == rootElement.getValue()) ? "NULL" : rootElement.getValue(),
                subtreeToString(rootElement.left), subtreeToString(rootElement.right));
    }

    private String charToCode(ListTree<String> a, String Value){
		ListTree<String> y = a;
		String value = Value;
		if(getElementByValue(y.root,value).father==null)return j;
		if(getElementByValue(y.root, value).father.left == y.getElementByValue(y.root, value)){
			j+="0";
		}else{
			j+="1";
		}
		return charToCode(y, getElementByValue(y.root, value).father.value);
	}
    public String toCode(String text, ListTree<String> a){
		char[] r = text.toCharArray();
		String code="";
		String newString;
		for(char e: r){
			code+=a.charToCode(a, String.valueOf(e));
	
			
		ListTree.j="";
		}
		return code;
	}
    public String deCode(String code, ListTree<String> a){
    	String[] w = new String[code.length()/3];
    	for(int i = 0; i < w.length; i++){
    		w[i]="";
    	}
    	String text = "";
    	ListTree<String> r = a;
    	int j = 0;
    	int counter = 0;
    	for(int i = 0; i < code.length(); i++){
    		w[j]+=code.charAt(i);
    		counter++;
    		if(counter%3==0)j++;
    	}
    	for(int i = 0; i < w.length; i++){
    	String y = w[i];
    	String t = String.valueOf(y.charAt(2));
    	 t += String.valueOf(y.charAt(1));
    	 t += String.valueOf(y.charAt(0));
    	 w[i]=t;
    	}
    	String temp="";
    	for(int i = 0; i < w.length; i++){
    	String ch = "";
    	if(w[i].charAt(0)=='0'){
			temp = r.root.left.value;
		}else{
			temp = r.root.right.value;
		}
    	if(w[i].charAt(1)=='0'){
			temp = r.getElementByValue(r.getElement(r), temp).left.value;
		}else{
			temp = r.getElementByValue(r.getElement(r), temp).right.value;
		}
    	if(w[i].charAt(2)=='0'){
			ch = r.getElementByValue(r.getElement(r), temp).left.value;
		}else{
			ch = r.getElementByValue(r.getElement(r), temp).right.value;
		}
    	text+=ch;
    	}
    	return text;
    }
    public String huffmanDecoding(ListTree<String> a, String code){
    	ArrayList<String> w = new ArrayList<String>();
    	char[] q = code.toCharArray();
    	while(true){
    		String t = "";
    		boolean isF = true;
    		int cou = 0;
    		for(char e: q){
    			if(e != '0' || isF){

    				t+=e;
					cou++;
    				isF=false;
    			}else{
    				break;
    			}
				//if(t.equals("0111"))break;
    		
    		}
    		w.add(t);
    		if(cou==0){
    			w.remove("");
    			break;
    		}
    		q = delete(cou, q);
    	}
    	String text = "";
    	for(String h: w){
    		String j = reverse(h);
    		Element<String> r = a.root;
    		String str = "";
    		for(int i = 0; i < j.length(); i++){
    			if(j.charAt(i)=='0'){
    				r = r.left;
    			}else{
    				if(str.equals("1111"))break;
    				r = r.right;
    				str+="1";
    			}

    		}
			str="";
    		text+=r.value;
    	}
    	return text;
    }
    private char[] delete(int y, char[] e){
    	char[] t = new char[e.length-y];
    	for(int i = 0;i < t.length; i++){
    		t[i]=e[i+y];
    	}
    	return t;
    }
    private String reverse(String s){
    	String h = "";
    	for(int i = 0; i < s.length(); i++){
    		h+=s.charAt(s.length()-1-i);
    	}
    	return h;
    }
}

