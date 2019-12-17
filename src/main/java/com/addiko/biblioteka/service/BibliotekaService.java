package com.addiko.biblioteka.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.addiko.biblioteka.model.Knjige;

public interface BibliotekaService {

	List<Knjige> getAllKnjige();

	Knjige createKnjige(Knjige knjiga);

	Knjige getKnjigeById(Long knjigaId);

	Knjige updateKnjiga(Long knjigaId, Knjige knjigaDetails);

	ResponseEntity<?> deleteKnjiga(Long knjigaId);

}