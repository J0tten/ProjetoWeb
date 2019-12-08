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
public class Produto {

    private int idProduto;
    private String nomeProduto;
    private Fornecedor fornecedor;
    private Limpeza limpeza;
    private double valorM2;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the limpeza
     */
    public Limpeza getLimpeza() {
        return limpeza;
    }

    /**
     * @param limpeza the limpeza to set
     */
    public void setLimpeza(Limpeza limpeza) {
        this.limpeza = limpeza;
    }

    /**
     * @return the valorM2
     */
    public double getValorM2() {
        return valorM2;
    }

    /**
     * @param valorM2 the valorM2 to set
     */
    public void setValorM2(double valorM2) {
        this.valorM2 = valorM2;
    }

    /**
     * @return the nome
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nome the nome to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

}
