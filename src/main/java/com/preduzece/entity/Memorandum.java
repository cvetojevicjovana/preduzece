/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Roki
 */
@Entity
public class Memorandum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memorandumID;

    @Temporal(TemporalType.DATE)
    private Date datumOd;
    @Temporal(TemporalType.DATE)
    private Date datumDo;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Spediter spediter;

    @ManyToOne(fetch = FetchType.EAGER)
    private Radnik radnik;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memorandum", cascade = CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<StavkeMemoranduma> stavkeMemoranduma;

    public Memorandum() {
    }

    public Memorandum(int memorandumID, Date datumOd, Date datumDo, Spediter spediter, Radnik radnik, String status) {
        this.memorandumID = memorandumID;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.spediter = spediter;
        this.radnik = radnik;
        this.status = status;
        this.stavkeMemoranduma = new ArrayList<>();
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

    public Spediter getSpediter() {
        return spediter;
    }

    public void setSpediter(Spediter spediter) {
        this.spediter = spediter;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public List<StavkeMemoranduma> getStavkeMemoranduma() {
        return stavkeMemoranduma;
    }

    public void setStavkeMemoranduma(List<StavkeMemoranduma> stavkeMemoranduma) {
        this.stavkeMemoranduma = stavkeMemoranduma;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Memorandum{" + "memorandumID=" + memorandumID + ", datumOd=" + datumOd + ", datumDo=" + datumDo + ", status=" + status + ", spediter=" + spediter + ", radnik=" + radnik + ", stavkeMemoranduma=" + stavkeMemoranduma + '}';
    }

}
