/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufabc.VeganWash.controller;

import br.edu.ufabc.VeganWash.dao.DataSource;
import br.edu.ufabc.VeganWash.dao.FornecedorDAO;
import br.edu.ufabc.VeganWash.dao.GenericDAO;
import br.edu.ufabc.VeganWash.dao.UsuarioDAO;
import br.edu.ufabc.VeganWash.model.Endereco;
import br.edu.ufabc.VeganWash.model.Fornecedor;
import br.edu.ufabc.VeganWash.model.Produto;
import br.edu.ufabc.VeganWash.model.Usuario;
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
 * @author GUILHERME
 */
public class CriarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paginaDestino = "/index.jsp";
        try {
            String prodNome = request.getParameter("prodNome");
            double prodValorM2 = Double.parseDouble(request.getParameter("valorm2"));
            String lavagem = request.getParameter("dropLavagem");

            Produto produto = new Produto();
            produto.setNome(prodNome);
            produto.setValorM2(prodValorM2);
            
            // tratar endereços
            Fornecedor forn = new Fornecedor();
            forn.setEmail(request.getParameter("emailForn"));
            forn.getProdutos().add(produto);

            DataSource dataSource = new DataSource();
            FornecedorDAO fornDao = new FornecedorDAO(dataSource);
            int dadosForn = fornDao.pegarIdFornecedor(forn);
            
            fornDao.create(forn);
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
}
