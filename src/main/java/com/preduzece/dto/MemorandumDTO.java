/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.dto;

import com.preduzece.entity.StavkeMemoranduma;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Roki
 */
public class MemorandumDTO implements Serializable {

    private int memorandumID;
    private Date datumOd;
    private Date datumDo;
    private SpediterDTO spediter;
    private RadnikDTO radnik;
    private List<StavkeMemorandumaDTO> stavkeMemoranduma;
    private String status;

    public MemorandumDTO() {
    }

    public MemorandumDTO(int memorandumID, Date datumOd, Date datumDo, SpediterDTO spediter, RadnikDTO radnik, String status) {
        this.memorandumID = memorandumID;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.spediter = spediter;
        this.radnik = radnik;
        this.stavkeMemoranduma = new ArrayList<>();
        this.status = status;
    }

    public int getMemorandumID() {
        return memorandumID;
    }

    public void setMemorandumID(int memorandumID) {
        this.memorandumID = memorandumID;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public SpediterDTO getSpediter() {
        return spediter;
    }

    public void setSpediter(SpediterDTO spediter) {
        this.spediter = spediter;
    }

    public RadnikDTO getRadnik() {
        return radnik;
    }

    public void setRadnik(RadnikDTO radnik) {
        this.radnik = radnik;
    }

    public List<StavkeMemorandumaDTO> getStavkeMemoranduma() {
        return stavkeMemoranduma;
    }

    public void setStavkeMemoranduma(List<StavkeMemorandumaDTO> stavkeMemoranduma) {
        this.stavkeMemoranduma = stavkeMemoranduma;
    }

    @Override
    public String toString() {
        return "MemorandumDTO{" + "memorandumID=" + memorandumID + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", spediter=" + spediter + ", radnik=" + radnik + ", stavkeMemoranduma=" + stavkeMemoranduma + '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
