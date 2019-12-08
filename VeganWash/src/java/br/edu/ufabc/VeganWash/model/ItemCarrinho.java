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
public class ItemCarrinho {
    private Produto produto;
    private double m2;

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the m2
     */
    public double getM2() {
        return m2;
    }

    /**
     * @param m2 the m2 to set
     */
    public void setM2(double m2) {
        this.m2 = m2;
    }
    
    
}
