/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.dao;

import br.edu.ufabc.VeganWash.model.Fornecedor;
import br.edu.ufabc.VeganWash.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class FornecedorDAO implements GenericDAO {

    private final DataSource dataSource;

    public FornecedorDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {
        Fornecedor c = (Fornecedor) o;
        try {
            String SQL = "INSERT INTO fornecedor values (null, ?, ?, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, c.getNome());
            stm.setInt(2, c.getCpf());
            stm.setInt(3, c.getTelefone());
            stm.setString(4, c.getEmail());
            stm.setString(5, c.getSenha());
            int result = stm.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("Falha ao inserir - registros duplicados");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
