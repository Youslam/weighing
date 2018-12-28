package com.smart.app.weighing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.app.weighing.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
