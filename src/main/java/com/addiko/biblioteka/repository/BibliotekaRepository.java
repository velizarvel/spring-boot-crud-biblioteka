package com.addiko.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.addiko.biblioteka.model.Knjige;

@Repository
public interface BibliotekaRepository extends JpaRepository<Knjige, Long>{

}
