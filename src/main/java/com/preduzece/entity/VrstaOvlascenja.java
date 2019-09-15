/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Roki
 */
@Entity
public class VrstaOvlascenja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ovlascenjeID;
    private String opis;

    public VrstaOvlascenja() {
    }

    public VrstaOvlascenja(int ovlascenjeID, String opis) {
        this.ovlascenjeID = ovlascenjeID;
        this.opis = opis;
    }

    public int getOvlascenjeID() {
        return ovlascenjeID;
    }

    public void setOvlascenjeID(int ovlascenjeID) {
        this.ovlascenjeID = ovlascenjeID;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

}
