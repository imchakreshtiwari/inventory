package com.volgainfo.inventorymgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.volgainfo.inventorymgmt.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	@Query("SELECT u FROM UserEntity u WHERE u.username = :username")
    public UserEntity getUserByUsername(@Param("username") String username);
}
