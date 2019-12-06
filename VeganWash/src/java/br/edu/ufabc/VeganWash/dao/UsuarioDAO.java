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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class UsuarioDAO implements GenericDAO {

    private final DataSource dataSource;

    public UsuarioDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(Object o) {
        try {
            Usuario c = (Usuario) o;
            String CREATE = "INSERT INTO usuario values (null, ?, ?, ?, ?)";
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

    @Override
    public void delete(Object o) {
        try{
            Usuario c =(Usuario) o;
            String delete = "DELETE FROM Usuario WHERE email = ?";
            PreparedStatement stmDelete = dataSource.getConnection().prepareCall(delete);
            stmDelete.setString(1, c.getEmail());
            stmDelete.executeUpdate();
            System.out.println("Usuário deleteado");
            stmDelete.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Object o) {
        try {
            Usuario c = (Usuario) o;
            String Update = "UPDATE Usuario SET senha=? WHERE email=?";
            PreparedStatement stmUpdate = dataSource.getConnection().prepareStatement(Update);
            stmUpdate.setString(1, c.getSenha());
            stmUpdate.setString(2, c.getEmail());
            stmUpdate.executeUpdate();
            System.out.println("Senha atualizada");
            stmUpdate.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean Login(Object o) throws SQLException, ClassNotFoundException {
        try {
            Usuario c = (Usuario) o;
            boolean i;
            String SQL = "SELECT idusuario, email, senha FROM usuario where (email = ? and senha = ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, c.getEmail());
            stm.setString(2, c.getSenha());
            ResultSet result = stm.executeQuery();
            if (result.next()) {
                System.out.println("Login efetuado");
                i = true;
            } else {
                System.out.println("login falhou");
                i = false;
            }
            stm.close();
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Object> read() {
        List<Object> result = null;
        try {
            String sql = "SELECT * FROM usuario";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                Usuario p = new Usuario();
                p.setIdUsuario(rs.getInt("idUsuario")); // aqui é o nome da coluna na tablea
                p.setEmail(rs.getString("txtEmail"));
                p.setSenha(rs.getString("txtSenha"));
                p.setTelefone(rs.getString("txtTelefone"));
                result.add(p);
            }
            rs.close();
            stm.close();
        } catch (Exception ex) {
            System.out.println("Usuario.READ - erro ao recuperar");
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
