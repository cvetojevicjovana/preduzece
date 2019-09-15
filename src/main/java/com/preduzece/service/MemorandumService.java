/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.service;

import com.preduzece.dto.MemorandumDTO;
import com.preduzece.entity.Memorandum;
import java.util.List;

/**
 *
 * @author Roki
 */
public interface MemorandumService {

    public List<Memorandum> findAll();

    public Memorandum findById(int id);

    public void deleteById(int id);

    public Memorandum saveOrUpdate(Memorandum memorandum);

    public List<Memorandum> search(int id, String datumOd, String spediter, String status);
    
}
