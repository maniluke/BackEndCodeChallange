package com.example.backendcode.BackEndCodeChallange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendcode.BackEndCodeChallange.dto.BackEndException;
import com.example.backendcode.BackEndCodeChallange.dto.ResponseTo;
import com.example.backendcode.BackEndCodeChallange.service.BackEndCodeChallangeService;

@RestController
@RequestMapping("/backEndCodeChallange")
public class BackEndCodeChallangeController {
	
	@Autowired
	BackEndCodeChallangeService backEndCodeChallengeService;
	
	@GetMapping("/user/getDetails")
	public ResponseEntity<ResponseTo> getUserInformationForFile(@RequestParam(value = "fileName", required = true) String fileName, 
																@RequestParam(value = "section", required = true) String section){
		ResponseTo response = backEndCodeChallengeService.getResponse(fileName, section);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void userInformationForFile_notFound(BackEndException exception) {
		
	}
	

}
