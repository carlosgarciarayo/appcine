package com.cgr.appcine.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cgr.appcine.model.Category;
import com.cgr.appcine.model.Profiles;
import com.cgr.appcine.model.User;





public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByNameLike(String name);	
	User findById(int id);
		
	

}
