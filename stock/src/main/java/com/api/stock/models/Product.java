package com.api.stock.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome" , nullable = false, length = 50)
	private String name;
	
	@Column(name = "quantidade")
	private Integer theAmount;
	
	@Column(name = "valor" , nullable = false)
	private Double value;

}
