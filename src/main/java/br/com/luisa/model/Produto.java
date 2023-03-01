package br.com.luisa.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Produto extends PanacheEntity {

	public String nome;
	public BigDecimal valor;
	@CreationTimestamp
	public LocalDate dataCriacao;
	@UpdateTimestamp
	public LocalDate dataAtualizacao;
	
}
