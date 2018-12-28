package com.smart.app.weighing.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@Entity
@Table(name = "user")
public class User extends Auditable<String> {

	private static final long serialVersionUID = -6347089557269064650L;

	@Column(name = "login", nullable = false)
	private String login;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	@Transient
    private String passwordConfirm;
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
