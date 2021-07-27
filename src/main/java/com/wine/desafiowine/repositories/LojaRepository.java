package com.wine.desafiowine.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wine.desafiowine.entities.Loja;

public interface LojaRepository extends  JpaRepository<Loja, Long>{
	
	@Query(value ="SELECT C.codigo_loja FROM LOJA as C WHERE "
			+ "(C.faixa_inicio <= ?1 AND C.faixa_fim >= ?1) "
			+ "OR (C.faixa_inicio >= ?1 AND C.faixa_inicio <= ?2)",nativeQuery = true)
	List<String> verificaCep(int faixa_inicio, int faixa_fim) ;
	

	@Query(value ="SELECT C.codigo_loja FROM LOJA as C WHERE "
			+ "(((C.faixa_inicio <= ?1 AND C.faixa_fim >= ?1) "
			+ "OR (C.faixa_inicio >= ?1 AND C.faixa_inicio <= ?2)) "
			+ "AND  C.id != ?3)",nativeQuery = true)
	List<String> verificaCep(int faixa_inicio, int faixa_fim,Long id) ;
	
	@Query(value ="SELECT * FROM LOJA AS C WHERE (c.faixa_inicio <= ?1) AND (c.faixa_fim >= ?1)",nativeQuery = true)
	Loja buscaLojaByCep(int cep) ;
}
