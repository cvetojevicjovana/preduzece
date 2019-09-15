/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.dto;

/**
 *
 * @author Roki
 */
public class RadnikDTO {

    private int radnikID;
    private String imePrezime;
    private String email;
    private String telefon;
    private String adresa;

    public RadnikDTO() {
    }

    public RadnikDTO(int radnikID, String imePrezime, String email, String telefon, String adresa) {
        this.radnikID = radnikID;
        this.imePrezime = imePrezime;
        this.email = email;
        this.telefon = telefon;
        this.adresa = adresa;
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

}
