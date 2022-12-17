package com.project.rg.Calculator.dao;

import com.project.rg.Calculator.model.History;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoryRepository extends MongoRepository<History,String> {

}
