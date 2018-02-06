package Units_OLD;

import java.util.Scanner;

public class Testing {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Units a = new Units(Units.convert(input.next()));
		System.out.printf("%s %s", a.getPrefix(), a.getBase());
	}
}
