/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.service;

import com.preduzece.entity.Radnik;
import java.util.List;

/**
 *
 * @author Roki
 */
public interface RadnikService {

    public List<Radnik> findAll();

    public Radnik findById(int id);

    public void saveOrUpdate(Radnik radnik);

    public void delete(int id);
    
}
