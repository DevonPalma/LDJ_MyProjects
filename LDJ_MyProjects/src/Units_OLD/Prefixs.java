package Units_OLD;

public enum Prefixs {
	Giga("G", 9),
	Mega("M", 6),
	Kilo("k", 3),
	Hecto("h", 2),
	Deca("da", 1),
	Unit("", 0),
	Deci("d", -1),
	Centi("c", -2),
	Milli("m", -3),
	Micro("u", -6),
	Nano("n", -9);
	
	private final String symbol;
	private final double conversion;
	
	Prefixs(String symbol, double conversion) {
		this.symbol = symbol;
		this.conversion = conversion;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public double getConversion() {
		return conversion;
	}
	
	public static Prefixs getPrefix(String symbol) {
		for (Prefixs p : Prefixs.values()) {
			if(p.getSymbol().equals(symbol))
				return p;
		}
		throw new IllegalArgumentException(
				String.format("symbol '%s' doesn't have a matching prefix", symbol));
	}
	
	public static String getRegex() {
		// converts to simple regex experssion
		String prefix = "";
		for(Prefixs p : Prefixs.values()) {
			prefix += (prefix.length() == 0 ? "" : "|") + p.getSymbol();
		}
		return prefix;
	}
}

// 31 lines