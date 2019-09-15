/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.service.impl;

import com.preduzece.entity.Radnik;
import com.preduzece.repository.RadnikRepository;
import com.preduzece.service.RadnikService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Roki
 */

@Service
@Transactional
public class RadnikServiceImpl implements RadnikService {
    
    @Autowired
    RadnikRepository radnikRepository;

    @Override
    public List<Radnik> findAll() {
        return radnikRepository.findAll();
    }

    @Override
    public Radnik findById(int id) {
        Optional<Radnik> radnik = radnikRepository.findById(id);
        
        if (radnik.isPresent()) {
            return radnik.get();
        }
        
        throw new EntityNotFoundException("Radnik ne postoji.");
    }

    @Override
    public void saveOrUpdate(Radnik radnik) {
        radnikRepository.save(radnik);
    }

    @Override
    public void delete(int id) {
        radnikRepository.deleteById(id);
    }
    
}
