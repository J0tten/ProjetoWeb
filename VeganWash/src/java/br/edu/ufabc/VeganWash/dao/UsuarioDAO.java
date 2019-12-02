/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import br.edu.ufabc.VeganWash.model.*;
import java.util.List;

/**
 *
 * @author Victor
 */
public class UsuarioDAO implements GenericDAO{

    private final DataSource dataSource;

    public UsuarioDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {
        try {
            Usuario c = (Usuario) o;
            String SQL = "INSERT INTO usuario values (null, ?, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, c.getNome());
            stm.setString(2, c.getEmail());
            stm.setString(3, c.getSenha());
            stm.setInt(4, c.getTelefone());
            int result = stm.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("Falha ao inserir - registros duplicados");
            }
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                c.setIdUsuario(rs.getInt(1));
                for (Endereco e : c.getEnderecos()) {
                    e.setUsuario(c);
                    SQL = "INSERT INTO Endereco values (null, ?,?,?,?,?,?,?,?)";
                    stm = dataSource.getConnection().prepareStatement(SQL);
                    stm.setString(1, e.getLogradouro());
                    stm.setInt(2, e.getNumeroEndereco());
                    stm.setString(3, e.getComplemento());
                    stm.setString(4, e.getCidade());
                    stm.setString(5, e.getBairro());
                    stm.setString(6, e.getEstado());
                    stm.setInt(7, e.getCep());
                    stm.setInt(8, e.getUsuario().getIdUsuario());
                    stm.executeUpdate();
                }
            }

            rs.close();
            stm.close();
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
