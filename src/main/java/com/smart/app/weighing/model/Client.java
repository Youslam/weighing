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
@Table(name = "client")
public class Client extends Auditable<String>{

	private static final long serialVersionUID = -8828331380103228378L;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "city", nullable = true)
	private String city;
	
	@Column(name = "country", nullable = true)
	private String country;
}
