package com.smart.app.weighing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.app.weighing.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByLogin(String login);
}
