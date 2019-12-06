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
    private Fornecedor idFornecedor;
    private Limpeza idLimpeza;
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
     * @return the idUsuario
     */
    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     * @return the idLimpeza
     */
    public Limpeza getIdLimpeza() {
        return idLimpeza;
    }

    /**
     * @param idLimpeza the idLimpeza to set
     */
    public void setIdLimpeza(Limpeza idLimpeza) {
        this.idLimpeza = idLimpeza;
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
}
