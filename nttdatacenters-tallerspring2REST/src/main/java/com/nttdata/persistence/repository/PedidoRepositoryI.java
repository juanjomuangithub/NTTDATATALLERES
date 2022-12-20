package com.nttdata.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.persistence.Pedido;

@Repository
public interface PedidoRepositoryI extends JpaRepository<Pedido, Long>{

}
