
public class TesterTask1 {


	public static void main(String[] args) {
		ListTree<String> a = new ListTree<String>("0");
		a.addValue("1", "0", true);
		a.addValue("2", "0", false);
		a.addValue("3", "1", true);
		a.addValue("4", "1", false);
		a.addValue("5", "2", true);
		a.addValue("6", "2", false);
		a.addValue("I", "3", true);
		a.addValue("<", "3", false);
		a.addValue("З", "4", true);
		a.addValue("K", "4", false);
		a.addValue("A", "5", true);
		a.addValue("M", "5", false);
		a.addValue("N", "6", true);
		a.addValue("U", "6", false);
		System.out.println(a.toString());
		System.out.println("Coding string - I<3NAUKMA");
		System.out.println("Coded into : "+a.toCode("I<ЗNAUKMA",a));
		System.out.println("Decoded - "+a.deCode(a.toCode("I<ЗNAUKMA",a), a));
	}
	
	}
