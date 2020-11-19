package com.jacaranda.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import com.jacaranda.service.DocumentService;

@RestController
@RequestMapping(path="/api")
public class DocumentController {

	
	//Creamos los servicios
	@Autowired
	private DocumentService documentService;
	
	
	//Devuelve un documento al pasarle la id del customer
	@GetMapping("/document/download/{id}")
	public ResponseEntity<Resource> downloadDocument(@PathVariable ("id") Long id) throws SQLException{
		return documentService.downloadDocument(id);
	}
	
	
	//Sube un archivo a la BBDD
	@PutMapping("/document/{idCustomer}")
	public ResponseEntity<?> addDocument(@RequestParam MultipartFile file, @PathVariable(required = false) Long idCustomer) {
		documentService.addDocument(idCustomer, file);
		return ResponseEntity.ok("File " + file.getOriginalFilename() + " succesfully uploaded");
		}
}
