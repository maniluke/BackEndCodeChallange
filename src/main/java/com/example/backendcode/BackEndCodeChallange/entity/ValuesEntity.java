package com.example.backendcode.BackEndCodeChallange.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ValuesEntity implements Serializable{
	
	
	@Id
	@GeneratedValue
	private long valuesId;

	private String subType;
	private String valueString;
	
	
}
