package com.smart.app.weighing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smart.app.weighing.model.Client;
import com.smart.app.weighing.model.Pesage;
import com.smart.app.weighing.model.Product;
import com.smart.app.weighing.model.Supplier;
import com.smart.app.weighing.model.Vehicle;

@Repository
public interface PesageRepository extends JpaRepository<Pesage, Long> {

	@Query("SELECT p FROM Pesage p WHERE vehicle in (:ids)")
	List<Pesage> searchByVehicle(@Param("ids") Iterable<Long> ids);
	List<Pesage> findByVehicleIn(List<Vehicle> ids);
	@Query("SELECT p FROM Pesage p WHERE product LIKE '%' || :term || '%'")
	List<Pesage> searchByProduct(@Param("term") String term);
	@Query("SELECT p FROM Pesage p WHERE client LIKE '%' || :term || '%'")
	List<Pesage> searchByClient(@Param("term") String term);
	@Query("SELECT p FROM Pesage p WHERE supplier LIKE '%' || :term || '%'")
	List<Pesage> searchBySupplier(@Param("term") String term);
	
	List<Pesage> findByProductIn(List<Product> products);
	List<Pesage> findByClientIn(List<Client> clients);
	List<Pesage> findBySupplierIn(List<Supplier> suppliers);
	
}
