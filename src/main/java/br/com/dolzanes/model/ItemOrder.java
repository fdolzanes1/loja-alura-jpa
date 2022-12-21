package br.com.dolzanes.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_orders")
public class ItemOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double priceUnit; 
	private int amount;
	@ManyToOne
	private Order order;
	@ManyToOne
	private Product product;
	
	public ItemOrder() {}
	
	public ItemOrder(int amount, Order order, Product product) {
		this.amount = amount;
		this.order = order;
		this.product = product;
		this.priceUnit = product.getPrice();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(Double priceUnit) {
		this.priceUnit = priceUnit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	} 
	
}
