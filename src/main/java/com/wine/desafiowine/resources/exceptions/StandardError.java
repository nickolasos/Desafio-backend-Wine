package com.wine.desafiowine.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Instant timesTamp;
	private Integer Status;
	private String error;
	private String patch;
	 
	 
	public StandardError(Instant timesTamp, Integer status, String error, String patch) {
		super();
		this.timesTamp = timesTamp;
		Status = status;
		this.error = error;
		this.patch = patch;
	}
	
	
	public Instant getTimesTamp() {
		return timesTamp;
	}
	public void setTimesTamp(Instant timesTamp) {
		this.timesTamp = timesTamp;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPatch() {
		return patch;
	}
	public void setPatch(String patch) {
		this.patch = patch;
	}
	 
	 

}
