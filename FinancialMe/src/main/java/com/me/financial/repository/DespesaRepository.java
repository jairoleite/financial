package com.me.financial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.me.financial.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

	@Query(value="select * from Despesa order by registryDate desc", nativeQuery=true)
	public List<Despesa> getList();
}
