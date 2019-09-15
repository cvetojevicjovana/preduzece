/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.repository;

import com.preduzece.entity.Radnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Roki
 */
@Repository
public interface RadnikRepository extends JpaRepository<Radnik, Integer> {

}
