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
public class Pedido {

    private int idPedido;
    private Produto idProduto;
    private Usuario idUsuario;
    private double m2;

    /**
     * @return the idPedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the idProduto
     */
    public Produto getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the idUsuario
     */
    public Usuario getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
