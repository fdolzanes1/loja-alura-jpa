package br.com.dolzanes.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double sumValue;
	private LocalDate data = LocalDate.now();

	@ManyToOne
	private Client client;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<ItemOrder> itens = new ArrayList<>();

	public Order() {
	}

	public Order(Client client) {
		this.client = client;
	}
	
	public void addItem(ItemOrder item) {
		item.setOrder(this);
		this.itens.add(item);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSumValue() {
		return sumValue;
	}

	public void setSumValue(Double sumValue) {
		this.sumValue = sumValue;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<ItemOrder> getItens() {
		return itens;
	}

	public void setItens(List<ItemOrder> itens) {
		this.itens = itens;
	}

}
