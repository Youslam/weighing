package com.smart.app.weighing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@ToString
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Entity
@Table(name = "vehicle")
public class Vehicle extends Auditable<String>{

	private static final long serialVersionUID = 49023855177490480L;

	@Column(name = "matricule", unique = true, nullable = false)
	private String matricule;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "brand", nullable = true)
	private String brand;
	
	@Column(name = "model", nullable = true)
	private String model;
	
	@Column(name="maxload", nullable = true)
	private double maxload;
	
}
