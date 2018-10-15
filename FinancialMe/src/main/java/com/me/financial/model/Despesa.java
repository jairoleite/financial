package com.me.financial.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Despesa")
public class Despesa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;
	
	private BigDecimal valorGasto;
	private Integer tipoDespesa;
	private Integer salarioMes;
	@Temporal(TemporalType.TIMESTAMP)
	private Date registryDate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getValorGasto() {
		return valorGasto;
	}
	public void setValorGasto(BigDecimal valorGasto) {
		this.valorGasto = valorGasto;
	}
	public Integer getTipoDespesa() {
		return tipoDespesa;
	}
	public void setTipoDespesa(Integer tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	public Integer getSalarioMes() {
		return salarioMes;
	}
	public void setSalarioMes(Integer salarioMes) {
		this.salarioMes = salarioMes;
	}
	public Date getRegistryDate() {
		return registryDate;
	}
	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}
	
	
}
