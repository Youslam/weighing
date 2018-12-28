package com.smart.app.weighing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Entity
@Table(name = "product")
public class Product extends Auditable<String>{

	private static final long serialVersionUID = 1411223355395303930L;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "type", nullable = true)
	private String type;
}
