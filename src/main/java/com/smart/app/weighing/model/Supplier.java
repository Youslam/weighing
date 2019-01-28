package com.smart.app.weighing.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper=false)
@ToString
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Entity
@Table(name = "supplier")
public class Supplier extends ProductHolder {

	private static final long serialVersionUID = 6188448428410086535L;

	@Transient
	private ProductHolderType type = ProductHolderType.SUPPLIER;
	
}
