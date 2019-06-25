package com.example.backendcode.BackEndCodeChallange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backendcode.BackEndCodeChallange.entity.ApplicationDetailEntity;

@Repository
public interface ApplicationDetailRespository extends JpaRepository<ApplicationDetailEntity, String>{
	
	Optional<ApplicationDetailEntity> findBySubType(String subType);

}
