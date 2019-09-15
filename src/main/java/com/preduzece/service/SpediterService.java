/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.service;

import com.preduzece.entity.Spediter;
import java.util.List;

/**
 *
 * @author Roki
 */


public interface SpediterService {

    public List<Spediter> findAll();

    public Spediter findById(int id);

    public void saveOrUdate(Spediter spediter);

    public void delete(int id);

    public List<Spediter> search(int id, String naziv, String adresa, String telefon, String pib);
    
}
