package com.jacaranda.service;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Document;
import com.jacaranda.repo.CustomerRepository;
import com.jacaranda.repo.DocumentRepository;

@Service
public class DocumentService extends AbstractServiceUtils{
	
	

	public DocumentService(CustomerRepository customerRepo, DocumentRepository documentRepo) {
		this.customerRepository=customerRepo;
		this.documentRepository=documentRepo;
	}

	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private FileHandlerService fhService;
	
	
	//Añade un documento a un customer
	public Customer addDocument(Long id, MultipartFile mpf) {
		Customer c = null;

		try {
			Document doc = documentRepository.save(new Document(
							fhService.createBlob(mpf), 
							mpf.getOriginalFilename(), 
							Integer.valueOf((int) mpf.getSize()),
							mpf.getContentType()));

			c = customerRepository.findCustomerBycustomerId(id);
			c.setDocument(doc);
			customerRepository.save(c);

		} catch (NumberFormatException e) {
			logger.debug(String.format("Customer with identifier %s could not be found ", id));
		}

		return c;
	}
	
	
	
	//Descarga un documento
	public ResponseEntity<Resource> downloadDocument(Long id) throws SQLException {
		Customer c = customerRepository.findCustomerBycustomerId(id);
		Document d = documentRepository.findById(c.getDocument().getIdDocument()).get();
		
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(d.getFileType()))
				.header("hola", "attachment; filename=\"" + d.getFileName() + "\"")
				.body(new ByteArrayResource(d.getFile().getBytes(1L, (int) d.getFile().length())));
		
	}
	

	protected void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	protected void setLogger(Logger logger) {
		this.logger = logger;
	}

	protected void setFhService(FileHandlerService fhService) {
		this.fhService = fhService;
	}
}
