package com.example.backendcode.BackEndCodeChallange.dto;

import java.util.List;

import lombok.Data;

@Data
public class ApplicationDetail {
	
	private String subType;
	private List<String> values;
	
	private ApplicationPartDetail applicationPartDetail;
	private String applicationDescription;
	private String serviceable;
	private String testable;
	
	private List<CompatibleAssemblies> compatibleAssemblies;
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
