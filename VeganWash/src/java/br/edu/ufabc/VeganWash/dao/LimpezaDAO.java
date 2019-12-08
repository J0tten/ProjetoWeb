/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.dao;

import br.edu.ufabc.VeganWash.model.Fornecedor;
import br.edu.ufabc.VeganWash.model.Limpeza;
import br.edu.ufabc.VeganWash.model.Produto;
import br.edu.ufabc.VeganWash.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

    public int buscaIdLimpeza(Object o){
        try {
            Limpeza limp = (Limpeza) o;
            int idLimp;
            String SQL = "SELECT idlimpeza FROM limpeza WHERE nome = ?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, limp.getIdLimpeza());
            ResultSet result = stm.executeQuery();
            idLimp = Integer.parseInt(result.getString("idLimpeza"));
            stm.close();
            return idLimp;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    
    public List<Object> read(String nome) {
         List<Object> result = null;
        try {
            String sql = "SELECT * FROM limpeza ORDER BY idLimpeza WHERE idLimpeza = ?";
            PreparedStatement stmread = dataSource.getConnection().prepareStatement(sql);
            stmread.setString(1, nome);
            ResultSet rs = stmread.executeQuery();
            
            result = new ArrayList<>();
            while (rs.next()) {
                Limpeza limp = new Limpeza();
                limp.setIdLimpeza(Integer.parseInt(rs.getString("idLimpeza")));
                limp.setNomeLimpeza(rs.getString("nome"));
                limp.setDescLimpeza(rs.getString("desclimpeza"));
                result.add(limp);
            }
            rs.close();
            stmread.close();
            System.out.println("Carregou Limpeza");
            return result;
        } catch (Exception ex) {
            System.out.println("LIMPEZA.READ - erro ao recuperar");
            System.out.println(ex.getMessage());
            return null;
        }
        
    }
    public Limpeza readId(String idlimp) {
         Limpeza result = null;
        try {
            String sql = "SELECT * FROM limpeza WHERE idLimpeza = ?";
            PreparedStatement stmread = dataSource.getConnection().prepareStatement(sql);
            stmread.setString(1, idlimp);
            ResultSet rslimp = stmread.executeQuery();
            while (rslimp.next()) {
                Limpeza limp = new Limpeza();
                limp.setIdLimpeza(Integer.parseInt(rslimp.getString("idLimpeza")));
                limp.setNomeLimpeza(rslimp.getString("nome"));
                limp.setDescLimpeza(rslimp.getString("descLimpeza"));
            }
            rslimp.close();
            stmread.close();
            System.out.println("Carregou Limpeza");
            return result;
        } catch (Exception ex) {
            System.out.println("LIMPEZADAO.READID - erro ao recuperar");
            System.out.println(ex.getMessage());
            return null;
        }
        
    }
    public List<Object> read() {
         List<Object> result = null;
        try {
            String sql = "SELECT * FROM limpeza";
            PreparedStatement stmread = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs = stmread.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Limpeza limp = new Limpeza();
                limp.setIdLimpeza(Integer.parseInt(rs.getString("idLimpeza")));
                limp.setNomeLimpeza(rs.getString("nome"));
                limp.setDescLimpeza(rs.getString("desclimpeza"));
                result.add(limp);
            }
            rs.close();
            stmread.close();
            System.out.println("Carregou Limpeza");
            return result;
        } catch (Exception ex) {
            System.out.println("LIMPEZADAO.READSTRING - erro ao recuperar");
            System.out.println(ex.getMessage());
            return null;
        }
        
    }
}

