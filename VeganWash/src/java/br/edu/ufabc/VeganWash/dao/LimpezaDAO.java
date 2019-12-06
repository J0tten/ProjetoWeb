/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.dao;

import br.edu.ufabc.VeganWash.model.Fornecedor;
import br.edu.ufabc.VeganWash.model.Limpeza;
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
            Fornecedor c = (Fornecedor) o;
            int idForn;
            String SQL = "SELECT idfornecedor FROM fornecedor where (email = ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, c.getEmail());
            ResultSet result = stm.executeQuery();
            idForn = Integer.parseInt(result.getString("idFornecedor"));
            stm.close();
            return idForn;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
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
                Limpeza l = new Limpeza();
                l.setIdLimpeza(rs.getInt("idLimpeza")); // aqui é o nome da coluna na tablea
                l.setNomeLimpeza(rs.getString("nomeLimpeza"));
                l.setDescLimpeza(rs.getString("descLimpeza"));
                result.add(l);
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
