package com.example.backendcode.BackEndCodeChallange.dto;

import java.util.List;

import com.example.backendcode.BackEndCodeChallange.dto.ApplicationDetail;

import lombok.Data;

@Data
public class ResponseTo {
	
	private List<ApplicationDetail> applicationDetail;

}
