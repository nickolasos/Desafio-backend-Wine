package com.wine.desafiowine.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wine.desafiowine.entities.Loja;
import com.wine.desafiowine.repositories.LojaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private LojaRepository lojaRepository ;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Loja c1 = new Loja(null,"LOJA_PINHEIROS",10000000,20000000);
		Loja c2 = new Loja(null,"LOJA_VITORIA",20000001,30000000);
		Loja c3 = new Loja(null,"LOJA_JARDINS",30000001,40000000);
		Loja c4 = new Loja(null,"LOJA_CAMPINAS",40000001,50000000);
		
		lojaRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
	}
}
