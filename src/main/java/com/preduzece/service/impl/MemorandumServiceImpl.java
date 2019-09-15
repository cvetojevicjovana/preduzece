/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.service.impl;

import com.preduzece.entity.Memorandum;
import com.preduzece.entity.Spediter;
import com.preduzece.entity.StavkeMemoranduma;
import com.preduzece.repository.MemorandumRepository;
import com.preduzece.repository.StavkeMemorandumaRepository;
import com.preduzece.service.MemorandumService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
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
public class MemorandumServiceImpl implements MemorandumService {

    @Autowired
    MemorandumRepository memorandumRepository;

    @Autowired
    StavkeMemorandumaRepository stavkeMemorandumaRepository;

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Memorandum> findAll() {
        return memorandumRepository.findAll();
    }

    @Override
    public Memorandum findById(int id) {
        Optional<Memorandum> memorandum = memorandumRepository.findById(id);

        if (memorandum.isPresent()) {
            return memorandum.get();
        }

        return null;
    }

    @Override
    public void deleteById(int id) {
        memorandumRepository.deleteById(id);
    }

    @Override
    public Memorandum saveOrUpdate(Memorandum memorandum) {
        Memorandum m = findById(memorandum.getMemorandumID());

        if (m != null) {

            stavkeMemorandumaRepository.deleteByMemorandumMemorandumID(m.getMemorandumID());

            if (memorandum.getStavkeMemoranduma() != null) {
                for (StavkeMemoranduma stavkeMemoranduma : memorandum.getStavkeMemoranduma()) {
                    stavkeMemoranduma.setMemorandum(new Memorandum(memorandum.getMemorandumID(), null, null, null, null, null));
                }
                stavkeMemorandumaRepository.saveAll(memorandum.getStavkeMemoranduma());
            }
            memorandum.setSpediter(memorandum.getSpediter());
            memorandumRepository.save(memorandum);
            return memorandum;

        } else {
            memorandum = memorandumRepository.save(memorandum);
            if (memorandum.getStavkeMemoranduma() != null) {

                for (StavkeMemoranduma stavkeMemoranduma : memorandum.getStavkeMemoranduma()) {
                    stavkeMemoranduma.setMemorandum(new Memorandum(memorandum.getMemorandumID(), null, null, null, null, null));
                }
                stavkeMemorandumaRepository.saveAll(memorandum.getStavkeMemoranduma());
            }

            return memorandum;
        }
    }

    @Override
    public List<Memorandum> search(int id, String datumOd, String spediter, String status) {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = qb.createQuery();
        Root<Memorandum> memorandum = cq.from(Memorandum.class);

        List<Predicate> predicates = new ArrayList<>();

        if (id != 0) {
            List<Memorandum> memorandumi = new ArrayList<>();
            memorandumi.add(findById(id));
            return memorandumi;
        }

        if (datumOd != null) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date datum = sf.parse(datumOd);
                predicates.add(qb.equal(memorandum.get("datumOd"), datum));
            } catch (ParseException ex) {
                Logger.getLogger(MemorandumServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (spediter != null) {
            predicates.add(qb.like(memorandum.get("spediter").get("naziv"), spediter + "%"));
        }
        if (status != null) {
            predicates.add(qb.like(memorandum.get("status"), status + "%"));
        }

        cq.select(memorandum).where(predicates.toArray(new Predicate[]{}));
        return entityManager.createQuery(cq).getResultList();
    }

}
