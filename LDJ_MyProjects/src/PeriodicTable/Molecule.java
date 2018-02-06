package PeriodicTable;

public class Molecule {
	subMolecule[] subMolecules;
	
	public Molecule(String molecule) {
		// split and create the objects
		String[] subParts = molecule.split("(?=[A-Z])");
		subMolecules = new subMolecule[subParts.length];
		for (int counter = 0; counter < subParts.length; counter++)
			try {
				subMolecules[counter] = new subMolecule(subParts[counter]);
			}
			catch (IllegalArgumentException e) {
				throw new IllegalArgumentException(String.format("Invalid molecule '%s'", molecule));
			}
	}
	
	@Override
	public String toString() {
		String full = "";
		for (subMolecule i : subMolecules) {
			full += i.toString();
		}
		return full;
	}
	
	public subMolecule[] getSubParts() {
		return subMolecules;
	}
}
