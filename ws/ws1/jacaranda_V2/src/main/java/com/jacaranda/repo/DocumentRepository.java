package com.jacaranda.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.entity.Document;

@Repository(value = "documentRepository")
public interface DocumentRepository extends CrudRepository<Document, Long> {

}
