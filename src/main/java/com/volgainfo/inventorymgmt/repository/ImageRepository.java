package com.volgainfo.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.volgainfo.inventorymgmt.entity.ImageEntity;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long>{

}
