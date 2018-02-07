package Units;

public enum A_rename {
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
	
	String symbol;
	int powerValue;
	
	A_rename(String symbol, int powerValue) {
		this.symbol = symbol;
		this.powerValue = powerValue;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getPowerValue() {
		return powerValue;
	}
	
	public static A_rename getPrefix(String symbol) {
		for (A_rename p : A_rename.values())
			if (p.getSymbol().equals(symbol) || p.toString().equals(symbol))
				return p;
		throw new IllegalArgumentException(
				String.format("No valid prefix matching symbol '%s'", symbol));
	}

	@Override
	public String toString() {
		if (this == A_rename.Unit)
			return "";
		else
			return super.toString();
	}
}

