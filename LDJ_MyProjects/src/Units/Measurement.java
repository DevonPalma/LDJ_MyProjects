package Units;

public class Measurement {
	private String amount; // stored as string that way I can get sig figs and percission
	private Unit unit;
	
	private static String regex = "(?<=(\\d|\\.))(?=([a-z|A-Z]+))";
	
	
	public Measurement(String amount, Unit unit) {
		this.amount = amount;
		this.unit = unit;
	}
	
	public Measurement(String m) {
		this(m.split(regex)[0], 
				Unit.parseUnit(m.split(regex)[1]));
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", amount, unit.toString(true));
	}
	
	
}
