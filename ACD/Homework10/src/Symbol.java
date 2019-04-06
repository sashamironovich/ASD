public class Symbol implements Comparable<Symbol> {
	public char value;
	public double probability;

	public Symbol(char value, double probability) {
		this.value = value;
		this.probability = probability;
	}

	public String toString() {
		return String.valueOf(value) + " "+ String.valueOf(probability);
	}

	@Override
	public int compareTo(Symbol arg0) {
		if (this.probability - (arg0.probability) > 0) {
			return 1;
		} else {
			return -1;
		}
	}
}
