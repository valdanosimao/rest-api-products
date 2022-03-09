package com.api.stock.dto;

import javax.validation.constraints.NotBlank;

public class ProductDTO {

		@NotBlank
		private Long id;
		
		@NotBlank
		private String name;
		
		@NotBlank
		private Integer theAmount;

		@NotBlank
		private Double value;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getTheAmount() {
			return theAmount;
		}

		public void setTheAmount(Integer theAmount) {
			this.theAmount = theAmount;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(Double value) {
			this.value = value;
		}

		
		
		
}
