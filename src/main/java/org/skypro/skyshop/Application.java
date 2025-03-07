package org.skypro.skyshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println (" " +
				" SSSSS  K   K  Y   Y   SSSSS  H   H  OOO  PPPP \n" +
				"  S       K  K    Y Y   S      H   H O   O P   P \n" +
				"  SSSSS   KKK      Y    SSSSS  HHHHH O   O PPPP \n" +
				"     S    K  K     Y        S  H   H O   O P \n" +
				"  SSSSS   K   K    Y    SSSSS  H   H  OOO  P ");
	}

}
