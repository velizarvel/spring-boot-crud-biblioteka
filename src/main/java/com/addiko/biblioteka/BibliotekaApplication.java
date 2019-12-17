package com.addiko.biblioteka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotekaApplication.class, args);
		
		double a = 1.05d;
		double b = 2.55d;
		System.out.println(a+b);

		float a1 = 1.05f;
		float b1 = 2.55f;
		System.out.println(a1+b1);
	
		System.out.println(Float.BYTES);
		System.out.println(Double.BYTES);
		double c = (a+b)*100;
		System.out.println(Math.round(c)/100);
	}

}
