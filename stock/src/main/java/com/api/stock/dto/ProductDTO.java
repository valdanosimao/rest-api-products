package com.api.stock.dto;

public class ProductDTO {

		private Long id;
		
		private String name;
		
		private Integer theAmount;

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
