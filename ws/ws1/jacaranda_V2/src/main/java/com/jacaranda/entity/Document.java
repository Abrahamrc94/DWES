package com.jacaranda.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocument;
	private Blob file;
	private String fileName;	
	private Integer fileSize;
	private String fileType;
	
	
	  
	public Document() {
		super();
	}
	public Document(Blob file, String fileName, Integer fileSize, String fileType) {
		super();
		this.file = file;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
	}
	// Constructor para buscar todos los documentos de un cliente (getCustomerDocuments)
	public Document(Long idDocument, String fileName, Integer fileSize, String fileType) {
		super();
		this.idDocument = idDocument;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
	}
	
	
	
	public Long getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}
	public Blob getFile() {
		return file;
	}
	public void setFile(Blob file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
}
