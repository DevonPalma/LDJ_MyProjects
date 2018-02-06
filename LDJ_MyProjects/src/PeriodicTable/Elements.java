package PeriodicTable;

public enum Elements {
	H("Hydrogen", 1.00794, 1),
	He("Helium", 4.003, 2),
	Li("Lithium", 6.941, 3),
	Be("Beryllium", 9.012, 4),
	B("Boron", 10.811, 5),
	C("Carbon", 12.011, 6),
	N("Nitrogen", 14.007, 7),
	O("Oxygen", 15.999, 8),
	F("Flourine", 18.998, 9),
	Ne("Neon", 20.180, 10),
	Na("Sodium", 22.990, 11),
	Mg("Magnesium", 24.305, 12),
	Al("Aluminum", 26.982, 13),
	Si("Silicon", 28.086, 14),
	P("Phosphorus", 30.974, 15),
	S("Sulfur", 32.065, 16),
	Cl("Chlorine", 35.453, 17),
	Ar("Argon", 39.948, 18),
	K("Potassium", 39.098, 19),
	Ca("Calcium", 40.078, 20),
	Sc("Scandium", 44.956, 21),
	Ti("Titanium", 47.867, 22),
	V("Vanadium", 50.942, 23),
	Cr("Chromium", 51.996, 24),
	Mn("Manganese", 54.938, 25),
	Fe("Iron", 55.845, 26),
	Co("Cobalt", 58.933, 27),
	Ni("Nickel", 58.693, 28),
	Cu("Copper", 63.546, 29),
	Zn("Zinc", 65.390, 30),
	Ga("Gallium", 69.723, 31),
	Ge("Germanium", 72.640, 32),
	As("Arsenic", 74.922, 33),
	Se("Selenium", 78.960, 34),
	Br("Bromine", 79.904, 35),
	Kr("Krypton", 83.800, 36),
	Rb("Rubidium", 85.468, 37),
	Sr("Strontium", 87.620, 38),
	Y("Yttrium", 88.906, 39),
	Zr("Zirconium", 91.224, 40),
	Nb("Niobium", 92.906, 41),
	Mo("Molybdenum", 95.940, 42),
	Tc("Technetium", 98.000, 43),
	Ru("Ruthenium", 101.070, 44),
	Rh("Rhodium", 102.906, 45),
	Pd("Palladium", 106.420, 46),
	Ag("Silver", 107.868, 47),
	Cd("Cadmium", 112.411, 48),
	In("Indium", 114.818, 49),
	Sn("Tin", 118.710, 50),
	Sb("Antimony", 121.760, 51),
	Te("Tellurium", 127.600, 52),
	I("Iodine", 126.905, 53),
	Xe("Xenon", 131.293, 54),
	Cs("Cesium", 132.906, 55),
	Ba("Barium", 137.327, 56),
	La("Lanthanum", 138.906, 57),
	Ce("Cerium", 140.116, 58),
	Pr("Praseodymium", 140.908, 59),
	Nd("Neodymium", 144.240, 60),
	Pm("Promethium", 145.000, 61),
	Sm("Samarium", 150.360, 62),
	Eu("Europium", 151.964, 63),
	Gd("Gadolinium", 157.250, 64),
	Tb("Terbium", 158.925, 65),
	Dy("Dysprosium", 162.500, 66),
	Ho("Holmium", 164.930, 67),
	Er("Erbium", 167.259, 68),
	Tm("Thlium", 168.934, 69),
	Yb("Ytterbium", 173.040, 70),
	Lu("Lutetium", 174.967, 71),
	Hf("Hafnium", 178.490, 72),
	Ta("Tantalum", 180.948, 73),
	W("Tungsten", 183.840, 74),
	Re("Rhenium", 186.207, 75),
	Os("Osmium", 190.230, 76),
	Ir("Iridium", 192.217, 77),
	Pt("Platinum", 195.078, 78),
	Au("Gold", 196.967, 79),
	Hg("Mercury", 200.590, 80),
	Tl("Thallium", 204.383, 81),
	Pb("Lead", 207.200, 82),
	Bi("Bismuth", 208.980, 83),
	Po("Polonium", 209.000, 84),
	At("Astatine", 210.000, 85),
	Rn("Radon", 222.000, 86),
	Fr("Francium", 223.000, 87),
	Ra("Radium", 226.000, 88),
	Ac("Actium", 227.000, 89),
	Th("Thorium", 232.038, 90),
	Pa("Protactinium", 231.036, 91),
	U("Uranium", 238.029, 92),
	Np("Neptunium", 237.000, 93),
	Pu("Plutonium", 244.000, 94),
	Am("Americium", 243.000, 95),
	Cm("Curium", 247.000, 96),
	Bk("Berkelium", 247.000, 97),
	Cf("Californium", 251.000, 98),
	Es("Einsteinium", 252.000, 99),
	Fm("Fermium", 257.000, 100),
	Md("Mendelvium", 258.000, 101),
	No("Nobelium", 259.000, 102),
	Lr("Lawrencium", 262.000, 103),
	Rf("Rutherfordium", 261.000, 104),
	Db("Dubnium", 262.000, 105),
	Sg("Seaborgium", 266.000, 106),
	Bh("Bohrium", 264.000, 107),
	Hs("Hassium", 277.000, 108),
	Mt("Meitnerium", 268.000, 109);
	
	
	private final String Name;
	private final double Mass;
	private final int Number;
	
	
	Elements(String Name, double Mass, int Number) {
		this.Name = Name;
		this.Mass = Mass;
		this.Number = Number;
	}
	
	public String getName() {
		return Name;
	}
	
	public double getMass() {
		return Mass;
	}
	
	public int getNumber() {
		return Number;
	}
}
