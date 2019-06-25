package com.example.backendcode.BackEndCodeChallange.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Protocol implements Serializable{
	
	@EmbeddedId
	private ProtocolPK embeddedId;
	private String networkWireless;

}
