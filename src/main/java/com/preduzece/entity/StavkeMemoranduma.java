/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author Roki
 */
@Entity
public class StavkeMemoranduma implements Serializable {

    @EmbeddedId
    private StavkeMemorandumaID id;

    private String napomena;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("memorandumID")
    @JoinColumn
    @JsonIgnore
    private Memorandum memorandum;

    @ManyToOne(fetch = FetchType.EAGER)
    private VrstaOvlascenja vrstaOvlascenja;

    public StavkeMemoranduma() {
    }

    public StavkeMemoranduma(StavkeMemorandumaID redniBroj, String napomena, Memorandum memorandum, VrstaOvlascenja vrstaOvlascenja) {
        this.id = redniBroj;
        this.napomena = napomena;
        this.memorandum = memorandum;
        this.vrstaOvlascenja = vrstaOvlascenja;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Memorandum getMemorandum() {
        return memorandum;
    }

    public void setMemorandum(Memorandum memorandum) {
        this.memorandum = memorandum;
    }

    public VrstaOvlascenja getVrstaOvlascenja() {
        return vrstaOvlascenja;
    }

    public void setVrstaOvlascenja(VrstaOvlascenja vrstaOvlascenja) {
        this.vrstaOvlascenja = vrstaOvlascenja;
    }

    public StavkeMemorandumaID getId() {
        return id;
    }

    public void setId(StavkeMemorandumaID id) {
        this.id = id;
    }

}
