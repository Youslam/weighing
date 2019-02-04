package com.smart.app.weighing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smart.app.weighing.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByNameContaining(String term);

	@Query("SELECT c FROM Client c WHERE c.name LIKE '%' || :term || '%'")
	public List<Client> searchClientByName(@Param("term") String term);
}
