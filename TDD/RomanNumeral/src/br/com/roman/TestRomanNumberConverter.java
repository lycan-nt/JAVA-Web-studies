package br.com.roman;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRomanNumberConverter {
	
	@Test
	public void mustUnderstandSymbolI() {
		RomanNumberConvert roman = new RomanNumberConvert();
		int number = roman.convert("I");
		assertEquals(1, number);
	}
	
	@Test
	public void mustUnderstandSymbolV() {
		RomanNumberConvert roman = new RomanNumberConvert();
		int number = roman.convert("V");
		assertEquals(5, number);
	}
	
	@Test
	public void mustUnderstandTwoSymbolsAsII() {
		RomanNumberConvert roman = new RomanNumberConvert();
		int number = roman.convert("II");
		assertEquals(2, number);
	}
	
	@Test
	public void mustUnderstandFourSymbolAsXXII() {
		RomanNumberConvert roman = new RomanNumberConvert();
		int number = roman.convert("XXII");
		assertEquals(22, number);
	}
	
	@Test
	public void mustUnderstandNumbersAsIX() {
		RomanNumberConvert roman = new RomanNumberConvert();
		int number = roman.convert("IX");
		assertEquals(9, number);
	}
	
	@Test
	public void mustUnderstandComplexNumbersAsXXIV() {
		RomanNumberConvert roman = new RomanNumberConvert();
		int number = roman.convert("XXIV");
		assertEquals(24, number);
	}
	
}
