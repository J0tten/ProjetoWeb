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
    
    public Carrinho(){
    itens = new ArrayList<>();
    total = 0.0f;
    }
    
    
}
