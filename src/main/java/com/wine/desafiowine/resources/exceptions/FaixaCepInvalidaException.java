package com.wine.desafiowine.resources.exceptions;


public class FaixaCepInvalidaException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FaixaCepInvalidaException(){

		super("erro! a faixa de inicio não pode ser maior que a faixa do fim");
	}


}
