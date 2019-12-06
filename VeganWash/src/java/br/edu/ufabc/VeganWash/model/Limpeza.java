/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.model;

/**
 *
 * @author Victor
 */
public class Limpeza {
    private int idLimpeza;
    private String nomeLimpeza;
    private String descLimpeza;

    /**
     * @return the idLimpeza
     */ 
    public int getIdLimpeza() {
        return idLimpeza;
    }

    /**
     * @param idLimpeza the idLimpeza to set
     */
    public void setIdLimpeza(int idLimpeza) {
        this.idLimpeza = idLimpeza;
    }

    /**
     * @return the descLimpeza
     */
    public String getDescLimpeza() {
        return descLimpeza;
    }

    /**
     * @param descLimpeza the descLimpeza to set
     */
    public void setDescLimpeza(String descLimpeza) {
        this.descLimpeza = descLimpeza;
    }
    
    public String getNomeLimpeza() {
        return nomeLimpeza;
    }
    public void setNomeLimpeza(String nomeLimpeza) {
        this.nomeLimpeza = nomeLimpeza;
    }
    
}