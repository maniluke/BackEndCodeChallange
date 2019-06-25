package com.example.backendcode.BackEndCodeChallange.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class FunctionalTypeValues implements Serializable{
	
	@Id
	private String subType; 

	private String functionalType;

}
