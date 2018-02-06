package Testing;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class test {
	public static void main(String[] args) {
		String[] b = {"F", "C", "K", "A"};
		
		String a = "";
		
		for(int i = 0; i < b.length; i++) {
			a += (a.length() == 0 ? "" : "|") + b[i]; 
		}
		
		System.out.printf(a);
	}
}
