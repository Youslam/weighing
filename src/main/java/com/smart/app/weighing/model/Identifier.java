package com.smart.app.weighing.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
public class Identifier implements Serializable {

	private static final long serialVersionUID = 6285840895043764248L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
