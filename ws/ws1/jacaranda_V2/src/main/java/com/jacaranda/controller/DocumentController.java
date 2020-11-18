package com.jacaranda.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Document;
import com.jacaranda.service.DocumentService;

@RestController
@RequestMapping(path="/api")
public class DocumentController {

	
	//Creamos los servicios
	@Autowired
	private DocumentService documentService;
	
	//@Autowired
	//private IService<Customer> service;
	
	//Devuelve un documento al pasarle la id del customer
	@GetMapping("/document/download/{id}")
	public ResponseEntity<Resource> downloadDocument(@PathVariable ("id") Long idDoc) throws SQLException{
		return documentService.downloadDocument(idDoc);
	}
	
	
	//Sube un archivo a la BBDD
	@PutMapping("/document/{idCustomer}")
	public ResponseEntity<?> addDocument(@RequestParam MultipartFile file, @PathVariable(required = false) Long idCustomer) {
		documentService.addDocument(idCustomer, file);
		return ResponseEntity.ok("File " + file.getOriginalFilename() + " succesfully uploaded");
		}
}
