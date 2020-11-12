package com.jacaranda.service;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Document;
import com.jacaranda.repo.CustomerRepository;
import com.jacaranda.repo.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private FileHandlerService fhService;
	
	
	public ResponseEntity<Resource> viewDocument(Long idDoc) throws SQLException{
		Document document = documentRepository.findById(idDoc).get();
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(document.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .body(new ByteArrayResource(document.getFile().getBytes(1, (int) document.getFile().length())));
	}


	public List<Document> getCustomerDocuments(Long idCustomer) {
		
		List<Document> newDocuments = null;
		
		// se guarda el cliente en una variable auxiliar
		Customer auxCustomer = customerRepository.findCustomerBycustomerId(idCustomer);

		// se comprueba si el cliente tiene documentos.
		if (!auxCustomer.getDocuments().isEmpty()) {			
			
			// se inicializa la lista
			newDocuments = new ArrayList<Document>();
			
			// se rellena la lista
			for (Document d : auxCustomer.getDocuments()) {
				newDocuments.add(new Document(d.getIdDocument(), d.getFileName(), d.getFileSize(), d.getFileType()));
			}
		}
		
		// se devuelve la lista
		return newDocuments;
	}
	
	
	public Customer addDocument(Long id, MultipartFile mpf) {
		Customer c = null;

		try {
			Document doc = documentRepository.save(new Document(
							fhService.createBlob(mpf), 
							mpf.getOriginalFilename(), 
							Integer.valueOf((int) mpf.getSize()),
							mpf.getContentType()));

			c = customerRepository.findCustomerBycustomerId(id);
			c.setDocuments(c.getDocuments() != null && !c.getDocuments().isEmpty() ? c.getDocuments() : new ArrayList<>());
			c.getDocuments().add(doc);
			customerRepository.save(c);

		} catch (NumberFormatException e) {
			logger.debug(String.format("Customer with identifier %s could not be found ", id));
		}

		return c;
	}
	
	
	
}
