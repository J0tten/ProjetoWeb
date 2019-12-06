/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.dao;

import br.edu.ufabc.VeganWash.model.Limpeza;
import br.edu.ufabc.VeganWash.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GUILHERME
 */
public class LimpezaDAO {

    private final DataSource dataSource;

    public LimpezaDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(Object o) {
    }

    public void delete(Object o) {
    }

    public void update(Object o) {
    }

    public List<Object> read() {
         List<Object> result = null;
        try {
            String sql = "SELECT * FROM limpeza ORDER BY idLimpeza";
            PreparedStatement stmread = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs = stmread.executeQuery();
            
            while (rs.next()) {
                
            }
            rs.close();
            stmread.close();
        } catch (Exception ex) {
            System.out.println("Limpeza.READ - erro ao recuperar");
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
