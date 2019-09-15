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
public class Spediter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spediterID;
    private String naziv;
    private String adresa;
    private String pib;
    private String telefon;

    public Spediter() {
    }

    public Spediter(int spediterID, String naziv, String adresa, String PIB, String telefon) {
        this.spediterID = spediterID;
        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = PIB;
        this.telefon = telefon;
    }

    public int getSpediterID() {
        return spediterID;
    }

    public void setSpediterID(int spediterID) {
        this.spediterID = spediterID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String PIB) {
        this.pib = PIB;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Spediter{" + "spediterID=" + spediterID + ", naziv=" + naziv + ", adresa=" + adresa + ", PIB=" + pib + ", telefon=" + telefon + '}';
    }

}
