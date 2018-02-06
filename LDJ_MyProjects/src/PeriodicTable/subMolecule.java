package PeriodicTable;

public class subMolecule {
	Elements element;
	int amount;
	
	public subMolecule(String subMolecule) {
		// split molecule from number (ex. C8 -> 'C' and '8')
		String[] info = subMolecule.split("(?=\\d)(?<=\\D)");
		
		// check for actual number
		if (info.length == 2)
			try {
				amount = Integer.parseInt(info[1]);
			}
			catch (NumberFormatException e) {
				throw new IllegalArgumentException(String.format("Invalid subMolecule '%s'", subMolecule));
			}
		else if (info.length == 1)
			amount = 1;
			
		try {
			element = Elements.valueOf(info[0]);
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(String.format("Invalid subMolecule '%s'", subMolecule));
		}
		
	}
	
	public void setElement(Elements e) {
		element = e;
	}
	
	public void setElement(String s) {
		try {
			setElement(Elements.valueOf(s));
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(String.format("Invalid subMolecule", s));
		}
	}
	
	public Elements getElement() {
		return element;
	}
	
	public void setAmount(int a) {
		if (a > 0)
			amount = a;
		else
			amount = 1;
	}
	
	public int getAmount() {
		return amount;
	}
	
	@Override
	public String toString() {
		return String.format("%s%d", getElement(), getAmount());
	}
}
