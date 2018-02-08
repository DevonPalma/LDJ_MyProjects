package Testing;

import Measurements.Measurement;
import Measurements.amount.DecodeDouble;


public class test {
	public static void main(String[] args) {
		System.out.print(DecodeDouble.getSigFigs("00123.22200"));
	}
}
