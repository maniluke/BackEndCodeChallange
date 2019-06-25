package com.example.backendcode.BackEndCodeChallange.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CompatibleAssemblies implements Serializable {

	@Id
	@GeneratedValue
	private long compatibleId;
	
	private String subType;
	private String assyPN;
}
