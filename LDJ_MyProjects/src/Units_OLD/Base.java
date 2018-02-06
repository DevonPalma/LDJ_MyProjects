package Units_OLD;

public enum Base {
	
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
	Inches("in", false),
	Feet("ft", false),
	Yards("yd", false),
	Miles("mi", false),
	Mole("mol", true),
	Liter("L", true),
	Byte("B", true),
	Second("S", true);
	
	private final String symbol;
	private final boolean isSIUnit;
	
	Base(String symbol, boolean isSIUnit) {
		this.symbol = symbol;
		this.isSIUnit = isSIUnit;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public boolean getSIUnit() {
		return isSIUnit;
	}
	
	public static Base getBase(String symbol) {
		for (Base b : Base.values()) {
			if(b.getSymbol().equals(symbol))
				return b;
		}
		throw new IllegalArgumentException(
				String.format("symbol '%s' doesn't have a matching base", symbol));
	}
	
	public static String[] getRegex() {
		// returns SI positive units in 0 and SI negative in 1
		String[] types = { "" , "" };

		for(Base b : Base.values()) {
			if (b.getSIUnit()) 
				types[0] += (types[0].length() == 0 ? "" : "|") + b.getSymbol();
			else
				types[1] += (types[1].length() == 0 ? "" : "|") + b.getSymbol();
		}
		
		return types;
	}
}

// 46 lines