package com.nttdata.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.persistence.Producto;

@Repository
public interface ProductoRepositoryI extends JpaRepository<Producto, Long>{

}
