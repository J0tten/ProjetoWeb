/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.dao;

import br.edu.ufabc.VeganWash.model.Endereco;
import br.edu.ufabc.VeganWash.model.ItemCarrinho;
import br.edu.ufabc.VeganWash.model.Pedido;
import br.edu.ufabc.VeganWash.model.Produto;
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
            
    }
     */
    public void create(Object o, int id, double m2) {
        try {
            Produto c = (Produto) o;
            String CREATE = "INSERT INTO pedido values (null, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, c.getIdProduto());
            stm.setInt(2, id);
            stm.setDouble(3, m2);
            stm.executeUpdate();
            stm.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void create(Object o) {
        try {
            Usuario c = (Usuario) o;
            String CREATE = "INSERT INTO pedido values (null, ?, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, c.getNome());
            stm.setString(2, c.getEmail());
            stm.setString(3, c.getSenha());
            stm.setString(4, c.getTelefone());
            int result = stm.executeUpdate();
            if (result == 0) {
                throw new RuntimeException("Falha ao inserir - registros duplicados");
            }
            ResultSet rs = stm.getGeneratedKeys();
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
