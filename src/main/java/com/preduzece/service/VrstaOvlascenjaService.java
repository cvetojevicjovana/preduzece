/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.service;

import com.preduzece.entity.VrstaOvlascenja;
import java.util.List;

/**
 *
 * @author Roki
 */
public interface VrstaOvlascenjaService {

    public List<VrstaOvlascenja> findAll();

    public VrstaOvlascenja findById(int id);

    public void saveOrUpdate(VrstaOvlascenja vrstaOvlascenja);

    public void delete(int id);
    
}
