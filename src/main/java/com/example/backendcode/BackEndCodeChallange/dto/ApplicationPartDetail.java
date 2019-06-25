package com.example.backendcode.BackEndCodeChallange.dto;

import lombok.Data;

@Data
public class ApplicationPartDetail {
	
	private String filePN;
	private String frozenStatus;
	private String successorPartNumber;
	
	private MGMFile mGMFile;
	
	private String version;
	private String RunTimeSize;
}
