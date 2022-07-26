package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="name")
    private String name;
    
    @Column(name="Note")
    private String note;
    @OneToMany(mappedBy = "category")
    private List<Heo> products;
	
	public List<Heo> getProducts() {
		return products;
	}
	public void setProducts(List<Heo> products) {
		this.products = products;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
