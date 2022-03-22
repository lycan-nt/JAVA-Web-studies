package main;

public class ClassMain {

	public static void main(String[] args) {
		
		//***declaring
		String myString = new String();
		myString = "JAVA";
		String myString2 = "JAVA";
		String myString3 = new String("JAVA");
		String myString4 = "";
		
		char[] myChars = new char[] {'J', 'A', 'V', 'A'};
		String myString5 = new String(myChars);
		//================================================
		
		//***useful methods
		String s = "This comment was bad";
		s = s.replace("bad", "very BAD");
		System.out.println(s);
		
		String s2 = "arara";
		s2 = s2.replace('a', 'e');
		System.out.println(s2);
		
		String s3 = " Remove Space";
		s3 = s3.trim();
		
		String s4 = "Hello World Go To Next Dev";
		System.out.println(s4.contains("To"));
		
		System.out.println("Hello".length());
		
		String s5 = "Felipe D. Santos";
		System.out.println(s5.toUpperCase());
		System.out.println(s5.toLowerCase());
		//==================================================

	}

}
