package Measurements.Units.SubParts;

public enum Prefix {
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
	
	Prefix(String symbol, int powerValue) {
		this.symbol = symbol;
		this.powerValue = powerValue;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getPowerValue() {
		return powerValue;
	}
	
	public static Prefix getPrefix(String symbol) {
		for (Prefix p : Prefix.values())
			if (p.getSymbol().equals(symbol) || p.toString().equals(symbol))
				return p;
		throw new IllegalArgumentException(
				String.format("No valid prefix matching symbol '%s'", symbol));
	}

	@Override
	public String toString() {
		if (this == Prefix.Unit)
			return "";
		else
			return super.toString();
	}
}

