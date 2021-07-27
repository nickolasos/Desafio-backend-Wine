package com.wine.desafiowine.services.exceptions;

import java.util.List;

public class ConflitoFaixaCepException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConflitoFaixaCepException(List<String> lojas){

		super("erro! essa faixa de CEP conflita com a faixa de CEP da "+lojas.toString().replaceAll("\\[|\\]", ""));
	}

}
