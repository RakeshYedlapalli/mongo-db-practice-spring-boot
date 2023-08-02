package com.gap.mongodb.practice.MongoDBPractice.repository;

import com.gap.mongodb.practice.MongoDBPractice.model.SeasonCodeMapping;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonCodeResourceRepository extends MongoRepository<SeasonCodeMapping, String> {


}
