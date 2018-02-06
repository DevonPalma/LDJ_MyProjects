package PeriodicTable;

public class MoleculeMath {
	public static double getMass(subMolecule molecule) {
		return molecule.getAmount() * molecule.getElement().getMass();
	}
	
	public static double getMass(Molecule molecule) {
		double mass = 0;
		for (subMolecule m : molecule.getSubParts()) {
			mass += getMass(m);
		}
		return mass;
	}
}
