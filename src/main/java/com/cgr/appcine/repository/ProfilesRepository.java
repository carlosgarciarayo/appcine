package com.cgr.appcine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgr.appcine.model.Profiles;

public interface ProfilesRepository extends JpaRepository<Profiles, Integer> {

	
	Profiles findById(int id);

}
