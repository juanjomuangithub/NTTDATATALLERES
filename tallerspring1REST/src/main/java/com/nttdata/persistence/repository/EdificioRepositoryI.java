package com.nttdata.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.persistence.Edificio;

@Repository
public interface EdificioRepositoryI extends JpaRepository<Edificio, Long>{

}
