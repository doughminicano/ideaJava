package com.ideas.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideas.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmail(String email);
	Optional<User> findById(Long id);


	
}
