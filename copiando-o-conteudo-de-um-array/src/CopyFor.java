import java.util.Random;

public class CopyFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] a = new int[5];
		Random numeros = new Random();
		
		for (int i  = 0; i < a.length; i++)
		{
			a[i] = numeros.nextInt();
			System.out.println("A[" + i + "] = " + a[i]);
		}
		System.out.println();
		
		int [] b = new int[a.length];
		
		for (int i=0; i < a.length; i++)
			b[i] = a[i];
		
		for (int i = 0; i < a.length; i++)
		{
			System.out.println("B[" + i + "]=" + b[i]);
		}

	}
}
