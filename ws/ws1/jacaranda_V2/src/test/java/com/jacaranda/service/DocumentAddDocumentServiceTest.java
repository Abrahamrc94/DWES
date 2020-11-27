package com.jacaranda.service;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.jacaranda.entity.Customer;
import com.jacaranda.entity.Document;
import com.jacaranda.repo.CustomerRepository;
import com.jacaranda.repo.DocumentRepository;
import com.mysql.cj.jdbc.Blob;


public class DocumentAddDocumentServiceTest {

	
	
	private DocumentService sut;
	
	private CustomerRepository mockCustomerRepo;
	private DocumentRepository mockDocumentRepo;
	private FileHandlerService mockFileHandlerService;
	private Logger mockLogger;
	
	
	private MultipartFile mockMPF;
	private Document mockDocument;
	private Customer mockCustomer;
	private Blob mockBlob;
	
	
	@BeforeEach
	private void init() {
		
		mockCustomerRepo = mock(CustomerRepository.class);
		mockDocumentRepo = mock(DocumentRepository.class);
		mockFileHandlerService = mock(FileHandlerService.class);
		mockLogger = mock(Logger.class);
		
		mockBlob = mock(Blob.class);
		mockDocument = mock(Document.class);
		mockCustomer = mock(Customer.class);
		mockMPF = mock(MultipartFile.class);
		
		when(mockFileHandlerService.createBlob(mockMPF)).thenReturn(mockBlob);
		when(mockMPF.getName()).thenReturn("Nombre de archivo");
		when(mockDocumentRepo.save(Mockito.any(Document.class))).thenReturn(mockDocument);
		
		
		sut = new DocumentService(mockCustomerRepo, mockDocumentRepo);
		sut.setLogger(mockLogger);
		sut.setFhService(mockFileHandlerService);
	}

	@Test
	public void addingDocumentToCustomerSuccessfully() {
		
		
		when(mockCustomerRepo.findCustomerBycustomerId(Mockito.anyLong())).thenReturn(mockCustomer);
		when(mockCustomer.getDocument()).thenReturn(mockDocument);
		
		Customer c = sut.addDocument(Mockito.anyLong(), mockMPF);
		
		assert(c.getDocument().equals(mockDocument));
	}
	
}
