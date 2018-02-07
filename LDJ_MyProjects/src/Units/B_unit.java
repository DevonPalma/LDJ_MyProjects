package Units;

public class B_unit {
	A_rename Prefix;
	A_body Body;
	
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
		
		for (A_body b : A_body.values()) {
			if (b.getUsesPrefix())
				bodyUsesPrefix += (bodyUsesPrefix.length() == 0 ? "" : "|") + b.getSymbol();
			else
				bodyNoPrefix += (bodyNoPrefix.length() == 0 ? "" : "|") + b.getSymbol();
		}
		
		for (A_rename p : A_rename.values()) {
			if (p != A_rename.Unit)
				Prefixs += (Prefixs.length() == 0 ? "" : "|") + p.getSymbol();
		}
		
		return String.format("(?<=(\\b|\\d))(?=(%s))|(?<=(\\b|\\d)(%s|))(?=((%s)\\b))", 
				bodyNoPrefix, Prefixs, bodyUsesPrefix);
	}
	
	// constructors
	public B_unit(A_rename Prefix, A_body Body) {
		if (Body.getUsesPrefix() || Prefix == A_rename.Unit) {
			this.Prefix = Prefix;
			this.Body = Body;
		}
		else 
			throw new IllegalArgumentException(
					String.format("'%s%s' is an invalid Unit", Prefix, Body));		
	}
	
	public B_unit(String Prefix, String Body) {
		this(A_rename.getPrefix(Prefix), A_body.getBody(Body));
	}
	
	public B_unit(String Prefix, A_body Body) {
		this(A_rename.getPrefix(Prefix), Body);
	}
	
	public B_unit(A_rename Prefix, String Body) {
		this(Prefix, A_body.getBody(Body));
	}
	
	public B_unit(B_unit Unit) {
		this(Unit.getPrefix(), Unit.getBody());
	}

	public B_unit(String Unit) {
		this(split(Unit)[0], split(Unit)[1]);
	}
	
	// basic set and get methods
	public void setPrefix(A_rename Prefix) {
		if (getBody().getUsesPrefix() || (Prefix == A_rename.Unit))
			this.Prefix = Prefix;
		else
			throw new IllegalArgumentException(
					String.format("Prefix '%s' can not be applied to body '%s'", 
							getPrefix(), getBody()));
	}
	
	public void setPrefix(String Prefix) {
		setPrefix(A_rename.getPrefix(Prefix));
	}
	
	public A_rename getPrefix() {
		return Prefix;
	}
	
	public void setBody(A_body Body) {
		this.Body = Body;
		if (!Body.getUsesPrefix())
			setPrefix("");
	}
	
	public void setBody(String Body) {
		setBody(A_body.getBody(Body));
	}
	
	public A_body getBody() {
		return Body;
	}
	
	public void setUnit(String Unit) {
		String[] split = split(Unit);
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
