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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Document;
import com.jacaranda.service.DocumentService;
import com.jacaranda.service.IService;

@RestController
@RequestMapping(path="/api")
public class DocumentController {

	
	//Creamos los servicios
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private IService<Document> service;
	
	//Devuelve un documento
	@GetMapping("/document/{id}")
	public ResponseEntity<Resource> viewDocument(@PathVariable ("id") Long idDoc) throws SQLException{
		return documentService.viewDocument(idDoc);
	}
	
	//Devuelve todos los documentos de un cliente concreto
	@GetMapping("/document/{idCustomer}")
	public ResponseEntity<?> getCustomerDocuments(@PathVariable Long idCustomer) {			
		ResponseEntity<?> response = null;
		List<Document> resultado = documentService.getCustomerDocuments(idCustomer);

		if (resultado == null) {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR. El cliente (" + idCustomer + ") no tiene documentos");
		} else {
			response = ResponseEntity.status(HttpStatus.OK).body(resultado);
		}
		
		return response;
	}
	
	//Sube un archivo a la BBDD
	@PutMapping("/customer/{id}")
	public ResponseEntity<?> uploadFile(MultipartFile file, @PathVariable Long id) {
		service.addDocument(id, file);
		return ResponseEntity.ok("File " + file.getOriginalFilename() + " successfully uploaded");
	}
}
