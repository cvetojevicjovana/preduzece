/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.preduzece.dto.MemorandumDTO;
import com.preduzece.dto.VrstaOvlascenjaDTO;
import com.preduzece.entity.StavkeMemorandumaID;
import java.io.Serializable;

/**
 *
 * @author Roki
 */
public class StavkeMemorandumaDTO implements Serializable {

    private StavkeMemorandumaID redniBroj;
    private String napomena;

    @JsonIgnore
    private MemorandumDTO memorandum;
    private VrstaOvlascenjaDTO vrstaOvlascenja;

    public StavkeMemorandumaDTO() {
    }

    public StavkeMemorandumaDTO(StavkeMemorandumaID redniBroj, String napomena, MemorandumDTO memorandum, VrstaOvlascenjaDTO vrstaOvlascenja) {
        this.redniBroj = redniBroj;
        this.napomena = napomena;
        this.memorandum = memorandum;
        this.vrstaOvlascenja = vrstaOvlascenja;
    }

    public StavkeMemorandumaID getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(StavkeMemorandumaID redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public MemorandumDTO getMemorandum() {
        return memorandum;
    }

    public void setMemorandum(MemorandumDTO memorandum) {
        this.memorandum = memorandum;
    }

    public VrstaOvlascenjaDTO getVrstaOvlascenja() {
        return vrstaOvlascenja;
    }

    public void setVrstaOvlascenja(VrstaOvlascenjaDTO vrstaOvlascenja) {
        this.vrstaOvlascenja = vrstaOvlascenja;
    }

}
