/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.controller;

import br.edu.ufabc.VeganWash.dao.DataSource;
import br.edu.ufabc.VeganWash.dao.GenericDAO;
import br.edu.ufabc.VeganWash.dao.UsuarioDAO;
import br.edu.ufabc.VeganWash.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GUILHERME
 */

public class SenhaUsuarioServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaDestino = "/index.jsp";
        try {
            String userEmail = request.getParameter("txtEmail");
            String userSenhaAntiga = request.getParameter("txtSenhaAntiga");
            String userNewSenha = request.getParameter("txtNewSenha");
            Usuario usuario = new Usuario();
            usuario.setEmail(userEmail);
            usuario.setSenha(userNewSenha);
            DataSource dataSource = new DataSource();
            GenericDAO userDao = new UsuarioDAO(dataSource);
            userDao.update(usuario);
            dataSource.getConnection().close();
            paginaDestino = "/loginusuario.jsp";

        } catch (Exception ex) {
            ex.printStackTrace();
            paginaDestino = "/erro.jsp";
        } finally {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
            dispatcher.forward(request, response);
        }
    }

}
