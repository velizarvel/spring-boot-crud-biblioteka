package com.addiko.biblioteka.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.addiko.biblioteka.exception.ResourceNotFoundException;
import com.addiko.biblioteka.model.Knjige;
import com.addiko.biblioteka.repository.BibliotekaRepository;

@Service
public class BibliotekaServiceImpl implements BibliotekaService {

	@Autowired
	private BibliotekaRepository bibliotekaRepository;

	
	@Override
	public List<Knjige> getAllKnjige() {
		return bibliotekaRepository.findAll();
	}
	
	@Override
	public Knjige createKnjige(@Valid @RequestBody Knjige knjiga) {
		return bibliotekaRepository.save(knjiga);
	}
	
	@Override
	public Knjige getKnjigeById(Long knjigaId) {
		return bibliotekaRepository.findById(knjigaId)
				.orElseThrow(() -> new ResourceNotFoundException("Biblioteka", "id", knjigaId));
	}
	
	@Override
	public Knjige updateKnjiga(Long knjigaId, Knjige knjigaDetails) {

		Knjige knjiga = bibliotekaRepository.findById(knjigaId)
				.orElseThrow(() -> new ResourceNotFoundException("Biblioteka", "id", knjigaId));

		knjiga.setNaslov(knjigaDetails.getNaslov());
		knjiga.setAutor(knjigaDetails.getAutor());
		knjiga.setIzdavac(knjigaDetails.getIzdavac());
		knjiga.setGodina(knjigaDetails.getGodina());

		Knjige updatedKnjiga = bibliotekaRepository.save(knjiga);
		return updatedKnjiga;
	}
	
	@Override
	public ResponseEntity<?> deleteKnjiga(Long knjigaId) {

		Knjige knjiga = bibliotekaRepository.findById(knjigaId)
				.orElseThrow(() -> new ResourceNotFoundException("Biblioteka", "id", knjigaId));

		bibliotekaRepository.delete(knjiga);

		return ResponseEntity.ok().build();
	}

	
	
	
}
