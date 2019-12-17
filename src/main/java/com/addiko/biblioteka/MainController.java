package com.addiko.biblioteka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@RequestMapping("/")
	public String pocetak() {
		return "Dobrodosli u kreiranu spring-boot aplikaciju.";
	}

	@RequestMapping("/pozdrav")
	public String pozdravnaPoruka() {
		return "Pozdravna poruka";
	}
}
