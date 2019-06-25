package com.example.backendcode.BackEndCodeChallange.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class ApplicationPartDetail implements Serializable{
	
	@Id
	@Column(insertable = false, updatable = false)
	private String subType; 
	@Column(insertable = false, updatable = false)
	private String filePN;
	
	private String frozenStatus;
	private String successorPartNumber;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "filePN", insertable = false, updatable = false)
	private MGMFile mGMFile;
	
	private String version;
	private String RunTimeSize;
	
}
