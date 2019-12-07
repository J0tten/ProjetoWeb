/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.dao;

import br.edu.ufabc.VeganWash.model.Endereco;
import br.edu.ufabc.VeganWash.model.Fornecedor;
import br.edu.ufabc.VeganWash.model.Limpeza;
import br.edu.ufabc.VeganWash.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GUILHERME
 */
public class ProdutoDAO implements GenericDAO {

    private final DataSource dataSource;

    public ProdutoDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {
        Produto prod = (Produto) o;
        try {
            String SQL = "INSERT INTO produto values (null, ?, ?, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,prod.getNome());
            stm.setInt(2, prod.getFornecedor().getIdFornecedor());
            stm.setInt(3, prod.getLimpeza().getIdLimpeza());
            stm.setDouble(4, prod.getValorM2());
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
        List<Object> result = null;
        try {
            String sql = "SELECT * FROM Produto";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(Integer.parseInt(rs.getString("idProduto"))); // aqui é o nome da coluna na tablea
                p.setValorM2(Integer.parseInt(rs.getString("valorM2")));
                
                result.add(p);
            }
            rs.close();
            stm.close();
        } catch (Exception ex) {
            System.out.println("PRODUTODAO.READ - erro ao recuperar");
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public List<Object> read(String nome) {
        List<Object> result = null;
        try {
            String sql = "SELECT * FROM Produto WHERE (nomeProduto = ? )";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto();
                p.setIdProduto(Integer.parseInt(rs.getString("idProduto"))); // aqui é o nome da coluna na tablea
                p.setValorM2(Integer.parseInt(rs.getString("valorM2")));
                
                result.add(p);
            }
            rs.close();
            stm.close();
        } catch (Exception ex) {
            System.out.println("PRODUTODAO.READ - erro ao recuperar");
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    
}   
