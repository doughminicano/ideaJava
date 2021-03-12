package com.ideas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ideas.models.Ideas;
import com.ideas.repository.IdeasRepo;

@Service
public class IdeasService {
	private final IdeasRepo repo;

//	REPO
	 
	public IdeasService(IdeasRepo repo) {
	     this.repo = repo;
	 }
	 
//	CREATE
	 
	 public Ideas create(Ideas obj) {
	     return repo.save(obj);
	 }
	 
//	RETRIEVE
	 
	 public Ideas retrieve(Long id) {
	     Optional<Ideas> obj = repo.findById(id);
	     if(obj.isPresent()) {
	         return obj.get();
	     } else {
	         return null;
	     }
	 }

//	RETRIEVE ALL
		
	 public List<Ideas> retrieveAll() {
	     return repo.findAll();
	 }
	 
//	UPDATE
	 public Ideas update(Long id) {
		return repo.save();

//	DELETE
	 
//	 public void delete(Long id) {
//		 repo.deleteById(id);		 
//	 }


		// TODO Auto-generated method stub
		
	}

}
