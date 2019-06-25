package com.example.backendcode.BackEndCodeChallange.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDetailEntity implements Serializable {
	
	@Id
	private String subType;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "subType" )
	private Set<ValuesEntity> valuesEntity;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "subType")
	private ApplicationPartDetail applicationPartDetail;
	private String applicationDescription;
	private String serviceable;
	private String testable;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "subType")
	private Set<CompatibleAssemblies> compatibleAssemblies;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "subType")
	private FunctionalTypeValues functionalTypeValues;
	
	private String sellable;
	private String residentOnVehicle;
	private String digitallySigned;
	private String consumerViewable;
	private String consumerDownloadable;
	private String dealerDownloadable;
	private String oTAViewable;
	private String oTADownloadable;

}
