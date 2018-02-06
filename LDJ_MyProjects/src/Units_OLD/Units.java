package Units_OLD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Units {
	// ----------------------------------------------------------------------
	// setting up base variables
	private Base base;
	private Prefixs prefix;

	private static final int CASE_UNKNOWN = 0;
	private static final int CASE_SI = 1;
	private static final int CASE_OTHER = 2;
	
	public static enum RegexType { LOCATE, SI, OTHERS, SPLIT;}
	public static enum Types { IS, OTHER, UNKNOWN }
	//
	// ----------------------------------------------------------------------
	//	inputing a sting like '44Gm' and transforming it into 'G' and 'm'
	//	
	public static String[] convert(String input) {
		// stips a known unit from the string
		String strippedInput = stripUnit(input);
		
		String[] output = { "", "" }; // { prefix, base }
		
		// finds the type of unit it is
		switch(checkType(strippedInput)) {
			case CASE_UNKNOWN:
				//shouldn't be reached but just in case
				throw new IllegalArgumentException(
						String.format("Input '%s' does not have a valid unit", input));
			case CASE_SI:
				String[] temporary = splitSI(strippedInput);
				output[0] = (temporary[0].length() == 0 ? "Unit" : temporary[0]);
				output[1] = temporary[1];
				break;
			case CASE_OTHER:
				output[0] = "Unit";
				output[1] = strippedInput;
				break;
		}
		return output;
	}
	
	public static String stripUnit(String toLocate) {
		// imports a string and finds a unit match
		Pattern p = Pattern.compile(getRegex(RegexType.LOCATE));
		Matcher m = p.matcher(toLocate);
		
		if (m.find())
			return m.group();
		else
			throw new IllegalArgumentException("Error");
	}
	//
	// ----------------------------------------------------------------------
	// 	determining the type
	//
	private static int checkType(String input) {
		if (checkOthers(input))
			return CASE_OTHER;
		else if(checkSI(input))
			return CASE_SI;
		else
			return CASE_UNKNOWN;
	}
	
	private static boolean checkOthers(String input) {
		// check if input string 
		Pattern p = Pattern.compile(getRegex(RegexType.OTHERS));
		Matcher m = p.matcher(input);
		
		return m.find();
	}
	
	private static boolean checkSI(String input) {
		Pattern p = Pattern.compile(getRegex(RegexType.SI));
		Matcher m = p.matcher(input);
		
		return m.find();
		
	}
	//
	// ----------------------------------------------------------------------
	//
	//
	private static String[] splitSI(String input) {
		return input.split(getRegex(RegexType.SPLIT));
	}
	//
	// ----------------------------------------------------------------------
	// 	Regex
	//
 	public static String getRegex(RegexType type) {
		// creates a regex filter for locating units in a large text
		String prefix = Prefixs.getRegex();
		String SI = Base.getRegex()[0];
		String others = Base.getRegex()[1];
		
		switch (type) {
			case LOCATE:
				return String.format("((\\b|(?<=(\\d)))((%s)|(%s|)(%s))\\b)", 
						others, prefix, SI);
			case OTHERS:
				return String.format("(?=(%s))", others);
			case SI:
				return String.format("(?=((%s|)(%s)))", prefix, SI);
			case SPLIT:
				return String.format("((?<=(%s))(?=((%s)\\b)))", prefix, SI);
			default:
				throw new IllegalArgumentException("Invalid ENUM type");
				
		}
	}
	//
	// ----------------------------------------------------------------------
	//	Constructors
	//
	public Units(Base base) {
		this(Prefixs.Unit, base);
	}
	
	public Units(String base) {
		this(Base.getBase(base));
	}
	
	public Units(Prefixs prefix, Base base) {
		this.base = base;
		if (!base.getSIUnit() && prefix != Prefixs.Unit)
			throw new IllegalArgumentException(
					String.format("attempted to put a prefix on a non SI unit'%s%s'", 
							prefix.getSymbol(), base.getSymbol()));
		this.prefix = prefix;
	}
	
	public Units(String prefix, Base base) {
		this(Prefixs.getPrefix(prefix), base);
	}
	
	public Units(Prefixs prefix, String base) {
		this(prefix, Base.getBase(base));
	}
	
	public Units(String prefix, String base) {
		this(Prefixs.getPrefix(prefix), Base.getBase(base));
	}
	
	public Units(String[] converted) {
		this(converted[0], converted[1]);
	}
	//
	// ----------------------------------------------------------------------
	// 	set and get methods
	//
	public void setBase(Base base) {
		this.base = base;
		if (!base.getSIUnit())
			setPrefix(Prefixs.Unit);
	}
	
	public void setBase(String base) {
		this.setBase(Base.getBase(base));
	}
	
	public Base getBase() {
		return base;
	}

	public void setPrefix(Prefixs prefix) {
		if (!base.getSIUnit() && prefix != Prefixs.Unit)
			throw new IllegalArgumentException(
					String.format("Attempted to put prefix on non SI unit '%s%s'",
							prefix.getSymbol(), getBase().getSymbol()));
		this.prefix = prefix;
	}
	
	public void setPrefix(String prefix) {
		this.setPrefix(Prefixs.getPrefix(prefix));
	}
	
	public Prefixs getPrefix() {
		return prefix;
	}
	
	@Override
	public String toString() {
		return String.format("%s%s", getPrefix().getSymbol(), getBase().getSymbol());
	}
}

//110