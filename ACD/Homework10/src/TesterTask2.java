import java.util.Arrays;


public class TesterTask2 {
	public static void main(String[] args){
		//Huffman coding
		Symbol[]alphabet = new Symbol[5];
		alphabet[0] = new Symbol('a', 0.12);
		alphabet[1] = new Symbol('b', 0.40);
		alphabet[2] = new Symbol('c', 0.15);
		alphabet[3] = new Symbol('d', 0.08);
		alphabet[4] = new Symbol('e', 0.25);
		double[]r = new double[5];
		for(int i = 0; i < 5; i++){
			r[i] = alphabet[i].probability;
		}
		Arrays.sort(alphabet);
		System.out.println(Arrays.toString(alphabet));
		ListTree<String> a = new ListTree<String>("1");
		int co = 1;
		for(int i = alphabet.length-1; i > 1;i--){
		a.addValue(String.valueOf(alphabet[i].value),String.valueOf(co) , true);
		a.addValue(String.valueOf(co+1),String.valueOf(co) , false);
		co++;
		}
		a.addValue(String.valueOf(alphabet[1].value),String.valueOf(co) , true);
		a.addValue(String.valueOf(alphabet[0].value),String.valueOf(co) , false);
		String coding1 = "abcea";
		String coding2 = "deacb";

		System.out.println("EXAMPLE1");
		System.out.println("String: " + coding1);
		System.out.println("Coded string: "+a.toCode(coding1, a));
		System.out.println("Decoded string: "+a.huffmanDecoding(a, a.toCode(coding1, a)));
		System.out.println("alphabet : "+Arrays.toString(alphabet));

		System.out.println("EXAMPLE2");
		System.out.println("String: " + coding2);
		System.out.println("Coded string: "+a.toCode(coding2, a));
		System.out.println("Decoded string: "+a.huffmanDecoding(a, a.toCode(coding2, a)));
		System.out.println("alphabet : "+Arrays.toString(alphabet));

	}
	
}
