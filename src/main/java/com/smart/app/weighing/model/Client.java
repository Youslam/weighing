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
@Table(name = "client")
public class Client extends ProductHolder {

	private static final long serialVersionUID = -8828331380103228378L;
	
	@Transient
	private ProductHolderType type = ProductHolderType.CLIENT;
}
