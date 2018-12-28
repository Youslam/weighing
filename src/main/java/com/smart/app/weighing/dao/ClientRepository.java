package com.smart.app.weighing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.app.weighing.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
