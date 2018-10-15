package com.me.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.financial.model.TipoDespesa;

public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Integer> {

}
