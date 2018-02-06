package PeriodicTable;


public class Testing {
	public static void main(String[] args) {
		Molecule m = new Molecule("C8H12O");
		System.out.printf("%f", MoleculeMath.getMass(m));
	}
}
