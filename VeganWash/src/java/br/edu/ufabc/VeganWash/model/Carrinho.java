/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Carrinho {

    private float total;
    private ArrayList<ItemCarrinho> itens;

    public Carrinho() {
        itens = new ArrayList<>();
        total = 0.0f;
    }

    public void Add(Produto p, double m2) {
        ItemCarrinho itenCar = new ItemCarrinho();
        itenCar.setProduto(p);
        itenCar.setM2(m2);

        itens.add(itenCar);
        total +=  itenCar.getProduto().getValorM2() * m2;
    }

    public void Remove(int idProduto) {
        ItemCarrinho itenCar = null;
        double m2 = 0;
        for (ItemCarrinho it : getItens()) {
            if (it.getProduto().getIdProduto() == idProduto) {
                itenCar = it;
                m2 = itenCar.getM2();
                break;
            }
        }
        total -=  itenCar.getProduto().getValorM2() * m2;
        itens.remove(itenCar);
    }

    public float getTotal() {
        return total;
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }
}
