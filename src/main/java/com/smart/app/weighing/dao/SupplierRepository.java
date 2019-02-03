package com.smart.app.weighing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smart.app.weighing.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	List<Supplier> findByNameContaining(String term);
	
	@Query("SELECT s FROM Supplier s WHERE s.name LIKE '%' || :term || '%'")
	public List<Supplier> searchSupplierByName(@Param("term") String term);

}
