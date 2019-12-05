/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.controller;

import br.edu.ufabc.VeganWash.dao.DataSource;
import br.edu.ufabc.VeganWash.dao.FornecedorDAO;
import br.edu.ufabc.VeganWash.dao.GenericDAO;
import br.edu.ufabc.VeganWash.model.Fornecedor;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GUILHERME
 */

public class SenhaFornecedorServlet extends HttpServlet {
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
            String fornecedorEmail = request.getParameter("txtEmail");
            String fornecedorSenhaAntiga = request.getParameter("txtSenhaAntiga");
            String fornecedorNewSenha = request.getParameter("txtNewSenha");
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setEmail(fornecedorEmail);
            fornecedor.setSenha(fornecedorNewSenha);
            DataSource dataSource = new DataSource();
            GenericDAO fornecedorDao = new FornecedorDAO(dataSource);
            fornecedorDao.update(fornecedor);
            dataSource.getConnection().close();
            paginaDestino = "/loginfornecedor.jsp";

        } catch (Exception ex) {
            ex.printStackTrace();
            paginaDestino = "/erro.jsp";
        }
        
        finally {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
            dispatcher.forward(request, response);
        }
    }

}
