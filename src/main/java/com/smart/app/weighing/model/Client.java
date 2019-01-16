package com.smart.app.weighing.model;

import javax.persistence.Column;
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
@Table(name = "client")
public class Client extends Auditable<String> {

	private static final long serialVersionUID = -8828331380103228378L;
	
	@Transient
	private ProductHolderType type = ProductHolderType.CLIENT;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "sector", nullable = true)
	private String sector;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "phone", nullable = true)
	private String phone;
	
	@Column(name = "adress", nullable = true)
	private String adress;
}
