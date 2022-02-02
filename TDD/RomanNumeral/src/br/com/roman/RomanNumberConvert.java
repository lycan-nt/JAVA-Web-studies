package br.com.roman;

public class RomanNumberConvert {

	public int convert(String romanNumber) {
		if (romanNumber.equals("I"))
			return 1;
		else if (romanNumber.equals("V"))
			return 5;
		return 0;
	}

}
