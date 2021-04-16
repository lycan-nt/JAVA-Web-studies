package br.com.owl.carr;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Carr van = new Carr(10);

        for (int i = 0; i < 5; i++)
        {
            van.peopleEnter();
        }
        System.out.println("Peoples in van: " + van.getQtdPeople());

        van.peopleExit();
        System.out.println("Peoples in van: " + van.getQtdPeople());

    }
}
