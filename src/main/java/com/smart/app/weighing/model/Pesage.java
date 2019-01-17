package com.smart.app.weighing.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter(value=AccessLevel.PUBLIC)
@Setter(value=AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="pesage")
public class Pesage extends Auditable<String> {
	
	private static final long serialVersionUID = -2113696215818731759L;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name = "vehicle", nullable = false, updatable=false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Vehicle vehicle;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="productId", nullable=false, updatable=false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Product productId;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="clientId", nullable=false, updatable=false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Client clientId;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="supplierId", nullable=false, updatable=false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Supplier supplierId;
	
	@Column(name="numberBL", nullable=false, updatable=false)
	private String numberBL;
	
	@Column(name="date_time", nullable=false, updatable=false)
	private Date dateTime;
	
	@Column(name="first_brut", nullable=false, updatable=false)
	private double firstBalanceBrut;
	
	@Column(name="first_net", nullable=false, updatable=false)
	private double firstBalanceNet;
	
	@Column(name="first_tare", nullable=false, updatable=false)
	private double firstBalanceTare;
	
	@Column(name="seconde_brut", nullable=true, updatable=false)
	private double secondeBalanceBrut;
	
	@Column(name="seconde_net", nullable=true, updatable=false)
	private double secondeBalanceNet;
	
	@Column(name="seconde_tare", nullable=true, updatable=false)
	private double secondeBalanceTare;

}
