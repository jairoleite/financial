package com.me.financial.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.financial.config.ResponseDefault;
import com.me.financial.model.Despesa;
import com.me.financial.repository.DespesaRepository;

@RestController
@RequestMapping("financeiro")
public class DespesaRest {

	@Autowired
	private DespesaRepository despesarepository; 
	
	@PostMapping("/save")
	public ResponseDefault save(@RequestBody Despesa despesa) {
		despesarepository.save(despesa);
		return new ResponseDefault(false, "Despesa salva com sucesso!");
	}
	
	@GetMapping("/listDespesas")
	public List<Despesa> getList() {
		return despesarepository.getList();
	}
}
