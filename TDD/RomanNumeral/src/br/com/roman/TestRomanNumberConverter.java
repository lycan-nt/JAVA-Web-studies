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
	
}
