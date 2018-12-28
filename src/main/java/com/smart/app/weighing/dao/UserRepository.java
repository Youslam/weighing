package com.smart.app.weighing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.app.weighing.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
