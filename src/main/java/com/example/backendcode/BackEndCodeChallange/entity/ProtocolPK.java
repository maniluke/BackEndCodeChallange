package com.example.backendcode.BackEndCodeChallange.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ProtocolPK implements Serializable{
	@Column(insertable = false, updatable = false)
	private String filePN;
	@Column(insertable = false, updatable = false)
	private String networkProtocol;

}
