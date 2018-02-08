package Measurements;

import Measurements.Units.Unit;
import Measurements.amount.DecodeDouble;

public class Measurement {
	private String amount; // stored as string that way I can get sig figs and percission
	private Unit unit;
	
	private static String regex = "(?<=(\\d|\\.))(?=([a-z|A-Z]+))";
	
	
	public Measurement(String amount, Unit unit) {
		this.amount = amount;
		this.unit = unit;
	}
	
	public Measurement(Double amount, Unit unit) {
		this(Double.toString(amount), unit);
	}
	
	public Measurement(String m) {
		this(m.split(regex)[0], m.split(regex)[1]);
	}
	
	public Measurement(String amount, String unit) {
		this(amount, Unit.parseUnit(unit));
	}
	
	
	
	// get methods
	public double getAmount() {
		return Double.parseDouble(amount);
	}
	
	public Unit getUnit() {
		return unit;
	}
	
	public int getSigFigs() {
		return DecodeDouble.getSigFigs(amount);
	}
	
	public int getPercission() {
		return DecodeDouble.getPercission(amount);
	}
	
	// 
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public void setAmount(double amount) {
		setAmount(Double.toString(amount));
	}
	
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	public void setUnit(String unit) {
		setUnit(Unit.parseUnit(unit));
	}
	
	public void setSigFigs(int number) {
		// TODO
	}
	
	public void setPercission(int number) {
		// TODO
	}
	
	
	@Override
	public String toString() {
		return String.format("%s %s", getAmount(), getUnit().toString(true));
	}
}
