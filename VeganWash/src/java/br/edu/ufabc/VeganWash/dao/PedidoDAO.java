/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.dao;

import br.edu.ufabc.VeganWash.model.Endereco;
import br.edu.ufabc.VeganWash.model.Pedido;
import br.edu.ufabc.VeganWash.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public class PedidoDAO implements GenericDAO {
    
    private final DataSource dataSource;

    public PedidoDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
    /*@Override
    public void create(Object o) {
        try {
            Pedido p = (Pedido) o;
            String CREATE = "INSERT INTO pedido values (null, ?, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, p.getNome());
            stm.setString(2, p.getEmail());
            stm.setString(3, p.getSenha());
            stm.setString(4, p.getTelefone());
            int result = stm.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("Falha ao inserir - registros duplicados");
            }
            ResultSet rs = stm.getGeneratedKeys();
            if (rs.next()) {
                c.setIdUsuario(rs.getInt(1));
                for (Endereco e : c.getEnderecos()) {
                    e.setUsuario(c);
                    CREATE = "INSERT INTO Endereco values (null, ?,?,?,?,?,?,?,?)";
                    stm = dataSource.getConnection().prepareStatement(CREATE);
                    stm.setString(1, e.getLogradouro());
                    stm.setInt(2, e.getNumeroEndereco());
                    stm.setString(3, e.getComplemento());
                    stm.setString(4, e.getCidade());
                    stm.setString(5, e.getBairro());
                    stm.setString(6, e.getEstado());
                    stm.setString(7, e.getCep());
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
    */
    @Override
    public void create(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
