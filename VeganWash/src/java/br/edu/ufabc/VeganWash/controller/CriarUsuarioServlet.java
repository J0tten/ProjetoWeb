/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.controller;

import br.edu.ufabc.VeganWash.dao.*;
import br.edu.ufabc.VeganWash.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
public class CriarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaDestino = "/index.jsp";
        try {
            String userNome = request.getParameter("txtNome");
            String userEmail = request.getParameter("txtEmail");
            String userSenha = request.getParameter("txtSenha");
            String userTelefone = request.getParameter("txtTelefone");
            Usuario usuario = new Usuario();
            usuario.setEnderecos(new ArrayList<Endereco>());            
            usuario.setNome(userNome);
            usuario.setEmail(userEmail);
            usuario.setSenha(userSenha);
            usuario.setTelefone(userTelefone);
            
            // tratar endereços
            Endereco endC = new Endereco();
            endC.setCep(Integer.parseInt(request.getParameter("txtCep")));
            endC.setLogradouro(request.getParameter("txtLogradouro"));
            endC.setNumeroEndereco(Integer.parseInt(request.getParameter("txtNumero")));
            endC.setComplemento(request.getParameter("txtComplemento"));
            endC.setBairro(request.getParameter("txtBairro"));
            endC.setCidade(request.getParameter("txtCidade"));
            endC.setEstado(request.getParameter("txtEstado"));
            
            usuario.getEnderecos().add(endC);
            

            DataSource dataSource = new DataSource();
            GenericDAO userDao = new UsuarioDAO(dataSource);
            userDao.create(usuario);          
            dataSource.getConnection().close();
            paginaDestino = "/sucesso.jsp";
        } catch (Exception ex) {
            ex.printStackTrace();
            paginaDestino = "/erro.jsp";
        } finally {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
            dispatcher.forward(request, response);
        }
        
    }
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
