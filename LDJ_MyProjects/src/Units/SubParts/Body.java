package Units.SubParts;

public enum Body {
	fahrenheit("F", false),
	Celsius("C", false),
	Kelvin("K", true),
	Ampere("A", true),
	Candela("cd", true),
	Joules("J", true),
	Pascal("Pa", true),
	Bar("bar", false),
	// makes sure atm comes before at or filter fucks up
	StandardAtmosphere("atm", false),
	TechnicalAtmosphere("at", false),
	Torr("Torr", false),
	PoundsPerSquareInch("psi", false),
	Gram("g", true),
	Meter("m", true),
	Inch("in", false),
	Feet("ft", false),
	Yard("yd", false),
	Mile("mi", false),
	Mole("mol", true),
	Liter("L", true),
	Byte("B", true),
	Second("S", true);

	String symbol;
	boolean usesPrefix;
	
	Body(String symbol, boolean usesPrefix) {
		this.symbol = symbol;
		this.usesPrefix = usesPrefix;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public boolean getUsesPrefix() {
		return usesPrefix;
	}
	
	public static Body getBody(String symbol) {
		for (Body b : Body.values()) 
			if (b.getSymbol().equals(symbol) || b.toString().equals(symbol))
				return b;
		
		throw new IllegalArgumentException(
				String.format("No valid body matching symbol/name '%s'", symbol));
	}
	
	public String toString() {
		return this.name();
	}
	
}
