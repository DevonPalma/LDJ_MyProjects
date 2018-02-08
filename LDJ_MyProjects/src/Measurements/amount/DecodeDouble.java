package Measurements.amount;

public class DecodeDouble {
	public static int getSigFigs(String number) {
		String[] digits; 
		
		if (getType(number))
			digits = number.split("");
		else
			digits = reverse(number.split(""));
		
		boolean foundFirst = false;
		int sigFigs = 0;
		
		for (String i : digits) {
			if ((!(i.equals("0")) || foundFirst) && !(i.equals("."))) {
				foundFirst = true;
				sigFigs++;
			}
		}
		return sigFigs;
	}
	
	public static double getPercission(String number) {
		String[] arr;
		if (getType(number)) {
			arr = number.split(".")[1].split("");
		}
		else {
			arr = reverse(number.split(""));
		}
		
			
	}
	
	private static boolean getType(String number) {
		// return true if pacific or false if atlantic
		return (number.contains("."));
	}
	
	private static String[] reverse(String[] arr) {
		String[] temp = arr;
		for(int i = 0; i < temp.length / 2; i++)
		{
		    String store = temp[i];
		    temp[i] = temp[temp.length - i - 1];
		    temp[temp.length - i - 1] = store;
		}
		return temp;
	}
	
}
