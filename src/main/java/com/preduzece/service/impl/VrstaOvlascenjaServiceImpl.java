/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.service.impl;

import com.preduzece.entity.VrstaOvlascenja;
import com.preduzece.repository.VrstaOvlascenjaRepository;
import com.preduzece.service.VrstaOvlascenjaService;
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
public class VrstaOvlascenjaServiceImpl implements VrstaOvlascenjaService {

    @Autowired
    VrstaOvlascenjaRepository vrstaOvlascenjaRepository;

    @Override
    public List<VrstaOvlascenja> findAll() {
        return vrstaOvlascenjaRepository.findAll();
    }

    @Override
    public VrstaOvlascenja findById(int id) {
        Optional<VrstaOvlascenja> vrstaOvlascenja = vrstaOvlascenjaRepository.findById(id);
        
        if(vrstaOvlascenja.isPresent()){
          return  vrstaOvlascenja.get();
        }
        throw new EntityNotFoundException("Vrsta ovlascenja ne postoji.");
    }

    @Override
    public void saveOrUpdate(VrstaOvlascenja vrstaOvlascenja) {
        vrstaOvlascenjaRepository.save(vrstaOvlascenja);
    }

    @Override
    public void delete(int id) {
        vrstaOvlascenjaRepository.deleteById(id);
    }

}
