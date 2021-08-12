package com.emilyread.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emilyread.dojos.models.Dojo;
import com.emilyread.dojos.models.Ninja;
import com.emilyread.dojos.repositories.DojoRepository;


@Service
public class DojoService {
private final DojoRepository dojoRepo;
	

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo= dojoRepo;	
	}
	
    public List<Dojo> allDojos() {
        return dojoRepo.findAll();
    }

    public Dojo createDojo(Dojo d) {
        return dojoRepo.save(d);
    }

    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    
}
