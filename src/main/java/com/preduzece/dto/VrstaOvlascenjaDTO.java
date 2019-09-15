/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.dto;

import java.io.Serializable;

/**
 *
 * @author Roki
 */
public class VrstaOvlascenjaDTO implements Serializable {

    private int ovlascenjeID;
    private String opis;

    public VrstaOvlascenjaDTO() {
    }

    public VrstaOvlascenjaDTO(int ovlascenjeID, String opis) {
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
