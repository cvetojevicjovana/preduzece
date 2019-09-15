/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.service.impl;

import com.preduzece.entity.Spediter;
import com.preduzece.repository.SpediterRepository;
import com.preduzece.service.SpediterService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Roki
 */

@Service
@Transactional
public class SpediterServiceImpl implements SpediterService {
    
    @Autowired
    SpediterRepository spediterRepository;
    
    @Autowired
    EntityManager entityManager;
    
    @Override
    public List<Spediter> findAll() {
        return spediterRepository.findAll();
    }

    @Override
    public Spediter findById(int id) {
        
        Optional<Spediter> spediter = spediterRepository.findById(id);
        
        if(spediter.isPresent()){
            return spediter.get();
        }
        
        throw new EntityNotFoundException("Spediter ne postoji!");
    }

    @Override
    public void saveOrUdate(Spediter spediter) {
        spediterRepository.save(spediter);
    }

    @Override
    public void delete(int id) {
        spediterRepository.deleteById(id);
    }

    @Override
    public List<Spediter> search(int id, String naziv, String adresa, String telefon, String pib) {
       CriteriaBuilder qb = entityManager.getCriteriaBuilder();
       CriteriaQuery cq = qb.createQuery();
       Root<Spediter> spediter = cq.from(Spediter.class);
       
       List<Predicate> predicates = new ArrayList<>();
       
       if(id!=0){
           List<Spediter> sprediteri = new ArrayList<>();
           sprediteri.add(findById(id));
           return sprediteri;
       }
       if(naziv!=null){
           predicates.add(qb.like(spediter.get("naziv"), naziv+"%"));
       }
       if(adresa!=null){
           predicates.add(qb.like(spediter.get("adresa"), adresa+"%"));
       }
       if(telefon!=null){
           predicates.add(qb.like(spediter.get("telefon"), telefon+"%"));
       }
       if(pib!=null){
           predicates.add(qb.like(spediter.get("pib"), pib+"%"));
       }
       
       cq.select(spediter).where(predicates.toArray(new Predicate[]{}));
        return entityManager.createQuery(cq).getResultList();
    }
    
    
}
