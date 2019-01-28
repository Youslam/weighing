package com.smart.app.weighing.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper=false)
@ToString
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@MappedSuperclass
public class ProductHolder extends Auditable<String>{

	private static final long serialVersionUID = 6188448428410086535L;

	@NotNull
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "sector", nullable = true)
	private String sector;
	
	@NotNull
	@Column(name = "email", unique = true, nullable = true)
	private String email;
	
	@Column(name = "phone", nullable = true)
	private String phone;
	
	@Column(name = "adress", nullable = true)
	private String adress;
	
}
