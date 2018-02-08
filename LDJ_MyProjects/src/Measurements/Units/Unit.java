package Measurements.Units;

import Measurements.Units.SubParts.Body;
import Measurements.Units.SubParts.Prefix;

public class Unit {
	Prefix prefix;
	Body body;
	
	// static methods for converting a string into separate parts
	private static String[] split(String Unit) {
		// WARNING: will not throw error if unit is unknown
		String[] Return = new String[2];
		String[] Split = Unit.split(getRegex());
		
		if (Split.length == 1) {
			Return[0] = "";
			Return[1] = Split[0];
		}
		else
			Return = Split;
		
		return Return;
	}
	
	private static String getRegex() {
		String bodyUsesPrefix = "";
		String bodyNoPrefix = "";
		String Prefixs = "";
		
		for (Body b : Body.values()) {
			if (b.getUsesPrefix())
				bodyUsesPrefix += (bodyUsesPrefix.length() == 0 ? "" : "|") + b.getSymbol();
			else
				bodyNoPrefix += (bodyNoPrefix.length() == 0 ? "" : "|") + b.getSymbol();
		}
		
		for (Prefix p : Prefix.values()) {
			if (p != Prefix.Unit)
				Prefixs += (Prefixs.length() == 0 ? "" : "|") + p.getSymbol();
		}
		
		return String.format("(?<=(\\b|\\d))(?=(%s))|(?<=(\\b|\\d)(%s|))(?=((%s)\\b))", 
				bodyNoPrefix, Prefixs, bodyUsesPrefix);
	}
	
	public static Unit parseUnit(String unit) {
		return new Unit(unit);
	}
	// constructors
	public Unit(Prefix prefix, Body body) {
		if (body.getUsesPrefix() || prefix == Prefix.Unit) {
			this.prefix = prefix;
			this.body = body;
		}
		else 
			throw new IllegalArgumentException(
					String.format("'%s%s' is an invalid Unit", prefix, body));		
	}
	
	public Unit(String prefix, String body) {
		this(Prefix.getPrefix(prefix), Body.getBody(body));
	}
	
	public Unit(String prefix, Body body) {
		this(Prefix.getPrefix(prefix), body);
	}
	
	public Unit(Prefix prefix, String body) {
		this(prefix, Body.getBody(body));
	}
	
	public Unit(Unit unit) {
		this(unit.getPrefix(), unit.getBody());
	}

	public Unit(String Unit) {
		this(split(Unit)[0], split(Unit)[1]);
	}
	
	// basic set and get methods
	public void setPrefix(Prefix prefix) {
		if (getBody().getUsesPrefix() || (prefix == Prefix.Unit))
			this.prefix = prefix;
		else
			throw new IllegalArgumentException(
					String.format("Prefix '%s' can not be applied to body '%s'", 
							getPrefix(), getBody()));
	}
	
	public void setPrefix(String prefix) {
		setPrefix(Prefix.getPrefix(prefix));
	}
	
	public Prefix getPrefix() {
		return prefix;
	}
	
	public void setBody(Body body) {
		this.body = body;
		if (!body.getUsesPrefix())
			setPrefix("");
	}
	
	public void setBody(String body) {
		setBody(Body.getBody(body));
	}
	
	public Body getBody() {
		return body;
	}
	
	public void setUnit(String unit) {
		String[] split = split(unit);
		setPrefix(split[0]);
		setBody(split[1]);
	}
	
	// override commands
	@Override
	public String toString() {
		return String.format("%s%s", getPrefix(), getBody());
	}
	
	public String toString(boolean shortened) {
		if (shortened)
			return String.format("%s%s", getPrefix().getSymbol(), getBody().getSymbol());
		else
			return toString();
	}
}
