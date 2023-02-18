package owl.demo;

import owl.goodbye.GoodBye;
import owl.hello.Hello;

public class Salutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello = new Hello();
		hello.helloModule();
		GoodBye goodBye = new GoodBye();
		goodBye.goodByeModule();
	}

}
