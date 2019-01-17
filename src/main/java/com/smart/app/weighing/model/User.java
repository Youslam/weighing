package com.smart.app.weighing.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//@ToString
//@EqualsAndHashCode(callSuper = false)
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Entity
@Table(name = "user")
public class User extends Auditable<String> {

	private static final long serialVersionUID = -6347089557269064650L;

	@NotNull
	@Column(name = "login", unique=true, nullable = false)
	private String login;
	
	@Column(name = "name", nullable = true)
	private String name;
	
	@NotNull
	@Column(name = "email", nullable = true)
	private String email;
	
	@NotNull
	@Column(name = "password", nullable = false)
	private String password;
	
	@Transient
    private String passwordConfirm;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
