package com.example.backendcode.BackEndCodeChallange.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class MGMFile {
	
	private List<Protocol> protocol;
	private String fileFormat;
	private String checksum;
	private String fileFingerprint;
	private String rOMSizeKB;
	private String size;
	private Timestamp fileDateModified;
	
}
