package com.wine.desafiowine.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wine.desafiowine.entities.Loja;
import com.wine.desafiowine.services.LojaService;

@RestController
@RequestMapping(value= "/api/lojas")
public class LojaResource {
	
	@Autowired
	private LojaService lojaService ;

	@GetMapping
	public ResponseEntity<List<Loja>> findAll(){
		List<Loja> list = lojaService.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/cep/{cep}")
	public ResponseEntity <Loja> findLojaByCep(@PathVariable int cep){
		
		Loja list = lojaService.FindLojaByCep(cep);
		
		return ResponseEntity.ok().body(list);
	}
		
	@PostMapping
	public ResponseEntity<Loja> insert(@RequestBody Loja cep){
		
		cep = lojaService.insert(cep);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cep.getId()).toUri();
		
		return ResponseEntity.created(uri).body(cep);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		lojaService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value= "/{id}")
	public ResponseEntity<Loja> update(@PathVariable Long id, @RequestBody Loja cep) {
		cep = lojaService.update(id, cep);
		return ResponseEntity.ok().body(cep);
		
	}
}
