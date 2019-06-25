package com.example.backendcode.BackEndCodeChallange.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class MGMFile implements Serializable{
	
	@Id
	@Column(insertable = false, updatable = false)
	private String filePN;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "filePN")
	private Set<Protocol> protocol;
	
	private String fileFormat;
	private String checksum;
	private String fileFingerprint;
	private String rOMSizeKB;
	private String size;
	private Timestamp fileDateModified;
	
}
