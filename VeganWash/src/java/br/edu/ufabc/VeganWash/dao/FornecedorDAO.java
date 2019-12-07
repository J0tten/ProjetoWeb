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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            stm.setString(2, c.getCpf());
            stm.setString(3, c.getTelefone());
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
        try {
            Usuario c = (Usuario) o;
            String delete = "DELETE FROM Fornecedor WHERE (cpf = ? and email = ?)";
            PreparedStatement stmDelete = dataSource.getConnection().prepareCall(delete);
            stmDelete.setString(1, c.getEmail());
            stmDelete.executeUpdate();
            System.out.println("Fornecedor deleteado");
            stmDelete.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Object o) {
        try {
            Fornecedor c = (Fornecedor) o;
            String UPDATE = "UPDATE Fornecedor SET senha=? WHERE email=?";
            PreparedStatement stmUpdate = dataSource.getConnection().prepareStatement(UPDATE);
            stmUpdate.setString(1, c.getSenha());
            stmUpdate.setString(2, c.getEmail());
            int result = stmUpdate.executeUpdate();
            System.out.println("Senha atualizada");
            stmUpdate.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Object> read() {
        List<Object> result = null;
        try {
            String sql = "SELECT * FROM fornecedor";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Fornecedor p = new Fornecedor();
                p.setIdFornecedor(rs.getInt("idFornecedor")); // aqui é o nome da coluna na tablea
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setSenha(rs.getString("Senha"));
                p.setTelefone(rs.getString("telefone"));
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

    public List<Object> read(String email) {
        List<Object> result = null;
        try {
            String sql = "SELECT * FROM fornecedor WHERE email = ?";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Fornecedor p = new Fornecedor();
                p.setIdFornecedor(rs.getInt("idFornecedor")); // aqui é o nome da coluna na tablea
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setEmail(rs.getString("email"));
                p.setSenha(rs.getString("Senha"));
                p.setTelefone(rs.getString("telefone"));
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

    public boolean Login(Object o) throws SQLException, ClassNotFoundException {
        try {
            Fornecedor c = (Fornecedor) o;
            boolean i;
            String SQL = "SELECT idfornecedor, email, senha FROM fornecedor where (email = ? and senha = ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, c.getEmail());
            stm.setString(2, c.getSenha());
            ResultSet result = stm.executeQuery();
            if (result.next()) {
                System.out.println("Login efetuado");
                i = true;
            } else {
                System.out.println("Login falhou");
                i = false;
            }
            stm.close();
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
