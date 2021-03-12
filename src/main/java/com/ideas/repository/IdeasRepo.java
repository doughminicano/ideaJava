package com.ideas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ideas.models.Ideas;

@Repository
public interface IdeasRepo extends CrudRepository<Ideas, Long> {
	List<Ideas> findAll();
	Ideas save();
}