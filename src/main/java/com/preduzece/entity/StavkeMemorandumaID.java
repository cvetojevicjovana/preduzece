/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preduzece.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Roki
 */
@Embeddable
public class StavkeMemorandumaID implements Serializable {

    private int memorandumID;
    private int redniBroj;

    public StavkeMemorandumaID() {
    }

    public StavkeMemorandumaID(int memorandumID, int redniBroj) {
        this.memorandumID = memorandumID;
        this.redniBroj = redniBroj;
    }

    public int getMemorandumID() {
        return memorandumID;
    }

    public void setMemorandumID(int memorandumID) {
        this.memorandumID = memorandumID;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

}
