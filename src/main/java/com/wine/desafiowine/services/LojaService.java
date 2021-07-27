package com.wine.desafiowine.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.wine.desafiowine.entities.Loja;
import com.wine.desafiowine.repositories.LojaRepository;
import com.wine.desafiowine.resources.exceptions.FaixaCepInvalidaException;
import com.wine.desafiowine.services.exceptions.ConflitoFaixaCepException;
import com.wine.desafiowine.services.exceptions.ResourceNotFoundException;

@Component
public class LojaService {
	
	@Autowired
	private LojaRepository repository;
	
	public List<Loja> findAll(){
		
		return repository.findAll();
	}
	
	public Loja insert(Loja loja) {
		this.verificaFaixaCep(loja);
		return repository.save(loja);
		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		 
	}
	
	public Loja update(Long id, Loja loja) {
		try {
			this.verificaFaixaCepUpdate(id,loja);
			Loja entity = repository.getById(id);
			this.updateData(entity,loja);
			return repository.save(entity);
			
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	private void updateData(Loja entity, Loja loja) {
		entity.setCodigoLoja(loja.getCodigoLoja());
		entity.setFaixaInicio(loja.getFaixaInicio());
		entity.setFaixaFim(loja.getFaixaFim());
	}
	
	public List<String> verificaFaixaCep(Loja loja) {

		List<String> result = repository.verificaCep(loja.getFaixaInicio(), loja.getFaixaFim());

		
		if(!this.faixasValidas(loja)) {
			throw new FaixaCepInvalidaException();
		}
	
		if(!result.isEmpty()) {
			throw new ConflitoFaixaCepException(result);
		}
			
		return result;
		
	}
	
	public List<String> verificaFaixaCepUpdate(Long id,Loja loja) {

		
		List<String> result = repository.verificaCep(loja.getFaixaInicio(), loja.getFaixaFim(),id);

		if(!this.faixasValidas(loja)) {
			throw new FaixaCepInvalidaException();
		}
	
		if(!result.isEmpty()) {
			throw new ConflitoFaixaCepException(result);
		}
			
		return result;
		
	}
	
	public Loja FindLojaByCep(int cep) {
		
		return repository.buscaLojaByCep(cep);
	}
	
	public boolean faixasValidas(Loja loja) {
		
		if(loja.getFaixaInicio()>loja.getFaixaFim()) {
			return false;
		}
		return true;
		
	}

}
