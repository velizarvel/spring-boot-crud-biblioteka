package com.addiko.biblioteka.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.addiko.biblioteka.model.Knjige;
import com.addiko.biblioteka.service.BibliotekaService;

@RestController
@RequestMapping("/biblioteka")
public class BibliotekaController {

	@Autowired
	private BibliotekaService bibliotekaService;

	// Dobijanje podataka iz baze (sve Knjige)
	@GetMapping("/knjige")
	public List<Knjige> getAllKnjige() {
		return bibliotekaService.getAllKnjige();
	}

	// Kreiranje nove Knjige
	@PostMapping("/knjige")
	public Knjige createKnjige(@Valid @RequestBody Knjige knjiga) {
		return bibliotekaService.createKnjige(knjiga);
	}

	// Dobijanje pojedinacne knjige na osnovu id
	@GetMapping("/knjige/{id}")
	public Knjige getKnjigeById(@PathVariable(value = "id") Long knjigaId) {
		return bibliotekaService.getKnjigeById(knjigaId);
	}

	// Azuriranje knjige
	@PutMapping("/knjige/{id}")
	public Knjige updateKnjiga(@PathVariable(value = "id") Long knjigaId, @Valid @RequestBody Knjige knjigaDetails) {

		return bibliotekaService.updateKnjiga(knjigaId, knjigaDetails);
	}

	// Brisanje knjige
	@DeleteMapping("/knjige/{id}")
	public ResponseEntity<?> deleteKnjiga(@PathVariable(value = "id") Long knjigaId) {

		return bibliotekaService.deleteKnjiga(knjigaId);
	}

}
