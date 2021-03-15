package com.volgainfo.inventorymgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.volgainfo.inventorymgmt.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

	//@Query("select MAX(e.sequence) from QueueEntity e where e.clientKey =:clientKey AND e.queueGroup.id =:queueGroupId group by e.clientKey")
	public List<ProductEntity> findByBrand(String brand);
}
